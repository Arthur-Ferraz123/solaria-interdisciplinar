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
     * Identificador único do profissional.
     * Imutável por ser um identificador (PK).
     */

    private long id;

    /**
     * Identificador único do {@link Usuario} (FK) que é o profissional.
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
     * Indica qual função o profissional exerce.
     */

    private String funcao;

    /**
     * CPF do profissional.
     * Imutável por conta da estruturação do sistema.
     * Deve seguir o padrão previsto em {@link }.
     */

    private String cpf;

    /**
     * Identificador único da {@link EmpresaTecnica} (FK) que o profissional trabalha.
     */

    private long idEmpresaTecnica;

    //Construtor

    /**
     * Construtor completo da classe Profissional
     *
     * @param id Identificador único do profissional (PK).
     * @param idUsuario Identificador único do {@link Usuario} (FK) que é o profissional.
     * @param tipoUsuario Qual a variação do usuário.
     * @param funcao Função que o profissional exerce.
     * @param cpf CPF do profissional.
     * @param idEmpresaTecnica Identificador único da {@link EmpresaTecnica} (FK) que o profissional trabalha.
     */

    public Profissional(long id, long idUsuario, String tipoUsuario, String funcao, String cpf, long idEmpresaTecnica) {

        this.id = id;
        this.idUsuario = idUsuario;
        this.tipoUsuario = tipoUsuario;
        this.funcao = funcao;
        this.cpf = cpf;
        this.idEmpresaTecnica = idEmpresaTecnica;

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

    public String getFuncao() {

        return funcao;

    }

    public void setFuncao(String funcao) {

        this.funcao = funcao;

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
                "Função: "+ this.funcao + "\n" +
                "CPF: "+ this.cpf + "\n" +
                "ID da empresa técnica: "+ this.idEmpresaTecnica + "\n" +
                "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n";

    }

}