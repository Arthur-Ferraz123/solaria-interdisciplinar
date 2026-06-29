public class Chat {

    //Atributos

    //PK da tabela
    private int id;

    private String nomeCliente;
    private String nomeAgente;

    //Construtor
    public Chat(int id, String nomeCliente, String nomeAgente) {
        this.id = id;
        this.nomeCliente = nomeCliente;
        this.nomeAgente = nomeAgente;
    }

    //Getters e Setters

    //OBS: O atributo id não tem setter, pois ele é a pk da tabela
    public int getId() {
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

}
