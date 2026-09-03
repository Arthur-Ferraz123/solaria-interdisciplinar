package model;

public class Profissional {

    //Atributos
    private final long id;
    private final long idUsuario;
    private final TiposUsuario tipoUsuario = TiposUsuario.PROFISSIONAL;
    private String profissao;
    private final String cpf;
    private long idFornecedor;

    //Construtor
    public Profissional(long id, long idUsuario, String profissao, String cpf, long idFornecedor) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.profissao = profissao;
        this.cpf = cpf;
        this.idFornecedor = idFornecedor;
    }

    //Getters e Setters
    public long getId() {
        return id;
    }

    public long getIdUsuario() {
        return idUsuario;
    }

    public TiposUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public String getCpf() {
        return cpf;
    }

    public long getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(long idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    //Método toString
    
    @Override
    public String toString(){
        return  "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n" +
                "ID: "+ this.id + "\n" +
                "ID do usuário: "+ this.idUsuario + "\n" +
                "Tipo do usuário: "+ this.tipoUsuario + "\n" +
                "Profissão: "+ this.profissao + "\n" +
                "CPF: "+ this.cpf + "\n" +
                "ID do fornecedor: "+ this.idFornecedor + "\n" +
                "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n";
    }
}
