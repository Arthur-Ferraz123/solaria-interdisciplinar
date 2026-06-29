public class EmpresaTecnica {

    //Atributos

    //PK da tabela
    private int id;

    private String cnpj;
    private String nome;
    private String email;
    private String senha;
    private String estado;
    private String cep;
    private int numero;
    private String bairro;
    private String complemento;
    private String cidade;
    private String logadouro;

    //Construtor
    public EmpresaTecnica(int id, String cnpj, String nome, String email, String senha, String estado,
                          String cep, int numero, String bairro, String complemento, String cidade,
                          String logadouro) {

        this.id = id;
        this.cnpj = cnpj;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.estado = estado;
        this.cep = cep;
        this.numero = numero;
        this.bairro = bairro;
        this.complemento = complemento;
        this.cidade = cidade;
        this.logadouro = logadouro;

    }

    //Getters e Setters

    //OBS: O atributo id não tem setter, pois ele é a pk da tabela
    public int getId() {

        return id;

    }

    //OBS: O atributo cnpj não tem setter, pois ele será imutável
    public String getCnpj() {

        return cnpj;

    }

    public String getNome() {

        return nome;

    }

    public void setNome(String nome) {

        this.nome = nome;

    }

    public String getEmail() {

        return email;

    }

    public void setEmail(String email) {

        this.email = email;

    }

    public String getSenha() {

        return senha;

    }

    public void setSenha(String senha) {

        this.senha = senha;

    }

    public String getEstado() {

        return estado;

    }

    public void setEstado(String estado) {

        this.estado = estado;

    }

    public String getCep() {

        return cep;

    }

    public void setCep(String cep) {

        this.cep = cep;

    }

    public int getNumero() {

        return numero;

    }

    public void setNumero(int numero) {

        this.numero = numero;

    }

    public String getBairro() {

        return bairro;

    }

    public void setBairro(String bairro) {

        this.bairro = bairro;

    }

    public String getComplemento() {

        return complemento;

    }

    public void setComplemento(String complemento) {

        this.complemento = complemento;

    }

    public String getCidade() {

        return cidade;

    }

    public void setCidade(String cidade) {

        this.cidade = cidade;

    }

    public String getLogadouro() {

        return logadouro;

    }

    public void setLogadouro(String logadouro) {

        this.logadouro = logadouro;

    }

    //Método toString
    @Override
    public String toString(){

        return  "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n" +
                "ID: "+ this.id + "\n" +
                "CNPJ: "+ this.cnpj + "\n" +
                "Nome: "+ this.nome + "\n" +
                "Email: "+ this.email + "\n" +
                "Senha: "+ this.senha + "\n" +
                "Estado: "+ this.estado + "\n" +
                "CEP: "+ this.cep + "\n" +
                "Número: "+ this.numero + "\n" +
                "Bairro: "+ this.bairro + "\n" +
                "Complemento: "+ this.complemento + "\n" +
                "Cidade: "+ this.cidade + "\n" +
                "Logradouro: "+ this.logadouro + "\n" +
                "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n";

    }

}
