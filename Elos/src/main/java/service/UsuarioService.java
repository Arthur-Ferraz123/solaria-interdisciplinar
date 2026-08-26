package service;

import dao.UsuarioDAO;
import enums.ErrosGerais;
import enums.GenericEnum;
import enums.ValidacaoDados;
import model.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import static enums.ValidacaoDados.*;
import static enums.ErrosGerais.REGISTRO_NAO_ENCONTRADO;

public class UsuarioService {


    //Métodos para realizar as ações do ReadUsuarioService
    public static List<Usuario> realizarSelect(String clausulaWhereNome, String clausulaWhereValor, String clausulaWhereValor2, String orderBy, ArrayList<GenericEnum> errosEncontrados){

        List<Usuario> usuarios = new ArrayList<>();



        return usuarios;

    }

    private static ArrayList<GenericEnum> validarUsuarioSelect(String clausulaWhereNome, String clausulaWhereValor, String clausulaWhereValor2, String orderBy, ArrayList<GenericEnum> errosEncontrados){



    }

    //Métodos para realizar as ações do InsertUsuarioServlet
    public static ArrayList<GenericEnum> realizarInsert(String email, String senha, String nome, String tipoUsuario, String raioProcuraKm){

        ArrayList<GenericEnum> mensagens = validarUsuarioInsert(email, senha, nome, tipoUsuario, raioProcuraKm);

        if (mensagens.isEmpty()) {

            int resultado = persistirUsuario(email, senha, nome, tipoUsuario, raioProcuraKm);

            if (resultado != 1) {

                mensagens.add(ErrosGerais.descobrirErroGeral(resultado));

            }

        }

        return mensagens;

    }

    private static ArrayList<GenericEnum> validarUsuarioInsert(String email, String senha, String nome, String tipoUsuario, String raioProcuraKm){

        ArrayList<GenericEnum> listaDeErros = new ArrayList<>();

        ValidacaoDados validacaoEmail = validarEmail(email, true);
        ValidacaoDados validacaoSenha = validarSenha(senha);
        ValidacaoDados validacaoTipoUsuario = validarTipoUsuario(tipoUsuario);
        ValidacaoDados validacaoNome = validarNome(nome, tipoUsuario);
        ValidacaoDados validacaoRaioProcuraKm = validarRaioProcuraKm(raioProcuraKm);

        if (validacaoEmail != VALIDACAO_OK){

            listaDeErros.add(validacaoEmail);

        }

        if(validacaoSenha != VALIDACAO_OK){

            listaDeErros.add(validacaoSenha);

        }

        if(validacaoTipoUsuario != VALIDACAO_OK){


            listaDeErros.add(validacaoTipoUsuario);

            listaDeErros.add(IMPOSSIVEL_VALIDAR_NOME);

            validacaoNome = VALIDACAO_OK;

        }

        if(validacaoNome != VALIDACAO_OK){

            listaDeErros.add(validacaoNome);
        }

        if(validacaoRaioProcuraKm != VALIDACAO_OK){

            listaDeErros.add(validacaoRaioProcuraKm);

        }

        return listaDeErros;

    }

    private static int persistirUsuario(String email, String senha, String nome, String tipoUsuario, String raioProcuraKm){

        Usuario usuario = criarUsuarioValido(email, senha, nome, tipoUsuario, raioProcuraKm);

        UsuarioDAO dao = new UsuarioDAO();

        return usuario.getRaioProcuraKm() == ATRIBUTO_NULL.getCodigo() ? dao.insertRaioProcuraKmNull(usuario) : dao.insert(usuario);

    }

    private static Usuario criarUsuarioValido(String email, String senha, String nome, String tipoUsuario, String raioProcuraKm){

        String emailTratado = email.toLowerCase().trim();
        String senhaTratada = senha.trim();
        String nomeTratado = nome.trim();
        String tipoUsuarioTratado = tipoUsuario.toUpperCase();
        double raioProcuraKmTratado = raioProcuraKm == null ? ATRIBUTO_NULL.getCodigo() : Double.parseDouble(raioProcuraKm.trim());

        return new Usuario(ATRIBUTO_NULL.getCodigo(), tipoUsuarioTratado, emailTratado, senhaTratada, nomeTratado, raioProcuraKmTratado);

    }

    //

    //Métodos auxiliares
    private static ValidacaoDados validarWhere(String where){

        if (where == null){return WHERE_INVALIDO;}

        String whereTratada = where.trim().toLowerCase().replaceAll("á","a")
                .replaceAll(" em","")
                .replaceAll(" de","")
                .replaceAll(" ", "_");

        switch(where) {
            case "id", "email", "nome", "tipo_usuario", "raio_procura_km", "nenhum":
                return VALIDACAO_OK;
            default:
                return WHERE_INVALIDO;

        }
    }

    private static ValidacaoDados validarOrderBy(String ordenacao){

        if (ordenacao == null){return ORDER_BY_INVALIDO;}

        String ordenacaoTratada = ordenacao.trim().toLowerCase().replaceAll("á","a")
                                                                .replaceAll(" em","")
                                                                .replaceAll(" de","")
                                                                .replaceAll(" ", "_");

        switch(ordenacaoTratada) {
            case "id", "email", "nome", "tipo_usuario", "raio_procura_km", "nenhum":
                return VALIDACAO_OK;
            default:
                return ORDER_BY_INVALIDO;

        }
    }

    private static ValidacaoDados validarId(String id){

        try {

            String idTratado = id.trim();

            long idConvertido = Long.parseLong(idTratado);

            return VALIDACAO_OK;

        } catch (NumberFormatException numberFormatException){

            return ID_INVALIDO;

        }

    }

    private static ValidacaoDados validarEmail(String email, boolean insert) {

        if (email == null) {

            return EMAIL_VAZIO;

        }

        String emailTratado = email.toLowerCase().trim();

        if(emailTratado.length() > 150){

            return EMAIL_TAMANHO_INVALIDO;

        }

        ValidacaoDados validacaoFormato = validarFormatoEmail(emailTratado);

        if (validacaoFormato != VALIDACAO_OK){

            return validacaoFormato;

        }

        ValidacaoDados emailNaoCadastrado = validarEmailNaoCadastrado(emailTratado);

        if(emailNaoCadastrado != VALIDACAO_OK && insert){

            return emailNaoCadastrado;

        }

        return VALIDACAO_OK;

    }

    private static ValidacaoDados validarFormatoEmail(String email){

        Pattern pattern = Pattern.compile("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,}$");
        Matcher matcher = pattern.matcher(email);

        if(!matcher.matches()){

            return EMAIL_INVALIDO;
        }

        return VALIDACAO_OK;

    }

    private static ValidacaoDados validarEmailNaoCadastrado(String email){

        UsuarioDAO dao = new UsuarioDAO();

        Usuario usuario = dao.readByEmail(email);

        if(usuario != null && usuario.getId() != REGISTRO_NAO_ENCONTRADO.getCodigo()){

            return EMAIL_INVALIDO;

        }

        return VALIDACAO_OK;

    }

    private static ValidacaoDados validarSenha(String senha){

        if (senha == null){

            return SENHA_VAZIA;

        }

        String senhaTrim = senha.trim();

        if (senhaTrim.length() < 8){

            return SENHA_MENOR_QUE_OITO;

        }

        if (senhaTrim.length() > 60){

            return SENHA_TAMANHO_INVALIDO;

        }

        Pattern pattern = Pattern.compile("(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[^a-zA-Z0-9\\s]).{8,}");
        Matcher matcher = pattern.matcher(senhaTrim);

        return matcher.matches() ? VALIDACAO_OK : SENHA_FRACA;

    }

    private static ValidacaoDados validarNome(String nome, String tipoUsuario){

        if (nome == null){

            return NOME_VAZIO;

        }

        String nomeTrim = nome.trim();

        if (nomeTrim.length() > 150){

            return NOME_TAMANHO_INVALIDO;

        }

        Pattern pattern;
        Matcher matcher;

        if ("PROFISSIONAL".equalsIgnoreCase(tipoUsuario)){

            pattern  = Pattern.compile("^[\\p{Script=Latin}\\']+[\\p{Script=Latin}\\'\\x20\\-]+$");

            matcher = pattern.matcher(nomeTrim);

        }
        else {

            pattern  = Pattern.compile("^[\\p{Script=Latin}0-9&,.;\\'\\-]+[\\p{Script=Latin}0-9&,.;\\'\\-\\x20]+$");

            matcher = pattern.matcher(nomeTrim);

        }

        return matcher.matches() ? VALIDACAO_OK : NOME_INVALIDO;

    }

    private static ValidacaoDados validarTipoUsuario(String tipoUsuario){

        if (tipoUsuario == null) {

            return TIPO_USUARIO_VAZIO;

        }

        if(tipoUsuario.length() > 18){

            return TIPO_USUARIO_INVALIDO;

        }

        String tipoUsuarioToUpperCase = tipoUsuario.toUpperCase();

        if (!"EMPRESA_DEMANDANTE".equalsIgnoreCase(tipoUsuarioToUpperCase) &&
            !"FORNECEDOR".equalsIgnoreCase(tipoUsuarioToUpperCase) &&
            !"PROFISSIONAL".equalsIgnoreCase(tipoUsuarioToUpperCase)){

            return TIPO_USUARIO_INVALIDO;

        }

        return VALIDACAO_OK;

    }

    private static ValidacaoDados validarRaioProcuraKm(String raioProcuraKm){

        if (raioProcuraKm == null){

            return ATRIBUTO_NULL;

        }

        Double raioProcuraKmConvertido = validarRaioProcuraKmConversivel(raioProcuraKm);

        if (raioProcuraKmConvertido == null){

            return RAIO_PROCURA_KM_NAO_NUMERICO;

        }

        if (!(raioProcuraKmConvertido > 0)){

            return RAIO_PROCURA_KM_MENOR_OU_IGUAL_QUE_ZERO;

        }

        return VALIDACAO_OK;

    }

    private static Double validarRaioProcuraKmConversivel(String raioProcuraKm){

        try {

            String raioProcuraKmTrim = raioProcuraKm.trim();

            Double raioProcuraKmConvertido = Double.parseDouble(raioProcuraKmTrim);

            return raioProcuraKmConvertido;

        }catch (NumberFormatException numberFormatException) {

            return null;

        }

    }

}