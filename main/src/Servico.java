public class Servico {

    //Atributos

    //PK da tabela
    private int id;

    //FK originada da tabela empresa_tecnica
    private int idEmpresa;

    private String servico;
    private String descricao;

    //Construtor
    public Servico(int id, int idEmpresa, String servico, String descricao) {
        this.id = id;
        this.idEmpresa = idEmpresa;
        this.servico = servico;
        this.descricao = descricao;
    }

    //Getters e Setters

    //OBS: O atributo id não tem setter, pois ele é a pk da tabela
    public int getId() {
        return id;
    }

    //OBS: O atributo idEmpresa não tem setter, pois ele é a fk da tabela e nesse caso ela acaba sendo inválida
    public int getIdEmpresa() {
        return idEmpresa;
    }

    public String getServico() {
        return servico;
    }

    public void setServico(String servico) {
        this.servico = servico;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    //Método toString
    @Override
    public String toString(){
        return  "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n" +
                "ID: "+ this.id + "\n" +
                "ID da empresa: "+ this.idEmpresa + "\n" +
                "Serviço: "+ this.servico + "\n" +
                "Descrição: "+ this.descricao + "\n" +
                "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n";
    }
}
