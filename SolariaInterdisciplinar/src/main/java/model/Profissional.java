package model;

/**
 * Representa a entidade profissional
 *
 * <p>Observação: Os atributos que não possuem informações sobre sua mutabilidade são <b>mutáveis</b></p>
 *
 * @author Eduardo Vicente Bisneto
 * @version 1.0.0
 */
public class Profissional {

    //Atributos

    /**
     * ID da assinatura registrado no banco de dados.
     * Imutável por ser a PK.
     */
    private long id;

    /**
     * ID do {@link Usuario} que é o profissional. (FK) (UNIQUE)
     * Imutável por conta da estruturação do sistema.
     */
    private long idUsuario;

    /**
     * Indica qual a variação do usuário.
     * Imutável por conta da estruturação do sistema.
     * Valor aceito: "PROFISSIONAL"
     */
    private String tipoUsuario;

    /**
     * Indica qual profissão o profissional exerce.
     */
    private String profissao;

    /**
     * CPF do profissional. (UNIQUE)
     * Imutável por conta da estruturação do sistema.
     * Deve seguir o padrão previsto em {@link }.
     */
    private String cpf;

    /**
     * ID da {@link EmpresaTecnica} que o profissional trabalha. (FK)
     */
    private long idEmpresaTecnica;

    //Construtor

    /**
     * Construtor completo da classe Profissional
     *
     * @param id ID da assinatura registrado no banco de dados.
     * @param idUsuario ID do {@link Usuario} que é o profissional. (FK) (UNIQUE)
     * @param tipoUsuario Qual a variação do usuário.
     * @param profissao Profissão que o profissional exerce.
     * @param cpf CPF do profissional. (UNIQUE)
     * @param idEmpresaTecnica ID da {@link EmpresaTecnica} que o profissional trabalha. (FK)
     */
    public Profissional(long id, long idUsuario, String tipoUsuario, String profissao, String cpf, long idEmpresaTecnica) {

        this.id = id;
        this.idUsuario = idUsuario;
        this.tipoUsuario = tipoUsuario;
        this.profissao = profissao;
        this.cpf = cpf;
        this.idEmpresaTecnica = idEmpresaTecnica;

    }

    /**
     * Construtor para o {@link dao.ProfissionalDAO#insert(Profissional)}
     *
     * @param idUsuario ID do {@link Usuario} que é o profissional. (FK) (UNIQUE)
     * @param profissao Profissão que o profissional exerce.
     * @param cpf CPF do profissional. (UNIQUE)
     * @param idEmpresaTecnica ID da {@link EmpresaTecnica} que o profissional trabalha. (FK)
     */
    public Profissional(long idUsuario,String profissao, String cpf, long idEmpresaTecnica) {

        this.idUsuario = idUsuario;
        this.profissao = profissao;
        this.cpf = cpf;
        this.idEmpresaTecnica = idEmpresaTecnica;

    }

    /**
     * Construtor para o {@link dao.ProfissionalDAO#update(Profissional)}
     *
     * @param profissao Profissão que o profissional exerce.
     * @param idEmpresaTecnica ID da {@link EmpresaTecnica} que o profissional trabalha. (FK)
     * @param id ID da assinatura registrado no banco de dados.
     */
    public Profissional(String profissao, long idEmpresaTecnica, long id) {

        this.profissao = profissao;
        this.idEmpresaTecnica = idEmpresaTecnica;
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

    public String getProfissao() {

        return profissao;

    }

    public void setProfissao(String profissao) {

        this.profissao = profissao;

    }

    public String getCpf() {

        return cpf;

    }

    public long getIdEmpresaTecnica() {

        return idEmpresaTecnica;

    }

    public void setIdEmpresaTecnica(long idEmpresaTecnica) {

        this.idEmpresaTecnica = idEmpresaTecnica;

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
                "Profissão: "+ this.profissao + "\n" +
                "CPF: "+ this.cpf + "\n" +
                "ID da empresa técnica: "+ this.idEmpresaTecnica + "\n" +
                "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n";

    }

}