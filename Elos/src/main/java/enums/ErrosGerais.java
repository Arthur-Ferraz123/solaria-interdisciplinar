package enums;

public enum ErrosGerais implements GenericEnum {

    //Variações do enum
    ERRO_POR_VIOLACAO_DE_REGRA_DO_BD(-1, "Um ou mais dados inseridos estão inválidos"),
    ERRO_GENERICO_NO_BD(-2, "Um possível erro de conexão ocorreu, cheque sua conexão de internet e tente novamente!"),
    ERRO_GENERICO(-3, "Algo inesperado aconteceu, tente novamente!"),
    REGISTRO_NAO_ENCONTRADO(-4, "O registro buscado não foi encontrado, verifique se os dados inseridos estão corretos");

    //Constantes do enum
    private final int codigo;
    private final String mensagem;

    //Construtor
    ErrosGerais(int codigo, String mensagem) {

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

    public static ErrosGerais descobrirErroGeral(int codigo){

        for (ErrosGerais errosGerais : ErrosGerais.values()){

            if(errosGerais.getCodigo() == codigo){

                return errosGerais;

            }

        }

        return ERRO_GENERICO;

    }

    //Método da interface
    @Override
    public String exibirMensagem() {
        return getMensagem();
    }

}
