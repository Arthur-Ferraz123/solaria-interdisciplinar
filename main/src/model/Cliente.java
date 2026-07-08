package model;

/**
 * Representa a entidade cliente
 *
 * <p>Observação: Os atributos que não possuem informações sobre sua mutabilidade são <b>mutáveis</b></p>
 *
 * @author Eduardo Vicente Bisneto
 * @version 1.0.0
 */

public class Cliente{

    //Atributos

    /**
     * Identificador único do cliente.
     * Imutável por ser um identificador (PK).
     */

    private long id;

    /**
     * Identificador único do {@link Usuario} (FK) que é o cliente.
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
     * CNPJ do cliente.
     * Imutável por conta da estruturação do sistema.
     * Deve seguir o padrão previsto em {@link }.
     */

    private String cnpj;

    //Construtor

    /**
     * Construtor completo da classe Cliente
     *
     * @param id Identificador único do cliente (PK).
     * @param idUsuario Identificador único do {@link Usuario} (FK) que é o cliente.
     * @param tipoUsuario Qual a variação do usuário.
     * @param cnpj CNPJ do cliente.
     */

    public Cliente(long id, long idUsuario, String tipoUsuario, String cnpj) {

        this.id = id;
        this.idUsuario = idUsuario;
        this.tipoUsuario = tipoUsuario;
        this.cnpj = cnpj;

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

    public String getCnpj() {

        return cnpj;

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
                "CNPJ: "+ this.cnpj + "\n" +
                "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n";

    }

}