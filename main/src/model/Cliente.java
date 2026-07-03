package model;

public class Cliente{

    //Atributos

    //PK da tabela
    private long id;

    //FK originada da tabela usuario
    private long idUsuario;

    private String cnpj;

    //Construtor
    public Cliente(long id, long idUsuario, String cnpj) {

        this.id = id;
        this.idUsuario = idUsuario;
        this.cnpj = cnpj;

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

    //OBS: O atributo cnpj não tem setter, pois ele será imutável
    public String getCnpj() {

        return cnpj;

    }

    //Método toString
    @Override
    public String toString(){

        return  "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n" +
                "ID: "+ this.id + "\n" +
                "ID do usuário: "+ this.idUsuario + "\n" +
                "CNPJ: "+ this.cnpj + "\n" +
                "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n";


    }

}
