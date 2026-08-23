package model;

public class Fornecedor {

    //Atributos
    private final long id;

    private final long idUsuario;

    private final String tipoUsuario;

    private String tipoFornecedor;

    private final String cnpj;

    private String razaoSocial;

    //Construtor
    public Fornecedor(long id, long idUsuario, String tipoUsuario, String tipoFornecedor, String cnpj, String razaoSocial) {

        this.id = id;
        this.idUsuario = idUsuario;
        this.tipoUsuario = tipoUsuario;
        this.tipoFornecedor = tipoFornecedor;
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;

    }

    //Getters e Setters
    public long getId() {

        return id;

    }

    public long getIdUsuario() {

        return idUsuario;

    }

    public String getTipoUsuario() {

        return tipoUsuario;

    }

    public String getTipoFornecedor() {

        return tipoFornecedor;

    }

    public void setTipoFornecedor(String tipoFornecedor) {

        this.tipoFornecedor = tipoFornecedor;

    }

    public String getCnpj() {

        return cnpj;

    }

    public String getRazaoSocial() {

        return razaoSocial;

    }

    public void setRazaoSocial(String razaoSocial) {

        this.razaoSocial = razaoSocial;

    }

    //Método toString
    @Override
    public String toString(){

        return  "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n" +
                "ID: "+ this.id + "\n" +
                "ID do usuário: "+ this.idUsuario + "\n" +
                "Tipo do usuário: "+ this.tipoUsuario + "\n" +
                "Tipo do fornecedor: "+ this.tipoFornecedor + "\n" +
                "CNPJ: "+ this.cnpj + "\n" +
                "Razão social: " + this.razaoSocial + "\n" +
                "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n";

    }

}