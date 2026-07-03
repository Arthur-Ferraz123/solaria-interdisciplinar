package model;

public class Plano {

    //Atributos

    //PK da tabela
    private long id;

    private String plano;
    private double valor;
    private String tipoMensalidade;

    //Construtor

    public Plano(long id, String plano, double valor, String tipoMensalidade) {

        this.id = id;
        this.plano = plano;
        this.valor = valor;
        this.tipoMensalidade = tipoMensalidade;

    }

    //Getters e Setters

    //OBS: O atributo id não tem setter, pois ele é a pk da tabela
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

    @Override
    public String toString() {

        return "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n" +
                "ID: " + this.id + "\n" +
                "model.Plano: " + this.plano + "\n" +
                "Valor: R$" + this.valor + "\n" +
                "Tipo de mensalidade: " + this.tipoMensalidade + "\n" +
                "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n";

    }

}
