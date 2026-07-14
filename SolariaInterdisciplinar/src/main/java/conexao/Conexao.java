package conexao;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.DriverManager;

import java.sql.Connection;

import java.sql.SQLException;

/**
 * Realiza conexões JDBC no PostgreSQL
 *
 * @author Eduardo Vicente Bisneto
 * @version 1.0.0
 */

public class Conexao {

    /**
     * Guarda de maneira estática os dados do .env.
     */

    private static final Dotenv DOTENV = Dotenv.load();

    /**
     * Guarda uma conexão JDBC ativa.
     */

    private Connection connection;

    /**
     * Cria uma conexão JDBC. Em caso de erro retorna null.
     *
     * @return A conexão criada.
     */

    public Connection conectar(){

        try{

            //Variáveis de ambiente
            final String URL = validarEnvs(DOTENV.get("DB_URL"), "DB_URL");
            final String USUARIO = validarEnvs(DOTENV.get("DB_USUARIO"), "DB_USUARIO");
            final String SENHA = validarEnvs(DOTENV.get("DB_SENHA"), "DB_SENHA");

            //Carrega o driver do PostgreSQL
            Class.forName("org.postgresql.Driver");

            //Criação da conexão JDBC
            connection = DriverManager.getConnection(URL, USUARIO, SENHA);

            System.out.println("conectou!");

            return connection;

            //Para casos de erros no .env
        } catch (NullPointerException | IllegalArgumentException e) {

            e.printStackTrace();

            return null;


        } catch (SQLException | ClassNotFoundException e) {

            e.printStackTrace();

            return null;


        } catch (Exception e){

            e.printStackTrace();

            return null;
        }

    }

    /**
     * Desliga uma conexão JDBC ativa.
     */

    public void desconectar(){

        try {

            if (connection != null && !connection.isClosed()) {

                System.out.println("desconectou!");

                connection.close();

            }

        } catch (SQLException e) {

            e.printStackTrace();

        } catch (Exception e){

            e.printStackTrace();
        }

    }

    //Método auxiliar para a classe conectar
    private static String validarEnvs(String valorEnv, String nomeEnv){

        if (valorEnv == null){

            throw new NullPointerException(String.format("Erro: A variável de ambiente %s não está registrada no .env", nomeEnv));

        }
        else if(valorEnv.isEmpty()){

            throw new IllegalArgumentException(String.format("Erro: A variável de ambiente %s não possuí um valor registrado", nomeEnv));

        }

        return valorEnv.trim();

    }

}

