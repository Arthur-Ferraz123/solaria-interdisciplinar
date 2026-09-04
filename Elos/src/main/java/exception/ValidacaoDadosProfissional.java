package exception;

public enum ValidacaoDadosProfissional implements GenericExceptionEnum{

    //Variações do enum
    ATRIBUTO_NULL(-1, "Atributo null"),
    VALIDACAO_OK(0, "Dado válido"),
    ID_INVALIDO(1, "O ID inserido é inválido"),
    ID_USUARIO_INVALIDO(2, "O ID do usuário inserido é inválido"),
    ID_USUARIO_NAO_REGISTRADO(3, "O ID inserido não foi encontrado");


    //Constantes do enum
    private final int codigo;
    private final String mensagem;

    //Construtor
    ValidacaoDadosProfissional(int codigo, String mensagem) {
        this.codigo = codigo;
        this.mensagem = mensagem;
    }

    //Getters
    public int getCodigo() {
        return codigo;
    }

    public String getMensagem() {
        return mensagem;
    }

    //Método da interface
    @Override
    public String exibirMensagem() {
        return getMensagem();
    }

}
