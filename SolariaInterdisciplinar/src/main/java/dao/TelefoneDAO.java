package dao;

import conexao.Conexao;

import model.Endereco;
import model.Telefone;
import model.Usuario;

import java.sql.Connection;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.util.List;

import java.util.ArrayList;

/**
 * Classe responsável pelo DAO da entidade Telefone
 *
 * @author Eduardo Vicente Bisneto
 * @version 1.0.0
 */

public class TelefoneDAO implements GenericDAO<Telefone> {

    public int insert(Telefone telefone){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try{

            String insert = "insert into telefone(telefone, tipo, id_usuario, principal) values(?, ?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(insert);

            preparedStatement.setString(1, telefone.getTelefone() );
            preparedStatement.setString(2, telefone.getTipo());
            preparedStatement.setLong(3, telefone.getIdUsuario());
            preparedStatement.setBoolean(4, telefone.isPrincipal() );

            return preparedStatement.executeUpdate();

        } catch (SQLException sqlException){

            String codigoSQLException = sqlException.getSQLState();

            //Verificação se a exceção foi causada por um dado inválido.
            //A verificação ocorre usando o código das exceções relacionadas a esse fator.
            if ("23502".equals(codigoSQLException) ||
                    "23503".equals(codigoSQLException) ||
                    "23505".equals(codigoSQLException) ||
                    "23514".equals(codigoSQLException) ){

                return -1;
            }

            return -2;

        } catch (Exception exception){

            return -3;

        } finally {

            conexao.desconectar();

        }

    }

    public Telefone readById(long id){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try {

            String readById = "select * from telefone where id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(readById);

            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){

                return new Telefone(
                        resultSet.getLong("id"),
                        resultSet.getString("telefone"),
                        resultSet.getString("tipo"),
                        resultSet.getLong("id_usuario"),
                        resultSet.getBoolean("principal")
                );

            }

            return null;

        } catch (Exception exception){

            return null;

        } finally {

            conexao.desconectar();

        }

    }

    /**
     * Variação do método {@link #readById(long)}. A diferença é que o parametro de busca é um email.
     *
     * @param telefone número do {@link Telefone} que se está buscando.
     * @return O Telefone com todos os seus dados.
     */
    public Telefone readByTelefone(String telefone){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try {

            String readById = "select * from telefone where telefone = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(readById);

            preparedStatement.setString(1, telefone);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){

                return new Telefone(
                        resultSet.getLong("id"),
                        resultSet.getString("telefone"),
                        resultSet.getString("tipo"),
                        resultSet.getLong("id_usuario"),
                        resultSet.getBoolean("principal")
                );

            }

            return null;

        } catch (Exception exception){

            return null;

        } finally {

            conexao.desconectar();

        }

    }

    public List<Telefone> readAll(){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();
        List<Telefone> telefones = new ArrayList<>();

        try {

            String readAll = "select * from telefone";

            PreparedStatement preparedStatement = connection.prepareStatement(readAll);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){

                telefones.add(new Telefone(
                        resultSet.getLong("id"),
                        resultSet.getString("telefone"),
                        resultSet.getString("tipo"),
                        resultSet.getLong("id_usuario"),
                        resultSet.getBoolean("principal")
                ));

            }

            return telefones;

        } catch (Exception exception){

            return null;

        } finally {

            conexao.desconectar();

        }

    }

    /**
     * Variação do método {@link #readAll()}. A diferença é que o idUsuario é usado como parametro de busca.
     * @param idUsuario ID de quem possuí o telefone buscado.
     * @return Uma lista com todos os registro da tabela que possuem o mesmo idUsuario que o parametro.
     */
    public List<Telefone> readAllByIdUsuario(long idUsuario){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();
        List<Telefone> telefones = new ArrayList<>();

        try {

            String readAll = "select * from telefone where id_usuario = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(readAll);

            preparedStatement.setLong(1, idUsuario);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){

                telefones.add(new Telefone(
                        resultSet.getLong("id"),
                        resultSet.getString("telefone"),
                        resultSet.getString("tipo"),
                        resultSet.getLong("id_usuario"),
                        resultSet.getBoolean("principal")
                ));

            }

            return telefones;

        } catch (Exception exception){

            return null;

        } finally {

            conexao.desconectar();

        }

    }

    public int update(Telefone telefone){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try{

            String update = "update telefone set telefone = ?, tipo = ?, principal = ? where id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(update);

            preparedStatement.setString(1, telefone.getTelefone() );
            preparedStatement.setString(2, telefone.getTipo() );
            preparedStatement.setBoolean(3, telefone.isPrincipal() );
            preparedStatement.setLong(4, telefone.getId());

            return preparedStatement.executeUpdate();

        } catch (SQLException sqlException){

            String codigoSQLException = sqlException.getSQLState();

            //Verificação se a exceção foi causada por um dado inválido.
            //A verificação ocorre usando o código das exceções relacionadas a esse fator.
            if ("23502".equals(codigoSQLException) ||
                    "23503".equals(codigoSQLException) ||
                    "23505".equals(codigoSQLException) ||
                    "23514".equals(codigoSQLException) ){

                return -1;
            }

            return -2;

        } catch (Exception exception){

            return -3;

        } finally {

            conexao.desconectar();

        }

    }

    public int deleteById(long id){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try{

            String delete = "delete from telefone where id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(delete);

            preparedStatement.setLong(1, id);

            return preparedStatement.executeUpdate();

        } catch (SQLException sqlException) {

            String codigoSQLException = sqlException.getSQLState();

            //Verificação se a exceção foi causada por uma foreign key existente.
            //A verificação ocorre usando o código da exceção relacionada a esse fator.
            if ("23503".equals(codigoSQLException)){

                return -1;
            }

            return -2;

        }catch (Exception exception){

            return -3;

        } finally {

            conexao.desconectar();

        }

    }

    /**
     * Variação do método {@link #deleteById(long)}. A diferença é que o número de telefone é usado como clausula de apagamento.
     * @param telefone Número do {@link Telefone}.
     * @return Mesmo padrão de retorno que o {@link #deleteById(long)}.
     */
    public int deleteByTelefone(String telefone){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try{

            String delete = "delete from telefone where telefone = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(delete);

            preparedStatement.setString(1, telefone);

            return preparedStatement.executeUpdate();

        } catch (SQLException sqlException) {

            String codigoSQLException = sqlException.getSQLState();

            //Verificação se a exceção foi causada por uma foreign key existente.
            //A verificação ocorre usando o código da exceção relacionada a esse fator.
            if ("23503".equals(codigoSQLException)){

                return -1;
            }

            return -2;

        }catch (Exception exception){

            return -3;

        } finally {

            conexao.desconectar();

        }

    }

}