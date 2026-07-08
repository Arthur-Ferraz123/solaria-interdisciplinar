package model;

/**
 * Representa a entidade placa solar certificação
 *
 * <p>Observação: Os atributos que não possuem informações sobre sua mutabilidade são <b>mutáveis</b></p>
 *
 * @author Eduardo Vicente Bisneto
 * @version 1.0.0
 */

public class PlacaSolarCertificacao {

    //Atributos

    /**
     * Identificador único da placa solar certificação.
     * Imutável por ser um identificador (PK).
     */

    private long id;

    /**
     * Identificador único da {@link PlacaSolar} (FK) ao qual a placa solar certificação se aplica.
     * Imutável por conta da estruturação do sistema.
     */

    private long idPlacaSolar;

    /**
     * Identificador único da {@link Certificacao} (FK) da placa solar certificação.
     * Imutável por conta da estruturação do sistema.
     */

    private long idCertificacao;

    //Construtor

    /**
     * Construtor completo da classe PlacaSolarCertificação
     *
     * @param id Identificador único da placa solar certificação (PK).
     * @param idPlacaSolar Identificador único da {@link PlacaSolar} (FK) ao qual a placa solar certificação se aplica.
     * @param idCertificacao Identificador único da {@link Certificacao} (FK) da placa solar certificação.
     */

    public PlacaSolarCertificacao(long id, long idPlacaSolar, long idCertificacao) {

        this.id = id;
        this.idPlacaSolar = idPlacaSolar;
        this.idCertificacao = idCertificacao;

    }

    //Getters e Setters

    public long getId() {

        return id;

    }

    public long getIdPlacaSolar() {

        return idPlacaSolar;

    }

    public long getIdCertificacao() {

        return idCertificacao;

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
                "ID da placa solar: "+ this.idPlacaSolar + "\n" +
                "ID da certificação: "+ this.idCertificacao + "\n" +
                "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n";

    }

}