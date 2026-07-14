package model;

import java.time.LocalDate;

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
     */
    public Mensagem(long id, long idChat, String mensagem, LocalDate dataEnvio, LocalTime horarioEnvio,
                    String remetente) {

        this.id = id;
        this.idChat = idChat;
        this.mensagem = mensagem;
        this.dataEnvio = dataEnvio;
        this.horarioEnvio = horarioEnvio;
        this.remetente = remetente;

    }

    /**
     * Construtor para o {@link dao.MensagemDAO#insert(Mensagem)}
     *
     * @param idChat Identificador único do {@link Chat} (FK) ao qual a mensagem pertence.
     * @param mensagem Texto da mensagem.
     * @param remetente Nome de quem enviou a mensagem.
     */
    public Mensagem(long idChat, String mensagem, String remetente) {

        this.idChat = idChat;
        this.mensagem = mensagem;
        this.remetente = remetente;

    }

    /**
     * Construtor para o {@link dao.MensagemDAO#update(Mensagem)}
     *
     * @param id Identificador único da mensagem (PK).
     * @param mensagem Texto da mensagem.
     */
    public Mensagem(long id, String mensagem) {

        this.id = id;
        this.mensagem = mensagem;

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
                "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n";

    }

}