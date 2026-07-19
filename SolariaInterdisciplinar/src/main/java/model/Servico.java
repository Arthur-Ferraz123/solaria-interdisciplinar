package model;

/**
 * Representa a entidade servico
 *
 * <p>Observação: Os atributos que não possuem informações sobre sua mutabilidade são <b>mutáveis</b></p>
 *
 * @author Eduardo Vicente Bisneto
 * @version 1.0.0
 */
public class Servico {

    //Atributos

    /**
     * ID do servico registrado no banco de dados.
     * Imutável por ser a PK.
     */
    private long id;

    /**
     * ID da {@link EmpresaTecnica} que presta o servico. (FK)
     * Imutável por conta da estruturação do sistema.
     */
    private long idEmpresaTecnica;

    /**
     * Nome do servico.
     */
    private String servico;

    /**
     * Descrição sobre o que é feito no servico.
     */
    private String descricao;

    //Construtor

    /**
     * Construtor completo da classe Servico
     *
     * @param id ID do servico registrado no banco de dados.
     * @param idEmpresaTecnica ID da {@link EmpresaTecnica} que presta o servico. (FK)
     * @param servico Nome do servico.
     * @param descricao Descrição sobre o que é feito no servico.
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
     * @param idEmpresaTecnica ID da {@link EmpresaTecnica} que presta o servico. (FK)
     * @param servico Nome do servico.
     * @param descricao Descrição sobre o que é feito no servico.
     */
    public Servico(long idEmpresaTecnica, String servico, String descricao) {

        this.idEmpresaTecnica = idEmpresaTecnica;
        this.servico = servico;
        this.descricao = descricao;

    }

    /**
     * Construtor para o {@link dao.ServicoDAO#update(Servico)}
     *
     * @param servico Nome do servico.
     * @param descricao Descrição sobre o que é feito no servico.
     * @param id ID do servico registrado no banco de dados.
     */
    public Servico(String servico, String descricao, long id) {

        this.servico = servico;
        this.descricao = descricao;
        this.id = id;

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