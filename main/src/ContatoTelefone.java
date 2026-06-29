// Avaliar a existencia dessa classe

public class ContatoTelefone {

    //Atributos

    //PK da tabela
    private long id;

    private String telefone;

    //FK originada da tabela contato
    private long idContato;

    //Construtor
    public ContatoTelefone(long id, String telefone, long idContato) {

        this.id = id;
        this.telefone = telefone;
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
                "ID do contato: "+ this.idContato + "\n" +
                "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n";

    }

}
