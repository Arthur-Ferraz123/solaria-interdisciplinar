public class Profissional {

    //Atributos

    //PK da tabela
    private long id;

    //FK originada da tabela usuario
    private long idUsuario;

    private String funcao;
    private String cpf;

    //FK originada da tabela empresa_tecnica no caso do profissional ser filiado a uma
    private long idEmpresa;

    //Construtor
    public Profissional(long id, long idUsuario, String funcao, String cpf, long idEmpresa) {

        this.id = id;
        this.idUsuario = idUsuario;
        this.funcao = funcao;
        this.cpf = cpf;
        this.idEmpresa = idEmpresa;

    }

    //Getters e Setters

    //OBS: O atributo id não tem setter, pois ele é a pk da tabela
    public long getId() {

        return id;

    }

    //OBS: O atributo idUsuario não tem setter, pois ele é a fk da tabela e nesse caso ela acaba sendo inválida
    public long getIdUsuario() {

        return idUsuario;

    }

    public String getFuncao() {

        return funcao;

    }

    public void setFuncao(String funcao) {

        this.funcao = funcao;

    }

    //OBS: O atributo cpf não tem setter, pois ele será imutável
    public String getCpf() {

        return cpf;

    }

    //OBS: O atributo idEmpresa é uma FK e não é imutável, então possui setter
    public long getIdEmpresa() {

        return idEmpresa;

    }

    public void setIdEmpresa(long idEmpresa) {

        this.idEmpresa = idEmpresa;

    }

    //Método toString
    @Override
    public String toString(){

        return  "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n" +
                "ID: "+ this.id + "\n" +
                "ID do usuário: "+ this.idUsuario + "\n" +
                "Função: "+ this.funcao + "\n" +
                "CPF: "+ this.cpf + "\n" +
                "ID da empresa: "+ this.idEmpresa + "\n" +
                "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n";

    }

}
