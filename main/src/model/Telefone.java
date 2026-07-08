package model;

/**
 * Representa a entidade telefone
 *
 * <p>Observação: Os atributos que não possuem informações sobre sua mutabilidade são <b>mutáveis</b>.</p>
 *
 * @author Eduardo Vicente Bisneto
 * @version 1.0.0
 */

public class Telefone {

    //Atributos

    /**
     * Identificador único do telefone.
     * Imutável por ser um identificador (PK).
     */

    private long id;

    /**
     * Número do telefone.
     * Deve seguir o padrão previsto em {@link }
     */

    private String telefone;

    /**
     * Indica qual o tipo do telefone.
     * Valores aceitos:
     */

    private String tipo;

    /**
     * Identificador único do {@link Usuario} (FK) dono do telefone.
     * Imutável por conta da estruturação do sistema.
     */

    private long idUsuario;

    /**
     * Indica se o telefone é o principal do {@link Usuario}.
     */

    private boolean principal;

    //Construtor

    /**
     * Construtor completo da classe Telefone
     *
     * @param id Identificador único do telefone (PK).
     * @param telefone Número do telefone.
     * @param tipo Tipo do telefone.
     * @param idUsuario Identificador único do {@link Usuario} (FK) dono do telefone.
     * @param principal O telefone é o principal do {@link Usuario}.
     */

    public Telefone(long id, String telefone, String tipo, long idUsuario, boolean principal) {

        this.id = id;
        this.telefone = telefone;
        this.tipo = tipo;
        this.idUsuario = idUsuario;
        this.principal = principal;

    }

    //Getters e Setters

    public long getId() {

        return id;

    }

    public String getTelefone() {

        return telefone;

    }

    public void setTelefone(String telefone) {

        this.telefone = telefone;

    }

    public String getTipo() {

        return tipo;

    }

    public void setTipo(String tipo) {

        this.tipo = tipo;

    }

    public long getIdUsuario() {

        return idUsuario;

    }

    public boolean isPrincipal() {

        return principal;

    }

    public void setPrincipal(boolean principal) {

        this.principal = principal;

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
                "Telefone: "+ this.telefone + "\n" +
                "Tipo do telefone: "+ this.tipo + "\n" +
                "ID do usuário: "+ this.idUsuario + "\n" +
                "Principal: "+ this.principal + "\n" +
                "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n";

    }

}