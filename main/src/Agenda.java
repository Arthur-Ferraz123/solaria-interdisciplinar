//Import do objeto utilizado para representar datatypes do tipo date no java
import java.time.LocalDate;

//Import do objeto utilizado para representar datatypes do tipo time no java
import java.time.LocalTime;

public class Agenda {

    //Atributos

    //PK da tabela
    private long id;

    //FK originaria da tabela profissional
    private long idProfissional;

    private LocalDate dataCompromisso;
    private String nomeCompromisso;
    private LocalTime horarioCompromisso;
    private String descricao;

    //FK originaria da tabela cliente
    private long idCliente;

    //Construtor
    public Agenda(long id, long idProfissional, LocalDate dataCompromisso, String nomeCompromisso, LocalTime horarioCompromisso, String descricao, long idCliente) {

        this.id = id;
        this.idProfissional = idProfissional;
        this.dataCompromisso = dataCompromisso;
        this.nomeCompromisso = nomeCompromisso;
        this.horarioCompromisso = horarioCompromisso;
        this.descricao = descricao;
        this.idCliente = idCliente;

    }

    //Getter e Setters

    //OBS: O atributo id não tem setter, pois ele é a pk da tabela
    public long getId() {

        return id;

    }

    //OBS: O atributo idProfissional não tem setter, pois ele é a fk da tabela e nesse caso ela acaba sendo inválida
    public long getIdProfissional() {

        return idProfissional;

    }

    public LocalDate getDataCompromisso() {

        return dataCompromisso;

    }

    public void setDataCompromisso(LocalDate dataCompromisso) {

        this.dataCompromisso = dataCompromisso;

    }

    public String getNomeCompromisso() {

        return nomeCompromisso;

    }

    public void setNomeCompromisso(String nomeCompromisso) {

        this.nomeCompromisso = nomeCompromisso;

    }

    public LocalTime getHorarioCompromisso() {

        return horarioCompromisso;

    }

    public void setHorarioCompromisso(LocalTime horarioCompromisso) {

        this.horarioCompromisso = horarioCompromisso;

    }

    public String getDescricao() {

        return descricao;

    }

    public void setDescricao(String descricao) {

        this.descricao = descricao;

    }

    //OBS: O atributo idCliente é uma FK e é imutável, então não possui setter
    public long getIdCliente() {

        return idCliente;

    }

    //Método toString
    @Override
    public String toString(){

        return  "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n" +
                "ID: "+ this.id + "\n" +
                "ID do profissional: "+ this.idProfissional + "\n" +
                "Data do compromisso: "+ this.dataCompromisso + "\n" +
                "Nome do compromisso: "+ this.nomeCompromisso + "\n" +
                "Horário do compromisso: "+ this.horarioCompromisso + "\n" +
                "Descrição: "+ this.descricao + "\n" +
                "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n";

    }

}
