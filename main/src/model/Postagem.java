package model;

//Import do objeto utilizado para representar datatypes do tipo date no java
import java.time.LocalDate;

//Import do objeto utilizado para representar datatypes do tipo time no java
import java.time.LocalTime;

/**
 * Representa a entidade usuário
 *
 * <p>Observação: Os atributos que não possuem informações sobre sua mutabilidade são <b>mutáveis</b></p>
 *
 * @author Eduardo Vicente Bisneto
 * @version 1.0.0
 */

public class Postagem {

    //Atributos

    /**
     * Identificador único da postagem.
     * Imutável por ser um identificador (PK).
     */

    private long id;

    /**
     * Identificador único do {@link Perfil} (FK) dono da postagem.
     * Imutável por conta da estruturação do sistema.
     */

    private long idPerfil;

    /**
     * Texto existênte na postagem.
     */

    private String texto;

    /**
     * Indica de qual a data que a postagem foi salva no sistema.
     * Imutável por conta da estruturação do sistema.
     */

    private LocalDate dataPublicacao;

    /**
     * Indica a quantidade de {@link Perfil} que visualizaram a postagem.
     */

    private int quantidadeVisualizacoes;

    /**
     * Indica de qual o horário que a postagem foi salva no sistema.
     * Imutável por conta da estruturação do sistema.
     */

    private LocalTime horarioPublicacao;

    //Construtor

    /**
     * Construtor completo da classe Postagem
     *
     * @param id Identificador único da postagem (PK).
     * @param idPerfil Identificador único do {@link Perfil} (FK) dono da postagem.
     * @param texto Texto existênte na postagem.
     * @param dataPublicacao Qual a data que a postagem foi salva no sistema.
     * @param quantidadeVisualizacoes Quantidade de {@link Perfil} visualizaram a postagem.
     * @param horarioPublicacao Qual o horário que a postagem foi salva no sistema.
     */

    public Postagem(long id, long idPerfil, String texto, LocalDate dataPublicacao,
                    int quantidadeVisualizacoes, LocalTime horarioPublicacao) {

        this.id = id;
        this.idPerfil = idPerfil;
        this.texto = texto;
        this.dataPublicacao = dataPublicacao;
        this.quantidadeVisualizacoes = quantidadeVisualizacoes;
        this.horarioPublicacao = horarioPublicacao;

    }

    //Getters e Setters

    public long getId() {

        return id;

    }

    public long getIdPerfil() {

        return idPerfil;

    }

    public String getTexto() {

        return texto;

    }

    public void setTexto(String texto) {

        this.texto = texto;

    }

    public LocalDate getDataPublicacao() {

        return dataPublicacao;

    }

    public int getQuantidadeVisualizacoes() {

        return quantidadeVisualizacoes;

    }

    public void setQuantidadeVisualizacoes(int quantidadeVisualizacoes) {

        this.quantidadeVisualizacoes = quantidadeVisualizacoes;

    }

    public LocalTime getHorarioPublicacao() {

        return horarioPublicacao;

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
                "ID do perfil: "+ this.idPerfil + "\n" +
                "Texto: "+ this.texto + "\n" +
                "Data de publicação: "+ this.dataPublicacao + "\n" +
                "Quantidade de visualizações: "+ this.quantidadeVisualizacoes + "\n" +
                "Horário de publicação: "+ this.horarioPublicacao + "\n" +
                "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n";

    }

}