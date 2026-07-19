package model;

import java.time.LocalDate;

/**
 * Representa a entidade assinatura
 *
 * <p>Observação: Os atributos que não possuem informações sobre sua mutabilidade são <b>mutáveis</b></p>
 *
 * @author Eduardo Vicente Bisneto
 * @version 1.0.0
 */
public class Assinatura {

    //Atributos

    /**
     * ID da assinatura registrado no banco de dados.
     * Imutável por ser a PK.
     */
    private long id;

    /**
     * ID do {@link Usuario} que realiza a assinatura. (FK) (UNIQUE)
     * Imutável por conta da estruturação do sistema.
     */
    private long idUsuario;

    /**
     * ID do {@link Plano} atual da assinatura. (FK)
     */
    private long idPlano;

    /**
     * Indica qual o estado atual da assinatura.
     * Valores aceitos: {"INATIVA", "ATIVA", "EM_PROCESSAMENTO", "VENCIDA", "AGUARDANDO_PAGAMENTO"}
     */
    private String statusAssinatura;

    /**
     * Indica se a assinatura debita automaticamente da conta.
     */
    private boolean renovacaoAutomatica;

    /**
     * Data que a assinatura foi iniciada ou a última vez que foi paga.
     */
    private LocalDate dataInicio;

    /**
     * Data de vencimento da assinatura.
     */
    private LocalDate validade;

    //Construtor

    /**
     * Construtor completo da classe Assinatura
     *
     * @param id ID da assinatura registrado no banco de dados.
     * @param idUsuario ID do {@link Usuario} que realiza a assinatura. (FK) (UNIQUE)
     * @param idPlano ID do {@link Plano} atual da assinatura. (FK)
     * @param statusAssinatura Qual o status atual da assinatura.
     * @param renovacaoAutomatica A assinatura debita ou não automaticamente da conta.
     * @param dataInicio Data que a assinatura foi iniciada ou a última vez que foi paga.
     * @param validade Data de vencimento da assinatura.
     */
    public Assinatura(long id, long idUsuario, long idPlano, String statusAssinatura, boolean renovacaoAutomatica, LocalDate dataInicio, LocalDate validade) {

        this.id = id;
        this.idUsuario = idUsuario;
        this.idPlano = idPlano;
        this.statusAssinatura = statusAssinatura;
        this.renovacaoAutomatica = renovacaoAutomatica;
        this.dataInicio = dataInicio;
        this.validade = validade;

    }

    /**
     * Construtor para o {@link dao.AssinaturaDAO#insert(Assinatura)}
     *
     * @param idUsuario ID do {@link Usuario} que realiza a assinatura. (FK) (UNIQUE)
     * @param idPlano ID do {@link Plano} atual da assinatura. (FK)
     * @param statusAssinatura Qual o status atual da assinatura.
     * @param renovacaoAutomatica A assinatura debita ou não automaticamente da conta.
     * @param dataInicio Data que a assinatura foi iniciada ou a última vez que foi paga.
     * @param validade Data de vencimento da assinatura.
     */
    public Assinatura(long idUsuario, long idPlano, String statusAssinatura, boolean renovacaoAutomatica, LocalDate dataInicio, LocalDate validade) {

        this.idUsuario = idUsuario;
        this.idPlano = idPlano;
        this.statusAssinatura = statusAssinatura;
        this.renovacaoAutomatica = renovacaoAutomatica;
        this.dataInicio = dataInicio;
        this.validade = validade;

    }

    /**
     * Construtor para o {@link dao.AssinaturaDAO#update(Assinatura)}
     *
     * @param idPlano ID do {@link Plano} atual da assinatura. (FK)
     * @param statusAssinatura Qual o status atual da assinatura.
     * @param renovacaoAutomatica A assinatura debita ou não automaticamente da conta.
     * @param dataInicio Data que a assinatura foi iniciada ou a última vez que foi paga.
     * @param validade Data de vencimento da assinatura.
     * @param id ID da assinatura registrado no banco de dados.
     */
    public Assinatura(long idPlano, String statusAssinatura, boolean renovacaoAutomatica, LocalDate dataInicio, LocalDate validade, long id) {

        this.idPlano = idPlano;
        this.statusAssinatura = statusAssinatura;
        this.renovacaoAutomatica = renovacaoAutomatica;
        this.dataInicio = dataInicio;
        this.validade = validade;
        this.id = id;

    }

    //Getters e Setters

    public long getId() {

        return id;

    }

    public long getIdUsuario() {

        return idUsuario;

    }

    public long getIdPlano() {

        return idPlano;

    }

    public String getStatusAssinatura() {

        return statusAssinatura;

    }

    public void setStatusAssinatura(String statusAssinatura) {

        this.statusAssinatura = statusAssinatura;

    }

    public boolean isRenovacaoAutomatica() {

        return renovacaoAutomatica;

    }

    public void setRenovacaoAutomatica(boolean renovacaoAutomatica) {

        this.renovacaoAutomatica = renovacaoAutomatica;

    }

    public LocalDate getDataInicio() {

        return dataInicio;

    }

    public void setDataInicio(LocalDate dataInicio) {

        this.dataInicio = dataInicio;

    }

    public LocalDate getValidade() {

        return validade;

    }

    public void setValidade(LocalDate validade) {

        this.validade = validade;

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
    public String toString() {

        return "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n" +
                "ID: " + this.id + "\n" +
                "ID do usuário: " + this.idUsuario + "\n" +
                "ID do plano: " + this.idPlano + "\n" +
                "Status da assinatura: " + this.statusAssinatura + "\n" +
                "Renovação automática: " + this.renovacaoAutomatica + "\n" +
                "Data de inicio: " + this.dataInicio + "\n" +
                "Validade: " + this.validade + "\n" +
                "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n";

    }

}