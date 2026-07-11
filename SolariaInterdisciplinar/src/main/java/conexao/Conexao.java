package conexao;

//Import da classe utilizada para ler o arquivo .env
import io.github.cdimascio.dotenv.Dotenv;

//Import da classe utilizada para realizar conexões JDBC
import java.sql.DriverManager;

//Import da interface utilizada para armazenar conexões JDBC ativas
import java.sql.Connection;

//Import da classe utilizada para representar erros que ocorrem no banco de dados
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

            //Para casos de erros quando o driver do PostgreSQL é carregado ou ao criar a conexão JDBC
        } catch (SQLException | ClassNotFoundException e) {

            e.printStackTrace();

            return null;


        }

    }

    /**
     * Desliga uma conexão JDBC ativa.
     */

    public void desconectar(){

        try {

            //Verifica se a conexão está ativa e a desconecta
            if (connection != null && !connection.isClosed()) {

                System.out.println("desconectou!");

                connection.close();

            }

            //Para caso de erro no .close
        } catch (SQLException e) {

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

