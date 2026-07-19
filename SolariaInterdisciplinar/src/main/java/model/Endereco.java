package model;

/**
 * Representa a entidade endereco
 *
 * <p>Observação: Os atributos que não possuem informações sobre sua mutabilidade são <b>mutáveis</b></p>
 *
 * @author Eduardo Vicente Bisneto
 * @version 1.0.0
 */
public class Endereco {

    //Atributos

    /**
     * ID da endereco registrado no banco de dados.
     * Imutável por ser a PK.
     */
    private long id;

    /**
     * ID do {@link Usuario} que é dono do endereco. (FK)
     * Imutável por conta da estruturação do sistema.
     */
    private long idUsuario;

    /**
     * Indica qual o estado do endereco.
     * Valores aceitos: {"AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"}
     */
    private String estado;

    /**
     * Nome da cidade que o endereco se situa.
     */
    private String cidade;

    /**
     * Nome do bairro que o endereco se situa.
     */
    private String bairro;

    /**
     * CEP do endereco.
     * Deve seguir o padrão previsto em {@link }.
     */
    private String cep;

    /**
     * Nome do logradouro do endereco se situa.
     */
    private String logradouro;

    /**
     * Número do endereco.
     */
    private String numero;

    /**
     * Complemento caso necessário para facilitar encontrar o endereco.
     */
    private String complemento;

    //Construtores

    /**
     * Construtor completo da classe Endereco
     *
     * @param id ID da endereco registrado no banco de dados.
     * @param idUsuario ID do {@link Usuario} que é dono do endereco. (FK)
     * @param estado Qual o estado do endereco.
     * @param cidade Nome da cidade que o endereco se situa.
     * @param bairro Nome do bairro que o endereco se situa.
     * @param cep CEP do endereco.
     * @param logradouro Nome do logradouro do endereco se situa.
     * @param numero Número do endereco.
     * @param complemento Complemento caso necessário para facilitar encontrar o endereco.
     */
    public Endereco(long id, long idUsuario, String estado, String cidade, String bairro, String cep, String logradouro, String numero, String complemento) {

        this.id = id;
        this.idUsuario = idUsuario;
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.cep = cep;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;

    }

    /**
     * Construtor para o {@link dao.EnderecoDAO#insert(Endereco)}
     *
     * @param idUsuario ID do {@link Usuario} que é dono do endereco. (FK)
     * @param estado Qual o estado do endereco.
     * @param cidade Nome da cidade que o endereco se situa.
     * @param bairro Nome do bairro que o endereco se situa.
     * @param cep CEP do endereco.
     * @param logradouro Nome do logradouro do endereco se situa.
     * @param numero Número do endereco.
     * @param complemento Complemento caso necessário para facilitar encontrar o endereco.
     */
    public Endereco(long idUsuario, String estado, String cidade, String bairro, String cep, String logradouro, String numero, String complemento) {

        this.idUsuario = idUsuario;
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.cep = cep;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;

    }

    /**
     * Construtor para o {@link dao.EnderecoDAO#update(Endereco)}
     *
     * @param estado Qual o estado do endereco.
     * @param cidade Nome da cidade que o endereco se situa.
     * @param bairro Nome do bairro que o endereco se situa.
     * @param cep CEP do endereco.
     * @param logradouro Nome do logradouro do endereco se situa.
     * @param numero Número do endereco.
     * @param complemento Complemento caso necessário para facilitar encontrar o endereco.
     * @param id ID da endereco registrado no banco de dados.
     */
    public Endereco(String estado, String cidade, String bairro, String cep, String logradouro, String numero, String complemento, long id) {

        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.cep = cep;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.id = id;

    }

    //Getters e Setters

    public long getId() {

        return id;

    }

    public long getIdUsuario() {

        return idUsuario;

    }

    public String getEstado() {

        return estado;

    }

    public void setEstado(String estado) {

        this.estado = estado;

    }

    public String getCidade() {

        return cidade;

    }

    public void setCidade(String cidade) {

        this.cidade = cidade;

    }

    public String getBairro() {

        return bairro;

    }

    public void setBairro(String bairro) {

        this.bairro = bairro;

    }

    public String getCep() {

        return cep;

    }

    public void setCep(String cep) {

        this.cep = cep;

    }

    public String getLogradouro() {

        return logradouro;

    }

    public void setLogradouro(String logradouro) {

        this.logradouro = logradouro;

    }

    public String getNumero() {

        return numero;

    }

    public void setNumero(String numero) {

        this.numero = numero;

    }

    public String getComplemento() {

        return complemento;

    }

    public void setComplemento(String complemento) {

        this.complemento = complemento;

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
                "Estado: "+ this.estado + "\n" +
                "Cidade: "+ this.cidade + "\n" +
                "Bairro: "+ this.bairro + "\n" +
                "CEP: "+ this.cep + "\n" +
                "Logradouro: "+ this.logradouro + "\n" +
                "Número: "+ this.numero + "\n" +
                "Complemento: "+ this.complemento + "\n" +
                "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n";

    }

}