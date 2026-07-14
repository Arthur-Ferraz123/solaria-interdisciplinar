package model;

/**
 * Representa a entidade fornecedor
 *
 * <p>Observação: Os atributos que não possuem informações sobre sua mutabilidade são <b>mutáveis</b></p>
 *
 * @author Eduardo Vicente Bisneto
 * @version 1.0.0
 */
public class Fornecedor {

    //Atributos

    /**
     * Identificador único do fornecedor.
     * Imutável por ser um identificador (PK).
     */
    private long id;

    /**
     * Identificador único do {@link Usuario} (FK) que é o fornecedor.
     * Imutável por conta da estruturação do sistema.
     */
    private long idUsuario;

    /**
     * Indica qual a variação do usuário.
     * Imutável por conta da estruturação do sistema.
     * Valores aceitos:
     */
    private String tipoUsuario;

    /**
     * Indica se ele é fabricante ou distribuidor
     * Valores aceitos: {"FABRICANTE", "DISTRIBUIDOR"}
     */
    private String tipoFornecedor;

    /**
     * CNPJ do fornecedor.
     * Imutável por conta da estruturação do sistema.
     * Deve seguir o padrão previsto em {@link }.
     */
    private String cnpj;

    /**
     * Razão social do fornecedor.
     */
    private String razaoSocial;

    //Construtor

    /**
     * Construtor completo da classe Fornecedor
     *
     * @param id Identificador único do fornecedor (PK).
     * @param idUsuario Identificador único do {@link Usuario} (FK) que é o fornecedor.
     * @param tipoUsuario Qual a variação do usuário.
     * @param tipoFornecedor Indica qual tipo de placas solares o fornecedor mais trabalha.
     * @param cnpj CNPJ do fornecedor.
     * @param razaoSocial Razão social do fornecedor
     */
    public Fornecedor(long id, long idUsuario, String tipoUsuario, String tipoFornecedor, String cnpj, String razaoSocial) {

        this.id = id;
        this.idUsuario = idUsuario;
        this.tipoUsuario = tipoUsuario;
        this.tipoFornecedor = tipoFornecedor;
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;

    }

    /**
     * Construtor para o {@link dao.FornecedorDAO#insert(Fornecedor)}
     * 
     * @param idUsuario Identificador único do {@link Usuario} (FK) que é o fornecedor.
     * @param tipoFornecedor Indica qual tipo de placas solares o fornecedor mais trabalha.
     * @param cnpj CNPJ do fornecedor.
     * @param razaoSocial Razão social do fornecedor
     */
    public Fornecedor(long idUsuario, String tipoFornecedor, String cnpj, String razaoSocial) {
        
        this.idUsuario = idUsuario;
        this.tipoFornecedor = tipoFornecedor;
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
        
    }

    /**
     * Construtor para o {@link dao.FornecedorDAO#update(Fornecedor)}
     *
     * @param id Identificador único do fornecedor (PK).
     * @param tipoFornecedor Indica qual tipo de placas solares o fornecedor mais trabalha.
     * @param razaoSocial Razão social do fornecedor
     */
    public Fornecedor(long id, String tipoFornecedor, String razaoSocial) {

        this.id = id;
        this.tipoFornecedor = tipoFornecedor;
        this.razaoSocial = razaoSocial;

    }

    //Getters e Setters

    public long getId() {

        return id;

    }

    public long getIdUsuario() {

        return idUsuario;

    }

    public String getTipoUsuario() {

        return tipoUsuario;

    }

    public String getTipoFornecedor() {

        return tipoFornecedor;

    }

    public void setTipoFornecedor(String tipoFornecedor) {

        this.tipoFornecedor = tipoFornecedor;

    }

    public String getCnpj() {

        return cnpj;

    }

    public String getRazaoSocial() {

        return razaoSocial;

    }

    public void setRazaoSocial(String razaoSocial) {

        this.razaoSocial = razaoSocial;

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
                "Tipo do usuário: "+ this.tipoUsuario + "\n" +
                "Tipo do fornecedor: "+ this.tipoFornecedor + "\n" +
                "CNPJ: "+ this.cnpj + "\n" +
                "Razão social: " + this.razaoSocial + "\n" +
                "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n";

    }

}