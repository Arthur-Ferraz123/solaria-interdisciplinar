package dao;

import conexao.Conexao;

import model.Servico;

import java.sql.Connection;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.util.List;

import java.util.ArrayList;

/**
 * Classe responsável pelo DAO da entidade Serviço
 *
 * @author Eduardo Vicente Bisneto
 * @version 1.0.0
 */
public class ServicoDAO implements GenericDAO<Servico> {

    public int insert(Servico servico){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try{

            String insert = "insert into servico(id_empresa_tecnica, servico, descricao) values(?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(insert);

            preparedStatement.setLong(1, servico.getIdEmpresaTecnica() );
            preparedStatement.setString(2, servico.getServico());
            preparedStatement.setString(3, servico.getDescricao());

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

    public Servico readById(long id){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try {

            String readById = "select * from servico where id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(readById);

            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){

                return new Servico(
                        resultSet.getLong("id"),
                        resultSet.getLong("id_empresa_tecnica"),
                        resultSet.getString("servico"),
                        resultSet.getString("descricao")
                );

            }

            return null;

        } catch (Exception exception){

            return null;

        } finally {

            conexao.desconectar();

        }

    }

    public List<Servico> readAll(){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();
        List<Servico> servicos = new ArrayList<>();

        try {

            String readAll = "select * from servico";

            PreparedStatement preparedStatement = connection.prepareStatement(readAll);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){

                servicos.add(new Servico(
                        resultSet.getLong("id"),
                        resultSet.getLong("id_empresa_tecnica"),
                        resultSet.getString("servico"),
                        resultSet.getString("descricao")
                ));

            }

            return servicos;

        } catch (Exception exception){

            return null;

        } finally {

            conexao.desconectar();

        }

    }

    /**
     * Variação do método {@link #readAll()}. A diferença é que o idEmpresaTecnica é usado como parametro de busca.
     * @param idEmpresaTecnica Identificador único (PK) da {@link model.EmpresaTecnica} que presta o serviço trabalham
     * @return Uma lista com todos os registro da tabela de serviços da empresa técnica do id recebido como parâmetro.
     */
    public List<Servico> readAllByIdEmpresaTecnica(long idEmpresaTecnica){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();
        List<Servico> servicos = new ArrayList<>();

        try {

            String readAll = "select * from servico where id_empresa_tecnica = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(readAll);

            preparedStatement.setLong(1, idEmpresaTecnica);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){

                servicos.add(new Servico(
                        resultSet.getLong("id"),
                        resultSet.getLong("id_empresa_tecnica"),
                        resultSet.getString("servico"),
                        resultSet.getString("descricao")
                ));

            }

            return servicos;

        } catch (Exception exception){

            return null;

        } finally {

            conexao.desconectar();

        }

    }

    public int update(Servico servico){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try{

            String update = "update servico set servico = ?, descricao = ? where id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(update);

            preparedStatement.setString(1, servico.getServico() );
            preparedStatement.setString(2, servico.getDescricao() );
            preparedStatement.setLong(3, servico.getId());

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

            String delete = "delete from servico where id = ?";

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