public class Fornecedor {

    //Atributos

    //PK da tabela
    private int id;

    //FK originada da tabela usuario
    private int idUsuario;

    //Verificar esse tipo fornecedor
    private String tipoFornecedor;

    private String cnpj;

    //Construtor
    public Fornecedor(int id, int idUsuario, String tipoFornecedor, String cnpj) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.tipoFornecedor = tipoFornecedor;
        this.cnpj = cnpj;
    }

    //Getters e Setters

    //OBS: O atributo id não tem setter, pois ele é a pk da tabela
    public int getId() {
        return id;
    }

    //OBS: O atributo idUsuario não tem setter, pois ele é a fk da tabela e nesse caso ela acaba sendo inválida
    public int getIdUsuario() {
        return idUsuario;
    }

    public String getTipoFornecedor() {
        return tipoFornecedor;
    }

    public void setTipoFornecedor(String tipoFornecedor) {
        this.tipoFornecedor = tipoFornecedor;
    }

    //Verificar se o cnpj vai possuir setter
    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
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
