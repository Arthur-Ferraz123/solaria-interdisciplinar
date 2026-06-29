//Import do objeto utilizado para representar datatypes do tipo date no java
import java.time.LocalDate;

//Import do objeto utilizado para representar datatypes do tipo time no java
import java.time.LocalTime;

public class Mensagem {

    //Atributos

    //PK da tabela
    private int id;

    //FK originaria da tabela chat
    private int idChat;

    private String mensagem;
    private LocalDate dataEnvio;
    private LocalTime horarioEnvio;

    //Avaliar o funcionamento desses atributos
    private String remetente;
    private String tipoMensagem;

    //Construtor
    public Mensagem(int id, int idChat, String mensagem, LocalDate dataEnvio, LocalTime horarioEnvio, String remetente, String tipoMensagem) {
        this.id = id;
        this.idChat = idChat;
        this.mensagem = mensagem;
        this.dataEnvio = dataEnvio;
        this.horarioEnvio = horarioEnvio;
        this.remetente = remetente;
        this.tipoMensagem = tipoMensagem;
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

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public LocalDate getDataEnvio() {
        return dataEnvio;
    }

    public void setDataEnvio(LocalDate dataEnvio) {
        this.dataEnvio = dataEnvio;
    }

    public LocalTime getHorarioEnvio() {
        return horarioEnvio;
    }

    public void setHorarioEnvio(LocalTime horarioEnvio) {
        this.horarioEnvio = horarioEnvio;
    }

    public String getRemetente() {
        return remetente;
    }

    public void setRemetente(String remetente) {
        this.remetente = remetente;
    }

    public String getTipoMensagem() {
        return tipoMensagem;
    }

    public void setTipoMensagem(String tipoMensagem) {
        this.tipoMensagem = tipoMensagem;
    }
}
