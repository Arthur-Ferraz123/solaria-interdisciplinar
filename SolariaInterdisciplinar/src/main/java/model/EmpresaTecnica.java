package model;

/**
 * Representa a entidade empresa técnica
 *
 * <p>Observação: Os atributos que não possuem informações sobre sua mutabilidade são <b>mutáveis</b></p>
 *
 * @author Eduardo Vicente Bisneto
 * @version 1.0.0
 */

public class EmpresaTecnica {

    //Atributos

    /**
     * Identificador único da empresa técnica.
     * Imutável por ser um identificador (PK).
     */

    private long id;

    /**
     * Identificador único do {@link Usuario} (FK) que é a empresa técnica.
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
     * CNPJ da empresa técnica.
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
     * @param id Identificador único da empresa técnica (PK).
     * @param idUsuario Identificador único do {@link Usuario} (FK) que é a empresa técnica.
     * @param tipoUsuario Indica qual a variação do usuário.
     * @param cnpj CNPJ da empresa técnica.
     * @param razaoSocial Razão social da empresa técnica.
     */

    public EmpresaTecnica(long id, long idUsuario, String tipoUsuario, String cnpj, String razaoSocial) {

        this.id = id;
        this.idUsuario = idUsuario;
        this.tipoUsuario = tipoUsuario;
        this.cnpj = cnpj;
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