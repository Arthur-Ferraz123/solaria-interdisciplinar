//Import do objeto utilizado para representar datatypes do tipo date no java
import java.time.LocalDate;

public class Certificacao {

    //Atributos

    //PK da tabela
    private int id;

    //FK originada da tabela placa_solar
    private int idPlacaSolar;

    private String selo;
    private String numeroRegistro;
    private LocalDate dataEmissao;
    private LocalDate validade;
    private String documento;

    //Construtor

    public Certificacao(int id, int idPlacaSolar, String selo, String numeroRegistro,
                        LocalDate dataEmissao, LocalDate validade, String documento) {
        this.id = id;
        this.idPlacaSolar = idPlacaSolar;
        this.selo = selo;
        this.numeroRegistro = numeroRegistro;
        this.dataEmissao = dataEmissao;
        this.validade = validade;
        this.documento = documento;
    }

    //Getters e Setters

    //OBS: O atributo id não tem setter, pois ele é a pk da tabela
    public int getId() {
        return id;
    }

    //OBS: O atributo idPlacaSolar não tem setter, pois ele é a fk da tabela e nesse caso ela acaba sendo inválida
    public int getIdPlacaSolar() {
        return idPlacaSolar;
    }

    public String getSelo() {
        return selo;
    }

    public void setSelo(String selo) {
        this.selo = selo;
    }

    public String getNumeroRegistro() {
        return numeroRegistro;
    }

    public void setNumeroRegistro(String numeroRegistro) {
        this.numeroRegistro = numeroRegistro;
    }

    public LocalDate getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(LocalDate dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public LocalDate getValidade() {
        return validade;
    }

    public void setValidade(LocalDate validade) {
        this.validade = validade;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    //Método toString
    @Override
    public String toString(){
        return  "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n" +
                "ID: "+ this.id + "\n" +
                "ID da placa solar: "+ this.idPlacaSolar + "\n" +
                "Selo: "+ this.selo + "\n" +
                "Número de registro: "+ this.numeroRegistro + "\n" +
                "Data de emissão: "+ this.dataEmissao + "\n" +
                "Validade: "+ this.validade + "\n" +
                "Documento: "+ this.documento + "\n" +
                "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n";
    }
}
