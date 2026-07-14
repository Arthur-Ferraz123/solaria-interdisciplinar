package model;

/**
 * Representa a entidade contato
 *
 * <p>Observação: Os atributos que não possuem informações sobre sua mutabilidade são <b>mutáveis</b></p>
 *
 * @author Eduardo Vicente Bisneto
 * @version 1.0.0
 */
public class Contato {

    //Atributos

    /**
     * Identificador único do contato.
     * Imutável por ser um identificador (PK).
     */
    private long id;

    /**
     * Identificador único do {@link Usuario} (FK) contatador.
     * Imutável por conta da estruturação do sistema.
     */
    private long idUsuarioContatador;

    /**
     * Identificador único do {@link Usuario} (FK) contatado.
     * Imutável por conta da estruturação do sistema.
     */
    private long idUsuarioContatado;

    /**
     * Representa um apelido dado ao contatado.
     */
    private String apelido;

    //Construtor

    /**
     * Construtor completo da classe Contato
     *
     * @param id Identificador único do contato (PK).
     * @param idUsuarioContatador Identificador único do {@link Usuario} (FK) contatador.
     * @param idUsuarioContatado Identificador único do {@link Usuario} (FK) contatado.
     * @param apelido Apelido dado ao contatado.
     */
    public Contato(long id, long idUsuarioContatador, long idUsuarioContatado, String apelido) {

        this.id = id;
        this.idUsuarioContatador = idUsuarioContatador;
        this.idUsuarioContatado = idUsuarioContatado;
        this.apelido = apelido;

    }

    /**
     * Construtor para o {@link dao.ContatoDAO#insert(Contato)}
     *
     * @param idUsuarioContatador Identificador único do {@link Usuario} (FK) contatador.
     * @param idUsuarioContatado Identificador único do {@link Usuario} (FK) contatado.
     * @param apelido Apelido dado ao contatado.
     */
    public Contato(long idUsuarioContatador, long idUsuarioContatado, String apelido) {

        this.idUsuarioContatador = idUsuarioContatador;
        this.idUsuarioContatado = idUsuarioContatado;
        this.apelido = apelido;

    }

    /**
     * Construtor para o {@link dao.ContatoDAO#update(Contato)}
     *
     * @param id Identificador único do contato (PK).
     * @param apelido Apelido dado ao contatado.
     */
    public Contato(long id, String apelido) {

        this.id = id;
        this.apelido = apelido;

    }

    //Getters e Setters

    public long getId() {

        return id;

    }

    public long getIdUsuarioContatador() {

        return idUsuarioContatador;

    }

    public long getIdUsuarioContatado() {

        return idUsuarioContatado;

    }

    public String getApelido() {

        return apelido;

    }

    public void setApelido(String apelido) {

        this.apelido = apelido;

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
                "Id do usuário contatador: "+ this.idUsuarioContatador + "\n" +
                "Id do usuário contatado: "+ this.idUsuarioContatado + "\n" +
                "Apelido: "+ this.apelido + "\n" +
                "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n";

    }

}