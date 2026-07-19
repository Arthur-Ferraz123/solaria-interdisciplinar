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
     * ID do fornecedor registrado no banco de dados.
     * Imutável por ser a PK.
     */
    private long id;

    /**
     * ID do {@link Usuario} que é o fornecedor. (FK) (UNIQUE)
     * Imutável por conta da estruturação do sistema.
     */
    private long idUsuario;

    /**
     * Indica qual a variação do {@link Usuario}.
     * Imutável por conta da estruturação do sistema.
     * O único valor aceito é "FORNECEDOR".
     */
    private String tipoUsuario;

    /**
     * Indica se ele é fabricante ou distribuidor.
     * Valores aceitos: {"FABRICANTE", "DISTRIBUIDOR"}
     */
    private String tipoFornecedor;

    /**
     * CNPJ do fornecedor. (UNIQUE)
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
     * @param id ID do fornecedor registrado no banco de dados.
     * @param idUsuario ID do {@link Usuario} que é o fornecedor. (FK) (UNIQUE)
     * @param tipoUsuario Qual a variação do usuário.
     * @param tipoFornecedor Indica se ele é fabricante ou distribuidor.
     * @param cnpj CNPJ do fornecedor. (UNIQUE)
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
     * @param idUsuario ID do {@link Usuario} que é o fornecedor. (FK) (UNIQUE)
     * @param tipoFornecedor Indica se ele é fabricante ou distribuidor.
     * @param cnpj CNPJ do fornecedor. (UNIQUE)
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
     * @param tipoFornecedor Indica se ele é fabricante ou distribuidor.
     * @param razaoSocial Razão social do fornecedor
     * @param id ID do fornecedor registrado no banco de dados.
     */
    public Fornecedor(String tipoFornecedor, String razaoSocial, long id) {

        this.tipoFornecedor = tipoFornecedor;
        this.razaoSocial = razaoSocial;
        this.id = id;

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