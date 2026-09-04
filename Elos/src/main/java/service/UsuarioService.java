package service;

import static exception.ErrosGerais.*;
import static exception.ValidacaoDadosUsuario.*;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import dao.UsuarioDAO;
import exception.ErrosGerais;
import exception.GenericExceptionEnum;
import model.TiposUsuario;
import exception.ValidacaoDadosUsuario;
import model.Usuario;

public class UsuarioService {

    private static final double TAMANHO_MAXIMO_RAIO_PROCURA_KM = 999.99;
    private static final int TAMANHO_MAXIMO_NOME = 150;
    private static final Pattern PATTERN_PESSOA_FISICA = Pattern.compile("^[\\p{Script=Latin}\\']+[\\p{Script=Latin}\\'\\x20\\-]+$");
    private static final Pattern PATTERN_PESSOA_JURIDICA = Pattern.compile("^[\\p{Script=Latin}0-9&,.;\\'\\-]+[\\p{Script=Latin}0-9&,.;\\'\\-\\x20]+$");
    private static final int TAMANHO_MINIMO_SENHA = 8;
    private static final int TAMANHO_MAXIMO_SENHA = 60;
    private static final Pattern PATTERN_SENHA = Pattern.compile("(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[^a-zA-Z0-9\\s]).{8,}");
    private static final Pattern PATTERN_EMAIL = Pattern.compile("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,}$");
    private static final int TAMANHO_MAXIMO_EMAIL = 150;

    //Métodos para realizar as ações do UpdateUsuarioServlet
    public static ArrayList<GenericExceptionEnum> realizarUpdate(String idUpdate, String tipoUsuarioUpdate, String emailUpdate, String senhaUpdate, String nomeUpdate, String raioProcuraKmUpdate){
        ArrayList<GenericExceptionEnum> erros = validarUpdate(tipoUsuarioUpdate, emailUpdate, senhaUpdate, nomeUpdate, raioProcuraKmUpdate);

        if(!erros.isEmpty()){
            return erros;
        }

        int qtdLinhasAlteradas = atualizarUsuario(idUpdate,tipoUsuarioUpdate, emailUpdate, senhaUpdate, nomeUpdate, raioProcuraKmUpdate);
        if(qtdLinhasAlteradas < 0){
            erros.add(ErrosGerais.descobrirErroGeral(qtdLinhasAlteradas));
        }
        return erros;
    }

    private static int atualizarUsuario(String idUpdate, String tipoUsuarioUpdate, String emailUpdate, String senhaUpdate, String nomeUpdate, String raioProcuraKmUpdate){
        Usuario usuario = criarUsuarioValido(idUpdate, emailUpdate, senhaUpdate, nomeUpdate, tipoUsuarioUpdate, raioProcuraKmUpdate);
        UsuarioDAO dao = new UsuarioDAO();
        int qtdLinhasAfetadas = dao.updateById(usuario);
        return qtdLinhasAfetadas;
    }

    private static ArrayList<GenericExceptionEnum> validarUpdate(String tipoUsuarioUpdate,String emailUpdate, String senhaUpdate, String nomeUpdate, String raioProcuraKmUpdate){
        ArrayList<GenericExceptionEnum> erros = new ArrayList<>();
        ValidacaoDadosUsuario emailValidacao = validarEmailBasico(emailUpdate);

        if(emailValidacao != VALIDACAO_OK){
            erros.add(emailValidacao);
        }

        ValidacaoDadosUsuario senhaValidacao = validarSenhaUpdate(senhaUpdate);
        if (senhaValidacao != VALIDACAO_OK){
            erros.add(senhaValidacao);
        }

        ValidacaoDadosUsuario nomeValidacao = validarNome(nomeUpdate, tipoUsuarioUpdate);
        if (nomeValidacao != VALIDACAO_OK){
            erros.add(nomeValidacao);
        }

        ValidacaoDadosUsuario raioProcuraKmValidacao = validarRaioProcuraKm(raioProcuraKmUpdate);
        if(raioProcuraKmValidacao != VALIDACAO_OK){
            erros.add(raioProcuraKmValidacao);
        }
        return erros;
    }

    public static Usuario exibirUsuarioParaUpdate(String id){
        if(validarId(id) != VALIDACAO_OK){
            return null;
        }

        UsuarioDAO dao = new UsuarioDAO();
        return dao.readById(Long.parseLong(id));
    }

    //Métodos para realizar as ações do DeleteUsuarioServlet
    public static ArrayList<GenericExceptionEnum> realizarDelete(String id){
        ArrayList<GenericExceptionEnum> erros = new ArrayList<>();

        ValidacaoDadosUsuario validarId = validarId(id);
        if(validarId != VALIDACAO_OK) {
            erros.add(validarId);
            return erros;
        }

        int qtdLinhasDeletadas = deletarUsuario(id);
        if(qtdLinhasDeletadas > 0){
            return null;
        }

        erros.add(descobrirErroGeral(qtdLinhasDeletadas));
        return erros;
    }

    private static int deletarUsuario(String id){
        UsuarioDAO dao = new UsuarioDAO();
        return dao.deleteById(Long.parseLong(id.trim()));
    }

    //Métodos para realizar as ações do ReadUsuarioService
    public static ArrayList<Usuario> realizarSelect(String clausulaWhereNome, String clausulaWhereValor, String clausulaWhereValor2, String orderBy, String ordenacao, ArrayList<GenericExceptionEnum> errosEncontrados){
        ArrayList<Usuario> usuarios;

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

    private static ArrayList<Usuario> lerUsuarios(String clausulaWhereNome, String clausulaWhereValor, String clausulaWhereValor2, String orderBy, String ordenacao, boolean erroEncontrado){
        ArrayList<Usuario> usuarios = new ArrayList<>();
        UsuarioDAO dao = new UsuarioDAO();
        if (erroEncontrado){
            return dao.readAll();
        }

        String clausulaWhereNomeTratado = clausulaWhereNome.trim().toLowerCase();
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

        String orderByTratado = orderBy.trim().toLowerCase();
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

    private static ArrayList<GenericExceptionEnum> validarUsuarioSelect(String clausulaWhereNome, String clausulaWhereValor, String clausulaWhereValor2, String ordenacao, String orderBy){
        ArrayList<GenericExceptionEnum> erros = new ArrayList<>();
        ValidacaoDadosUsuario clausulaWhereNomeValidacao = validarWhere(clausulaWhereNome);
        if (clausulaWhereNomeValidacao != VALIDACAO_OK){
            erros.add(clausulaWhereNomeValidacao);
            return erros;
        }

        erros.addAll(validarClausulaWhereValor(clausulaWhereNome, clausulaWhereValor, clausulaWhereValor2));
        ValidacaoDadosUsuario orderByValidacao = validarOrderBy(orderBy);
        if (orderByValidacao != VALIDACAO_OK){
            erros.add(orderByValidacao);
        }

        ValidacaoDadosUsuario ordenacaoValidacao = validarSentidoOrdenacao(ordenacao);
        if (ordenacaoValidacao != VALIDACAO_OK){
            erros.add(ordenacaoValidacao);
        }
        return erros;
    }

    private static ArrayList<GenericExceptionEnum> validarClausulaWhereValor(String clausulaWhereNome, String clausulaWhereValor, String clausulaWhereValor2){
        ArrayList<GenericExceptionEnum> dadosValidados = new ArrayList<>();
        ValidacaoDadosUsuario dadoValidado = null;
        ValidacaoDadosUsuario dadoValidado2 = null;
        String clausulaWhereNomeTratado = clausulaWhereNome.trim().toLowerCase();
        if (clausulaWhereNomeTratado.equalsIgnoreCase("id")){
            dadoValidado = validarId(clausulaWhereValor);
        }

        if (clausulaWhereNomeTratado.equalsIgnoreCase("email")){
            dadoValidado = validarEmailBasico(clausulaWhereValor);
        }

        if (clausulaWhereNomeTratado.equalsIgnoreCase("nome")){
            dadoValidado = validarNome(clausulaWhereValor, TiposUsuario.PROFISSIONAL.getTipoDoUsuario()) == VALIDACAO_OK ?
                           validarNome(clausulaWhereValor, TiposUsuario.PROFISSIONAL.getTipoDoUsuario()) :
                           validarNome(clausulaWhereValor, TiposUsuario.FORNECEDOR.getTipoDoUsuario());
        }

        if (clausulaWhereNomeTratado.equalsIgnoreCase("tipo_usuario")){
            dadoValidado = validarTipoUsuario(clausulaWhereValor);
        }

        if (clausulaWhereNomeTratado.equalsIgnoreCase("raio_procura_km")){
            dadoValidado = validarRaioProcuraKm(clausulaWhereValor);
            dadoValidado2 = validarRaioProcuraKm(clausulaWhereValor2);
            if(dadoValidado != VALIDACAO_OK || dadoValidado2 != VALIDACAO_OK){
                dadosValidados.add(RAIOS_PROCURA_KM_NAO_NUMERICO);
                return dadosValidados;
            }
        }

        if (clausulaWhereNomeTratado.equalsIgnoreCase("nenhuma")){
            return dadosValidados;
        }

        if (dadoValidado == null){
            dadoValidado = DADO_INVALIDO_GENERICO;
        }

        if (dadoValidado != VALIDACAO_OK){
            dadosValidados.add(dadoValidado);
        }
        return dadosValidados;
    }

    //Métodos para realizar as ações do InsertUsuarioServlet
    public static ArrayList<GenericExceptionEnum> realizarInsert(String email, String senha, String nome, String tipoUsuario, String raioProcuraKm){
        ArrayList<GenericExceptionEnum> mensagens = validarUsuarioInsert(email, senha, nome, tipoUsuario, raioProcuraKm);
        if (mensagens.isEmpty()) {
            int resultado = persistirUsuario(email, senha, nome, tipoUsuario, raioProcuraKm);
            if (resultado != 1) {
                mensagens.add(ErrosGerais.descobrirErroGeral(resultado));
            }
        }
        return mensagens;
    }

    private static ArrayList<GenericExceptionEnum> validarUsuarioInsert(String email, String senha, String nome, String tipoUsuario, String raioProcuraKm){
        ArrayList<GenericExceptionEnum> listaDeErros = new ArrayList<>();

        ValidacaoDadosUsuario validacaoEmail = validarEmailInsert(email);
        if (validacaoEmail != VALIDACAO_OK){
            listaDeErros.add(validacaoEmail);
        }

        ValidacaoDadosUsuario validacaoSenha = validarSenha(senha);
        if(validacaoSenha != VALIDACAO_OK){
            listaDeErros.add(validacaoSenha);
        }

        ValidacaoDadosUsuario validacaoRaioProcuraKm = validarRaioProcuraKm(raioProcuraKm);
        if(validacaoRaioProcuraKm != VALIDACAO_OK && validacaoRaioProcuraKm != ATRIBUTO_NULL){
            listaDeErros.add(validacaoRaioProcuraKm);
        }

        ValidacaoDadosUsuario validacaoTipoUsuario = validarTipoUsuario(tipoUsuario);
        if(validacaoTipoUsuario != VALIDACAO_OK){
            listaDeErros.add(validacaoTipoUsuario);
            listaDeErros.add(IMPOSSIVEL_VALIDAR_NOME);
            return listaDeErros;
        }

        ValidacaoDadosUsuario validacaoNome = validarNome(nome, tipoUsuario);
        if(validacaoNome != VALIDACAO_OK){
            listaDeErros.add(validacaoNome);
        }
        return listaDeErros;
    }

    private static int persistirUsuario(String email, String senha, String nome, String tipoUsuario, String raioProcuraKm){
        Usuario usuario = criarUsuarioValido(null, email, senha, nome, tipoUsuario, raioProcuraKm);
        UsuarioDAO dao = new UsuarioDAO();
        return dao.insert(usuario);
    }

    private static Usuario criarUsuarioValido(String id, String email, String senha, String nome, String tipoUsuario, String raioProcuraKm){
        long idTratado = id != null && !id.isBlank()? Long.parseLong(id.trim()) : ATRIBUTO_NULL.getCodigo();
        double raioProcuraKmTratado = raioProcuraKm == null || raioProcuraKm.isEmpty() ? ATRIBUTO_NULL.getCodigo() : Double.parseDouble(raioProcuraKm.trim());

        String emailTratado = email.toLowerCase().trim();
        String senhaTratada = senha == null || senha.isBlank() ? null : senha.trim();
        String nomeTratado = nome.trim();

        TiposUsuario tipoUsuarioTratado = TiposUsuario.descobrirTipoUsuario(tipoUsuario.toUpperCase().trim());

        return new Usuario(idTratado, emailTratado, senhaTratada, nomeTratado, tipoUsuarioTratado, raioProcuraKmTratado);
    }

    //Métodos auxiliares
    private static ValidacaoDadosUsuario validarSentidoOrdenacao(String ordenacao){
        if (ordenacao == null || ordenacao.isBlank()){return ORDENACAO_INVALIDA;}

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

    private static ValidacaoDadosUsuario validarWhere(String where){
        if (where == null || where.isBlank()){return WHERE_INVALIDO;}

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

    private static ValidacaoDadosUsuario validarOrderBy(String ordenacao){
        if (ordenacao == null || ordenacao.isBlank()){return ORDER_BY_INVALIDO;}

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

    private static ValidacaoDadosUsuario validarId(String id){
        try {
            String idTratado = id.trim();
            Long.parseLong(idTratado);
            return VALIDACAO_OK;
        } catch (NumberFormatException numberFormatException){
            return ID_INVALIDO;
        }
    }

    private static ValidacaoDadosUsuario validarEmailBasico(String email) {
        if (email == null || email.isBlank()) {
            return EMAIL_VAZIO;
        }

        String emailTratado = email.toLowerCase().trim();
        if(emailTratado.length() > TAMANHO_MAXIMO_EMAIL){
            return EMAIL_TAMANHO_INVALIDO;
        }

        ValidacaoDadosUsuario validacaoFormato = validarFormatoEmail(emailTratado);
        return validarFormatoEmail(emailTratado) != VALIDACAO_OK ? EMAIL_INVALIDO : VALIDACAO_OK;
    }

    private static ValidacaoDadosUsuario validarEmailInsert(String email) {
        ValidacaoDadosUsuario validarEmailBasico = validarFormatoEmail(email);
        if(validarEmailBasico != VALIDACAO_OK){
            return validarEmailBasico;
        }

        String emailTratado = email.toLowerCase().trim();
        return validarEmailNaoCadastrado(emailTratado) != VALIDACAO_OK ? EMAIL_INVALIDO : VALIDACAO_OK;
    }

    private static ValidacaoDadosUsuario validarFormatoEmail(String email){
        return PATTERN_EMAIL.matcher(email).matches() ? VALIDACAO_OK : EMAIL_INVALIDO;
    }

    private static ValidacaoDadosUsuario validarEmailNaoCadastrado(String email){
        UsuarioDAO dao = new UsuarioDAO();
        Usuario usuario = dao.readByEmail(email);
        if(usuario != null && usuario.getId() != REGISTRO_NAO_ENCONTRADO.getCodigo()){
            return EMAIL_INVALIDO;
        }
        return VALIDACAO_OK;
    }

    private static ValidacaoDadosUsuario validarSenhaUpdate(String senha){
        if (senha == null || senha.isBlank()){
            return VALIDACAO_OK;
        }

        String senhaTrim = senha.trim();
        return validarSenha(senhaTrim);
    }

    private static ValidacaoDadosUsuario validarSenha(String senha){
        if (senha == null || senha.isBlank()){
            return SENHA_VAZIA;
        }

        String senhaTrim = senha.trim();
        if (senhaTrim.length() < TAMANHO_MINIMO_SENHA){
            return SENHA_MENOR_QUE_OITO;
        }

        if (senhaTrim.length() > TAMANHO_MAXIMO_SENHA){
            return SENHA_TAMANHO_INVALIDO;
        }

        Matcher matcher = PATTERN_SENHA.matcher(senhaTrim);
        return matcher.matches() ? VALIDACAO_OK : SENHA_FRACA;
    }

    private static ValidacaoDadosUsuario validarNome(String nome, String tipoUsuario){
        if (nome == null || nome.isBlank()){
            return NOME_VAZIO;
        }

        String nomeTrim = nome.trim();
        if (nomeTrim.length() > TAMANHO_MAXIMO_NOME){
            return NOME_TAMANHO_INVALIDO;
        }

        boolean nomeValido = TiposUsuario.PROFISSIONAL.getTipoDoUsuario().equalsIgnoreCase(tipoUsuario) ?
                PATTERN_PESSOA_FISICA.matcher(nomeTrim).matches() :
                PATTERN_PESSOA_JURIDICA.matcher(nomeTrim).matches();
        return nomeValido ? VALIDACAO_OK : NOME_INVALIDO;
    }

    private static ValidacaoDadosUsuario validarTipoUsuario(String tipoUsuario){
        if (tipoUsuario == null || tipoUsuario.isBlank()) {
            return TIPO_USUARIO_VAZIO;
        }

        if (TiposUsuario.descobrirTipoUsuario(tipoUsuario.toUpperCase().trim()) == null){
            return TIPO_USUARIO_INVALIDO;
        }
        return VALIDACAO_OK;
    }

    private static ValidacaoDadosUsuario validarRaioProcuraKm(String raioProcuraKm){
        if (raioProcuraKm == null || raioProcuraKm.isBlank()){
            return ATRIBUTO_NULL;
        }

        Double raioProcuraKmConvertido = validarRaioProcuraKmConversivel(raioProcuraKm);
        if (raioProcuraKmConvertido == null){
            return RAIO_PROCURA_KM_NAO_NUMERICO;
        }

        if (raioProcuraKmConvertido <= 0){
            return RAIO_PROCURA_KM_MENOR_OU_IGUAL_QUE_ZERO;
        }

        if (raioProcuraKmConvertido > TAMANHO_MAXIMO_RAIO_PROCURA_KM){
            return RAIO_PROCURA_KM_TAMANHO_INVALIDO;
        }

        return VALIDACAO_OK;
    }

    private static Double validarRaioProcuraKmConversivel(String raioProcuraKm){
        try {
            String raioProcuraKmTrim = raioProcuraKm.trim();
            return Double.parseDouble(raioProcuraKmTrim);
        }catch (NumberFormatException numberFormatException) {
            return null;
        }
    }
}