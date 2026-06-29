public class Chat {

    //Atributos

    //PK da tabela
    private long id;

    //SOB ANALISE ATÉ A APROVAÇÃO PELO NISFLEI
    private String nomeCliente;
    private String nomeAgente;

    //Construtor
    public Chat(long id, String nomeCliente, String nomeAgente) {

        this.id = id;
        this.nomeCliente = nomeCliente;
        this.nomeAgente = nomeAgente;

    }

    //Getters e Setters

    //OBS: O atributo id não tem setter, pois ele é a pk da tabela
    public long getId() {

        return id;

    }

    public String getNomeCliente() {

        return nomeCliente;

    }

    public void setNomeCliente(String nomeCliente) {

        this.nomeCliente = nomeCliente;

    }

    public String getNomeAgente() {

        return nomeAgente;

    }

    public void setNomeAgente(String nomeAgente) {

        this.nomeAgente = nomeAgente;

    }

    //Método toString
    @Override
    public String toString(){

        return  "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n" +
                "ID: "+ this.id + "\n" +
                "Nome do cliente: "+ this.nomeCliente + "\n" +
                "Nome do agente: "+ this.nomeAgente + "\n" +
                "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n";

    }

}
