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

import static enums.ErrosGerais.*;
import static enums.ValidacaoDados.*;

public class UsuarioService {

    public static Usuario exibirUsuarioUpdate(String id){

        if(validarId(id).getCodigo() != VALIDACAO_OK.getCodigo()){

            return null;

        }

        UsuarioDAO dao = new UsuarioDAO();

        return dao.readById(Long.parseLong(id));

    }

    //Métodos para realizar as ações do DeleteUsuarioServlet
    public static GenericEnum realizarDelete(String id){

        ValidacaoDados erro = validarId(id);

        if(erro.getCodigo() != VALIDACAO_OK.getCodigo()) {

            return erro;

        }

        int resultado = deletarUsuario(id);

        if(resultado > 0){

            return null;

        }

        return descobrirErroGeral(resultado);


    }

    private static int deletarUsuario(String id){

        long idConvertido = Long.parseLong(id.trim());

        UsuarioDAO dao = new UsuarioDAO();

        int resultado = dao.deleteById(idConvertido);

        return resultado;


    }

    //Métodos para realizar as ações do ReadUsuarioService
    public static List<Usuario> realizarSelect(String clausulaWhereNome, String clausulaWhereValor, String clausulaWhereValor2, String orderBy, String ordenacao, ArrayList<GenericEnum> errosEncontrados){

        List<Usuario> usuarios = new ArrayList<>();

        if(clausulaWhereNome == null && clausulaWhereValor == null && clausulaWhereValor2 == null && orderBy == null && ordenacao == null){

            return lerUsuarios(null, null, null, null, null, true);

        }

        errosEncontrados.addAll(validarUsuarioSelect(clausulaWhereNome, clausulaWhereValor, clausulaWhereValor2, ordenacao, orderBy));

        if (!errosEncontrados.isEmpty()){

            return lerUsuarios(clausulaWhereNome, clausulaWhereValor, clausulaWhereValor2, orderBy, ordenacao,true);

        }

        usuarios = lerUsuarios(clausulaWhereNome, clausulaWhereValor, clausulaWhereValor2, orderBy, ordenacao,false);

        if (usuarios.isEmpty()){

            errosEncontrados.add(REGISTROS_NAO_ENCONTRADOS);

        }

        return usuarios;

    }

    private static List<Usuario> lerUsuarios(String clausulaWhereNome, String clausulaWhereValor, String clausulaWhereValor2, String orderBy, String ordenacao, boolean erroEncontrado){

        List<Usuario> usuarios = new ArrayList<>();

        UsuarioDAO dao = new UsuarioDAO();

        if  (erroEncontrado){

            return dao.readAll();

        }

        String clausulaWhereNomeTratado = clausulaWhereNome.trim().toLowerCase().replaceAll("á","a")
                .replaceAll(" em","")
                .replaceAll(" de","")
                .replaceAll(" ", "_");


        String orderByTratado = orderBy.trim().toLowerCase().replaceAll("á","a")
                .replaceAll(" em","")
                .replaceAll(" de","")
                .replaceAll(" ", "_");


        if (clausulaWhereNomeTratado.equalsIgnoreCase("id")){

            long id = Long.parseLong(clausulaWhereValor.trim());

            usuarios.add(dao.readById(id));

            return usuarios;

        }

        if (clausulaWhereNomeTratado.equalsIgnoreCase("email")){

            String emailTratado = clausulaWhereValor.toLowerCase().trim();

            usuarios.add(dao.readByEmail(emailTratado));

            return usuarios;

        }

        if (clausulaWhereNomeTratado.equalsIgnoreCase("nome")){

            String nomeTratado = clausulaWhereValor.trim();

            usuarios.add(dao.readByNome(nomeTratado));

            return usuarios;

        }

        if (clausulaWhereNomeTratado.equalsIgnoreCase("nenhuma")){

            usuarios = orderByTratado.equalsIgnoreCase("nenhuma") ? dao.readAll() : dao.readAllOrderBy(orderByTratado, ordenacao);

            return usuarios;

        }

        if(clausulaWhereNomeTratado.equalsIgnoreCase("tipo_usuario")){

            String tipoUsuarioTratado = clausulaWhereValor.toUpperCase();

            usuarios = orderByTratado.equalsIgnoreCase("nenhuma") ?
                            dao.readAllByTipoUsuario(tipoUsuarioTratado) :
                            dao.readAllByTipoUsuarioOrderBy(tipoUsuarioTratado, orderByTratado, ordenacao);

            return usuarios;


        }

        if(clausulaWhereNomeTratado.equalsIgnoreCase("raio_procura_km")){

            double raioProcuraKmMin = Double.parseDouble(clausulaWhereValor.trim());
            double raioProcuraKmMax = Double.parseDouble(clausulaWhereValor2.trim());

            return orderByTratado.equalsIgnoreCase("nenhuma") ?
                    dao.readAllWhereRaioProcuraKmEntre(raioProcuraKmMin, raioProcuraKmMax) :
                    dao.readAllWhereRaioProcuraKmEntreOrderBy(raioProcuraKmMin, raioProcuraKmMax, orderBy, ordenacao);
        }

        return dao.readAll();

    }

    private static ArrayList<GenericEnum> validarUsuarioSelect(String clausulaWhereNome, String clausulaWhereValor, String clausulaWhereValor2, String ordenacao, String orderBy){

        ArrayList<GenericEnum> erros = new ArrayList<>();

        ValidacaoDados clausulaWhereNomeValidacao = validarWhere(clausulaWhereNome);

        if (clausulaWhereNomeValidacao.getCodigo() != VALIDACAO_OK.getCodigo()){

            erros.add(clausulaWhereNomeValidacao);

            return erros;

        }


        erros.addAll(validarClausulaWhereValor(clausulaWhereNome, clausulaWhereValor, clausulaWhereValor2));

        ValidacaoDados orderByValidacao = validarOrderBy(orderBy);

        if (orderByValidacao.getCodigo() != VALIDACAO_OK.getCodigo()){

            erros.add(orderByValidacao);

        }

        ValidacaoDados ordenacaoValidacao = validarSentidoOrdenacao(ordenacao);

        if (ordenacaoValidacao.getCodigo() != VALIDACAO_OK.getCodigo()){

            erros.add(ordenacaoValidacao);

        }



        return erros;

    }

    private static ArrayList<GenericEnum> validarClausulaWhereValor(String clausulaWhereNome, String clausulaWhereValor, String clausulaWhereValor2){

        ArrayList<GenericEnum> dadosValidados = new ArrayList<>();

        ValidacaoDados dadoValidado = null;
        ValidacaoDados dadoValidado2 = null;

        String clausulaWhereNomeTratado = clausulaWhereNome.trim().toLowerCase().replaceAll("á","a")
                .replaceAll(" em","")
                .replaceAll(" de","")
                .replaceAll(" ", "_");

        if (clausulaWhereNomeTratado.equalsIgnoreCase("id")){

            dadoValidado = validarId(clausulaWhereValor);

        } else if(clausulaWhereNomeTratado.equalsIgnoreCase("email")){

            dadoValidado = validarEmail(clausulaWhereValor, false);

        } else if(clausulaWhereNomeTratado.equalsIgnoreCase("nome")){

            dadoValidado = validarNome(clausulaWhereValor, "PROFISSIONAL").getCodigo() == VALIDACAO_OK.getCodigo() ? validarNome(clausulaWhereValor, "PROFISSIONAL") : validarNome(clausulaWhereValor, "FORNECEDOR");

        } else if(clausulaWhereNomeTratado.equalsIgnoreCase("tipo_usuario")){

            dadoValidado = validarTipoUsuario(clausulaWhereValor);

        } else if(clausulaWhereNomeTratado.equalsIgnoreCase("raio_procura_km")){

            dadoValidado = validarRaioProcuraKm(clausulaWhereValor);
            dadoValidado2 = validarRaioProcuraKm(clausulaWhereValor2);

        } else if (clausulaWhereNomeTratado.equalsIgnoreCase("nenhuma")){

            return dadosValidados;

        }else {

            dadoValidado = DADO_INVALIDO_GENERICO;

        }

        if (dadoValidado.getCodigo() != VALIDACAO_OK.getCodigo()){

            dadosValidados.add(dadoValidado);

        }

        if (dadoValidado2 != null && dadoValidado2.getCodigo() != VALIDACAO_OK.getCodigo()){

            dadosValidados.add(dadoValidado2);

        }

        return dadosValidados;

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

        return new Usuario(ATRIBUTO_NULL.getCodigo(), emailTratado, senhaTratada, nomeTratado, tipoUsuarioTratado, raioProcuraKmTratado);

    }

    //Métodos auxiliares
    private static ValidacaoDados validarSentidoOrdenacao(String ordenacao){

        if (ordenacao == null){return ORDENACAO_INVALIDA;}

        String ordenacaoTratada = ordenacao.trim().toLowerCase().replaceAll("á","a")
                .replaceAll(" em","")
                .replaceAll(" de","")
                .replaceAll(" ", "_");

        switch(ordenacaoTratada) {
            case "asc", "desc":
                return VALIDACAO_OK;
            default:
                return ORDENACAO_INVALIDA;

        }

    }

    private static ValidacaoDados validarWhere(String where){

        if (where == null){return WHERE_INVALIDO;}

        String whereTratada = where.trim().toLowerCase().replaceAll("á","a")
                .replaceAll(" em","")
                .replaceAll(" de","")
                .replaceAll(" ", "_");

        switch(whereTratada) {
            case "id", "email", "nome", "tipo_usuario", "raio_procura_km", "nenhuma":
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
            case "id", "email", "nome", "tipo_usuario", "raio_procura_km", "nenhuma":
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

        if(!insert){

            return VALIDACAO_OK;

        }

        ValidacaoDados emailNaoCadastrado = validarEmailNaoCadastrado(emailTratado);

        if(emailNaoCadastrado != VALIDACAO_OK){

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