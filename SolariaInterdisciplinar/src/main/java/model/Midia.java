package model;

/**
 * Representa a entidade midia
 *
 * <p>Observação: Os atributos que não possuem informações sobre sua mutabilidade são <b>mutáveis</b></p>
 *
 * @author Eduardo Vicente Bisneto
 * @version 1.0.0
 */
public class Midia {

    //Atributos

    /**
     * ID da midia registrado no banco de dados.
     * Imutável por ser a PK.
     */
    private long id;

    /**
     * ID da {@link Postagem} que é a midia é atrelada. (FK)
     * Imutável por conta da estruturação do sistema.
     */
    private long idPostagem;

    /**
     * ID da {@link Mensagem} que é a midia é atrelada. (FK)
     * Imutável por conta da estruturação do sistema.
     */
    private long idMensagem;

    /**
     * Link da mídia.
     * Imutável por conta da estruturação do sistema.
     */
    private String midia;

    /**
     * Indica o tipo da mídia.
     * Imutável por conta da estruturação do sistema.
     * Valores aceitos: {"IMAGEM", "VIDEO", "DOCUMENTO"}.
     */
    private String tipoMidia;

    //Construtor

    /**
     * Construtor completo da classe Midia
     *
     * @param id ID da midia registrado no banco de dados.
     * @param idPostagem ID da {@link Postagem} que é a midia é atrelada. (FK)
     * @param idMensagem ID da {@link Mensagem} que é a midia é atrelada. (FK)
     * @param midia Link da mídia.
     * @param tipoMidia Indica o tipo da mídia.
     */
    public Midia(long id, long idPostagem, long idMensagem, String midia, String tipoMidia) {

        this.id = id;
        this.idPostagem = idPostagem;
        this.idMensagem = idMensagem;
        this.midia = midia;
        this.tipoMidia = tipoMidia;

    }

    /**
     * Construtor para o {@link dao.MidiaDAO#insert(Midia)}
     *
     * @param idPostagem ID da {@link Postagem} que é a midia é atrelada. (FK)
     * @param idMensagem ID da {@link Mensagem} que é a midia é atrelada. (FK)
     * @param midia Link da mídia.
     * @param tipoMidia Indica o tipo da mídia.
     */
    public Midia(long idPostagem, long idMensagem, String midia, String tipoMidia) {

        this.idPostagem = idPostagem;
        this.idMensagem = idMensagem;
        this.midia = midia;
        this.tipoMidia = tipoMidia;

    }

    /**
     * Construtor para o {@link dao.MidiaDAO#update(Midia)}
     *
     * @param midia Link da mídia.
     * @param tipoMidia Indica o tipo da mídia.
     * @param id Identificador único da mídia (PK).
     */
    public Midia( String midia, String tipoMidia, long id) {

        this.midia = midia;
        this.tipoMidia = tipoMidia;
        this.id = id;

    }

    //Getters e Setters

    public long getId() {

        return id;

    }

    public long getIdPostagem() {

        return idPostagem;

    }

    public long getIdMensagem() {

        return idMensagem;

    }

    public String getMidia() {

        return midia;

    }

    public String getTipoMidia() {

        return tipoMidia;

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
                "ID postagem: "+ this.idPostagem + "\n" +
                "ID mensagem: "+ this.idMensagem + "\n" +
                "Mídia: "+ this.midia + "\n" +
                "Tipo da mídia: "+ this.tipoMidia + "\n" +
                "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n";

    }

}
