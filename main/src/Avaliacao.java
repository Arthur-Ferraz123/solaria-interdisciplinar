public class Avaliacao {

    //Atributos

    //PK da tabela
    private long id;

    //FK originada da tabela perfil
    private long idPerfil;

    private String comentario;
    private int quantidadeEstrelas;

    //Construtor
    public Avaliacao(long id, long idPerfil, String comentario, int quantidadeEstrelas) {

        this.id = id;
        this.idPerfil = idPerfil;
        this.comentario = comentario;
        this.quantidadeEstrelas = quantidadeEstrelas;

    }

    //Getters e Setters

    //OBS: O atributo id não tem setter, pois ele é a pk da tabela
    public long getId() {

        return id;

    }

    //OBS: O atributo idPerfil é uma FK e é imutável, então não possui setter
    public long getIdPerfil() {

        return idPerfil;

    }

    public String getComentario() {

        return comentario;

    }

    public void setComentario(String comentario) {

        this.comentario = comentario;

    }

    public int getQuantidadeEstrelas() {

        return quantidadeEstrelas;

    }

    public void setQuantidadeEstrelas(int quantidadeEstrelas) {

        this.quantidadeEstrelas = quantidadeEstrelas;

    }

    //Método toString
    @Override
    public String toString(){

        return  "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n" +
                "ID: "+ this.id + "\n" +
                "ID do perfil: "+ this.idPerfil + "\n" +
                "Comentário: "+ this.comentario + "\n" +
                "Quantidade de estrelas: "+ this.quantidadeEstrelas + "\n" +
                "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n";

    }

}
