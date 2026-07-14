package model;

/**
 * Representa a entidade serviço
 *
 * <p>Observação: Os atributos que não possuem informações sobre sua mutabilidade são <b>mutáveis</b></p>
 *
 * @author Eduardo Vicente Bisneto
 * @version 1.0.0
 */
public class Servico {

    //Atributos

    /**
     * Identificador único do serviço.
     * Imutável por ser um identificador (PK).
     */
    private long id;

    /**
     * Identificador único da {@link EmpresaTecnica} (FK) que realiza o serviço.
     * Imutável por conta da estruturação do sistema.
     */
    private long idEmpresaTecnica;

    /**
     * Nome do serviço.
     */
    private String servico;

    /**
     * Descrição sobre o que é feito no serviço.
     */
    private String descricao;

    //Construtor

    /**
     * Construtor completo da classe Servico
     *
     * @param id Identificador único do serviço (PK).
     * @param idEmpresaTecnica Identificador único da {@link EmpresaTecnica} (FK) que realiza o serviço.
     * @param servico Nome do serviço.
     * @param descricao Descrição sobre o que é feito no serviço.
     */
    public Servico(long id, long idEmpresaTecnica, String servico, String descricao) {

        this.id = id;
        this.idEmpresaTecnica = idEmpresaTecnica;
        this.servico = servico;
        this.descricao = descricao;

    }

    /**
     * Construtor para o {@link dao.ServicoDAO#insert(Servico)}
     *
     * @param idEmpresaTecnica Identificador único da {@link EmpresaTecnica} (FK) que realiza o serviço.
     * @param servico Nome do serviço.
     * @param descricao Descrição sobre o que é feito no serviço.
     */
    public Servico(long idEmpresaTecnica, String servico, String descricao) {

        this.idEmpresaTecnica = idEmpresaTecnica;
        this.servico = servico;
        this.descricao = descricao;

    }

    /**
     * Construtor para o {@link dao.ServicoDAO#update(Servico)}
     *
     * @param servico Nome do serviço.
     * @param descricao Descrição sobre o que é feito no serviço.
     */
    public Servico(String servico, String descricao) {

        this.servico = servico;
        this.descricao = descricao;

    }

    //Getters e Setters

    public long getId() {

        return id;

    }

    public long getIdEmpresaTecnica() {

        return idEmpresaTecnica;

    }

    public String getServico() {

        return servico;

    }

    public void setServico(String servico) {

        this.servico = servico;

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
                "ID da empresa técnica: "+ this.idEmpresaTecnica + "\n" +
                "Serviço: "+ this.servico + "\n" +
                "Descrição: "+ this.descricao + "\n" +
                "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n";

    }

}