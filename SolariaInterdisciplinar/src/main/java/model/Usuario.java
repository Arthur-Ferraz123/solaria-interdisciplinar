package model;

/**
 * Representa a entidade usuario
 *
 * <p>Observação: Os atributos que não possuem informações sobre sua mutabilidade são <b>mutáveis</b>.</p>
 *
 * @author Eduardo Vicente Bisneto
 * @version 1.0.0
 */
public class Usuario {

    //Atributos

    /**
     * ID do usuario registrado no banco de dados.
     * Imutável por ser a PK.
     */
    private long id;

    /**
     * E-mail do usuario. (UNIQUE)
     * Deve seguir o padrão previsto em {@link }.
     */
    private String email;

    /**
     * Senha usada pelo usuario.
     * Deve seguir o padrão previsto em {@link }.
     */
    private String senha;

    /**
     * Nome do usuario.
     */
    private String nome;

    /**
     * Indica qual a variação do usuario.
     * Imutável por conta da estruturação do sistema.
     * Valores aceitos: {"CLIENTE", "FORNECEDOR", "PROFISSIONAL", "EMPRESA_TECNICA"}
     */
    private String tipoUsuario;

    //Construtores

    public Usuario(){};

    /**
     * Construtor completo da classe Usuario
     *
     * @param id ID do usuario registrado no banco de dados.
     * @param email E-mail do usuario. (UNIQUE)
     * @param senha Senha utilizada pelo usuario.
     * @param nome Nome do usuario.
     * @param tipoUsuario Qual a variação do usuario.
     */
    public Usuario(long id, String email, String senha, String nome, String tipoUsuario) {

        this.id = id;
        this.email = email;
        this.senha = senha;
        this.nome = nome;
        this.tipoUsuario = tipoUsuario;

    }

    /**
     * Construtor para o {@link dao.UsuarioDAO#insert(Usuario)}
     *
     * @param email E-mail do usuario. (UNIQUE)
     * @param senha Senha utilizada pelo usuario.
     * @param nome Nome do usuario.
     * @param tipoUsuario Qual a variação do usuario.
     */
    public Usuario(String email, String senha, String nome, String tipoUsuario) {

        this.email = email;
        this.senha = senha;
        this.nome = nome;
        this.tipoUsuario = tipoUsuario;

    }

    /**
     * Construtor para o {@link dao.UsuarioDAO#update(Usuario)}
     *
     * @param email E-mail do usuario. (UNIQUE)
     * @param senha Senha utilizada pelo usuario.
     * @param nome Nome do usuario.
     * @param id ID do usuario registrado no banco de dados.
     */
    public Usuario(String email, String senha, String nome, long id) {

        this.id = id;
        this.email = email;
        this.senha = senha;
        this.nome = nome;

    }

    //Getters e Setters

    public long getId() {

        return id;

    }

    public String getEmail() {

        return email;

    }

    public void setEmail(String email) {

        this.email = email;

    }

    public String getSenha() {

        return senha;

    }

    public void setSenha(String senha) {

        this.senha = senha;

    }

    public String getNome() {

        return nome;

    }

    public void setNome(String nome) {

        this.nome = nome;

    }

    public String getTipoUsuario() {

        return tipoUsuario;

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
                "Email: "+ this.email + "\n" +
                "Senha: "+ this.senha + "\n" +
                "Nome: "+ this.nome + "\n" +
                "Tipo do usuário: "+ this.tipoUsuario + "\n" +
                "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n";

    }

}