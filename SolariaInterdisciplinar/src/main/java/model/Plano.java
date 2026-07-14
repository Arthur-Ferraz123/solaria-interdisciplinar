package model;

/**
 * Representa a entidade Plano
 *
 * <p>Observação: Os atributos que não possuem informações sobre sua mutabilidade são <b>mutáveis</b></p>
 *
 * @author Eduardo Vicente Bisneto
 * @version 1.0.0
 */
public class Plano {

    //Atributos

    /**
     * Identificador único do Plano.
     * Imutável por ser um identificador (PK).
     */
    private long id;

    /**
     * Nome do nome.
     */
    private String nome;

    /**
     * Indica qual tipo de usuário que o plano é direcionado
     * Valores aceitos:
     */
    private String tipoUsuarioDestinado;

    /**
     * Valor do Plano em reais.
     */
    private double valor;

    /**
     * Indica de qual o tipo da mensalidade.
     * Valores aceitos:
     */
    private String tipoMensalidade;

    //Construtor

    /**
     * Construtor completo da classe Plano e para o {@link dao.PlanoDAO#update(Plano)}
     *
     * @param id Identificador único do nome (PK).
     * @param nome Nome do Plano.
     * @param valor Valor do Plano em reais.
     * @param tipoMensalidade Indica de qual o tipo da mensalidade.
     */
    public Plano(long id, String nome, String tipoUsuarioDestinado, double valor, String tipoMensalidade) {

        this.id = id;
        this.nome = nome;
        this.tipoUsuarioDestinado = tipoUsuarioDestinado;
        this.valor = valor;
        this.tipoMensalidade = tipoMensalidade;

    }

    /**
     * Construtor para o {@link dao.PlanoDAO#insert(Plano)}
     *
     * @param nome
     * @param tipoUsuarioDestinado
     * @param valor
     * @param tipoMensalidade
     */
    public Plano(String nome, String tipoUsuarioDestinado, double valor, String tipoMensalidade) {

        this.nome = nome;
        this.tipoUsuarioDestinado = tipoUsuarioDestinado;
        this.valor = valor;
        this.tipoMensalidade = tipoMensalidade;

    }

    //Getters e Setters

    public long getId() {

        return id;

    }

    public String getNome() {

        return nome;

    }

    public void setNome(String nome) {

        this.nome = nome;

    }

    public String getTipoUsuarioDestinado() {

        return tipoUsuarioDestinado;

    }

    public void setTipoUsuarioDestinado(String tipoUsuarioDestinado) {

        this.tipoUsuarioDestinado = tipoUsuarioDestinado;

    }

    public double getValor() {

        return valor;

    }

    public void setValor(double valor) {

        this.valor = valor;

    }

    public String getTipoMensalidade() {

        return tipoMensalidade;

    }

    public void setTipoMensalidade(String tipoMensalidade) {

        this.tipoMensalidade = tipoMensalidade;

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
    public String toString() {

        return "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n" +
                "ID: " + this.id + "\n" +
                "Nome: " + this.nome + "\n" +
                "Tipo usuário destinado: " + this.tipoUsuarioDestinado + "\n" +
                "Valor: R$" + this.valor + "\n" +
                "Tipo de mensalidade: " + this.tipoMensalidade + "\n" +
                "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n";

    }

}