package model;

/**
 * Representa a entidade chat
 *
 * <p>Observação: Os atributos que não possuem informações sobre sua mutabilidade são <b>mutáveis</b></p>
 *
 * @author Eduardo Vicente Bisneto
 * @version 1.0.0
 */

public class Chat {

    //Atributos

    /**
     * Identificador único do chat.
     * Imutável por ser um identificador (PK).
     */

    private long id;

    //Construtor

    /**
     * Construtor completo da classe Chat
     *
     * @param id Identificador único do chat (PK).
     */

    public Chat(long id) {

        this.id = id;

    }

    //Getters e Setters

    public long getId() {

        return id;

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
                "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n";

    }

}