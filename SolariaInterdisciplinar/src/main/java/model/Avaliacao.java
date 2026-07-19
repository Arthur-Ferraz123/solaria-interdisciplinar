package model;

/**
 * Representa a entidade avaliacao
 *
 * <p>Observação: Os atributos que não possuem informações sobre sua mutabilidade são <b>mutáveis</b></p>
 *
 * @author Eduardo Vicente Bisneto
 * @version 1.0.0
 */
public class Avaliacao {

    //Atributos

    /**
     * ID da avaliacao registrado no banco de dados.
     * Imutável por ser a PK.
     */
    private long id;

    /**
     * ID do {@link Usuario} que está realizando a avaliacao. (FK)
     * Imutável por conta da estruturação do sistema.
     */
    private long idUsuarioAvaliador;

    /**
     * ID do {@link Usuario} que está sendo avaliado. (FK)
     * Imutável por conta da estruturação do sistema.
     */
    private long idUsuarioAvaliado;

    /**
     * Um comentário associado a avaliacao.
     */
    private String comentario;

    /**
     * Indica a positividade da avaliacao.
     * O valor deve estar entre 0 e 5.
     */
    private int quantidadeEstrelas;

    //Construtor

    /**
     * Construtor completo da classe Avaliacao
     *
     * @param id ID da avaliacao registrado no banco de dados.
     * @param idUsuarioAvaliador ID do {@link Usuario} que está realizando a avaliacao. (FK)
     * @param idUsuarioAvaliado ID do {@link Usuario} que está recebendo a avaliacao. (FK)
     * @param comentario Um comentário associado a avaliação.
     * @param quantidadeEstrelas A positividade da avaliação.
     */
    public Avaliacao(long id, long idUsuarioAvaliador, long idUsuarioAvaliado, String comentario, int quantidadeEstrelas) {

        this.id = id;
        this.idUsuarioAvaliador = idUsuarioAvaliador;
        this.idUsuarioAvaliado = idUsuarioAvaliado;
        this.comentario = comentario;
        this.quantidadeEstrelas = quantidadeEstrelas;

    }

    /**
     * Construtor para o {@link dao.AvaliacaoDAO#insert(Avaliacao)}
     *
     * @param idUsuarioAvaliador ID do {@link Usuario} que está realizando a avaliacao. (FK)
     * @param idUsuarioAvaliado ID do {@link Usuario} que está recebendo a avaliacao. (FK)
     * @param comentario Um comentário associado a avaliação.
     * @param quantidadeEstrelas A positividade da avaliação.
     */
    public Avaliacao(long idUsuarioAvaliador, long idUsuarioAvaliado, String comentario, int quantidadeEstrelas) {

        this.idUsuarioAvaliador = idUsuarioAvaliador;
        this.idUsuarioAvaliado = idUsuarioAvaliado;
        this.comentario = comentario;
        this.quantidadeEstrelas = quantidadeEstrelas;

    }

    /**
     * Construtor para o {@link dao.AvaliacaoDAO#update(Avaliacao)}
     *.
     * @param comentario Um comentário associado a avaliação.
     * @param quantidadeEstrelas A positividade da avaliação.
     * @param id ID da avaliacao registrado no banco de dados
     */
    public Avaliacao(String comentario, int quantidadeEstrelas, long id) {

        this.comentario = comentario;
        this.quantidadeEstrelas = quantidadeEstrelas;
        this.id = id;
    }


    //Getters e Setters

    public long getId() {

        return id;

    }

    public long getIdUsuarioAvaliador() {

        return idUsuarioAvaliador;

    }

    public long getIdUsuarioAvaliado() {

        return idUsuarioAvaliado;

    }

    public String getComentario() {

        return comentario;

    }

    public void setComentario(String comentario) {

        this.comentario = comentario;

    }

    public int getQuantidadeEstrelas() {

        return quantidadeEstrelas;

    }

    public void setQuantidadeEstrelas(int quantidadeEstrelas) {

        this.quantidadeEstrelas = quantidadeEstrelas;

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
                "ID do usuário avaliador: "+ this.idUsuarioAvaliador + "\n" +
                "ID do usuário avaliado: "+ this.idUsuarioAvaliado + "\n" +
                "Comentário: "+ this.comentario + "\n" +
                "Quantidade de estrelas: "+ this.quantidadeEstrelas + "\n" +
                "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n";

    }

}