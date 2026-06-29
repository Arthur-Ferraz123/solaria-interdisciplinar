public class UsuarioChatAgente {
    //Atributos

    //PK da tabela
    private int id;

    //FK originaria da tabela usuario
    private int idUsuario;

    //FK originaria da tabela chat
    private int idChat;

    //Construtor

    public UsuarioChatAgente(int id, int idUsuario, int idChat) {

        this.id = id;
        this.idUsuario = idUsuario;
        this.idChat = idChat;

    }

    //Getters e Setters

    //OBS: O atributo id não tem setter, pois ele é a pk da tabela
    public int getId() {

        return id;

    }

    //OBS: O atributo idUsuario é uma FK e é imutável, então não possui setter
    public int getIdUsuario() {

        return idUsuario;

    }

    //OBS: O atributo idChat é uma FK e é imutável, então não possui setter
    public int getIdChat() {

        return idChat;

    }

    //Método toString
    @Override
    public String toString(){

        return  "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n" +
                "ID: "+ this.id + "\n" +
                "ID do usuário: "+ this.idUsuario + "\n" +
                "ID do chat: "+ this.idChat + "\n" +
                "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n";

    }

}
