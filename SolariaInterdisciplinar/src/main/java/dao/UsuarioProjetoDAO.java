package dao;

import conexao.Conexao;

import model.UsuarioProjeto;

import java.sql.Connection;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.util.List;

import java.util.ArrayList;

/**
 * Classe responsável pelo DAO da entidade UsuarioProjeto
 *
 * @author Eduardo Vicente Bisneto
 * @version 1.0.0
 */
public class UsuarioProjetoDAO implements GenericDAO<UsuarioProjeto> {

    public int insert(UsuarioProjeto usuarioProjeto){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try{

            String insert = "insert into usuarioProjeto(id_projeto, id_usuario, dono_do_projeto) values(?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(insert);

            preparedStatement.setLong(1, usuarioProjeto.getIdProjeto() );
            preparedStatement.setLong(2, usuarioProjeto.getIdUsuario());
            preparedStatement.setBoolean(3, usuarioProjeto.isDonoDoProjeto());

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

    public UsuarioProjeto readById(long id){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try {

            String readById = "select * from usuarioProjeto where id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(readById);

            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){

                return new UsuarioProjeto(
                        resultSet.getLong("id"),
                        resultSet.getLong("id_projeto"),
                        resultSet.getLong("id_usuario"),
                        resultSet.getBoolean("dono_do_projeto")
                );

            }

            return null;

        } catch (Exception exception){

            return null;

        } finally {

            conexao.desconectar();

        }

    }

    public List<UsuarioProjeto> readAll(){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();
        List<UsuarioProjeto> usuarioProjetos = new ArrayList<>();

        try {

            String readAll = "select * from usuarioProjeto";

            PreparedStatement preparedStatement = connection.prepareStatement(readAll);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){

                usuarioProjetos.add(new UsuarioProjeto(
                        resultSet.getLong("id"),
                        resultSet.getLong("id_projeto"),
                        resultSet.getLong("id_usuario"),
                        resultSet.getBoolean("dono_do_projeto")
                ));

            }

            return usuarioProjetos;

        } catch (Exception exception){

            return null;

        } finally {

            conexao.desconectar();

        }

    }

    public List<UsuarioProjeto> readAllByIdProjeto(long idProjeto){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();
        List<UsuarioProjeto> usuarioProjetos = new ArrayList<>();

        try {

            String readAll = "select * from usuarioProjeto where id_projeto = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(readAll);

            preparedStatement.setLong(1, idProjeto);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){

                usuarioProjetos.add(new UsuarioProjeto(
                        resultSet.getLong("id"),
                        resultSet.getLong("id_projeto"),
                        resultSet.getLong("id_usuario"),
                        resultSet.getBoolean("dono_do_projeto")
                ));

            }

            return usuarioProjetos;

        } catch (Exception exception){

            return null;

        } finally {

            conexao.desconectar();

        }

    }

    public List<UsuarioProjeto> readAllByIdUsuario(long idUsuario){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();
        List<UsuarioProjeto> usuarioProjetos = new ArrayList<>();

        try {

            String readAll = "select * from usuarioProjeto where id_usuario = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(readAll);

            preparedStatement.setLong(1, idUsuario);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){

                usuarioProjetos.add(new UsuarioProjeto(
                        resultSet.getLong("id"),
                        resultSet.getLong("id_projeto"),
                        resultSet.getLong("id_usuario"),
                        resultSet.getBoolean("dono_do_projeto")
                ));

            }

            return usuarioProjetos;

        } catch (Exception exception){

            return null;

        } finally {

            conexao.desconectar();

        }

    }

    public int update(UsuarioProjeto usuarioProjeto){

        return 0;

    }

    public int deleteById(long id){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try{

            String delete = "delete from usuarioProjeto where id = ?";

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