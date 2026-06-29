//Import do objeto utilizado para representar datatypes do tipo date no java
import java.time.LocalDate;

//Import do objeto utilizado para representar datatypes do tipo time no java
import java.time.LocalTime;

public class Mensagem {

    //Atributos

    //PK da tabela
    private long id;

    //FK originaria da tabela chat
    private long idChat;

    private String mensagem;
    private LocalDate dataEnvio;
    private LocalTime horarioEnvio;
    private String remetente;

    //Avaliar esses atributos
    private String video;
    private String imagem;

    //Construtor
    public Mensagem(long id, long idChat, String mensagem, LocalDate dataEnvio, LocalTime horarioEnvio,
                    String remetente, String video, String imagem) {

        this.id = id;
        this.idChat = idChat;
        this.mensagem = mensagem;
        this.dataEnvio = dataEnvio;
        this.horarioEnvio = horarioEnvio;
        this.remetente = remetente;

        //Avaliar esses atributos
        this.video = video;
        this.imagem = imagem;

    }

    //Getters e Setters

    //OBS: O atributo id não tem setter, pois ele é a pk da tabela
    public long getId() {

        return id;

    }

    //OBS: O atributo idChat é uma FK e é imutável, então não possui setter
    public long getIdChat() {

        return idChat;

    }

    public String getMensagem() {

        return mensagem;

    }

    public void setMensagem(String mensagem) {

        this.mensagem = mensagem;

    }

    //OBS: O atributo dataEnvio é imutável
    public LocalDate getDataEnvio() {

        return dataEnvio;

    }

    //OBS: O atributo horarioEnvio é imutável
    public LocalTime getHorarioEnvio() {

        return horarioEnvio;

    }

    //OBS: O atributo remetente é imutável
    public String getRemetente() {

        return remetente;

    }

    // REAVALIAR A SITUAÇÃO DESSES CAMPOS
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
                "ID do chat: "+ this.idChat + "\n" +
                "Mensagem: "+ this.mensagem + "\n" +
                "Data de envio: "+ this.dataEnvio + "\n" +
                "Horário de envio: "+ this.horarioEnvio + "\n" +
                "Remetente: "+ this.remetente + "\n" +
                "Video: "+ this.video + "\n" +
                "Imagem: "+ this.imagem + "\n" +
                "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n";

    }

}
