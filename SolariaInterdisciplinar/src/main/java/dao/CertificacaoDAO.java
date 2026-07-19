package dao;

import conexao.Conexao;

import model.Certificacao;
import model.Usuario;

import java.sql.Connection;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.sql.Date;

import java.time.LocalDate;
import java.util.List;

import java.util.ArrayList;

/**
 * Classe responsável pelo DAO da entidade certificacao
 *
 * @author Eduardo Vicente Bisneto
 * @version 1.0.0
 */
public class CertificacaoDAO implements GenericDAO<Certificacao> {

    @Override
    public int insert(Certificacao certificacao){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try{

            String insert = "insert into certificacao(id_fornecedor, selo, numero_registro, data_emissao, validade, documento) values(?, ?, ?, ?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(insert);

            preparedStatement.setLong(1, certificacao.getIdFornecedor() );
            preparedStatement.setString(2, certificacao.getSelo());
            preparedStatement.setString(3, certificacao.getNumeroRegistro());
            preparedStatement.setDate(5, Date.valueOf(certificacao.getDataEmissao()));
            preparedStatement.setDate(6, Date.valueOf(certificacao.getValidade()) );
            preparedStatement.setString(7, certificacao.getDocumento() );

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

    @Override
    public Certificacao readById(long id){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try {

            String readById = "select * from certificacao where id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(readById);

            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){

                return new Certificacao(
                        resultSet.getLong("id"),
                        resultSet.getLong("id_fornecedor"),
                        resultSet.getString("selo"),
                        resultSet.getString("numero_registro"),
                        resultSet.getObject("data_emissao", LocalDate.class),
                        resultSet.getObject("validade", LocalDate.class),
                        resultSet.getString("documento")
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
    public List<Certificacao> readAll(){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();
        List<Certificacao> certificacoes = new ArrayList<>();

        try {

            String readAll = "select * from certificacao";

            PreparedStatement preparedStatement = connection.prepareStatement(readAll);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){

                certificacoes.add(new Certificacao(
                        resultSet.getLong("id"),
                        resultSet.getLong("id_fornecedor"),
                        resultSet.getString("selo"),
                        resultSet.getString("numero_registro"),
                        resultSet.getObject("data_emissao", LocalDate.class),
                        resultSet.getObject("validade", LocalDate.class),
                        resultSet.getString("documento")
                ));

            }

            return certificacoes;

        } catch (Exception exception){

            return null;

        } finally {

            conexao.desconectar();

        }

    }

    /**
     * Variação do {@link #readAll}. A diferença é que o atributo idFornecedor é utilizado como parametro de filtragem.
     *
     * @param idFornecedor Valor do atributo idPlano das {@link model.Certificacao} que se buscam.
     * @return Todos os dados registrados de todas as Certificacao encontradas.
     */
    public List<Certificacao> readAllByIdFornecedor(long idFornecedor){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();
        List<Certificacao> certificacoes = new ArrayList<>();

        try {

            String readAll = "select * from certificacao where id_fornecedor = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(readAll);

            preparedStatement.setLong(1, idFornecedor);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){

                certificacoes.add(new Certificacao(
                        resultSet.getLong("id"),
                        resultSet.getLong("id_fornecedor"),
                        resultSet.getString("selo"),
                        resultSet.getString("numero_registro"),
                        resultSet.getObject("data_emissao", LocalDate.class),
                        resultSet.getObject("validade", LocalDate.class),
                        resultSet.getString("documento")
                ));

            }

            return certificacoes;

        } catch (Exception exception){

            return null;

        } finally {

            conexao.desconectar();

        }

    }

    @Override
    public int update(Certificacao certificacao){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try{

            String update = "update certificacao set selo = ?, numero_registro = ?, data_emissao = ?, validade = ?, documento = ? where id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(update);

            preparedStatement.setString(1, certificacao.getSelo() );
            preparedStatement.setString(2, certificacao.getNumeroRegistro() );
            preparedStatement.setDate(3, Date.valueOf(certificacao.getDataEmissao()) );
            preparedStatement.setDate(4, Date.valueOf(certificacao.getValidade()));
            preparedStatement.setString(5, certificacao.getDocumento() );
            preparedStatement.setLong(6, certificacao.getId());

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

    @Override
    public int deleteById(long id){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try{

            String delete = "delete from certificacao where id = ?";

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
