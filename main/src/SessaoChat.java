//Import do objeto utilizado para representar datatypes do tipo date no java
import java.time.LocalDate;

public class SessaoChat {

    //Atributos

    //PK da tabela
    private int id;

    //FK originaria da tabela chat
    private int idChat;
    private LocalDate dataInicio;
    private boolean statusSessao;
    private LocalDate dataFim;

    //Construtor
    public SessaoChat(int id, int idChat, LocalDate dataInicio, boolean statusSessao, LocalDate dataFim) {
        this.id = id;
        this.idChat = idChat;
        this.dataInicio = dataInicio;
        this.statusSessao = statusSessao;
        this.dataFim = dataFim;
    }

    //Getters e Setters

    //OBS: O atributo id não tem setter, pois ele é a pk da tabela
    public int getId() {
        return id;
    }

    //OBS: O atributo idChat não tem setter, pois ele é a fk da tabela e nesse caso ela acaba sendo inválida
    public int getIdChat() {
        return idChat;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public boolean isStatusSessao() {
        return statusSessao;
    }

    public void setStatusSessao(boolean statusSessao) {
        this.statusSessao = statusSessao;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    //Método toString
    @Override
    public String toString(){
        return  "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n" +
                "ID: "+ this.id + "\n" +
                "ID do chat: "+ this.idChat + "\n" +
                "Data de inicio: "+ this.dataInicio + "\n" +
                "Status da sessão: "+ this.statusSessao + "\n" +
                "Data do fim: "+ this.dataFim + "\n" +
                "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n";
    }
}
