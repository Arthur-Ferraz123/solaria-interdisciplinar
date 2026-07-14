package model;

import java.time.LocalDate;

import java.time.LocalTime;

/**
 * Representa a entidade compromisso
 *
 * <p>Observação: Os atributos que não possuem informações sobre sua mutabilidade são <b>mutáveis</b></p>
 *
 * @author Eduardo Vicente Bisneto
 * @version 1.0.0
 */
public class Compromisso {

    //Atributos

    /**
     * Identificador único do compromisso.
     * Imutável por ser um identificador (PK).
     */
    private long id;

    /**
     * Identificador único do {@link UsuarioProjeto} (FK) dono do compromisso.
     * Imutável por conta da estruturação do sistema.
     */
    private long idUsuarioProjeto;

    /**
     * Nome do compromisso.
     */
    private String nome;

    /**
     * Descrição sobre o que será feito no compromisso.
     */
    private String descricao;

    /**
     * Data de realização do compromisso.
     */
    private LocalDate dataCompromisso;

    /**
     * Horário de realização do compromisso.
     */
    private LocalTime horarioCompromisso;

    /**
     * Data prevista para a conclusão do compromisso.
     */
    private LocalDate dataPrevistaParaConclusao;

    //Construtor

    /**
     * Construtor completo da classe Compromisso
     *
     * @param id Identificador único do compromisso (PK).
     * @param idUsuarioProjeto Identificador único do {@link UsuarioProjeto} (FK) dono do compromisso.
     * @param nome Nome do compromisso.
     * @param descricao Descrição sobre o que será feito no compromisso.
     * @param dataCompromisso Data de realização do compromisso.
     * @param horarioCompromisso Horário de realização do compromisso.
     * @param dataPrevistaParaConclusao Data prevista para a conclusão do compromisso.
     */
    public Compromisso(long id, long idUsuarioProjeto, String nome, String descricao, LocalDate dataCompromisso, LocalTime horarioCompromisso, LocalDate dataPrevistaParaConclusao) {

        this.id = id;
        this.idUsuarioProjeto = idUsuarioProjeto;
        this.nome = nome;
        this.descricao = descricao;
        this.dataCompromisso = dataCompromisso;
        this.horarioCompromisso = horarioCompromisso;
        this.dataPrevistaParaConclusao = dataPrevistaParaConclusao;

    }

    /**
     * Construtor para o {@link dao.CompromissoDAO#insert(Compromisso)}
     *
     * @param idUsuarioProjeto Identificador único do {@link UsuarioProjeto} (FK) dono do compromisso.
     * @param nome Nome do compromisso.
     * @param descricao Descrição sobre o que será feito no compromisso.
     * @param dataCompromisso Data de realização do compromisso.
     * @param horarioCompromisso Horário de realização do compromisso.
     * @param dataPrevistaParaConclusao Data prevista para a conclusão do compromisso.
     */
    public Compromisso(long idUsuarioProjeto, String nome, String descricao, LocalDate dataCompromisso, LocalTime horarioCompromisso, LocalDate dataPrevistaParaConclusao) {

        this.idUsuarioProjeto = idUsuarioProjeto;
        this.nome = nome;
        this.descricao = descricao;
        this.dataCompromisso = dataCompromisso;
        this.horarioCompromisso = horarioCompromisso;
        this.dataPrevistaParaConclusao = dataPrevistaParaConclusao;

    }

    /**
     * Construtor para o {@link dao.CompromissoDAO#update(Compromisso)}
     *
     * @param id Identificador único do compromisso (PK).
     * @param nome Nome do compromisso.
     * @param descricao Descrição sobre o que será feito no compromisso.
     * @param dataCompromisso Data de realização do compromisso.
     * @param horarioCompromisso Horário de realização do compromisso.
     * @param dataPrevistaParaConclusao Data prevista para a conclusão do compromisso.
     * @param daoUpdate Parâmetro passado somente para indicar o construtor
     */
    public Compromisso(long id, String nome, String descricao, LocalDate dataCompromisso, LocalTime horarioCompromisso, LocalDate dataPrevistaParaConclusao, boolean daoUpdate) {

        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.dataCompromisso = dataCompromisso;
        this.horarioCompromisso = horarioCompromisso;
        this.dataPrevistaParaConclusao = dataPrevistaParaConclusao;

    }

    //Getters e Setters

    public long getId() {

        return id;

    }

    public long getIdUsuarioProjeto() {

        return idUsuarioProjeto;

    }

    public String getNome() {

        return nome;

    }

    public void setNome(String nome) {

        this.nome = nome;

    }

    public String getDescricao() {

        return descricao;

    }

    public void setDescricao(String descricao) {

        this.descricao = descricao;

    }

    public LocalDate getDataCompromisso() {

        return dataCompromisso;

    }

    public void setDataCompromisso(LocalDate dataCompromisso) {

        this.dataCompromisso = dataCompromisso;

    }

    public LocalTime getHorarioCompromisso() {

        return horarioCompromisso;

    }

    public void setHorarioCompromisso(LocalTime horarioCompromisso) {

        this.horarioCompromisso = horarioCompromisso;

    }

    public LocalDate getDataPrevistaParaConclusao() {

        return dataPrevistaParaConclusao;

    }

    public void setDataPrevistaParaConclusao(LocalDate dataPrevistaParaConclusao) {

        this.dataPrevistaParaConclusao = dataPrevistaParaConclusao;

    }

    //Método toString

    /**
     * Retorna uma representação completa dos valores de <b>todos</b> os atributos da classe.
     * <p>
     *     O formato possuí o <i>nome do atributo com <b>algumas alterações</b></i> para facilitar a compreensão,
     *     seguido de seu valor.
     * </p>
     * @return Uma String no formato <b>"Nome do atributo: Valor"</b>
     */
    @Override
    public String toString(){

        return  "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n" +
                "ID: "+ this.id + "\n" +
                "ID do usuário projeto: "+ this.idUsuarioProjeto + "\n" +
                "Nome: "+ this.nome + "\n" +
                "Descrição: "+ this.descricao + "\n" +
                "Data do compromisso: "+ this.dataCompromisso + "\n" +
                "Horário do compromisso: "+ this.horarioCompromisso + "\n" +
                "Intervalo previsto para a conclusão: "+ this.dataPrevistaParaConclusao + "\n" +
                "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n";

    }

}