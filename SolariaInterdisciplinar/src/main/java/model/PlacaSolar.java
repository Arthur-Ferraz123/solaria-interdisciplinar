package model;

/**
 * Representa a entidade placa solar
 *
 * <p>Observação: Os atributos que não possuem informações sobre sua mutabilidade são <b>mutáveis</b></p>
 *
 * @author Eduardo Vicente Bisneto
 * @version 1.0.0
 */
public class PlacaSolar {

    //Atributos

    /**
     * Identificador único da placa solar.
     * Imutável por ser um identificador (PK).
     */
    private long id;

    /**
     * Identificador único do {@link Fornecedor} (FK) que vende a placa solar.
     * Imutável por conta da estruturação do sistema.
     */
    private long idFornecedor;

    /**
     * Nome do modelo da placa solar.
     */
    private String modelo;

    /**
     * Código SKU (Stock Keeping Unit), o código alfanumérico que o vendedor utiliza como identificador do modelo. Cada fornecedor pode ter um código diferente mesmo o modelo sendo o mesmo
     */
    private String sku;

    /**
     * Tecnologia presente na placa.
     */
    private String tecnologia;

    /**
     * Tamanho da placa.
     */
    private String dimensoes;

    /**
     * Indica se a placa está ou não em estoque.
     */
    private boolean emEstoque;

    /**
     * Potência da placa em Watts.
     */
    private double potencia;

    /**
     * Nome da fabricante da placa.
     */
    private String fabricante;

    /**
     * Peso da placa em quilogramas.
     */
    private double peso;

    /**
     * Qual tipo de proteção a placa possuí.
     */
    private String grauProtecao;

    /**
     * Eficiência pratica da placa.
     */
    private double eficiencia;

    /**
     * Descrição sobre a placa.
     */
    private String descricao;

    //Construtor

    /**
     * Construtor completo da classe PlacaSolar
     *
     * @param id Identificador único da placa solar (PK).
     * @param idFornecedor Identificador único do {@link Fornecedor} (FK) que vende a placa solar.
     * @param modelo Nome do modelo da placa solar.
     * @param sku Código SKU (Stock Keeping Unit), o código alfanumérico que o vendedor utiliza como identificador do modelo.
     * @param tecnologia Tecnologia presente na placa.
     * @param dimensoes Tamanho da placa.
     * @param emEstoque A placa está ou não em estoque.
     * @param potencia Potência da placa em Watts.
     * @param fabricante Nome da fabricante da placa.
     * @param peso Peso da placa em quilogramas.
     * @param grauProtecao Qual tipo de proteção a placa possuí.
     * @param eficiencia Eficiência pratica da placa.
     * @param descricao Descrição sobre a placa.
     */
    public PlacaSolar(long id, long idFornecedor, String modelo, String sku, String tecnologia, String dimensoes,
                      boolean emEstoque, double potencia, String fabricante, double peso, String grauProtecao,
                      double eficiencia, String descricao) {

        this.id = id;
        this.idFornecedor = idFornecedor;
        this.modelo = modelo;
        this.sku = sku;
        this.tecnologia = tecnologia;
        this.dimensoes = dimensoes;
        this.emEstoque = emEstoque;
        this.potencia = potencia;
        this.fabricante = fabricante;
        this.peso = peso;
        this.grauProtecao = grauProtecao;
        this.eficiencia = eficiencia;
        this.descricao = descricao;

    }

    /**
     * Construtor para o {@link dao.PlacaSolarDAO#insert(PlacaSolar)}
     *
     * @param idFornecedor Identificador único do {@link Fornecedor} (FK) que vende a placa solar.
     * @param modelo Nome do modelo da placa solar.
     * @param sku Código SKU (Stock Keeping Unit), o código alfanumérico que o vendedor utiliza como identificador do modelo.
     * @param tecnologia Tecnologia presente na placa.
     * @param dimensoes Tamanho da placa.
     * @param emEstoque A placa está ou não em estoque.
     * @param potencia Potência da placa em Watts.
     * @param fabricante Nome da fabricante da placa.
     * @param peso Peso da placa em quilogramas.
     * @param grauProtecao Qual tipo de proteção a placa possuí.
     * @param eficiencia Eficiência pratica da placa.
     * @param descricao Descrição sobre a placa.
     */
    public PlacaSolar(long idFornecedor, String modelo, String sku, String tecnologia, String dimensoes,
                      boolean emEstoque, double potencia, String fabricante, double peso, String grauProtecao,
                      double eficiencia, String descricao) {

        this.idFornecedor = idFornecedor;
        this.modelo = modelo;
        this.sku = sku;
        this.tecnologia = tecnologia;
        this.dimensoes = dimensoes;
        this.emEstoque = emEstoque;
        this.potencia = potencia;
        this.fabricante = fabricante;
        this.peso = peso;
        this.grauProtecao = grauProtecao;
        this.eficiencia = eficiencia;
        this.descricao = descricao;

    }

    /**
     * Construtor para o {@link dao.PlacaSolarDAO#update(PlacaSolar)}
     *
     * @param id Identificador único da placa solar (PK).
     * @param modelo Nome do modelo da placa solar.
     * @param sku Código SKU (Stock Keeping Unit), o código alfanumérico que o vendedor utiliza como identificador do modelo.
     * @param tecnologia Tecnologia presente na placa.
     * @param dimensoes Tamanho da placa.
     * @param emEstoque A placa está ou não em estoque.
     * @param potencia Potência da placa em Watts.
     * @param fabricante Nome da fabricante da placa.
     * @param peso Peso da placa em quilogramas.
     * @param grauProtecao Qual tipo de proteção a placa possuí.
     * @param eficiencia Eficiência pratica da placa.
     * @param descricao Descrição sobre a placa.
     * @param daoUpdate Parâmetro passado somente para indicar o construtor
     */
    public PlacaSolar(long id, String modelo, String sku, String tecnologia, String dimensoes,
                      boolean emEstoque, double potencia, String fabricante, double peso, String grauProtecao,
                      double eficiencia, String descricao, boolean daoUpdate) {

        this.id = id;
        this.modelo = modelo;
        this.sku = sku;
        this.tecnologia = tecnologia;
        this.dimensoes = dimensoes;
        this.emEstoque = emEstoque;
        this.potencia = potencia;
        this.fabricante = fabricante;
        this.peso = peso;
        this.grauProtecao = grauProtecao;
        this.eficiencia = eficiencia;
        this.descricao = descricao;

    }

    //Getters e Setters

    public long getId() {

        return id;

    }

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

    public String getDimensoes() {

        return dimensoes;

    }

    public void setDimensoes(String dimensoes) {

        this.dimensoes = dimensoes;

    }

    public boolean isEmEstoque() {

        return emEstoque;

    }

    public void setEmEstoque(boolean emEstoque) {

        this.emEstoque = emEstoque;

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
                "ID do fornecedor: "+ this.idFornecedor + "\n" +
                "Modelo: "+ this.modelo + "\n" +
                "SKU: "+ this.sku + "\n" +
                "Tecnologia: "+ this.tecnologia + "\n" +
                "Dimensão: "+ this.dimensoes + "\n" +
                "Está em estoque: "+ this.emEstoque + "\n" +
                "Potência: "+ this.potencia + "w" + "\n" +
                "Fabricante: "+ this.fabricante + "\n" +
                "Peso: "+ this.peso + "kg" + "\n" +
                "Grau de proteção: "+ this.grauProtecao + "\n" +
                "Eficiência: "+ this.eficiencia + "w" + "\n" +
                "Descrição: "+ this.descricao + "\n" +
                "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n";

    }

}