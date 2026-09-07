package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;


public final class CriarInstrucaoDinamica {

    private record AuxiliarWhere(String campoWhere, String operacaoWhere, String operadorLogico){}
    private record ValorComDataType(Object object, int dataType){}
    private record OrderBy(String campo, String sentido){}

    private final Queue<String> campos = new ArrayDeque<>();
    private final Queue<ValorComDataType> valoresComDataTypes = new ArrayDeque<>();

    private final Queue<AuxiliarWhere> informacoesWhere = new ArrayDeque<>();
    private final Queue<ValorComDataType> valoresComDataTypesWhere = new ArrayDeque<>();

    private final Queue<OrderBy> orderBys = new ArrayDeque<>();

    private int indexDoPreparedStatement = 1;

    public String construirSelect(String tabela){
        if (tabela == null || tabela.isBlank()){
            throw new IllegalArgumentException("Nenhuma tabela inserida");
        }

        StringBuilder sb = new StringBuilder();

        sb.append("select * from ").append(tabela);

        if(informacoesWhere.isEmpty()){
            return sb.toString().trim();
        }

        String camposWhereEmString = construirWhere();
        String orderBys = construirOrderBy();

        sb.append(" where ").append(camposWhereEmString).append(orderBys);

        return sb.toString().trim();
    }

    public String construirDelete(String tabela){
        if (tabela == null || tabela.isBlank()){
            throw new IllegalArgumentException("Nenhuma tabela inserida");
        }

        if(informacoesWhere.isEmpty()){
            throw new IllegalArgumentException("Nenhum where foi inserido");
        }

        String camposWhereEmString = construirWhere();

        StringBuilder sb = new StringBuilder();

        sb.append("delete ").append(tabela)
                .append(" where ").append(camposWhereEmString);

        return sb.toString().trim();
    }

    public String construirInsert(String tabela){
        if (tabela == null || tabela.isBlank()){
            throw new IllegalArgumentException("Nenhuma tabela inserida");
        }

        String[] interrogacoes = new String[campos.size()];
        Arrays.fill(interrogacoes, "?");
        String listaInterrogacoes = String.join(", ",interrogacoes);

        String camposEmString = String.join(", ", campos);

        StringBuilder sb = new StringBuilder();

        sb.append("insert into ").append(tabela)
        .append("(").append(camposEmString).append(")")
        .append(" values(").append(listaInterrogacoes).append(")");

        return sb.toString().trim();
    }

    public String construirUpdate(String tabela){
        if (tabela == null || tabela.isBlank()){
            throw new IllegalArgumentException("Nenhuma tabela inserida");
        }

        if(informacoesWhere.isEmpty()){
            throw new IllegalArgumentException("Nenhum where inserido");
        }

        String camposWhereEmString = construirWhere();

        StringBuilder sb = new StringBuilder();

        sb.append("update ").append(tabela).append(" set ");

        boolean primeiro = true;

        while(!campos.isEmpty()){
            String campo = campos.poll();

            if(!primeiro){
                sb.append(", ");
            }

            sb.append(campo).append(" = ").append(" coalesce(?, ").append(campo).append(")");

            primeiro = false;
        }


        sb.append(" where ").append(camposWhereEmString);

        return sb.toString().trim();
    }

    public void setCampo(String campo, Object valor, int dataType){
        campos.add(campo);
        valoresComDataTypes.add(new ValorComDataType(valor, dataType));
    }

    public void setWhere(String campoWhere, String operacaoWhere, String operadorLogico, Object valorWhere, int dataType){
        informacoesWhere.add(new AuxiliarWhere(campoWhere, operacaoWhere, operadorLogico));

        valoresComDataTypesWhere.add(new ValorComDataType(valorWhere, dataType));
    }

    public void setWhereMultiplosValores(String campoWhere, String operacaoWhere, String operadorLogico, List<Object> valoresWhere, int dataType) {
        informacoesWhere.add(new AuxiliarWhere(campoWhere, operacaoWhere, operadorLogico));

        for (Object object : valoresWhere) {
            valoresComDataTypesWhere.add(new ValorComDataType(object, dataType));
        }
    }

    public void aplicarValoresDoPreparedStatement(PreparedStatement preparedStatement) throws SQLException{
        aplicarValores(preparedStatement);
        aplicarValoresWhere(preparedStatement);
    }

    private void aplicarValores(PreparedStatement preparedStatement) throws SQLException{
        while(!valoresComDataTypes.isEmpty()){
            ValorComDataType valorComDataType = valoresComDataTypes.poll();

            DataTypesUsados dataTypeAtual = DataTypesUsados.descobrirDataType(valorComDataType.dataType());
            dataTypeAtual.realizarSet(preparedStatement, indexDoPreparedStatement, valorComDataType.object());

            indexDoPreparedStatement++;
        }
    }

    private void aplicarValoresWhere(PreparedStatement preparedStatement) throws SQLException{
        while(!valoresComDataTypesWhere.isEmpty()){
            ValorComDataType valorComDataType = valoresComDataTypesWhere.poll();

            DataTypesUsados dataTypeAtual = DataTypesUsados.descobrirDataType(valorComDataType.dataType());
            dataTypeAtual.realizarSet(preparedStatement, indexDoPreparedStatement, valorComDataType.object());

            indexDoPreparedStatement++;
        }
    }

    private String construirWhere(){
        if (informacoesWhere.isEmpty()) {
            throw new IllegalArgumentException("Nenhum campo inserido");
        }

        StringBuilder sb = new StringBuilder();
        boolean primeiro = true;

        while (!informacoesWhere.isEmpty()) {
            AuxiliarWhere auxiliarWhere = informacoesWhere.poll();
            String campo = auxiliarWhere.campoWhere();
            String operacao = auxiliarWhere.operacaoWhere;
            String operadorLogico = auxiliarWhere.operadorLogico;

            if (!primeiro) {
                sb.append(operadorLogico).append(" ");
            }
            primeiro = false;

            sb.append(campo).append(" ").append(operacao).append(" ");
            if ("between".equalsIgnoreCase(operacao)) {
                sb.append("? and ? ");
            } else {
                sb.append("? ");
            }
        }
        return sb.toString().trim();
    }

    private String construirOrderBy(){
        if(orderBys.isEmpty()){
            return "";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("order by ");

        boolean primeiro = true;
        while(!orderBys.isEmpty()){

            OrderBy orderBy = orderBys.poll();

            if(!primeiro){
                sb.append(", ");
            }

            sb.append(orderBy.campo()).append(" ").append(orderBy.sentido);

            primeiro = false;

        }
        return sb.toString();
    }

    public void setOrderBy(String campo, String sentido){
        orderBys.add(new OrderBy(campo, sentido));
    }

}
