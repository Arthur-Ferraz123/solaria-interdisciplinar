package model;

/**
 * Representa a entidade perfil
 *
 * <p>Observação: Os atributos que não possuem informações sobre sua mutabilidade são <b>mutáveis</b></p>
 *
 * @author Eduardo Vicente Bisneto
 * @version 1.0.0
 */
public class Perfil {

    //Atributos

    /**
     * ID do perfil registrado no banco de dados.
     * Imutável por ser a PK.
     */
    private long id;

    /**
     * ID do {@link Usuario} que é possuí o perfil. (FK) (UNIQUE)
     * Imutável por conta da estruturação do sistema.
     */
    private long idUsuario;

    /**
     * Descrição sobre o perfil.
     */
    private String descricao;

    /**
     * Link para a foto do perfil.
     */
    private String fotoPerfil;

    //Construtores

    /**
     * Construtor completo da classe Perfil
     *
     * @param id ID do perfil registrado no banco de dados.
     * @param idUsuario ID do {@link Usuario} que é possuí o perfil. (FK) (UNIQUE)
     * @param descricao Descrição sobre o perfil.
     * @param fotoPerfil Link para a foto do perfil.
     */
    public Perfil(long id, long idUsuario, String descricao, String fotoPerfil) {

        this.id = id;
        this.idUsuario = idUsuario;
        this.descricao = descricao;
        this.fotoPerfil = fotoPerfil;

    }

    /**
     * Construtor para o {@link dao.PerfilDAO#insert(Perfil)}
     *
     * @param idUsuario ID do {@link Usuario} que é possuí o perfil. (FK) (UNIQUE)
     * @param descricao Descrição sobre o perfil.
     * @param fotoPerfil Link para a foto do perfil.
     */
    public Perfil(long idUsuario, String descricao, String fotoPerfil) {

        this.idUsuario = idUsuario;
        this.descricao = descricao;
        this.fotoPerfil = fotoPerfil;

    }

    /**
     * Construtor para o {@link dao.PerfilDAO#update(Perfil)}
     *
     * @param descricao Descrição sobre o perfil.
     * @param fotoPerfil Link para a foto do perfil.
     * @param id ID do perfil registrado no banco de dados.
     */
    public Perfil(String descricao, String fotoPerfil, long id) {

        this.descricao = descricao;
        this.fotoPerfil = fotoPerfil;
        this.id = id;

    }

    //Getters e Setters

    public long getId() {

        return id;

    }

    public long getIdUsuario() {

        return idUsuario;

    }

    public String getDescricao() {

        return descricao;

    }

    public void setDescricao(String descricao) {

        this.descricao = descricao;

    }

    public String getFotoPerfil() {

        return fotoPerfil;

    }

    public void setFotoPerfil(String fotoPerfil) {

        this.fotoPerfil = fotoPerfil;

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
                "ID do usuário: "+ this.idUsuario + "\n" +
                "Descrição: "+ this.descricao + "\n" +
                "Foto do perfil: "+ this.fotoPerfil + "\n" +
                "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n";

    }

}