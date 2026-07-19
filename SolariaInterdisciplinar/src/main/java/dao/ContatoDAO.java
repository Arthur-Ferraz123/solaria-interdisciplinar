package dao;

import conexao.Conexao;

import model.Contato;

import java.sql.Connection;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.util.List;

import java.util.ArrayList;

/**
 * Classe responsável pelo DAO da entidade contato
 *
 * @author Eduardo Vicente Bisneto
 * @version 1.0.0
 */
public class ContatoDAO implements GenericDAO<Contato> {

    @Override
    public int insert(Contato contato){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try{

            String insert = "insert into contato(id_usuario_contatador, id_usuario_contatado, apelido) values(?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(insert);

            preparedStatement.setLong(1, contato.getIdUsuarioContatador() );
            preparedStatement.setLong(2, contato.getIdUsuarioContatado());
            preparedStatement.setString(3, contato.getApelido());

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
    public Contato readById(long id){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try {

            String readById = "select * from contato where id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(readById);

            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){

                return new Contato(
                        resultSet.getLong("id"),
                        resultSet.getLong("id_usuario_contatador"),
                        resultSet.getLong("id_usuario_contatado"),
                        resultSet.getString("apelido")
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
    public List<Contato> readAll(){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();
        List<Contato> contatos = new ArrayList<>();

        try {

            String readAll = "select * from contato";

            PreparedStatement preparedStatement = connection.prepareStatement(readAll);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){

                contatos.add(new Contato(
                        resultSet.getLong("id"),
                        resultSet.getLong("id_usuario_contatador"),
                        resultSet.getLong("id_usuario_contatado"),
                        resultSet.getString("apelido")
                ));

            }

            return contatos;

        } catch (Exception exception){

            return null;

        } finally {

            conexao.desconectar();

        }

    }

    /**
     * Variação do {@link #readAll}. A diferença é que o atributo idUsuarioContatador é utilizado como parametro de filtragem.
     *
     * @param idUsuarioContatador Valor do atributo idUsuarioContatador dos {@link model.Contato} que se buscam.
     * @return Todos os dados registrados de todos os Contato encontrados.
     */
    public List<Contato> readAllByIdUsuarioContatador(long idUsuarioContatador){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();
        List<Contato> contatos = new ArrayList<>();

        try {

            String readAll = "select * from contato where id_usuario_contatador = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(readAll);

            preparedStatement.setLong(1, idUsuarioContatador);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){

                contatos.add(new Contato(
                        resultSet.getLong("id"),
                        resultSet.getLong("id_usuario_contatador"),
                        resultSet.getLong("id_usuario_contatado"),
                        resultSet.getString("apelido")
                ));

            }

            return contatos;

        } catch (Exception exception){

            return null;

        } finally {

            conexao.desconectar();

        }

    }

    /**
     * Variação do {@link #readAll}. A diferença é que o atributo idUsuarioContatado é utilizado como parametro de filtragem.
     *
     * @param idUsuarioContatado Valor do atributo idUsuarioContatado dos {@link model.Contato} que se buscam.
     * @return Todos os dados registrados de todos os Contato encontrados.
     */
    public List<Contato> readAllByIdUsuarioContatado(long idUsuarioContatado){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();
        List<Contato> contatos = new ArrayList<>();

        try {

            String readAll = "select * from contato where id_usuario_contatado = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(readAll);

            preparedStatement.setLong(1, idUsuarioContatado);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){

                contatos.add(new Contato(
                        resultSet.getLong("id"),
                        resultSet.getLong("id_usuario_contatador"),
                        resultSet.getLong("id_usuario_contatado"),
                        resultSet.getString("apelido")
                ));

            }

            return contatos;

        } catch (Exception exception){

            return null;

        } finally {

            conexao.desconectar();

        }

    }

    @Override
    public int update(Contato contato){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try{

            String update = "update contato set apelido = ? where id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(update);

            preparedStatement.setString(1, contato.getApelido() );
            preparedStatement.setLong(2, contato.getId());

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

            String delete = "delete from contato where id = ?";

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