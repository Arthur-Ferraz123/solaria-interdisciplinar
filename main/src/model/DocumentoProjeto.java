package model;

/**
 * Representa a entidade documento projeto
 *
 * <p>Observação: Os atributos que não possuem informações sobre sua mutabilidade são <b>mutáveis</b></p>
 *
 * @author Eduardo Vicente Bisneto
 * @version 1.0.0
 */

public class DocumentoProjeto {

    //Atributos

    /**
     * Identificador único do documento projeto.
     * Imutável por ser um identificador (PK).
     */

    private long id;

    /**
     * Identificador único do {@link Projeto} (FK) ao qual o documento pertence.
     * Imutável por conta da estruturação do sistema.
     */

    private long idProjeto;

    /**
     * Identificador único do {@link UsuarioProjeto} (FK) que criou o documento projeto.
     * Imutável por conta da estruturação do sistema.
     */

    private long idUsuarioCriador;

    /**
     * Link do documento.
     */

    private String documento;

    //Construtor

    /**
     * Construtor completo da classe DocumentoProjeto
     * @param id Identificador único do documento projeto (PK).
     * @param idProjeto Identificador único do {@link Projeto} (FK) ao qual o documento pertence.
     * @param idUsuarioCriador Identificador único do {@link UsuarioProjeto} (FK) que criou o documento projeto.
     * @param documento Link do documento
     */

    public DocumentoProjeto(long id, long idProjeto, long idUsuarioCriador, String documento) {

        this.id = id;
        this.idProjeto = idProjeto;
        this.idUsuarioCriador = idUsuarioCriador;
        this.documento = documento;

    }

    //Getters e Setters

    public long getId() {

        return id;

    }

    public long getIdProjeto() {

        return idProjeto;

    }

    public long getIdUsuarioCriador() {

        return idUsuarioCriador;

    }

    public String getDocumento() {

        return documento;

    }

    public void setDocumento(String documento) {

        this.documento = documento;

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
                "ID do projeto: "+ this.idProjeto + "\n" +
                "ID do usuário projeto criador: "+ this.idUsuarioCriador + "\n" +
                "Documento: "+ this.documento + "\n" +
                "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n";

    }

}