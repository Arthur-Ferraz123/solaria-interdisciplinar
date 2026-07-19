package dao;

import conexao.Conexao;

import model.Mensagem;

import java.sql.Connection;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import java.util.ArrayList;

/**
 * Classe responsável pelo DAO da entidade mensagem
 *
 * @author Eduardo Vicente Bisneto
 * @version 1.0.0
 */
public class MensagemDAO implements GenericDAO<Mensagem> {

    @Override
    public int insert(Mensagem mensagem){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try{

            String insert = "insert into mensagem(id_chat, mensagem, remetente) values(?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(insert);

            preparedStatement.setLong(1, mensagem.getId() );
            preparedStatement.setString(2, mensagem.getMensagem());
            preparedStatement.setString(3, mensagem.getRemetente());

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
    public Mensagem readById(long id){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try {

            String readById = "select * from mensagem where id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(readById);

            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){

                return new Mensagem(
                        resultSet.getLong("id"),
                        resultSet.getLong("id_chat"),
                        resultSet.getString("mensagem"),
                        resultSet.getObject("data_envio", LocalDate.class),
                        resultSet.getObject("horario_envio", LocalTime.class),
                        resultSet.getString("remetente")
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
    public List<Mensagem> readAll(){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();
        List<Mensagem> mensagens = new ArrayList<>();

        try {

            String readAll = "select * from mensagem";

            PreparedStatement preparedStatement = connection.prepareStatement(readAll);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){

                mensagens.add(new Mensagem(
                        resultSet.getLong("id"),
                        resultSet.getLong("id_chat"),
                        resultSet.getString("mensagem"),
                        resultSet.getObject("data_envio", LocalDate.class),
                        resultSet.getObject("horario_envio", LocalTime.class),
                        resultSet.getString("remetente")
                ));

            }

            return mensagens;

        } catch (Exception exception){

            return null;

        } finally {

            conexao.desconectar();

        }

    }

    /**
     * Variação do {@link #readAll}. A diferença é que o atributo idChat é utilizado como parametro de filtragem.
     *
     * @param idChat Valor do atributo idChat das {@link model.Mensagem} que se buscam.
     * @return Todos os dados registrados de todas as Mensagem encontradas.
     */
    public List<Mensagem> readAllByIdChat(long idChat){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();
        List<Mensagem> mensagens = new ArrayList<>();

        try {

            String readAll = "select * from mensagem where id_chat = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(readAll);

            preparedStatement.setLong(1, idChat);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){

                mensagens.add(new Mensagem(
                        resultSet.getLong("id"),
                        resultSet.getLong("id_chat"),
                        resultSet.getString("mensagem"),
                        resultSet.getObject("data_envio", LocalDate.class),
                        resultSet.getObject("horario_envio", LocalTime.class),
                        resultSet.getString("remetente")
                ));

            }

            return mensagens;

        } catch (Exception exception){

            return null;

        } finally {

            conexao.desconectar();

        }

    }

    @Override
    public int update(Mensagem mensagem){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try{

            String update = "update mensagem set mensagem = ? where id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(update);

            preparedStatement.setString(1, mensagem.getMensagem() );
            preparedStatement.setLong(2, mensagem.getId());

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

            String delete = "delete from mensagem where id = ?";

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