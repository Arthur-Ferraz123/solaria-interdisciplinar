package dao;

import conexao.Conexao;

import model.Endereco;
import model.Telefone;
import model.Usuario;

import java.sql.Connection;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.util.List;

import java.util.ArrayList;

/**
 * Classe responsável pelo DAO da entidade telefone
 *
 * @author Eduardo Vicente Bisneto
 * @version 1.0.0
 */

public class TelefoneDAO implements GenericDAO<Telefone> {

    @Override
    public int insert(Telefone telefone){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try{

            String insert = "insert into telefone(telefone, tipo, id_usuario, principal) values(?, ?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(insert);

            preparedStatement.setString(1, telefone.getTelefone() );
            preparedStatement.setString(2, telefone.getTipo());
            preparedStatement.setLong(3, telefone.getIdUsuario());
            preparedStatement.setBoolean(4, telefone.isPrincipal() );

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
    public Telefone readById(long id){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try {

            String readById = "select * from telefone where id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(readById);

            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){

                return new Telefone(
                        resultSet.getLong("id"),
                        resultSet.getString("telefone"),
                        resultSet.getString("tipo"),
                        resultSet.getLong("id_usuario"),
                        resultSet.getBoolean("principal")
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
     * Variação do {@link #readById(long)}. A diferença é que o atributo telefone é usado como parametro de busca ao invés do atributo id.
     *
     * @param telefone Atributo telefone de um {@link model.Telefone}.
     * @return Todos os dados registrados do Telefone buscado.
     */
    public Telefone readByTelefone(String telefone){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try {

            String readById = "select * from telefone where telefone = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(readById);

            preparedStatement.setString(1, telefone);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){

                return new Telefone(
                        resultSet.getLong("id"),
                        resultSet.getString("telefone"),
                        resultSet.getString("tipo"),
                        resultSet.getLong("id_usuario"),
                        resultSet.getBoolean("principal")
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
    public List<Telefone> readAll(){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();
        List<Telefone> telefones = new ArrayList<>();

        try {

            String readAll = "select * from telefone";

            PreparedStatement preparedStatement = connection.prepareStatement(readAll);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){

                telefones.add(new Telefone(
                        resultSet.getLong("id"),
                        resultSet.getString("telefone"),
                        resultSet.getString("tipo"),
                        resultSet.getLong("id_usuario"),
                        resultSet.getBoolean("principal")
                ));

            }

            return telefones;

        } catch (Exception exception){

            return null;

        } finally {

            conexao.desconectar();

        }

    }

    /**
     * Variação do {@link #readAll}. A diferença é que o atributo idUsuario é utilizado como parametro de filtragem.
     *
     * @param idUsuario Valor do atributo idUsuario dos {@link model.Telefone} que se buscam.
     * @return Todos os dados registrados de todos os Telefone encontradas.
     */
    public List<Telefone> readAllByIdUsuario(long idUsuario){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();
        List<Telefone> telefones = new ArrayList<>();

        try {

            String readAll = "select * from telefone where id_usuario = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(readAll);

            preparedStatement.setLong(1, idUsuario);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){

                telefones.add(new Telefone(
                        resultSet.getLong("id"),
                        resultSet.getString("telefone"),
                        resultSet.getString("tipo"),
                        resultSet.getLong("id_usuario"),
                        resultSet.getBoolean("principal")
                ));

            }

            return telefones;

        } catch (Exception exception){

            return null;

        } finally {

            conexao.desconectar();

        }

    }

    @Override
    public int update(Telefone telefone){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try{

            String update = "update telefone set telefone = ?, tipo = ?, principal = ? where id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(update);

            preparedStatement.setString(1, telefone.getTelefone() );
            preparedStatement.setString(2, telefone.getTipo() );
            preparedStatement.setBoolean(3, telefone.isPrincipal() );
            preparedStatement.setLong(4, telefone.getId());

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

            String delete = "delete from telefone where id = ?";

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
     * Variação do {@link #deleteById(long)}. A diferença é que o atributo telefone é utilizado como parametro de apagamento.
     *
     * @param telefone Atributo idUsuario de um {@link model.Telefone}.
     * @return A quantidade de registros apagados.
     */
    public int deleteByTelefone(String telefone){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try{

            String delete = "delete from telefone where telefone = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(delete);

            preparedStatement.setString(1, telefone);

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