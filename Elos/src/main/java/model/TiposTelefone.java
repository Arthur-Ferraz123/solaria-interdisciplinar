package model;

public enum TiposTelefone {

    PESSOAL("PESSOAL"),
    EMPRESARIAL("EMPRESARIAL");

    private final String tipoTelefone;

    TiposTelefone(String tipoTelefone) {
        this.tipoTelefone = tipoTelefone;
    }

    public String getTipoTelefone() {
        return tipoTelefone;
    }

    public static TiposTelefone descobrirTipoTelefone(String tipoTelefoneRecebido){
        for(TiposTelefone tiposTelefone : TiposTelefone.values()){
            if(tiposTelefone.tipoTelefone.equalsIgnoreCase(tipoTelefoneRecebido)){
                return tiposTelefone;
            }
        }
        return null;
    }
}
