package model;

/**
 * Representa a entidade usuario_projeto
 *
 * <p>Observação: Os atributos que não possuem informações sobre sua mutabilidade são <b>mutáveis</b></p>
 *
 * @author Eduardo Vicente Bisneto
 * @version 1.0.0
 */
public class UsuarioProjeto {

    //Atributos

    /**
     * ID do usuario_projeto registrado no banco de dados.
     * Imutável por ser a PK.
     */
    private long id;

    /**
     * ID do {@link Projeto} que usuario_projeto faz parte. (FK)
     * Imutável por conta da estruturação do sistema.
     */
    private long idProjeto;

    /**
     * ID do {@link Usuario} que é o usuario_projeto. (FK)
     * Imutável por conta da estruturação do sistema.
     */
    private long idUsuario;

    /**
     * Indica se o usuario_projeto é o dono do projeto.
     * Imutável por conta da estruturação do sistema.
     */
    private boolean donoDoProjeto;

    //Construtor

    /**
     * Construtor completo da classe UsuarioProjeto
     *
     * @param id ID do usuario_projeto registrado no banco de dados.
     * @param idProjeto ID do {@link Projeto} que usuario_projeto faz parte. (FK)
     * @param idUsuario ID do {@link Usuario} que é o usuario_projeto. (FK)
     * @param donoDoProjeto Indica se o usuario_projeto é o dono do projeto.
     */
    public UsuarioProjeto(long id, long idProjeto, long idUsuario, boolean donoDoProjeto) {

        this.id = id;
        this.idProjeto = idProjeto;
        this.idUsuario = idUsuario;
        this.donoDoProjeto = donoDoProjeto;

    }

    /**
     * Construtor para o {@link dao.UsuarioProjetoDAO#insert(UsuarioProjeto)}
     *
     * @param idProjeto ID do {@link Projeto} que usuario_projeto faz parte. (FK)
     * @param idUsuario ID do {@link Usuario} que é o usuario_projeto. (FK)
     * @param donoDoProjeto Indica se o usuario_projeto é o dono do projeto.
     */
    public UsuarioProjeto(long idProjeto, long idUsuario, boolean donoDoProjeto) {

        this.idProjeto = idProjeto;
        this.idUsuario = idUsuario;
        this.donoDoProjeto = donoDoProjeto;

    }

    //Getters e Setters

    public long getId() {

        return id;
    }

    public long getIdProjeto() {

        return idProjeto;

    }

    public long getIdUsuario() {

        return idUsuario;

    }

    public boolean isDonoDoProjeto() {

        return donoDoProjeto;

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
                "ID do usuário: "+ this.idUsuario + "\n" +
                "É o dono do projeto: "+ this.donoDoProjeto + "\n" +
                "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n";

    }

}