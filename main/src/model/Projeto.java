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
     * Identificador único do projeto.
     * Imutável por ser um identificador (PK).
     */

    private long id;

    /**
     * Identificador único do {@link Chat} (FK) do projeto.
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
     * @param id Identificador único do projeto (PK).
     * @param idChat Identificador único do {@link Chat} (FK) do projeto.
     * @param nome Nome do projeto.
     * @param descricao Descrição do projeto.
     */

    public Projeto(long id, long idChat, String nome, String descricao) {

        this.id = id;
        this.idChat = idChat;
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