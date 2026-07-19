package dao;

import conexao.Conexao;

import model.Compromisso;

import java.sql.Connection;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.sql.Date;

import java.sql.Time;

import java.time.LocalDate;

import java.time.LocalTime;

import java.util.List;

import java.util.ArrayList;

/**
 * Classe responsável pelo DAO da entidade compromisso
 *
 * @author Eduardo Vicente Bisneto
 * @version 1.0.0
 */
public class CompromissoDAO implements GenericDAO<Compromisso> {

    @Override
    public int insert(Compromisso compromisso){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try{

            String insert = "insert into compromisso(id_usuario_projeto, nome, descricao, data_compromisso, horario_compromisso, data_prevista_para_conclusao) values(?, ?, ?, ?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(insert);

            preparedStatement.setLong(1, compromisso.getIdUsuarioProjeto() );
            preparedStatement.setString(2, compromisso.getNome());
            preparedStatement.setString(3, compromisso.getDescricao());
            preparedStatement.setDate(4, Date.valueOf(compromisso.getDataCompromisso()));
            preparedStatement.setTime(5, Time.valueOf(compromisso.getHorarioCompromisso()));
            preparedStatement.setDate(6, Date.valueOf(compromisso.getDataPrevistaParaConclusao()));

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
    public Compromisso readById(long id){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try {

            String readById = "select * from compromisso where id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(readById);

            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){

                return new Compromisso(
                        resultSet.getLong("id"),
                        resultSet.getLong("id_usuario_projeto"),
                        resultSet.getString("nome"),
                        resultSet.getString("descricao"),
                        resultSet.getObject("data_compromisso", LocalDate.class),
                        resultSet.getObject("horario_compromisso", LocalTime.class),
                        resultSet.getObject("data_prevista_para_conclusao", LocalDate.class)
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
    public List<Compromisso> readAll(){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();
        List<Compromisso> compromissos = new ArrayList<>();

        try {

            String readAll = "select * from compromisso";

            PreparedStatement preparedStatement = connection.prepareStatement(readAll);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){

                compromissos.add(new Compromisso(
                        resultSet.getLong("id"),
                        resultSet.getLong("id_usuario_projeto"),
                        resultSet.getString("nome"),
                        resultSet.getString("descricao"),
                        resultSet.getObject("data_compromisso", LocalDate.class),
                        resultSet.getObject("horario_compromisso", LocalTime.class),
                        resultSet.getObject("data_prevista_para_conclusao", LocalDate.class)
                ));

            }

            return compromissos;

        } catch (Exception exception){

            return null;

        } finally {

            conexao.desconectar();

        }

    }

    /**
     * Variação do {@link #readAll}. A diferença é que o atributo idUsuarioProjeto é utilizado como parametro de filtragem.
     *
     * @param idUsuarioProjeto Valor do atributo idUsuarioProjeto dos {@link model.Compromisso} que se buscam.
     * @return Todos os dados registrados de todos os Compromisso encontrados.
     */
    public List<Compromisso> readAllByIdUsuarioProjeto(long idUsuarioProjeto){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();
        List<Compromisso> compromissos = new ArrayList<>();

        try {

            String readAll = "select * from compromisso where id_usuario_projeto = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(readAll);

            preparedStatement.setLong(1, idUsuarioProjeto);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){

                compromissos.add(new Compromisso(
                        resultSet.getLong("id"),
                        resultSet.getLong("id_usuario_projeto"),
                        resultSet.getString("nome"),
                        resultSet.getString("descricao"),
                        resultSet.getObject("data_compromisso", LocalDate.class),
                        resultSet.getObject("horario_compromisso", LocalTime.class),
                        resultSet.getObject("data_prevista_para_conclusao", LocalDate.class)
                ));

            }

            return compromissos;

        } catch (Exception exception){

            return null;

        } finally {

            conexao.desconectar();

        }

    }

    @Override
    public int update(Compromisso compromisso){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try{

            String update = "update compromisso set nome = ?, descricao = ?, data_compromisso = ?, horario_compromisso = ?, data_prevista_para_conclusao = ? where id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(update);

            preparedStatement.setString(1, compromisso.getNome() );
            preparedStatement.setString(2, compromisso.getDescricao() );
            preparedStatement.setDate(3, Date.valueOf(compromisso.getDataCompromisso()));
            preparedStatement.setTime(4, Time.valueOf(compromisso.getHorarioCompromisso()));
            preparedStatement.setDate(5, Date.valueOf(compromisso.getDataPrevistaParaConclusao()));
            preparedStatement.setLong(6, compromisso.getId());

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

        } catch (Exception exception){

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

            String delete = "delete from compromisso where id = ?";

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
