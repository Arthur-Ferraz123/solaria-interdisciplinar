package model;

/**
 * Representa a entidade placa_solar_certificacao
 *
 * <p>Observação: Os atributos que não possuem informações sobre sua mutabilidade são <b>mutáveis</b></p>
 *
 * @author Eduardo Vicente Bisneto
 * @version 1.0.0
 */
public class PlacaSolarCertificacao {

    //Atributos

    /**
     * ID da placa_solar_certificacao registrado no banco de dados.
     * Imutável por ser a PK.
     */
    private long id;

    /**
     * ID da {@link PlacaSolar} que a placa_solar_certificacao se aplica. (FK)
     * Imutável por conta da estruturação do sistema.
     */
    private long idPlacaSolar;

    /**
     * ID da {@link Certificacao} que a placa_solar_certificacao aplica. (FK)
     * Imutável por conta da estruturação do sistema.
     */
    private long idCertificacao;

    //Construtor

    /**
     * Construtor completo da classe PlacaSolarCertificacao
     *
     * @param id ID da placa_solar_certificacao registrado no banco de dados.
     * @param idPlacaSolar ID da {@link PlacaSolar} que a placa_solar_certificacao se aplica. (FK)
     * @param idCertificacao ID da {@link Certificacao} que a placa_solar_certificacao aplica. (FK)
     */
    public PlacaSolarCertificacao(long id, long idPlacaSolar, long idCertificacao) {

        this.id = id;
        this.idPlacaSolar = idPlacaSolar;
        this.idCertificacao = idCertificacao;

    }

    /**
     * Construtor para o {@link dao.PlacaSolarCertificacaoDAO#insert(PlacaSolarCertificacao)}
     *
     * @param idPlacaSolar ID da {@link PlacaSolar} que a placa_solar_certificacao se aplica. (FK)
     * @param idCertificacao ID da {@link Certificacao} que a placa_solar_certificacao aplica. (FK)
     */
    public PlacaSolarCertificacao(long idPlacaSolar, long idCertificacao) {

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