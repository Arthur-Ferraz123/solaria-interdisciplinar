public class Perfil {

    //Atributos

    //PK da tabela
    private int id;

    //FK originada da tabela usuario
    private int idUsuario;

    private String descricao;

    //Avaliar a existência desse atributo
    private String tipoUsuario;

    //Construtor
    public Perfil(int id, int idUsuario, String descricao, String tipoUsuario) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.descricao = descricao;
        this.tipoUsuario = tipoUsuario;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
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
