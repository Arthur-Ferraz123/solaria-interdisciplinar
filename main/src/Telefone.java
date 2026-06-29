public class Telefone {

    //Atributos

    //PK da tabela
    private int id;

    //Verificar se o telefone vai ser String ou long
    private String telefone;

    //Avaliar como vai funcionar esse atributo
    //FK originada da tabela usuario ou empresa_tecnica
    private int idUsuario;

    public Telefone(int id, String telefone, int idUsuario) {
        this.id = id;
        this.telefone = telefone;
        this.idUsuario = idUsuario;
    }

    //Getters e Setters

    //OBS: O atributo id não tem setter, pois ele é a pk da tabela
    public int getId() {
        return id;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    //OBS: O atributo idUsuario não tem setter, pois ele é a fk da tabela e nesse caso ela acaba sendo inválida
    public int getIdUsuario() {
        return idUsuario;
    }

    //Método toString
    @Override
    public String toString(){
        return  "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n" +
                "ID: "+ this.id + "\n" +
                "Telefone: "+ this.telefone + "\n" +
                "ID do usuário: "+ this.idUsuario + "\n" +
                "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n";
    }
}
