package dao;

import conexao.Conexao;

import model.Midia;

import java.sql.Connection;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.util.List;

import java.util.ArrayList;

/**
 * Classe responsável pelo DAO da entidade Usuário
 *
 * @author Eduardo Vicente Bisneto
 * @version 1.0.0
 */
public class MidiaDAO implements GenericDAO<Midia> {

    public int insert(Midia midia){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try{

            String insert = "insert into midia(id_postagem, id_mensagem, midia, tipo_midia) values(?, ?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(insert);

            preparedStatement.setLong(1, midia.getIdPostagem() );
            preparedStatement.setLong(2, midia.getIdMensagem());
            preparedStatement.setString(3, midia.getMidia());
            preparedStatement.setString(4, midia.getTipoMidia() );

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

    public Midia readById(long id){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try {

            String readById = "select * from midia where id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(readById);

            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){

                return new Midia(
                        resultSet.getLong("id"),
                        resultSet.getLong("id_postagem"),
                        resultSet.getLong("id_mensagem"),
                        resultSet.getString("midia"),
                        resultSet.getString("tipo_midia")
                );

            }

            return null;

        } catch (Exception exception){

            return null;

        } finally {

            conexao.desconectar();

        }

    }

    public List<Midia> readAll(){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();
        List<Midia> midias = new ArrayList<>();

        try {

            String readAll = "select * from midia";

            PreparedStatement preparedStatement = connection.prepareStatement(readAll);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){

                midias.add(new Midia(
                        resultSet.getLong("id"),
                        resultSet.getLong("id_postagem"),
                        resultSet.getLong("id_mensagem"),
                        resultSet.getString("midia"),
                        resultSet.getString("tipo_midia")
                ));

            }

            return midias;

        } catch (Exception exception){

            return null;

        } finally {

            conexao.desconectar();

        }

    }

    public List<Midia> readAllByIdPostagem(long idPostagem){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();
        List<Midia> midias = new ArrayList<>();

        try {

            String readAll = "select * from midia where id_postagem = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(readAll);

            preparedStatement.setLong(1, idPostagem);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){

                midias.add(new Midia(
                        resultSet.getLong("id"),
                        resultSet.getLong("id_postagem"),
                        resultSet.getLong("id_mensagem"),
                        resultSet.getString("midia"),
                        resultSet.getString("tipo_midia")
                ));

            }

            return midias;

        } catch (Exception exception){

            return null;

        } finally {

            conexao.desconectar();

        }

    }

    public List<Midia> readAllByIdMensagem(long idMensagem){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();
        List<Midia> midias = new ArrayList<>();

        try {

            String readAll = "select * from midia where id_mensagem = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(readAll);

            preparedStatement.setLong(1, idMensagem);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){

                midias.add(new Midia(
                        resultSet.getLong("id"),
                        resultSet.getLong("id_postagem"),
                        resultSet.getLong("id_mensagem"),
                        resultSet.getString("midia"),
                        resultSet.getString("tipo_midia")
                ));

            }

            return midias;

        } catch (Exception exception){

            return null;

        } finally {

            conexao.desconectar();

        }

    }

    public int update(Midia midia){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try{

            String update = "update midia set midia = ?, tipo_midia = ? where id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(update);

            preparedStatement.setString(1, midia.getMidia() );
            preparedStatement.setString(2, midia.getTipoMidia() );
            preparedStatement.setLong(3, midia.getId());

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

            String delete = "delete from midia where id = ?";

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

}
