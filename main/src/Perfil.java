public class Perfil {

    //Atributos

    //PK da tabela
    private long id;

    //FK originada da tabela usuario ou empresa_tecnica
    private long idUsuario;

    private String descricao;

    //Avaliar a existência desse atributo
    private String tipoUsuario;

    //Construtor
    public Perfil(long id, long idUsuario, String descricao, String tipoUsuario) {

        this.id = id;
        this.idUsuario = idUsuario;
        this.descricao = descricao;
        this.tipoUsuario = tipoUsuario;

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

    public String getDescricao() {

        return descricao;

    }

    public void setDescricao(String descricao) {

        this.descricao = descricao;

    }

    //OBS: O atributo tipoUsuario é imutável, então não possui setter
    public String getTipoUsuario() {

        return tipoUsuario;

    }

    //Método toString
    @Override
    public String toString(){

        return  "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n" +
                "ID: "+ this.id + "\n" +
                "ID do usuário: "+ this.idUsuario + "\n" +
                "Descrição: "+ this.descricao + "\n" +
                "Tipo do usuário: "+ this.tipoUsuario + "\n" +
                "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n";

    }

}
