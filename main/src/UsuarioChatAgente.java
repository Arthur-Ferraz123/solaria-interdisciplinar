public class UsuarioChatAgente {
    //Atributos

    //PK da tabela
    private long id;

    //FK originaria da tabela usuario
    private long idUsuario;

    //FK originaria da tabela chat
    private long idChat;

    private String nomeAgente;

    //Construtor

    public UsuarioChatAgente(long id, long idUsuario, long idChat, String nomeAgente) {

        this.id = id;
        this.idUsuario = idUsuario;
        this.idChat = idChat;
        this.nomeAgente = nomeAgente;

    }

    //Getters e Setters

    //OBS: O atributo id não tem setter, pois ele é a pk da tabela
    public long getId() {

        return id;

    }

    //OBS: O atributo idUsuario é uma FK e é imutável, então não possui setter
    public long getIdUsuario() {

        return idUsuario;

    }

    //OBS: O atributo idChat é uma FK e é imutável, então não possui setter
    public long getIdChat() {

        return idChat;

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
                "ID do usuário: "+ this.idUsuario + "\n" +
                "ID do chat: "+ this.idChat + "\n" +
                "Nome do agente: "+ this.nomeAgente + "\n" +
                "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n";

    }

}
