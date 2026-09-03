package model;

public enum TiposUsuario {

    FORNECEDOR("FORNECEDOR"),
    EMPRESA_DEMANDANTE("EMPRESA_DEMANDANTE"),
    PROFISSIONAL("PROFISSIONAL");

    private final String tipoUsuario;

    TiposUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public static TiposUsuario descobrirTipoUsuario(String tipoUsuarioRecebido){

        String tipoUsuarioRecebidoTratado = tipoUsuarioRecebido.toUpperCase().trim();

        for(TiposUsuario tiposUsuario : TiposUsuario.values()){

            if(tiposUsuario.getTipoUsuario().equalsIgnoreCase(tipoUsuarioRecebidoTratado)){
                return tiposUsuario;
            }
        }
        return null;
    }

}
