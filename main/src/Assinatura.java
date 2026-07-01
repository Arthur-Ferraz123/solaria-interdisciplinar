//Import do objeto utilizado para representar datatypes do tipo date no java
import java.time.LocalDate;

public class Assinatura {

    //Atributos

    //PK da tabela
    private long id;

    //FK originada da tabela usuario
    private long idUsuario;

    //FK originada da tabela empresa_tecnica
    private long idEmpresaTecnica;

    //FK originada da tabela plano
    private long idPlano;

    private String statusAssinatura;
    private boolean renovacaoAutomatica;
    private LocalDate dataInicio;
    private LocalDate dataFim;

    //Construtor

    public Assinatura(long id, long idUsuario, long idEmpresaTecnica, long idPlano, String statusAssinatura, boolean renovacaoAutomatica, LocalDate dataInicio, LocalDate dataFim) {

        this.id = id;
        this.idUsuario = idUsuario;
        this.idEmpresaTecnica = idEmpresaTecnica;
        this.idPlano = idPlano;
        this.statusAssinatura = statusAssinatura;
        this.renovacaoAutomatica = renovacaoAutomatica;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;

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

    //OBS: O atributo idEmpresaTecnica é uma FK e é imutável, então não possui setter
    public long getIdEmpresaTecnica() {

        return idEmpresaTecnica;

    }

    //OBS: O atributo idPlano é uma FK e é imutável, então não possui setter
    public long getIdPlano() {

        return idPlano;

    }

    public String getStatusAssinatura() {

        return statusAssinatura;

    }

    public void setStatusAssinatura(String statusAssinatura) {

        this.statusAssinatura = statusAssinatura;

    }

    public boolean getRenovacaoAutomatica() {

        return renovacaoAutomatica;

    }

    public void setRenovacaoAutomatica(boolean renovacaoAutomatica) {

        this.renovacaoAutomatica = renovacaoAutomatica;

    }

    //OBS: O atributo dataInicio é imutável
    public LocalDate getDataInicio() {

        return dataInicio;

    }


    public LocalDate getDataFim() {

        return dataFim;

    }

    //Validar a existência conforme a alteração do status
    public void setDataFim(LocalDate dataFim) {

        this.dataFim = dataFim;

    }

    //Método toString
    @Override
    public String toString() {

        return "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n" +
                "ID: " + this.id + "\n" +
                "ID do usuário: " + this.idUsuario + "\n" +
                "ID da empresa técnica: " + this.idEmpresaTecnica + "\n" +
                "ID do plano: " + this.idPlano + "\n" +
                "Status da assinatura: " + this.statusAssinatura + "\n" +
                "Renovação automática: " + this.renovacaoAutomatica + "\n" +
                "Data de inicio: " + this.dataInicio + "\n" +
                "Data do fim: " + this.dataFim + "\n" +
                "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n";

    }

}
