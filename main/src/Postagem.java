//Import do objeto utilizado para representar datatypes do tipo date no java
import java.time.LocalDate;

//Import do objeto utilizado para representar datatypes do tipo time no java
import java.time.LocalTime;

public class Postagem {

    //Atributos

    //PK da tabela
    private long id;

    //FK originada da tabela perfil
    private long idPerfil;

    private String texto;
    private LocalDate dataPublicacao;
    private int quantidadeVisualizacoes;
    private LocalTime horarioPublicacao;

    //Verificar como vai funcionar esses atributos
    private String video;
    private String imagem;

    //Construtor
    public Postagem(long id, long idPerfil, String texto, LocalDate dataPublicacao,
                    int quantidadeVisualizacoes, LocalTime horarioPublicacao, String video, String imagem) {

        this.id = id;
        this.idPerfil = idPerfil;
        this.texto = texto;
        this.dataPublicacao = dataPublicacao;
        this.quantidadeVisualizacoes = quantidadeVisualizacoes;
        this.horarioPublicacao = horarioPublicacao;
        this.video = video;
        this.imagem = imagem;

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

    public String getTexto() {

        return texto;

    }

    public void setTexto(String texto) {

        this.texto = texto;

    }

    //OBS: O atributo dataPublicacao é imutável
    public LocalDate getDataPublicacao() {

        return dataPublicacao;

    }

    public int getQuantidadeVisualizacoes() {

        return quantidadeVisualizacoes;

    }

    public void setQuantidadeVisualizacoes(int quantidadeVisualizacoes) {

        this.quantidadeVisualizacoes = quantidadeVisualizacoes;

    }

    //OBS: O atributo horarioPublicacao é imutável
    public LocalTime getHorarioPublicacao() {

        return horarioPublicacao;

    }

    // REAVALIAR A SITUAÇÃO ATUAL DESSES ATRIBUTOS

    public String getVideo() {

        return video;

    }

    public void setVideo(String video) {

        this.video = video;

    }

    public String getImagem() {

        return imagem;

    }

    public void setImagem(String imagem) {

        this.imagem = imagem;

    }

    //Método toString
    @Override
    public String toString(){

        return  "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n" +
                "ID: "+ this.id + "\n" +
                "ID do perfil: "+ this.idPerfil + "\n" +
                "Texto: "+ this.texto + "\n" +
                "Data de publicação: "+ this.dataPublicacao + "\n" +
                "Quantidade de visualizações: "+ this.quantidadeVisualizacoes + "\n" +
                "Horário de publicação: "+ this.horarioPublicacao + "\n" +
                "Vídeo: "+ this.video + "\n" +
                "Imagem: "+ this.imagem + "\n" +
                "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n";

    }

}
