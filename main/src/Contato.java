public class Contato {

    //Atributos

    //PK da tabela
    private long id;

    private String email;
    private String nome;

    //FK originada da tabela usuario
    private long idUsuario;

    //Construtor
    public Contato(long id, String email, String nome, long idUsuario) {

        this.id = id;
        this.email = email;
        this.nome = nome;
        this.idUsuario = idUsuario;

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

    public String getNome() {

        return nome;

    }

    public void setNome(String nome) {

        this.nome = nome;

    }

    //OBS: O atributo idUsuario é uma FK e é imutável, então não possui setter
    public long getIdUsuario() {

        return idUsuario;

    }

    //Método toString
    @Override
    public String toString(){

        return  "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n" +
                "ID: "+ this.id + "\n" +
                "Email: "+ this.email + "\n" +
                "Nome: "+ this.nome + "\n" +
                "Id do usuário: "+ this.idUsuario + "\n" +
                "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n";

    }

}
