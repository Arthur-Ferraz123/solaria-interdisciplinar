package dao;

import conexao.Conexao;

import model.SessaoChat;

import java.sql.Connection;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.sql.Date;

import java.time.LocalDate;

import java.util.List;

import java.util.ArrayList;

/**
 * Classe responsável pelo DAO da entidade sessao_chat
 *
 * @author Eduardo Vicente Bisneto
 * @version 1.0.0
 */
public class SessaoChatDAO implements GenericDAO<SessaoChat> {

    @Override
    public int insert(SessaoChat sessaoChat){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try{

            String insert = "insert into sessaoChat(id_chat, status_sessao, data_fim) values(?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(insert);

            preparedStatement.setLong(1, sessaoChat.getIdChat() );
            preparedStatement.setBoolean(2, sessaoChat.isStatusSessao());
            preparedStatement.setDate(3, Date.valueOf(sessaoChat.getDataFim()));


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
    public SessaoChat readById(long id){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try {

            String readById = "select * from sessaoChat where id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(readById);

            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){

                return new SessaoChat(
                        resultSet.getLong("id"),
                        resultSet.getLong("id_chat"),
                        resultSet.getObject("data_inicio", LocalDate.class),
                        resultSet.getBoolean("status_sessao"),
                        resultSet.getObject("data_fim", LocalDate.class)
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
     * Variação do {@link #readById(long)}. A diferença é que o atributo idChat é usado como parametro de busca ao invés do atributo id.
     *
     * @param idChat Atributo idChat de uma {@link model.SessaoChat}.
     * @return Todos os dados registrados da SessaoChat buscado.
     */
    public SessaoChat readByIdChat(long idChat){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try {

            String readById = "select * from sessaoChat where id_chat = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(readById);

            preparedStatement.setLong(1, idChat);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){

                return new SessaoChat(
                        resultSet.getLong("id"),
                        resultSet.getLong("id_chat"),
                        resultSet.getObject("data_inicio", LocalDate.class),
                        resultSet.getBoolean("status_sessao"),
                        resultSet.getObject("data_fim", LocalDate.class)
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
    public List<SessaoChat> readAll(){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();
        List<SessaoChat> sessaoChats = new ArrayList<>();

        try {

            String readAll = "select * from sessaoChat";

            PreparedStatement preparedStatement = connection.prepareStatement(readAll);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){

                sessaoChats.add(new SessaoChat(
                        resultSet.getLong("id"),
                        resultSet.getLong("id_chat"),
                        resultSet.getObject("data_inicio", LocalDate.class),
                        resultSet.getBoolean("status_sessao"),
                        resultSet.getObject("data_fim", LocalDate.class)
                ));

            }

            return sessaoChats;

        } catch (Exception exception){

            return null;

        } finally {

            conexao.desconectar();

        }

    }

    @Override
    public int update(SessaoChat sessaoChat){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try{

            String update = "update sessaoChat set status_sessao = ?, data_fim = ? where id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(update);

            preparedStatement.setBoolean(1, sessaoChat.isStatusSessao() );
            preparedStatement.setDate(2, Date.valueOf(sessaoChat.getDataFim()));
            preparedStatement.setLong(3, sessaoChat.getId());

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

            String delete = "delete from sessaoChat where id = ?";

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

    /**
     * Variação do {@link #deleteById(long)}. A diferença é que o atributo idChat é utilizado como parametro de apagamento.
     *
     * @param idChat Atributo idChat de uma {@link model.SessaoChat}.
     * @return A quantidade de registros pagados.
     */
    public int deleteByIdChat(long idChat){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try{

            String delete = "delete from sessaoChat where id_chat = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(delete);

            preparedStatement.setLong(1, idChat);

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