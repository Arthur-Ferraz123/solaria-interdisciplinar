package dao;

import conexao.Conexao;

import model.Assinatura;

import java.sql.Connection;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.sql.Date;

import java.time.LocalDate;
import java.util.List;

import java.util.ArrayList;

/**
 * Classe responsável pelo DAO da entidade Assinatura
 *
 * @author Eduardo Vicente Bisneto
 * @version 1.0.0
 */
public class AssinaturaDAO implements GenericDAO<Assinatura> {

    public int insert(Assinatura assinatura){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try{

            String insert = "insert into assinatura(id_usuario, id_plano, status_assinatura, renovacao_automatica, data_inicio, validade) values(?, ?, ?, ?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(insert);

            preparedStatement.setLong(1, assinatura.getIdUsuario() );
            preparedStatement.setLong(2, assinatura.getIdUsuario());
            preparedStatement.setString(3, assinatura.getStatusAssinatura());
            preparedStatement.setBoolean(4, assinatura.isRenovacaoAutomatica() );
            preparedStatement.setDate(5, Date.valueOf(assinatura.getDataInicio() ) );
            preparedStatement.setDate(6, Date.valueOf(assinatura.getValidade() ) );

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

    public Assinatura readById(long id){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try {

            String readById = "select * from assinatura where id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(readById);

            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){

                return new Assinatura(
                        resultSet.getLong("id"),
                        resultSet.getLong("id_usuario"),
                        resultSet.getLong("id_plano"),
                        resultSet.getString("status_assinatura"),
                        resultSet.getBoolean("renovacao_automatica"),
                        resultSet.getObject("data_inicio", LocalDate.class),
                        resultSet.getObject("validade", LocalDate.class)
                );

            }

            return null;

        } catch (Exception exception){

            return null;

        } finally {

            conexao.desconectar();

        }

    }

    public Assinatura readByIdUsuario(long idUsuario){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try {

            String readById = "select * from assinatura where id_usuario = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(readById);

            preparedStatement.setLong(1, idUsuario);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){

                return new Assinatura(
                        resultSet.getLong("id"),
                        resultSet.getLong("id_usuario"),
                        resultSet.getLong("id_plano"),
                        resultSet.getString("status_assinatura"),
                        resultSet.getBoolean("renovacao_automatica"),
                        resultSet.getObject("data_inicio", LocalDate.class),
                        resultSet.getObject("validade", LocalDate.class)
                );

            }

            return null;

        } catch (Exception exception){

            return null;

        } finally {

            conexao.desconectar();

        }

    }

    public List<Assinatura> readAll(){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();
        List<Assinatura> assinaturas = new ArrayList<>();

        try {

            String readAll = "select * from assinatura";

            PreparedStatement preparedStatement = connection.prepareStatement(readAll);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){

                assinaturas.add(new Assinatura(
                        resultSet.getLong("id"),
                        resultSet.getLong("id_usuario"),
                        resultSet.getLong("id_plano"),
                        resultSet.getString("status_assinatura"),
                        resultSet.getBoolean("renovacao_automatica"),
                        resultSet.getObject("data_inicio", LocalDate.class),
                        resultSet.getObject("validade", LocalDate.class)
                ));

            }

            return assinaturas;

        } catch (Exception exception){

            return null;

        } finally {

            conexao.desconectar();

        }

    }

    public List<Assinatura> readAllByIdPlano(long idPlano){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();
        List<Assinatura> assinaturas = new ArrayList<>();

        try {

            String readAll = "select * from assinatura where id_plano = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(readAll);

            preparedStatement.setLong(1, idPlano);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){

                assinaturas.add(new Assinatura(
                        resultSet.getLong("id"),
                        resultSet.getLong("id_usuario"),
                        resultSet.getLong("id_plano"),
                        resultSet.getString("status_assinatura"),
                        resultSet.getBoolean("renovacao_automatica"),
                        resultSet.getObject("data_inicio", LocalDate.class),
                        resultSet.getObject("validade", LocalDate.class)
                ));

            }

            return assinaturas;

        } catch (Exception exception){

            return null;

        } finally {

            conexao.desconectar();

        }

    }

    public int update(Assinatura assinatura){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try{

            String update = "update assinatura set id_plano = ?, status_assinatura = ?, renovacao_automatica = ?, data_inicio = ?, validade = ? where id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(update);

            preparedStatement.setLong(1, assinatura.getIdPlano() );
            preparedStatement.setString(2, assinatura.getStatusAssinatura() );
            preparedStatement.setBoolean(3, assinatura.isRenovacaoAutomatica() );
            preparedStatement.setDate(4, Date.valueOf(assinatura.getDataInicio() ) );
            preparedStatement.setDate(5, Date.valueOf(assinatura.getValidade() ) );
            preparedStatement.setLong(6, assinatura.getId());

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

            String delete = "delete from assinatura where id = ?";

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