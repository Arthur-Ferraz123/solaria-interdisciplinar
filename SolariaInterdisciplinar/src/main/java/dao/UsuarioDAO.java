package dao;

import java.sql.*;
import java.util.List;

import conexao.Conexao;

import model.Usuario;

import java.util.ArrayList;

public class UsuarioDAO implements GenericDAO<Usuario> {

    public int insert(Usuario usuario){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try{



        String insert = "insert into usuario(email, senha, nome, tipo_usuario) values(?, ?, ?, ?)";

        PreparedStatement preparedStatement = connection.prepareStatement(insert);

        preparedStatement.setString(1, usuario.getEmail() );
        preparedStatement.setString(2, usuario.getSenha());
        preparedStatement.setString(3, usuario.getNome());
        preparedStatement.setString(4, usuario.getTipoUsuario() );

        return preparedStatement.executeUpdate();

        } catch (SQLException sqlException){

            sqlException.printStackTrace();
            String codigoSQLException = sqlException.getSQLState();

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

    public Usuario readById(long id){

        Conexao conexao = new Conexao();

        Connection connection = conexao.conectar();

        try {

            String readById = "select * from usuario where id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(readById);

            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){

                return new Usuario(
                        resultSet.getLong("id"),
                        resultSet.getString("email"),
                        resultSet.getString("senha"),
                        resultSet.getString("nome"),
                        resultSet.getString("tipo_usuario")
                );

            }

            return null;


        } catch (Exception exception){

            return null;


        } finally {

            conexao.desconectar();

        }

    }

    public List<Usuario> readAll(){

        Conexao conexao = new Conexao();

        Connection connection = conexao.conectar();

        List<Usuario> usuarios = new ArrayList<>();

        try {

            String readById = "select * from usuario";

            PreparedStatement preparedStatement = connection.prepareStatement(readById);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){



                 usuarios.add(new Usuario(
                        resultSet.getLong("id"),
                        resultSet.getString("email"),
                        resultSet.getString("senha"),
                        resultSet.getString("nome"),
                        resultSet.getString("tipo_usuario")
                ));

            }

            return usuarios;


        } catch (Exception exception){

            return null;


        } finally {

            conexao.desconectar();

        }

    }

    public int update(Usuario usuario){
        return 0;
    }

    public int delete(int id){

        return 0;
    }



}
