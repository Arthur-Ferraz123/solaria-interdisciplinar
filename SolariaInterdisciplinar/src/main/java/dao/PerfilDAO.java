package dao;

import conexao.Conexao;

import model.Perfil;
import model.Usuario;

import java.sql.Connection;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.util.List;

import java.util.ArrayList;

/**
 * Classe responsável pelo DAO da entidade Perfil
 *
 * @author Eduardo Vicente Bisneto
 * @version 1.0.0
 */
public class PerfilDAO implements GenericDAO<Perfil> {

    public int insert(Perfil perfil){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try{

            String insert = "insert into perfil(id_usuario, descricao, foto_perfil) values(?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(insert);

            preparedStatement.setLong(1, perfil.getIdUsuario() );
            preparedStatement.setString(2, perfil.getDescricao());
            preparedStatement.setString(3, perfil.getFotoPerfil());

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

    public Perfil readById(long id){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try {

            String readById = "select * from perfil where id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(readById);

            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){

                return new Perfil(
                        resultSet.getLong("id"),
                        resultSet.getLong("id_usuario"),
                        resultSet.getString("descricao"),
                        resultSet.getString("foto_perfil")
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
     * Variação do método {@link #readById(long)}. A diferença é que o parametro de busca é o idUsuario.
     *
     * @param idUsuario idUsuario do {@link Usuario} que possuí o perfil buscado.
     * @return O usuário e todos os seus dados.
     */
    public Perfil readByIdUsuario(long idUsuario){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try {

            String readById = "select * from perfil where id_usuario = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(readById);

            preparedStatement.setLong(1, idUsuario);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){

                return new Perfil(
                        resultSet.getLong("id"),
                        resultSet.getLong("id_usuario"),
                        resultSet.getString("descricao"),
                        resultSet.getString("foto_perfil")
                );

            }

            return null;

        } catch (Exception exception){

            return null;

        } finally {

            conexao.desconectar();

        }

    }

    public List<Perfil> readAll(){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();
        List<Perfil> perfils = new ArrayList<>();

        try {

            String readAll = "select * from perfil";

            PreparedStatement preparedStatement = connection.prepareStatement(readAll);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){

                perfils.add(new Perfil(
                        resultSet.getLong("id"),
                        resultSet.getLong("id_usuario"),
                        resultSet.getString("descricao"),
                        resultSet.getString("foto_perfil")
                ));

            }

            return perfils;

        } catch (Exception exception){

            return null;

        } finally {

            conexao.desconectar();

        }

    }

    public int update(Perfil perfil){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try{

            String update = "update perfil set descricao = ?, foto_perfil = ? where id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(update);

            preparedStatement.setString(1, perfil.getDescricao() );
            preparedStatement.setString(2, perfil.getFotoPerfil() );
            preparedStatement.setLong(3, perfil.getId());

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

            String delete = "delete from perfil where id = ?";

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
     * Variação do método {@link #deleteById(long)}. A diferença é que o idUsuario é usado como clausula de apagamento.
     * @param idUsuario O identificador único (PK) do {@link Usuario} que possuí o perfil.
     * @return Mesmo padrão de retorno que o {@link #deleteById(long)}.
     */
    public int deleteByIdUsuario(long idUsuario){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try{

            String delete = "delete from perfil where id_usuario = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(delete);

            preparedStatement.setLong(1, idUsuario);

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