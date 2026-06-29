public class Servico {

    //Atributos

    //PK da tabela
    private long id;

    //FK originada da tabela empresa_tecnica
    private long idEmpresa;

    private String servico;
    private String descricao;

    //Construtor
    public Servico(long id, long idEmpresa, String servico, String descricao) {

        this.id = id;
        this.idEmpresa = idEmpresa;
        this.servico = servico;
        this.descricao = descricao;

    }

    //Getters e Setters

    //OBS: O atributo id não tem setter, pois ele é a pk da tabela
    public long getId() {

        return id;

    }

    //OBS: O atributo idEmpresa é uma FK e é imutável, então não possui setter
    public long getIdEmpresa() {

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
