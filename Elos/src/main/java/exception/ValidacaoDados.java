package exception;

public enum ValidacaoDados implements GenericExceptionEnum{

    //Variações do enum
    ATRIBUTO_NULL(-1, "Atributo null"),
    VALIDACAO_OK(0, "Dado válido"),
    RAIO_PROCURA_KM_NAO_NUMERICO(1,"O raio de procura em km inserido não é um valor numérico"),
    RAIO_PROCURA_KM_MENOR_OU_IGUAL_QUE_ZERO(2,"Insira raios de procura em km maiores que zero"),
    TIPO_USUARIO_VAZIO(3,"Nenhum tipo de usuário foi inserido"),
    TIPO_USUARIO_INVALIDO(4, "O tipo de usuário que foi inserido é inválido"),
    NOME_VAZIO(5, "Nenhum nome foi inserido"),
    NOME_TAMANHO_INVALIDO(6, "O tamanho do nome inserido é inválido, insira um nome com até 150 caracteres"),
    NOME_INVALIDO(7, "O nome inserido é inválido"),
    SENHA_VAZIA(8, "Nenhuma senha foi inserida"),
    SENHA_MENOR_QUE_OITO(9, "Insira uma senha com ao menos 8 caracteres"),
    SENHA_TAMANHO_INVALIDO(10, "A senha inserida possui um tamanho maior que o permitido, insira uma senha com até 60 caracteres"),
    SENHA_FRACA(11, "A senha deve possuir uma letra maiúscula, uma minuscula, um número e um caractere especial"),
    EMAIL_INVALIDO(12, "O email inserido é inválido"),
    EMAIL_VAZIO(13, "Nenhum email foi inserido"),
    EMAIL_TAMANHO_INVALIDO(14, "O email inserido possui um tamanho maior que o permitido, insira um email com até 150 caracteres"),
    IMPOSSIVEL_VALIDAR_NOME(15, "Não foi possível validar o nome pois o tipo de usuário inserido é inválido"),
    ID_INVALIDO(16, "O ID inserido é inválido"),
    ORDER_BY_INVALIDO(17, "A clausula de ordenação é inválida"),
    WHERE_INVALIDO(18, "O nome da clausula de filtragem é inválido"),
    DADO_INVALIDO_GENERICO(19, "Algum dado inserido está inválido"),
    ORDENACAO_INVALIDA(20, "A ordenação inserida é inválida"),
    RAIOS_PROCURA_KM_NAO_NUMERICO(21,"Um ou mais raios de procura em km inseridos não são valores numéricos"),
    RAIO_PROCURA_KM_TAMANHO_INVALIDO(22,"O raio de procura em km inserido excede o limite aceito");

    //Constantes do enum
    private final int codigo;
    private final String mensagem;

    //Construtor
    ValidacaoDados(int codigo, String mensagem) {
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
