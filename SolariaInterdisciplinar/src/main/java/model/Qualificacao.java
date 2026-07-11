package model;

//Import do objeto utilizado para representar datatypes do tipo date no java
import java.time.LocalDate;

/**
 * Representa a entidade qualificação
 *
 * <p>Observação: Os atributos que não possuem informações sobre sua mutabilidade são <b>mutáveis</b></p>
 *
 * @author Eduardo Vicente Bisneto
 * @version 1.0.0
 */

public class Qualificacao {

    //Atributos

    /**
     * Identificador único da qualificação.
     * Imutável por ser um identificador (PK).
     */

    private long id;

    /**
     * Identificador único do {@link Profissional} (FK) que possuí a qualificação.
     * Imutável por conta da estruturação do sistema.
     */

    private long idProfissional;

    /**
     * Nome do órgão que emitiu a qualificação.
     */

    private String orgaoExpeditor;

    /**
     * Nome da qualificação.
     */

    private String nome;

    /**
     * O tipo credencial da qualificação.
     * Valores aceitos:
     */

    private String tipoCredencial;

    /**
     * Data que a qualificação foi emitida.
     */

    private LocalDate dataEmissao;

    /**
     * Data que a qualificação expira, no caso de ela expirar.
     */

    private LocalDate validade;

    /**
     * Carga horária realizada para obter a qualificação.
     */

    private double cargaHorariaCurso;

    /**
     * Número de registro da qualificação.
     */

    private String numeroRegistro;

    /**
     * Link do documento da qualificação.
     */

    private String documento;

    /**
     * No caso de ser uma NR qual o número.
     */

    private String numeroNr;

    /**
     * Qual fabricante de placas o certificado se aplica.
     */

    private String fabricanteCertificado;

    //Construtor

    /**
     * Construtor completo da classe Qualificacao
     *
     * @param id Identificador único da qualificação (PK).
     * @param idProfissional Identificador único do {@link Profissional} (FK) que possuí a qualificação.
     * @param orgaoExpeditor Nome do órgão que emitiu a qualificação.
     * @param nome Nome da qualificação.
     * @param tipoCredencial O tipo credencial da qualificação.
     * @param dataEmissao Data que a qualificação foi emitida.
     * @param validade Data que a qualificação expira, no caso de ela expirar.
     * @param cargaHorariaCurso Carga horária realizada para obter a qualificação.
     * @param numeroRegistro Número de registro da qualificação.
     * @param documento Link do documento da qualificação.
     * @param numeroNr No caso de ser uma NR qual o número.
     * @param fabricanteCertificado Qual fabricante de placas o certificado se aplica.
     */

    public Qualificacao(long id, long idProfissional, String orgaoExpeditor, String nome, String tipoCredencial, LocalDate dataEmissao,
                        LocalDate validade, double cargaHorariaCurso, String numeroRegistro, String documento, String numeroNr, String fabricanteCertificado) {

        this.id = id;
        this.idProfissional = idProfissional;
        this.orgaoExpeditor = orgaoExpeditor;
        this.nome = nome;
        this.tipoCredencial = tipoCredencial;
        this.dataEmissao = dataEmissao;
        this.validade = validade;
        this.cargaHorariaCurso = cargaHorariaCurso;
        this.numeroRegistro = numeroRegistro;
        this.documento = documento;
        this.numeroNr = numeroNr;
        this.fabricanteCertificado = fabricanteCertificado;

    }

    //Getters e Setters

    public long getId() {

        return id;

    }

    public long getIdProfissional() {

        return idProfissional;

    }

    public String getOrgaoExpeditor() {

        return orgaoExpeditor;

    }

    public void setOrgaoExpeditor(String orgaoExpeditor) {

        this.orgaoExpeditor = orgaoExpeditor;

    }

    public String getNome() {

        return nome;

    }

    public void setNome(String nome) {

        this.nome = nome;

    }

    public String getTipoCredencial() {

        return tipoCredencial;

    }

    public void setTipoCredencial(String tipoCredencial) {

        this.tipoCredencial = tipoCredencial;

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

    public double getCargaHorariaCurso() {

        return cargaHorariaCurso;

    }

    public void setCargaHorariaCurso(double cargaHorariaCurso) {

        this.cargaHorariaCurso = cargaHorariaCurso;

    }

    public String getNumeroRegistro() {

        return numeroRegistro;

    }

    public void setNumeroRegistro(String numeroRegistro) {

        this.numeroRegistro = numeroRegistro;

    }

    public String getDocumento() {

        return documento;

    }

    public void setDocumento(String documento) {

        this.documento = documento;

    }

    public String getNumeroNr() {

        return numeroNr;

    }

    public void setNumeroNr(String numeroNr) {

        this.numeroNr = numeroNr;

    }

    public String getFabricanteCertificado() {

        return fabricanteCertificado;

    }

    public void setFabricanteCertificado(String fabricanteCertificado) {

        this.fabricanteCertificado = fabricanteCertificado;

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
                "ID do profissional: "+ this.idProfissional + "\n" +
                "Órgão expedidor: "+ this.orgaoExpeditor + "\n" +
                "Nome: "+ this.nome + "\n" +
                "Tipo de credencial: "+ this.tipoCredencial + "\n" +
                "Data de emissão: "+ this.dataEmissao + "\n" +
                "Validade: "+ this.validade + "\n" +
                "Carga horária do curso: "+ this.cargaHorariaCurso + "\n" +
                "Número de registro: "+ this.numeroRegistro + "\n" +
                "Documento: "+ this.documento + "\n" +
                "Número da NR: "+ this.numeroNr + "\n" +
                "Fabricante da certificação: "+ this.fabricanteCertificado + "\n" +
                "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n";

    }

}