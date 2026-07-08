package model;

//Import do objeto utilizado para representar datatypes do tipo date no java
import java.time.LocalDate;

//Import do objeto utilizado para representar datatypes do tipo time no java
import java.time.LocalTime;

/**
 * Representa a entidade mensagem
 *
 * <p>Observação: Os atributos que não possuem informações sobre sua mutabilidade são <b>mutáveis</b></p>
 *
 * @author Eduardo Vicente Bisneto
 * @version 1.0.0
 */

public class Mensagem {

    //Atributos

    /**
     * Identificador único da mensagem.
     * Imutável por ser um identificador (PK).
     */

    private long id;

    /**
     * Identificador único do {@link Chat} (FK) ao qual a mensagem pertence.
     * Imutável por conta da estruturação do sistema.
     */

    private long idChat;

    /**
     * Texto da mensagem.
     */

    private String mensagem;

    /**
     * Data que a mensagem foi enviada.
     * Imutável por conta da estruturação do sistema.
     */

    private LocalDate dataEnvio;

    /**
     * Horário que a mensagem foi enviada.
     * Imutável por conta da estruturação do sistema.
     */

    private LocalTime horarioEnvio;

    /**
     * Nome de quem enviou a mensagem.
     * Imutável por conta da estruturação do sistema.
     */

    private String remetente;

    /**
     * Link para o video da mensagem.
     * Imutável por conta da estruturação do sistema.
     */

    private String video;

    /**
     * Link para a imagem da mensagem.
     * Imutável por conta da estruturação do sistema.
     */

    private String imagem;

    //Construtor

    /**
     * Construtor completo da classe Mensagem
     *
     * @param id Identificador único da mensagem (PK).
     * @param idChat Identificador único do {@link Chat} (FK) ao qual a mensagem pertence.
     * @param mensagem Texto da mensagem.
     * @param dataEnvio Data que a mensagem foi enviada.
     * @param horarioEnvio Horário que a mensagem foi enviada.
     * @param remetente Nome de quem enviou a mensagem.
     * @param video Link para o video da mensagem.
     * @param imagem Link para a imagem da mensagem.
     */

    public Mensagem(long id, long idChat, String mensagem, LocalDate dataEnvio, LocalTime horarioEnvio,
                    String remetente, String video, String imagem) {

        this.id = id;
        this.idChat = idChat;
        this.mensagem = mensagem;
        this.dataEnvio = dataEnvio;
        this.horarioEnvio = horarioEnvio;
        this.remetente = remetente;
        this.video = video;
        this.imagem = imagem;

    }

    //Getters e Setters

    public long getId() {

        return id;

    }

    public long getIdChat() {

        return idChat;

    }

    public String getMensagem() {

        return mensagem;

    }

    public void setMensagem(String mensagem) {

        this.mensagem = mensagem;

    }

    public LocalDate getDataEnvio() {

        return dataEnvio;

    }

    public LocalTime getHorarioEnvio() {

        return horarioEnvio;

    }

    public String getRemetente() {

        return remetente;

    }

    public String getVideo() {

        return video;

    }

    public String getImagem() {

        return imagem;

    }

    //Método toString

    /**
     * Retorna uma representação completa dos valores de <b>todos</b> os atributos da classe.
     * <p>
     *     O formato possuí o <i>nome do atributo com <b>algumas alterações</b></i> para facilitar a compreensão,
     *     seguido de seu valor.
     * </p>
     * @return Uma String no formato <b>"Nome do atributo: Valor"</b>
     */

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