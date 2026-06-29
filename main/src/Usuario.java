public class Usuario {

    //Atributos

    //PK da tabela
    private long id;

    private String email;
    private String senha;
    private String nome;
    private String estado;
    private String cep;
    private int numero;
    private String bairro;
    private String complemento;
    private String cidade;
    private String logradouro;
    private String tipoUsuario;

    //Construtor
    public Usuario(long id, String email, String senha, String nome, String estado, String cep,
                   int numero, String bairro, String complemento, String cidade,
                   String logradouro, String tipoUsuario) {

        this.id = id;
        this.email = email;
        this.senha = senha;
        this.nome = nome;
        this.estado = estado;
        this.cep = cep;
        this.numero = numero;
        this.bairro = bairro;
        this.complemento = complemento;
        this.cidade = cidade;
        this.logradouro = logradouro;
        this.tipoUsuario = tipoUsuario;

    }

    //Getters e Setters

    //OBS: O atributo id não tem setter, pois ele é a pk da tabela
    public long getId() {

        return id;

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

    public String getNome() {

        return nome;

    }

    public void setNome(String nome) {

        this.nome = nome;

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

    public String getLogradouro() {

        return logradouro;

    }

    public void setLogradouro(String logradouro) {

        this.logradouro = logradouro;

    }

    //OBS: O atributo tipoUsuario não tem setter, pois ele é imutável
    public String getTipoUsuario() {

        return tipoUsuario;

    }

    //Método toString
    @Override
    public String toString(){

        return  "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n" +
                "ID: "+ this.id + "\n" +
                "Email: "+ this.email + "\n" +
                "Senha: "+ this.senha + "\n" +
                "Nome: "+ this.nome + "\n" +
                "Estado: "+ this.estado + "\n" +
                "CEP: "+ this.cep + "\n" +
                "Número: "+ this.numero + "\n" +
                "Bairro: "+ this.bairro + "\n" +
                "Complemento: "+ this.complemento + "\n" +
                "Cidade: "+ this.cidade + "\n" +
                "Logradouro: "+ this.logradouro + "\n" +
                "Tipo do usuário: "+ this.tipoUsuario + "\n" +
                "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n";

    }

}
