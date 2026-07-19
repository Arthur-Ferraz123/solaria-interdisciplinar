package model;

/**
 * Representa a entidade empresa_tecnica
 *
 * <p>Observação: Os atributos que não possuem informações sobre sua mutabilidade são <b>mutáveis</b></p>
 *
 * @author Eduardo Vicente Bisneto
 * @version 1.0.0
 */
public class EmpresaTecnica {

    //Atributos

    /**
     * ID da empresa_tecnica registrado no banco de dados.
     * Imutável por ser a PK.
     */
    private long id;

    /**
     * ID do {@link Usuario} que é a empresa_tecnica. (FK) (UNIQUE)
     * Imutável por conta da estruturação do sistema.
     */
    private long idUsuario;

    /**
     * Indica qual a variação do {@link Usuario}.
     * Imutável por conta da estruturação do sistema.
     * O único valor aceito é "EMPRESA_TECNICA".
     */
    private String tipoUsuario;

    /**
     * CNPJ da empresa técnica. (UNIQUE)
     * Imutável por conta da estruturação do sistema.
     * Deve seguir o padrão previsto em {@link }.
     */
    private String cnpj;

    /**
     * Razão social da empresa técnica
     */
    private String razaoSocial;

    //Construtor

    /**
     * Construtor completo da classe EmpresaTecnica
     *
     * @param id ID da empresa_tecnica registrado no banco de dados.
     * @param idUsuario ID do {@link Usuario} que é a empresa_tecnica. (FK) (UNIQUE)
     * @param tipoUsuario Indica qual a variação do usuário.
     * @param cnpj CNPJ da empresa_tecnica. (UNIQUE)
     * @param razaoSocial Razão social da empresa_tecnica.
     */
    public EmpresaTecnica(long id, long idUsuario, String tipoUsuario, String cnpj, String razaoSocial) {

        this.id = id;
        this.idUsuario = idUsuario;
        this.tipoUsuario = tipoUsuario;
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;

    }

    /**
     * Construtor para o {@link dao.EmpresaTecnicaDAO#insert(EmpresaTecnica)}
     *
     * @param idUsuario ID do {@link Usuario} que é a empresa_tecnica. (FK) (UNIQUE)
     * @param cnpj CNPJ da empresa_tecnica. (UNIQUE)
     * @param razaoSocial Razão social da empresa_tecnica.
     */
    public EmpresaTecnica(long idUsuario, String cnpj, String razaoSocial) {

        this.idUsuario = idUsuario;
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;

    }

    /**
     * Construtor para o {@link dao.EmpresaTecnicaDAO#update(EmpresaTecnica)}
     *
     * @param razaoSocial Razão social da empresa_tecnica.
     * @param id ID da empresa_tecnica registrado no banco de dados.
     */
    public EmpresaTecnica(String razaoSocial, long id) {

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
                "Razão social: "+ this.razaoSocial + "\n" +
                "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n";

    }

}