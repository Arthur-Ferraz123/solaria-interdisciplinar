package model;

//Import do objeto utilizado para representar datatypes do tipo date no java
import java.time.LocalDate;

/**
 * Representa a entidade certificação
 *
 * <p>Observação: Os atributos que não possuem informações sobre sua mutabilidade são <b>mutáveis</b></p>
 *
 * @author Eduardo Vicente Bisneto
 * @version 1.0.0
 */


public class Certificacao {

    //Atributos

    /**
     * Identificador único da certificação.
     * Imutável por ser um identificador (PK).
     */

    private long id;

    /**
     * Identificador único do {@link Fornecedor} (FK) que possuí a certificação.
     * Imutável por conta da estruturação do sistema.
     */

    private long idFornecedor;

    /**
     * Selo da certificação.
     */

    private String selo;

    /**
     * Número de registro da certificação.
     */

    private String numeroRegistro;

    /**
     * Data que a certificação foi emitida.
     */

    private LocalDate dataEmissao;

    /**
     * Data de validade da certificação.
     */

    private LocalDate validade;

    /**
     * Link do documento da certificação.
     */

    private String documento;

    //Construtor

    /**
     * Construtor completo da classe Certificacao
     *
     * @param id Identificador único da certificação (PK).
     * @param idFornecedor Identificador único do {@link Fornecedor} (FK) que possuí a certificação.
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