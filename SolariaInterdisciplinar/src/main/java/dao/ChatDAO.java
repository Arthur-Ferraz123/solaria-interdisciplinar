package dao;

import conexao.Conexao;

import model.Chat;

import java.sql.Connection;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.util.List;

import java.util.ArrayList;

/**
 * Classe responsável pelo DAO da entidade chat
 *
 * @author Eduardo Vicente Bisneto
 * @version 1.0.0
 */
public class ChatDAO implements GenericDAO<Chat> {

    @Override
    public int insert(Chat chat){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try{

            String insert = "insert into chat(nome) values(?)";

            PreparedStatement preparedStatement = connection.prepareStatement(insert);

            preparedStatement.setString(1, chat.getNome());

            return preparedStatement.executeUpdate();

        } catch (SQLException sqlException){

            String codigoSQLException = sqlException.getSQLState();

            //Verificação se a exceção foi causada por um dado inválido.
            //A verificação ocorre usando o código das exceções relacionadas a esse fator.
            if ("23502".equals(codigoSQLException) ||
                "23503".equals(codigoSQLException) ||
                "23505".equals(codigoSQLException) ||
                "23514".equals(codigoSQLException) ){

                return ERRO_POR_CONSTRAINT_DE_DADOS_NO_BD;
            }

            return ERRO_NO_BD;

        }catch (Exception exception){

            return ERRO_GENERICO;

        } finally {

            conexao.desconectar();

        }

    }

    @Override
    public Chat readById(long id){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try {

            String readById = "select * from chat where id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(readById);

            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){

                return new Chat(
                        resultSet.getLong("id"),
                        resultSet.getString("nome")
                );

            }

            return null;

        } catch (Exception exception){

            return null;

        } finally {

            conexao.desconectar();

        }

    }

    @Override
    public List<Chat> readAll(){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();
        List<Chat> chats = new ArrayList<>();

        try {

            String readAll = "select * from chat";

            PreparedStatement preparedStatement = connection.prepareStatement(readAll);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){

                chats.add(new Chat(
                        resultSet.getLong("id"),
                        resultSet.getString("nome")
                ));

            }

            return chats;

        } catch (Exception exception){

            return null;

        } finally {

            conexao.desconectar();

        }

    }

    @Override
    public int update(Chat chat){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try{

            String update = "update chat set nome = ? where id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(update);

            preparedStatement.setString(1, chat.getNome() );
            preparedStatement.setLong(2, chat.getId());

            return preparedStatement.executeUpdate();

        } catch (SQLException sqlException){

            String codigoSQLException = sqlException.getSQLState();

            //Verificação se a exceção foi causada por um dado inválido.
            //A verificação ocorre usando o código das exceções relacionadas a esse fator.
            if ("23502".equals(codigoSQLException) ||
                "23503".equals(codigoSQLException) ||
                "23505".equals(codigoSQLException) ||
                "23514".equals(codigoSQLException) ){

                return ERRO_POR_CONSTRAINT_DE_DADOS_NO_BD;
            }

            return ERRO_NO_BD;

        }catch (Exception exception){

            return ERRO_GENERICO;

        } finally {

            conexao.desconectar();

        }

    }

    @Override
    public int deleteById(long id){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try{

            String delete = "delete from chat where id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(delete);

            preparedStatement.setLong(1, id);

            return preparedStatement.executeUpdate();

        } catch (SQLException sqlException) {

            String codigoSQLException = sqlException.getSQLState();

            //Verificação se a exceção foi causada por uma foreign key existente.
            //A verificação ocorre usando o código da exceção relacionada a esse fator.
            if ("23503".equals(codigoSQLException)){

                return ERRO_POR_CONSTRAINT_DE_DADOS_NO_BD;
            }

            return ERRO_NO_BD;

        }catch (Exception exception){

            return ERRO_GENERICO;

        } finally {

            conexao.desconectar();

        }

    }

}
