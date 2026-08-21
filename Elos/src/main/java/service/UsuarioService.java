package service;

import model.Usuario;

import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class UsuarioService {

    //Chamar esse método somente depois de validar se nenhum dado está incorreto
    public static Usuario construirUsuarioCasoNenhumErroDeDado(String email, String senha, String nome, String tipoUsuario, String raioProcuraKm){

        String emailTratado = email.toLowerCase().trim();
        String senhaTratada = senha.trim();
        String nomeTratado = nome.trim();
        String tipoUsuarioTratado = tipoUsuario.toUpperCase();
        double raioProcuraKmTratado = Double.parseDouble(raioProcuraKm.trim());

        return new Usuario(-1, tipoUsuarioTratado, emailTratado, senhaTratada, nomeTratado, raioProcuraKmTratado);

    }

    //Validação dos dados do usuario
    public static ArrayList<String> validarUsuarioInsert(String email, String senha, String nome, String tipoUsuario, String raioProcuraKm){

        ArrayList<String> listaDeErros = new ArrayList<>();

        String validacaoEmail = validarEmail(email);
        String validacaoSenha = validarSenha(senha);
        String validacaoTipoUsuario = validarTipoUsuario(tipoUsuario);
        String validacaoNome = validarNome(nome, tipoUsuario);
        String validacaoRaioProcuraKm = validarRaioProcuraKm(raioProcuraKm);

        if (validacaoEmail != null){

            listaDeErros.add(validacaoEmail);

        }

        if(validacaoSenha != null){

            listaDeErros.add(validacaoSenha);

        }

        if(validacaoTipoUsuario != null){

            listaDeErros.add(validacaoTipoUsuario);
            listaDeErros.add("Não foi possível validar o nome pois o tipo de usuário inserido é inválido");

            validacaoNome = null;

        }

        if(validacaoNome != null){

            listaDeErros.add(validacaoNome);
        }

        if(validacaoRaioProcuraKm != null){

            listaDeErros.add(validacaoRaioProcuraKm);

        }

        return listaDeErros.isEmpty() ? null : listaDeErros;

    }

    //Validação do email
    private static String validarEmail(String email){

        if (email == null){

            return "Nenhum email foi inserido";

        }

        String emailTratado = email.toLowerCase().trim();

        Pattern pattern = Pattern.compile("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,}$");
        Matcher matcher = pattern.matcher(emailTratado);

        return matcher.matches() ? null : "O email inserido é inválido";

    }

    //Validação da senha
    private static String validarSenha(String senha){

        if (senha == null){

            return "Nenhuma senha foi inserida";

        }

        String senhaTrim = senha.trim();

        if (senhaTrim.length() < 8){

            return "Insira uma senha com ao menos 8 caracteres";

        }

        Pattern pattern = Pattern.compile("(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[^a-zA-Z0-9\\s]).{8,}");
        Matcher matcher = pattern.matcher(senhaTrim);

        return matcher.matches() ? null : "A senha deve possuir uma letra maiúscula, uma minuscula, um número e um caractere especial";

    }

    //Validação do nome
    private static String validarNome(String nome, String tipoUsuario){

        if (nome == null){

            return "Nenhum nome foi inserido";

        }

        String nomeTrim = nome.trim();

        Pattern pattern;
        Matcher matcher;

        if ("PROFISSIONAL".equalsIgnoreCase(tipoUsuario)){

            pattern  = Pattern.compile("^[\\p{Script=Latin}\\'u0027]+[\\p{Script=Latin}\\'u0027\\x20\\-]+$");

            matcher = pattern.matcher(nomeTrim);

        }
        else {

            pattern  = Pattern.compile("^[\\p{Script=Latin}0-9&,.;\\'\\-]+[\\p{Script=Latin}0-9&,.;\\'\\-\\x20]+$");

            matcher = pattern.matcher(nomeTrim);

        }

        return matcher.matches() ? null : "O nome inserido é inválido";

    }

    //Validação do tipoUsuario
    private static String validarTipoUsuario(String tipoUsuario){

        if (tipoUsuario == null) {

            return "Nenhum tipo de usuário foi inserido";

        }

        String tipoUsuarioToUpperCase = tipoUsuario.toUpperCase();

        if (!"EMPRESA_DEMANDANTE".equalsIgnoreCase(tipoUsuarioToUpperCase) &&
            !"FORNECEDOR".equalsIgnoreCase(tipoUsuarioToUpperCase) &&
            !"PROFISSIONAL".equalsIgnoreCase(tipoUsuarioToUpperCase)){

            return "O tipo de usuário que foi inserido é inválido";

        }

        return null;

    }

    //Validações do raioProcuraKm
    private static String validarRaioProcuraKm(String raioProcuraKm){

        if (raioProcuraKm == null){

            return "Nenhum raio de procura em km foi inserido";

        }

        Double raioProcuraKmConvertido = validarRaioProcuraKmConversivel(raioProcuraKm);

        if (raioProcuraKmConvertido == null){

            return "O raio de procura em km inserido não é um valor numérico";

        }

        if (!(raioProcuraKmConvertido > 0)){

            return "Insira um raio de procura em km maior que zero";

        }

        return null;

    }

    private static Double validarRaioProcuraKmConversivel(String raioProcuraKm){

        try {

            String raioProcuraKmTrim = raioProcuraKm.trim();

            Double raioProcuraKmConvertido = Double.parseDouble(raioProcuraKmTrim);

            return raioProcuraKmConvertido;

        }

        catch (NumberFormatException numberFormatException) {

            return null;

        }

    }

}