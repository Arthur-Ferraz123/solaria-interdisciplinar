package model;

/**
 * Representa a entidade usuário chat
 *
 * <p>Observação: Os atributos que não possuem informações sobre sua mutabilidade são <b>mutáveis</b></p>
 *
 * @author Eduardo Vicente Bisneto
 * @version 1.0.0
 */
public class UsuarioChat {

    //Atributos

    /**
     * Identificador único do usuário chat.
     * Imutável por ser um identificador (PK).
     */
    private long id;

    /**
     * Identificador único do {@link Chat} (FK) ao qual o usuário chat pertence.
     * Imutável por conta da estruturação do sistema.
     */
    private long idChat;

    /**
     * Identificador único do {@link Usuario} (FK) que é o usuário chat.
     * Imutável por conta da estruturação do sistema.
     */
    private long idUsuario;

    //Construtor

    /**
     * Construtor completo da classe UsuarioChat
     *
     * @param id Identificador único do usuário chat (PK).
     * @param idChat Identificador único do {@link Chat} (FK) ao qual o usuário chat pertence.
     * @param idUsuario Identificador único do {@link Usuario} (FK) que é o usuário chat.
     */
    public UsuarioChat(long id, long idChat, long idUsuario) {

        this.id = id;
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