package model;

/**
 * Representa a entidade plano
 *
 * <p>Observação: Os atributos que não possuem informações sobre sua mutabilidade são <b>mutáveis</b></p>
 *
 * @author Eduardo Vicente Bisneto
 * @version 1.0.0
 */

public class Plano {

    //Atributos

    /**
     * Identificador único do plano.
     * Imutável por ser um identificador (PK).
     */

    private long id;

    /**
     * Nome do plano.
     */

    private String plano;

    /**
     * Valor do plano em reais.
     */

    private double valor;

    /**
     * Indica de qual o tipo da mensalidade.
     * Valores aceitos:
     */

    private String tipoMensalidade;

    //Construtor

    /**
     * Construtor completo da classe Plano
     *
     * @param id Identificador único do plano (PK).
     * @param plano Nome do plano.
     * @param valor Valor do plano em reais.
     * @param tipoMensalidade Indica de qual o tipo da mensalidade.
     */

    public Plano(long id, String plano, double valor, String tipoMensalidade) {

        this.id = id;
        this.plano = plano;
        this.valor = valor;
        this.tipoMensalidade = tipoMensalidade;

    }

    //Getters e Setters

    public long getId() {

        return id;

    }

    public String getPlano() {

        return plano;

    }

    public void setPlano(String plano) {

        this.plano = plano;

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
                "Plano: " + this.plano + "\n" +
                "Valor: R$" + this.valor + "\n" +
                "Tipo de mensalidade: " + this.tipoMensalidade + "\n" +
                "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n";

    }

}