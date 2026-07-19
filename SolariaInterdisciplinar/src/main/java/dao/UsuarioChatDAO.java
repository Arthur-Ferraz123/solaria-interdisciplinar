package dao;

import conexao.Conexao;

import model.UsuarioChat;

import java.sql.Connection;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.util.List;

import java.util.ArrayList;

/**
 * Classe responsável pelo DAO da entidade usuario_chat
 *
 * @author Eduardo Vicente Bisneto
 * @version 1.0.0
 */
public class UsuarioChatDAO implements GenericDAO<UsuarioChat> {

    @Override
    public int insert(UsuarioChat usuarioChat){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try{

            String insert = "insert into usuario_chat(id_usuario, id_chat) values(?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(insert);

            preparedStatement.setLong(1, usuarioChat.getIdUsuario() );
            preparedStatement.setLong(2, usuarioChat.getIdChat());

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
    public UsuarioChat readById(long id){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try {

            String readById = "select * from usuario_chat where id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(readById);

            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){

                return new UsuarioChat(
                        resultSet.getLong("id"),
                        resultSet.getLong("id_usuario"),
                        resultSet.getLong("id_chat")
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
    public List<UsuarioChat> readAll(){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();
        List<UsuarioChat> usuarioChats = new ArrayList<>();

        try {

            String readAll = "select * from usuario_chat";

            PreparedStatement preparedStatement = connection.prepareStatement(readAll);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){

                usuarioChats.add(new UsuarioChat(
                        resultSet.getLong("id"),
                        resultSet.getLong("id_usuario"),
                        resultSet.getLong("id_chat")
                ));

            }

            return usuarioChats;

        } catch (Exception exception){

            return null;

        } finally {

            conexao.desconectar();

        }

    }

    /**
     * Variação do {@link #readAll}. A diferença é que o atributo idUsuario é utilizado como parametro de filtragem.
     *
     * @param idUsuario Valor do atributo idUsuario dos {@link model.UsuarioChat} que se buscam.
     * @return Todos os dados registrados de todos os UsuarioChat encontrados.
     */
    public List<UsuarioChat> readAllByIdUsuario(long idUsuario){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();
        List<UsuarioChat> usuarioChats = new ArrayList<>();

        try {

            String readAll = "select * from usuario_chat where id_usuario = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(readAll);

            preparedStatement.setLong(1, idUsuario);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){

                usuarioChats.add(new UsuarioChat(
                        resultSet.getLong("id"),
                        resultSet.getLong("id_usuario"),
                        resultSet.getLong("id_chat")
                ));

            }

            return usuarioChats;

        } catch (Exception exception){

            return null;

        } finally {

            conexao.desconectar();

        }

    }

    /**
     * Variação do {@link #readAll}. A diferença é que o atributo idChat é utilizado como parametro de filtragem.
     *
     * @param idChat Valor do atributo idChat dos {@link model.UsuarioChat} que se buscam.
     * @return Todos os dados registrados de todos os UsuarioChat encontrados.
     */
    public List<UsuarioChat> readAllByIdChat(long idChat){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();
        List<UsuarioChat> usuarioChats = new ArrayList<>();

        try {

            String readAll = "select * from usuario_chat where id_chat = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(readAll);

            preparedStatement.setLong(1, idChat);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){

                usuarioChats.add(new UsuarioChat(
                        resultSet.getLong("id"),
                        resultSet.getLong("id_usuario"),
                        resultSet.getLong("id_chat")
                ));

            }

            return usuarioChats;

        } catch (Exception exception){

            return null;

        } finally {

            conexao.desconectar();

        }

    }

    @Override
    public int update(UsuarioChat usuarioChat){

        //Essa entidade não suporta um método para o update.
        //Porque os seus atributos são imutáveis.
        return 0;

    }

    @Override
    public int deleteById(long id){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try{

            String delete = "delete from usuario_chat where id = ?";

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