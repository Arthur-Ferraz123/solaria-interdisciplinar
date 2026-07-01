public class Telefone {

    //Atributos

    //PK da tabela
    private long id;

    private String telefone;

    //FK originada da tabela usuario
    private long idUsuario;

    //FK originada da tabela empresa_tecnica
    private long idEmpresaTecnica;

    //FK originada da tabela contato
    private long idContato;

    //Construtor
    public Telefone(long id, String telefone, long idUsuario, long idEmpresaTecnica, long idContato) {

        this.id = id;
        this.telefone = telefone;
        this.idUsuario = idUsuario;
        this.idEmpresaTecnica = idEmpresaTecnica;
        this.idContato = idContato;

    }

    //Getters e Setters

    //OBS: O atributo id não tem setter, pois ele é a pk da tabela
    public long getId() {

        return id;

    }

    public String getTelefone() {

        return telefone;

    }

    public void setTelefone(String telefone) {

        this.telefone = telefone;

    }

    //OBS: O atributo idUsuario é uma FK e é imutável, então não possui setter
    public long getIdUsuario() {

        return idUsuario;

    }

    //OBS: O atributo idEmpresaTecnica é uma FK e é imutável, então não possui setter
    public long getIdEmpresaTecnica() {

        return idEmpresaTecnica;

    }

    //OBS: O atributo idContato é uma FK e é imutável, então não possui setter
    public long getIdContato() {

        return idContato;

    }

    //Método toString
    @Override
    public String toString(){

        return  "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n" +
                "ID: "+ this.id + "\n" +
                "Telefone: "+ this.telefone + "\n" +
                "ID do usuário: "+ this.idUsuario + "\n" +
                "ID da empresa técnica: "+ this.idEmpresaTecnica + "\n" +
                "ID do contato: "+ this.idContato + "\n" +
                "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n";

    }

}
