public class PlacaSolar {

    //Atributos

    //PK da tabela
    private long id;

    //FK originada da tabela fornecedor
    private long idFornecedor;

    private String modelo;
    private String sku;
    private String tecnologia;
    private String dimensao;
    private boolean estoque;
    private double potencia;
    private String fabricante;
    private double peso;
    private String grauProtecao;
    private double eficiencia;
    private String descricao;

    //Construtor
    public PlacaSolar(long id, long idFornecedor, String modelo, String sku, String tecnologia, String dimensao,
                      boolean estoque, double potencia, String fabricante, double peso, String grauProtecao,
                      double eficiencia, String descricao) {

        this.id = id;
        this.idFornecedor = idFornecedor;
        this.modelo = modelo;
        this.sku = sku;
        this.tecnologia = tecnologia;
        this.dimensao = dimensao;
        this.estoque = estoque;
        this.potencia = potencia;
        this.fabricante = fabricante;
        this.peso = peso;
        this.grauProtecao = grauProtecao;
        this.eficiencia = eficiencia;
        this.descricao = descricao;

    }

    //Getters e Setters

    //OBS: O atributo id não tem setter, pois ele é a pk da tabela
    public long getId() {

        return id;

    }

    //OBS: O atributo idFornecedor é uma FK e é imutável, então não possui setter
    public long getIdFornecedor() {

        return idFornecedor;

    }

    public String getModelo() {

        return modelo;

    }

    public void setModelo(String modelo) {

        this.modelo = modelo;

    }

    public String getSku() {

        return sku;

    }

    public void setSku(String sku) {

        this.sku = sku;

    }

    public String getTecnologia() {

        return tecnologia;

    }

    public void setTecnologia(String tecnologia) {

        this.tecnologia = tecnologia;

    }

    public String getDimensao() {

        return dimensao;

    }

    public void setDimensao(String dimensao) {

        this.dimensao = dimensao;

    }

    public boolean getEstoque() {

        return estoque;

    }

    public void setEstoque(boolean estoque) {

        this.estoque = estoque;

    }

    public double getPotencia() {

        return potencia;

    }

    public void setPotencia(double potencia) {

        this.potencia = potencia;

    }

    public String getFabricante() {

        return fabricante;

    }

    public void setFabricante(String fabricante) {

        this.fabricante = fabricante;

    }

    public double getPeso() {

        return peso;

    }

    public void setPeso(double peso) {

        this.peso = peso;

    }

    public String getGrauProtecao() {

        return grauProtecao;

    }

    public void setGrauProtecao(String grauProtecao) {

        this.grauProtecao = grauProtecao;

    }

    public double getEficiencia() {

        return eficiencia;

    }

    public void setEficiencia(double eficiencia) {

        this.eficiencia = eficiencia;

    }

    public String getDescricao() {

        return descricao;

    }

    public void setDescricao(String descricao) {

        this.descricao = descricao;

    }

    //Método toString
    @Override
    public String toString(){

        return  "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n" +
                "ID: "+ this.id + "\n" +
                "ID do fornecedor: "+ this.idFornecedor + "\n" +
                "Modelo: "+ this.modelo + "\n" +
                "SKU: "+ this.sku + "\n" +
                "Tecnologia: "+ this.tecnologia + "\n" +
                "Dimensão: "+ this.dimensao + "\n" +
                "Estoque: "+ this.estoque + "\n" +
                "Potência: "+ this.potencia + "w" + "\n" +
                "Fabricante: "+ this.fabricante + "\n" +
                "Peso: "+ this.peso + "kg" + "\n" +
                "Grau de proteção: "+ this.grauProtecao + "\n" +
                "Eficiência: "+ this.eficiencia + "\n" +
                "Descrição: "+ this.descricao + "\n" +
                "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n";

    }

}
