package model;

import java.time.LocalDate;

/**
 * Representa a entidade sessao_chat
 *
 * <p>Observação: Os atributos que não possuem informações sobre sua mutabilidade são <b>mutáveis</b></p>
 *
 * @author Eduardo Vicente Bisneto
 * @version 1.0.0
 */
public class SessaoChat {

    //Atributos

    /**
     * ID da sessao_chat registrado no banco de dados.
     * Imutável por ser a PK.
     */
    private long id;

    /**
     * ID do {@link Chat} que a sessao_chat atua. (FK)
     * Imutável por conta da estruturação do sistema.
     */
    private long idChat;

    /**
     * Indica a data que a sessao_chat foi iniciada.
     * Imutável por conta da estruturação do sistema.
     */
    private LocalDate dataInicio;

    /**
     * Indica se a sessao_chat está ou não ativa.
     */
    private boolean statusSessao;

    /**
     * Indica a data em que a sessao_chat foi finalizada.
     */
    private LocalDate dataFim;

    //Construtor

    /**
     * Construtor completo da classe SessaoChat
     *
     * @param id ID da sessao_chat registrado no banco de dados.
     * @param idChat ID do {@link Chat} que a sessao_chat atua. (FK)
     * @param dataInicio A data que a sessao_chat foi iniciada.
     * @param statusSessao A sessao_chat está ou não ativa.
     * @param dataFim A data em que a sessao_chat foi finalizada.
     */
    public SessaoChat(long id, long idChat, LocalDate dataInicio, boolean statusSessao, LocalDate dataFim) {

        this.id = id;
        this.idChat = idChat;
        this.dataInicio = dataInicio;
        this.statusSessao = statusSessao;
        this.dataFim = dataFim;

    }

    /**
     * Construtor para o {@link dao.SessaoChatDAO#insert(SessaoChat)}
     *
     * @param idChat ID do {@link Chat} que a sessao_chat atua. (FK)
     * @param statusSessao A sessao_chat está ou não ativa.
     * @param dataFim A data em que a sessao_chat foi finalizada.
     */
    public SessaoChat(long idChat, boolean statusSessao, LocalDate dataFim) {

        this.idChat = idChat;
        this.statusSessao = statusSessao;
        this.dataFim = dataFim;

    }

    /**
     * Construtor para o {@link dao.SessaoChatDAO#update(SessaoChat)}
     *
     * @param statusSessao A sessao_chat está ou não ativa.
     * @param dataFim A data em que a sessao_chat foi finalizada.
     * @param id ID da sessao_chat registrado no banco de dados.
     */
    public SessaoChat(boolean statusSessao, LocalDate dataFim, long id) {

        this.statusSessao = statusSessao;
        this.dataFim = dataFim;
        this.id = idChat;

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