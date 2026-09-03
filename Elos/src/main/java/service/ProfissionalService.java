package service;

import exception.ValidacaoDadosProfissional;

import static exception.ValidacaoDadosProfissional.*;


public class ProfissionalService {



    //Métodos auxiliares
    private static ValidacaoDadosProfissional validarId(String id){
        try {
            String idTratado = id.trim();
            long idConvertido = Long.parseLong(idTratado);

            return VALIDACAO_OK;

        } catch (NumberFormatException numberFormatException){
            return ID_INVALIDO;

        }
    }

    private static ValidacaoDadosProfissional validarIdUsuario(String idUsuario){

        ValidacaoDadosProfissional validacaoIdBase = validarId(idUsuario);

        if(validacaoIdBase != VALIDACAO_OK){
            return validacaoIdBase;
        }



    }
}
