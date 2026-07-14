package dao;

import conexao.Conexao;

import model.PlacaSolarCertificacao;
import model.Usuario;

import java.sql.Connection;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.util.List;

import java.util.ArrayList;

/**
 * Classe responsável pelo DAO da entidade PlacaSolarCertificacao
 *
 * @author Eduardo Vicente Bisneto
 * @version 1.0.0
 */
public class PlacaSolarCertificacaoDAO implements GenericDAO<PlacaSolarCertificacao> {

    public int insert(PlacaSolarCertificacao placaSolarCertificacao){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try{

            String insert = "insert into placa_solar_certificacao(id_placa_solar, seid_certificacaonha) values(?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(insert);

            preparedStatement.setLong(1, placaSolarCertificacao.getIdPlacaSolar() );
            preparedStatement.setLong(2, placaSolarCertificacao.getIdCertificacao());


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

    public PlacaSolarCertificacao readById(long id){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try {

            String readById = "select * from placa_solar_certificacao where id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(readById);

            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){

                return new PlacaSolarCertificacao(
                        resultSet.getLong("id"),
                        resultSet.getLong("id_placa_solar"),
                        resultSet.getLong("id_certificacao")
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
     * Variação do método {@link #readById(long)}. A diferença é que o parametro de busca é o idPlacaSolar.
     *
     * @param idPlacaSolar idPlacaSolar da {@link PlacaSolarCertificacao} buscada.
     * @return O PlacaSolarCertificacao com todos os seus dados.
     */
    public PlacaSolarCertificacao readByIdPlacaSolar(long idPlacaSolar){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try {

            String readById = "select * from placa_solar_certificacao where id_placa_solar = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(readById);

            preparedStatement.setLong(1, idPlacaSolar);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){

                return new PlacaSolarCertificacao(
                        resultSet.getLong("id"),
                        resultSet.getLong("id_placa_solar"),
                        resultSet.getLong("id_certificacao")
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
     * Variação do método {@link #readById(long)}. A diferença é que o parametro de busca é o idPlacaSolar.
     *
     * @param idCertificacao idCertificacao da {@link PlacaSolarCertificacao} buscada.
     * @return O PlacaSolarCertificacao com todos os seus dados.
     */
    public PlacaSolarCertificacao readByIdCertificacao(long idCertificacao){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try {

            String readById = "select * from placa_solar_certificacao where id_certificacao = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(readById);

            preparedStatement.setLong(1, idCertificacao);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){

                return new PlacaSolarCertificacao(
                        resultSet.getLong("id"),
                        resultSet.getLong("id_placa_solar"),
                        resultSet.getLong("id_certificacao")
                );

            }

            return null;

        } catch (Exception exception){

            return null;

        } finally {

            conexao.desconectar();

        }

    }

    public List<PlacaSolarCertificacao> readAll(){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();
        List<PlacaSolarCertificacao> placaSolarCertificacoes = new ArrayList<>();

        try {

            String readAll = "select * from placa_solar_certificacao";

            PreparedStatement preparedStatement = connection.prepareStatement(readAll);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){

                placaSolarCertificacoes.add(new PlacaSolarCertificacao(
                        resultSet.getLong("id"),
                        resultSet.getLong("id_placa_solar"),
                        resultSet.getLong("id_certificacao")
                ));

            }

            return placaSolarCertificacoes;

        } catch (Exception exception){

            return null;

        } finally {

            conexao.desconectar();

        }

    }

    public int update(PlacaSolarCertificacao placaSolarCertificacao){

        //Essa entidade não suporta um método para o update.
        //Todos os seus atributos são imutáveis
        return 0;

    }

    public int deleteById(long id){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try{

            String delete = "delete from placa_solar_certificacao where id = ?";

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
     * @param idPlacaSolar idPlacaSolar da {@link PlacaSolarCertificacao} que se deseja deletar.
     * @return Mesmo padrão de retorno que o {@link #deleteById(long)}.
     */
    public int deleteByIdPlacaSolar(long idPlacaSolar){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try{

            String delete = "delete from placa_solar_certificacao where id_placa_solar = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(delete);

            preparedStatement.setLong(1, idPlacaSolar);

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
     * @param idCertificacao idCertificacao da {@link PlacaSolarCertificacao} que se deseja deletar.
     * @return Mesmo padrão de retorno que o {@link #deleteById(long)}.
     */
    public int deleteByIdCertificacao(long idCertificacao){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try{

            String delete = "delete from placa_solar_certificacao where id_certificacao = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(delete);

            preparedStatement.setLong(1, idCertificacao);

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
