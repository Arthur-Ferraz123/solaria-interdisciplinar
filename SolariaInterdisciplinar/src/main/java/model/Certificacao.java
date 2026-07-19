package model;

import java.time.LocalDate;

/**
 * Representa a entidade certificacao
 *
 * <p>Observação: Os atributos que não possuem informações sobre sua mutabilidade são <b>mutáveis</b></p>
 *
 * @author Eduardo Vicente Bisneto
 * @version 1.0.0
 */
public class Certificacao {

    //Atributos

    /**
     * ID da certificacao registrado no banco de dados.
     * Imutável por ser a PK.
     */
    private long id;

    /**
     * ID do {@link Fornecedor} que a certificacao se aplica. (FK)
     * Imutável por conta da estruturação do sistema.
     */
    private long idFornecedor;

    /**
     * Selo da certificacao.
     */
    private String selo;

    /**
     * Número de registro da certificacao.
     */
    private String numeroRegistro;

    /**
     * Data que a certificacao foi emitida.
     */
    private LocalDate dataEmissao;

    /**
     * Data de validade da certificacao.
     */
    private LocalDate validade;

    /**
     * Link do documento da certificacao.
     */
    private String documento;

    //Construtor

    /**
     * Construtor completo da classe Certificacao
     *
     * @param id ID da certificacao registrado no banco de dados.
     * @param idFornecedor ID do {@link Fornecedor} que a certificacao se aplica. (FK)
     * @param selo Selo da certificação.
     * @param numeroRegistro Número de registro da certificação.
     * @param dataEmissao Data que a certificação foi emitida.
     * @param validade Data de validade da certificação.
     * @param documento Link do documento da certificação.
     */
    public Certificacao(long id, long idFornecedor, String selo, String numeroRegistro,
                        LocalDate dataEmissao, LocalDate validade, String documento) {

        this.id = id;
        this.idFornecedor = idFornecedor;
        this.selo = selo;
        this.numeroRegistro = numeroRegistro;
        this.dataEmissao = dataEmissao;
        this.validade = validade;
        this.documento = documento;

    }

    /**
     * Construtor para o {@link dao.CertificacaoDAO#insert(Certificacao)}
     *
     * @param idFornecedor ID do {@link Fornecedor} que a certificacao se aplica. (FK)
     * @param selo Selo da certificacao.
     * @param numeroRegistro Número de registro da certificacao.
     * @param dataEmissao Data que a certificacao foi emitida.
     * @param validade Data de validade da certificacao.
     * @param documento Link do documento da certificacao.
     */
    public Certificacao(long idFornecedor, String selo, String numeroRegistro, LocalDate dataEmissao, LocalDate validade, String documento) {

        this.idFornecedor = idFornecedor;
        this.selo = selo;
        this.numeroRegistro = numeroRegistro;
        this.dataEmissao = dataEmissao;
        this.validade = validade;
        this.documento = documento;

    }

    /**
     * Construtor para o {@link dao.CertificacaoDAO#update(Certificacao)}
     *
     * @param selo Selo da certificacao.
     * @param numeroRegistro Número de registro da certificacao.
     * @param dataEmissao Data que a certificacao foi emitida.
     * @param validade Data de validade da certificacao.
     * @param documento Link do documento da certificacao.
     * @param id ID da certificacao registrado no banco de dados.
     */
    public Certificacao(String selo, String numeroRegistro, LocalDate dataEmissao, LocalDate validade, String documento, long id) {

        this.selo = selo;
        this.numeroRegistro = numeroRegistro;
        this.dataEmissao = dataEmissao;
        this.validade = validade;
        this.documento = documento;
        this.id = id;

    }

    //Getters e Setters

    public long getId() {

        return id;

    }

    public long getIdFornecedor() {

        return idFornecedor;

    }

    public String getSelo() {

        return selo;

    }

    public void setSelo(String selo) {

        this.selo = selo;

    }

    public String getNumeroRegistro() {

        return numeroRegistro;

    }

    public void setNumeroRegistro(String numeroRegistro) {

        this.numeroRegistro = numeroRegistro;

    }

    public LocalDate getDataEmissao() {

        return dataEmissao;

    }

    public void setDataEmissao(LocalDate dataEmissao) {

        this.dataEmissao = dataEmissao;

    }

    public LocalDate getValidade() {

        return validade;

    }

    public void setValidade(LocalDate validade) {

        this.validade = validade;

    }

    public String getDocumento() {

        return documento;

    }

    public void setDocumento(String documento) {

        this.documento = documento;

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
                "ID do fornecedor: "+ this.idFornecedor + "\n" +
                "Selo: "+ this.selo + "\n" +
                "Número de registro: "+ this.numeroRegistro + "\n" +
                "Data de emissão: "+ this.dataEmissao + "\n" +
                "Validade: "+ this.validade + "\n" +
                "Documento: "+ this.documento + "\n" +
                "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n";

    }

}