package service;

import dao.UsuarioDAO;
import exception.ValidacaoDadosProfissional;
import model.Usuario;

import static exception.ErrosGerais.REGISTRO_NAO_ENCONTRADO;
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
        if(validarId(idUsuario) != VALIDACAO_OK){
            return ID_USUARIO_INVALIDO;
        }

        long idUsuarioConvertido = Long.parseLong(idUsuario);

        UsuarioDAO dao = new UsuarioDAO();
        Usuario usuario = dao.readById(idUsuarioConvertido);

        if(usuario != null && usuario.getId() == REGISTRO_NAO_ENCONTRADO.getCodigo()){
            return ID_USUARIO_NAO_REGISTRADO;
        }

        return VALIDACAO_OK;
    }
}
