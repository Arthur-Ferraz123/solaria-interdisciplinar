package model;

/**
 * Representa a entidade usuario_chat
 *
 * <p>Observação: Os atributos que não possuem informações sobre sua mutabilidade são <b>mutáveis</b></p>
 *
 * @author Eduardo Vicente Bisneto
 * @version 1.0.0
 */
public class UsuarioChat {

    //Atributos

    /**
     * ID do usuario_chat registrado no banco de dados.
     * Imutável por ser a PK.
     */
    private long id;

    /**
     * ID do {@link Chat} que o usuario_chat participa. (FK)
     * Imutável por conta da estruturação do sistema.
     */
    private long idChat;

    /**
     * ID do {@link Usuario} que é o usuario_chat. (FK)
     * Imutável por conta da estruturação do sistema.
     */
    private long idUsuario;

    //Construtor

    /**
     * Construtor completo da classe UsuarioChat
     *
     * @param id ID do usuario_chat registrado no banco de dados.
     * @param idChat ID do {@link Chat} que o usuario_chat participa. (FK)
     * @param idUsuario ID do {@link Usuario} que é o usuario_chat. (FK)
     */
    public UsuarioChat(long id, long idChat, long idUsuario) {

        this.id = id;
        this.idChat = idChat;
        this.idUsuario = idUsuario;

    }

    /**
     * Construtor para o {@link dao.UsuarioChatDAO#insert(UsuarioChat)}
     *
     * @param idChat ID do {@link Chat} que o usuario_chat participa. (FK)
     * @param idUsuario ID do {@link Usuario} que é o usuario_chat. (FK)
     */
    public UsuarioChat(long idChat, long idUsuario) {

        this.idChat = idChat;
        this.idUsuario = idUsuario;

    }

    //Getters e Setters


    public long getId() {

        return id;

    }

    public long getIdChat() {

        return idChat;

    }

    public long getIdUsuario() {

        return idUsuario;

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
                "ID do usuário: "+ this.idUsuario + "\n" +
                "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n";

    }

}