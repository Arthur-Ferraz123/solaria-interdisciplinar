package model;

/**
 * Representa a entidade documento_projeto
 *
 * <p>Observação: Os atributos que não possuem informações sobre sua mutabilidade são <b>mutáveis</b></p>
 *
 * @author Eduardo Vicente Bisneto
 * @version 1.0.0
 */
public class DocumentoProjeto {

    //Atributos

    /**
     * ID do documento_projeto registrado no banco de dados.
     * Imutável por ser a PK.
     */
    private long id;

    /**
     * ID do {@link Projeto} que ao qual esse documento_projeto faz parte. (FK)
     * Imutável por conta da estruturação do sistema.
     */
    private long idProjeto;

    /**
     * ID do {@link UsuarioProjeto} que fez o documento_projeto. (FK)
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
     *
     * @param id ID do documento_projeto registrado no banco de dados.
     * @param idProjeto ID do {@link Projeto} que ao qual esse documento_projeto faz parte. (FK)
     * @param idUsuarioCriador ID do {@link UsuarioProjeto} que fez o documento_projeto. (FK)
     * @param documento Link do documento.
     */
    public DocumentoProjeto(long id, long idProjeto, long idUsuarioCriador, String documento) {

        this.id = id;
        this.idProjeto = idProjeto;
        this.idUsuarioCriador = idUsuarioCriador;
        this.documento = documento;

    }

    /**
     * Construtor para o {@link dao.DocumentoProjetoDAO#insert(DocumentoProjeto)}
     *
     * @param idProjeto ID do {@link Projeto} que ao qual esse documento_projeto faz parte. (FK)
     * @param idUsuarioCriador ID do {@link UsuarioProjeto} que fez o documento_projeto. (FK)
     * @param documento Link do documento.
     */
    public DocumentoProjeto(long idProjeto, long idUsuarioCriador, String documento) {

        this.idProjeto = idProjeto;
        this.idUsuarioCriador = idUsuarioCriador;
        this.documento = documento;

    }

    /**
     * Construtor para o {@link dao.DocumentoProjetoDAO#update(DocumentoProjeto)}
     *
     * @param documento Link do documento.
     * @param id ID do documento_projeto registrado no banco de dados.
     */
    public DocumentoProjeto(String documento, long id) {

        this.documento = documento;
        this.id = id;

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