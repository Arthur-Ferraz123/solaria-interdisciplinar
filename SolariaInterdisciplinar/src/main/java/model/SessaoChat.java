package model;

//Import do objeto utilizado para representar datatypes do tipo date no java
import java.time.LocalDate;

/**
 * Representa a entidade sessão chat
 *
 * <p>Observação: Os atributos que não possuem informações sobre sua mutabilidade são <b>mutáveis</b></p>
 *
 * @author Eduardo Vicente Bisneto
 * @version 1.0.0
 */

public class SessaoChat {

    //Atributos

    /**
     * Identificador único da sessão chat.
     * Imutável por ser um identificador (PK).
     */

    private long id;

    /**
     * Identificador único do {@link Chat} (FK) ao qual a sessão chat é relacionada.
     * Imutável por conta da estruturação do sistema.
     */

    private long idChat;

    /**
     * Indica a data que o chat foi iniciado.
     * Imutável por conta da estruturação do sistema.
     */

    private LocalDate dataInicio;

    /**
     * Indica se a sessão chat está ou não ativa.
     */

    private boolean statusSessao;

    /**
     * Indica a data em que o chat foi finalizado.
     */

    private LocalDate dataFim;

    //Construtor

    /**
     * Construtor completo da classe SessaoChat
     *
     * @param id Identificador único da sessão chat (PK).
     * @param idChat Identificador único do {@link Chat} (FK) ao qual a sessão chat é relacionada.
     * @param dataInicio A data que o chat foi iniciado.
     * @param statusSessao A sessão chat está ou não ativa.
     * @param dataFim A data em que o chat foi finalizado.
     */

    public SessaoChat(long id, long idChat, LocalDate dataInicio, boolean statusSessao, LocalDate dataFim) {

        this.id = id;
        this.idChat = idChat;
        this.dataInicio = dataInicio;
        this.statusSessao = statusSessao;
        this.dataFim = dataFim;

    }

    //Getters e Setters

    public long getId() {

        return id;

    }

    public long getIdChat() {

        return idChat;

    }

    public LocalDate getDataInicio() {

        return dataInicio;

    }

    public boolean isStatusSessao() {

        return statusSessao;

    }

    public void setStatusSessao(boolean statusSessao) {

        this.statusSessao = statusSessao;

    }

    public LocalDate getDataFim() {

        return dataFim;

    }

    public void setDataFim(LocalDate dataFim) {

        this.dataFim = dataFim;

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
                "Data de inicio: "+ this.dataInicio + "\n" +
                "Status da sessão: "+ this.statusSessao + "\n" +
                "Data do fim: "+ this.dataFim + "\n" +
                "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n";

    }

}