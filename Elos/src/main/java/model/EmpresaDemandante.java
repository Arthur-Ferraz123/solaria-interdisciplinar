package model;

public class EmpresaDemandante {

    //Atributos
    private final long id;
    private final long idUsuario;
    private final String tipoUsuario;
    private final String cnpj;
    private String razaoSocial;
    private boolean ehMandante;

    //Construtor
    public EmpresaDemandante(long id, long idUsuario, String tipoUsuario, String cnpj, String razaoSocial, boolean ehMandante) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.tipoUsuario = tipoUsuario;
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
        this.ehMandante = ehMandante;
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

    public String getCnpj() {
        return cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public boolean isEhMandante() {
        return ehMandante;
    }

    public void setEhMandante(boolean ehMandante) {
        this.ehMandante = ehMandante;
    }

    //Método toString
    @Override
    public String toString(){
        return  "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n" +
                "ID: "+ this.id + "\n" +
                "ID do usuário: "+ this.idUsuario + "\n" +
                "Tipo do usuário: "+ this.tipoUsuario + "\n" +
                "CNPJ: "+ this.cnpj + "\n" +
                "Razão social: " + this.razaoSocial + "\n" +
                "É mandante: " + this.ehMandante +
                "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n";
    }
}
