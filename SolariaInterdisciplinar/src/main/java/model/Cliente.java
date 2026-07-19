package model;

/**
 * Representa a entidade cliente
 *
 * <p>Observação: Os atributos que não possuem informações sobre sua mutabilidade são <b>mutáveis</b></p>
 *
 * @author Eduardo Vicente Bisneto
 * @version 1.0.0
 */
public class Cliente{

    //Atributos

    /**
     * ID do cliente registrado no banco de dados.
     * Imutável por ser a PK.
     */
    private long id;

    /**
     * ID do {@link Usuario} que é o cliente. (FK) (UNIQUE)
     * Imutável por conta da estruturação do sistema.
     */
    private long idUsuario;

    /**
     * Indica qual a variação do {@link Usuario}.
     * Imutável por conta da estruturação do sistema.
     * O único valor aceito é "CLIENTE".
     */
    private String tipoUsuario;

    /**
     * CNPJ do cliente. (UNIQUE)
     * Imutável por conta da estruturação do sistema.
     * Deve seguir o padrão previsto em {@link }.
     */
    private String cnpj;

    /**
     * Razão social do cliente.
     */
    private String razaoSocial;

    //Construtor

    /**
     * Construtor completo da classe Cliente
     *
     * @param id ID do cliente registrado no banco de dados.
     * @param idUsuario ID do {@link Usuario} que é o cliente. (FK) (UNIQUE)
     * @param tipoUsuario Qual a variação do usuário.
     * @param cnpj CNPJ do cliente. (UNIQUE)
     * @param razaoSocial Razão social do cliente.
     */
    public Cliente(long id, long idUsuario, String tipoUsuario, String cnpj, String razaoSocial) {

        this.id = id;
        this.idUsuario = idUsuario;
        this.tipoUsuario = tipoUsuario;
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;

    }

    /**
     * Construtor para o {@link dao.ClienteDAO#insert(Cliente)}
     *
     * @param idUsuario ID do {@link Usuario} que é o cliente. (FK) (UNIQUE)
     * @param cnpj CNPJ do cliente. (UNIQUE)
     * @param razaoSocial Razão social do cliente.
     */
    public Cliente(long idUsuario, String cnpj, String razaoSocial) {

        this.idUsuario = idUsuario;
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;

    }

    /**
     * Construtor para o {@link dao.ClienteDAO#update(Cliente)}
     *
     * @param razaoSocial Razão social do cliente.
     * @param id ID do cliente registrado no banco de dados.
     */
    public Cliente(String razaoSocial, long id) {

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
                "CNPJ: "+ this.cnpj + "\n" +
                "Razão social: " + this.razaoSocial + "\n" +
                "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n";

    }

}