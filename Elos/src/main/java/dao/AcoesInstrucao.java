package dao;

public enum AcoesInstrucao {

    ILIKE(" ilike "),
    BETWEEN(" between "),
    IGUAL(" = "),
    AND(" and "),
    OR(" or "),
    VAZIO(" ");

    private final String acao;

     AcoesInstrucao(String acao) {
        this.acao = acao;
    }

    public String getAcao() {
        return acao;
    }
}
