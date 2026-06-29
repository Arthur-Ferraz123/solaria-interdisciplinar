public class Profissional {

    //Atributos

    //PK da tabela
    private int id;

    //FK originada da tabela usuario
    private int idUsuario;

    private String funcao;
    private String cpf;

    //FK originada da tabela empresa_tecnica no caso do profissional ser filiado a uma
    private int idEmpresa;

    //Construtor
    public Profissional(int id, int idUsuario, String funcao, String cpf, int idEmpresa) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.funcao = funcao;
        this.cpf = cpf;
        this.idEmpresa = idEmpresa;
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

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    //OBS: O atributo idEmpresa tem setter, pois mesmo sendo uma fk o profissional pode ir para outra empresa ou se tornar autônomo
    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
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
