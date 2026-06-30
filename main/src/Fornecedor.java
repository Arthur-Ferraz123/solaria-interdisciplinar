public class Fornecedor {

    //Atributos

    //PK da tabela
    private long id;

    //FK originada da tabela usuario
    private long idUsuario;

    private String tipoFornecedor;
    private String cnpj;

    //Construtor
    public Fornecedor(long id, long idUsuario, String tipoFornecedor, String cnpj) {

        this.id = id;
        this.idUsuario = idUsuario;
        this.tipoFornecedor = tipoFornecedor;
        this.cnpj = cnpj;

    }

    //Getters e Setters

    //OBS: O atributo id não tem setter, pois ele é a pk da tabela
    public long getId() {

        return id;

    }

    //OBS: O atributo idUsuario é uma FK e é imutável, então não possui setter
    public long getIdUsuario() {

        return idUsuario;

    }

    public String getTipoFornecedor() {

        return tipoFornecedor;

    }

    public void setTipoFornecedor(String tipoFornecedor) {

        this.tipoFornecedor = tipoFornecedor;

    }

    //OBS: O atributo cnpj não tem setter, pois ele será imutável
    public String getCnpj() {

        return cnpj;

    }

    //Método toString
    @Override
    public String toString(){

        return  "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n" +
                "ID: "+ this.id + "\n" +
                "ID do usuário: "+ this.idUsuario + "\n" +
                "Tipo do fornecedor: "+ this.tipoFornecedor + "\n" +
                "CNPJ: "+ this.cnpj + "\n" +
                "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n";

    }

}
