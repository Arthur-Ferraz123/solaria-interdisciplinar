package model;

/**
 * Representa a entidade projeto
 *
 * <p>Observação: Os atributos que não possuem informações sobre sua mutabilidade são <b>mutáveis</b></p>
 *
 * @author Eduardo Vicente Bisneto
 * @version 1.0.0
 */
public class Projeto {

    //Atributos

    /**
     * ID da assinatura registrado no banco de dados.
     * Imutável por ser a PK.
     */
    private long id;

    /**
     * ID do {@link Chat} atrelado ao projeto. (FK)
     * Imutável por conta da estruturação do sistema.
     */
    private long idChat;

    /**
     * Nome do projeto.
     */
    private String nome;

    /**
     * Descrição do projeto.
     */
    private String descricao;

    //Construtor

    /**
     * Construtor completo da classe Projeto
     *
     * @param id ID da assinatura registrado no banco de dados.
     * @param idChat ID do {@link Chat} atrelado ao projeto. (FK)
     * @param nome Nome do projeto.
     * @param descricao Descrição do projeto.
     */
    public Projeto(long id, long idChat, String nome, String descricao) {

        this.id = id;
        this.idChat = idChat;
        this.nome = nome;
        this.descricao = descricao;

    }

    /**
     * Construtor para o {@link dao.ProjetoDAO#insert(Projeto)}
     *
     * @param idChat ID do {@link Chat} atrelado ao projeto. (FK)
     * @param nome Nome do projeto.
     * @param descricao Descrição do projeto.
     */
    public Projeto(long idChat, String nome, String descricao) {

        this.idChat = idChat;
        this.nome = nome;
        this.descricao = descricao;

    }

    /**
     * Construtor para o {@link dao.ProjetoDAO#update(Projeto)}
     *
     * @param nome Nome do projeto.
     * @param descricao Descrição do projeto.
     * @param id ID da assinatura registrado no banco de dados.
     */
    public Projeto(String nome, String descricao, long id) {

        this.id = id;
        this.nome = nome;
        this.descricao = descricao;

    }

    //Getters e Setters

    public long getId() {

        return id;

    }

    public long getIdChat() {

        return idChat;

    }

    public String getNome() {

        return nome;

    }

    public void setNome(String nome) {

        this.nome = nome;

    }

    public String getDescricao() {

        return descricao;

    }

    public void setDescricao(String descricao) {

        this.descricao = descricao;

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
                "Nome: "+ this.nome + "\n" +
                "Descrição: "+ this.descricao + "\n" +
                "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n";

    }

}