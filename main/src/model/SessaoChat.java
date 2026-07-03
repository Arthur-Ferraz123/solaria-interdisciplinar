package model;

//Import do objeto utilizado para representar datatypes do tipo date no java
import java.time.LocalDate;

public class SessaoChat {

    //Atributos

    //PK da tabela
    private long id;

    //FK originaria da tabela chat
    private long idChat;
    private LocalDate dataInicio;
    private boolean statusSessao;
    private LocalDate dataFim;

    //Construtor
    public SessaoChat(long id, long idChat, LocalDate dataInicio, boolean statusSessao, LocalDate dataFim) {

        this.id = id;
        this.idChat = idChat;
        this.dataInicio = dataInicio;
        this.statusSessao = statusSessao;
        this.dataFim = dataFim;

    }

    //Getters e Setters

    //OBS: O atributo id não tem setter, pois ele é a pk da tabela
    public long getId() {

        return id;

    }

    //OBS: O atributo idChat não tem setter, pois ele é a fk da tabela e nesse caso ela acaba sendo inválida
    public long getIdChat() {

        return idChat;

    }

    //OBS: O atributo dataInicio é imutável
    public LocalDate getDataInicio() {

        return dataInicio;

    }

    public boolean getStatusSessao() {

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
