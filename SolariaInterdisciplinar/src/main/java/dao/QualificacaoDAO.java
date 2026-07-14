package dao;

import conexao.Conexao;

import model.Qualificacao;

import java.sql.Connection;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.sql.Date;

import java.time.LocalDate;
import java.util.List;

import java.util.ArrayList;

/**
 * Classe responsável pelo DAO da entidade Qualificacao
 *
 * @author Eduardo Vicente Bisneto
 * @version 1.0.0
 */
public class QualificacaoDAO implements GenericDAO<Qualificacao> {

    public int insert(Qualificacao qualificacao){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try{

            String insert = "insert into qualificacao(id_profissional, orgao_expeditor, nome, tipo_credencial, data_emissao, validade, carga_horaria_curso, numero_registro, documento, numero_nr, fabricante_certificado) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(insert);

            preparedStatement.setLong(1, qualificacao.getIdProfissional() );
            preparedStatement.setString(2, qualificacao.getOrgaoExpeditor());
            preparedStatement.setString(3, qualificacao.getNome());
            preparedStatement.setString(4, qualificacao.getTipoCredencial() );
            preparedStatement.setDate(5, Date.valueOf(qualificacao.getDataEmissao() ) );
            preparedStatement.setDate(6, Date.valueOf(qualificacao.getValidade() ) );
            preparedStatement.setDouble(7, qualificacao.getCargaHorariaCurso() );
            preparedStatement.setString(8, qualificacao.getNumeroRegistro() );
            preparedStatement.setString(9, qualificacao.getDocumento() );
            preparedStatement.setString(10, qualificacao.getNumeroNr() );
            preparedStatement.setString(11, qualificacao.getFabricanteCertificado() );

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

    public Qualificacao readById(long id){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try {

            String readById = "select * from qualificacao where id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(readById);

            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){

                return new Qualificacao(
                        resultSet.getLong("id"),
                        resultSet.getLong("id_profissional"),
                        resultSet.getString("orgao_expeditor"),
                        resultSet.getString("nome"),
                        resultSet.getString("tipo_credencial"),
                        resultSet.getObject("data_emissao", LocalDate.class),
                        resultSet.getObject("validade", LocalDate.class),
                        resultSet.getDouble("carga_horaria_curso"),
                        resultSet.getString("numero_registro"),
                        resultSet.getString("documento"),
                        resultSet.getString("numero_nr"),
                        resultSet.getString("fabricante_certificado")
                );

            }

            return null;

        } catch (Exception exception){

            return null;

        } finally {

            conexao.desconectar();

        }

    }

    public List<Qualificacao> readAll(){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();
        List<Qualificacao> qualificacaos = new ArrayList<>();

        try {

            String readAll = "select * from qualificacao";

            PreparedStatement preparedStatement = connection.prepareStatement(readAll);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){

                qualificacaos.add(new Qualificacao(
                        resultSet.getLong("id"),
                        resultSet.getLong("id_profissional"),
                        resultSet.getString("orgao_expeditor"),
                        resultSet.getString("nome"),
                        resultSet.getString("tipo_credencial"),
                        resultSet.getObject("data_emissao", LocalDate.class),
                        resultSet.getObject("validade", LocalDate.class),
                        resultSet.getDouble("carga_horaria_curso"),
                        resultSet.getString("numero_registro"),
                        resultSet.getString("documento"),
                        resultSet.getString("numero_nr"),
                        resultSet.getString("fabricante_certificado")
                ));

            }

            return qualificacaos;

        } catch (Exception exception){

            return null;

        } finally {

            conexao.desconectar();

        }

    }

    public List<Qualificacao> readAllByIdProfissional(long idProfissional){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();
        List<Qualificacao> qualificacaos = new ArrayList<>();

        try {

            String readAll = "select * from qualificacao where id_profissional = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(readAll);

            preparedStatement.setLong(1, idProfissional);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){

                qualificacaos.add(new Qualificacao(
                        resultSet.getLong("id"),
                        resultSet.getLong("id_profissional"),
                        resultSet.getString("orgao_expeditor"),
                        resultSet.getString("nome"),
                        resultSet.getString("tipo_credencial"),
                        resultSet.getObject("data_emissao", LocalDate.class),
                        resultSet.getObject("validade", LocalDate.class),
                        resultSet.getDouble("carga_horaria_curso"),
                        resultSet.getString("numero_registro"),
                        resultSet.getString("documento"),
                        resultSet.getString("numero_nr"),
                        resultSet.getString("fabricante_certificado")
                ));

            }

            return qualificacaos;

        } catch (Exception exception){

            return null;

        } finally {

            conexao.desconectar();

        }

    }

    public int update(Qualificacao qualificacao){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try{

            String update = "update qualificacao set orgao_expeditor = ?, nome = ?, tipo_credencial = ?,  data_emissao = ?, validade = ?, carga_horaria_curso = ?, numero_registro = ?, documento = ?, numero_nr = ?, fabricante_certificacao = ? where id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(update);

            preparedStatement.setString(1, qualificacao.getOrgaoExpeditor() );
            preparedStatement.setString(2, qualificacao.getNome() );
            preparedStatement.setString(3, qualificacao.getTipoCredencial() );
            preparedStatement.setDate(4, Date.valueOf(qualificacao.getDataEmissao()));
            preparedStatement.setDate(5, Date.valueOf(qualificacao.getValidade()));
            preparedStatement.setDouble(6, qualificacao.getCargaHorariaCurso());
            preparedStatement.setString(7, qualificacao.getNumeroRegistro());
            preparedStatement.setString(8, qualificacao.getDocumento());
            preparedStatement.setString(9, qualificacao.getNumeroNr());
            preparedStatement.setString(10, qualificacao.getFabricanteCertificado());
            preparedStatement.setLong(11, qualificacao.getId());

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

            String delete = "delete from qualificacao where id = ?";

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