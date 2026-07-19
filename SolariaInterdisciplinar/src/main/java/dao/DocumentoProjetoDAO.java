package dao;

import conexao.Conexao;

import model.DocumentoProjeto;

import java.sql.Connection;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.util.List;

import java.util.ArrayList;

/**
 * Classe responsável pelo DAO da entidade documento_projeto
 *
 * @author Eduardo Vicente Bisneto
 * @version 1.0.0
 */
public class DocumentoProjetoDAO implements GenericDAO<DocumentoProjeto> {

    @Override
    public int insert(DocumentoProjeto documentoProjeto){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try{

            String insert = "insert into documento_projeto(id_projeto, id_usuario_criador, documento) values(?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(insert);

            preparedStatement.setLong(1, documentoProjeto.getIdProjeto() );
            preparedStatement.setLong(2, documentoProjeto.getIdUsuarioCriador());
            preparedStatement.setString(3, documentoProjeto.getDocumento());


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
    public DocumentoProjeto readById(long id){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try {

            String readById = "select * from documento_projeto where id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(readById);

            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){

                return new DocumentoProjeto(
                        resultSet.getLong("id"),
                        resultSet.getLong("id_projeto"),
                        resultSet.getLong("id_usuario_criador"),
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
    public List<DocumentoProjeto> readAll(){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();
        List<DocumentoProjeto> documentoProjetos = new ArrayList<>();

        try {

            String readAll = "select * from documento_projeto";

            PreparedStatement preparedStatement = connection.prepareStatement(readAll);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){

                documentoProjetos.add(new DocumentoProjeto(
                        resultSet.getLong("id"),
                        resultSet.getLong("id_projeto"),
                        resultSet.getLong("id_usuario_criador"),
                        resultSet.getString("documento")
                ));

            }

            return documentoProjetos;

        } catch (Exception exception){

            return null;

        } finally {

            conexao.desconectar();

        }

    }

    /**
     * Variação do {@link #readAll}. A diferença é que o atributo idProjeto é utilizado como parametro de filtragem.
     *
     * @param idProjeto Valor do atributo idProjeto dos {@link model.DocumentoProjeto} que se buscam.
     * @return Todos os dados registrados de todos os DocumentoProjeto encontrados.
     */
    public List<DocumentoProjeto> readAllByIdProjeto(long idProjeto){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();
        List<DocumentoProjeto> documentoProjetos = new ArrayList<>();

        try {

            String readAll = "select * from documento_projeto where id_projeto = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(readAll);

            preparedStatement.setLong(1, idProjeto);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){

                documentoProjetos.add(new DocumentoProjeto(
                        resultSet.getLong("id"),
                        resultSet.getLong("id_projeto"),
                        resultSet.getLong("id_usuario_criador"),
                        resultSet.getString("documento")
                ));

            }

            return documentoProjetos;

        } catch (Exception exception){

            return null;

        } finally {

            conexao.desconectar();

        }

    }

    /**
     * Variação do {@link #readAll}. A diferença é que o atributo idUsuarioCriador é utilizado como parametro de filtragem.
     *
     * @param idUsuarioCriador Valor do atributo idUsuarioCriador dos {@link model.DocumentoProjeto} que se buscam.
     * @return Todos os dados registrados de todos os DocumentoProjeto encontrados.
     */
    public List<DocumentoProjeto> readAllByIdUsuarioCriador(long idUsuarioCriador){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();
        List<DocumentoProjeto> documentoProjetos = new ArrayList<>();

        try {

            String readAll = "select * from documento_projeto where id_usuario_criador = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(readAll);

            preparedStatement.setLong(1, idUsuarioCriador);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){

                documentoProjetos.add(new DocumentoProjeto(
                        resultSet.getLong("id"),
                        resultSet.getLong("id_projeto"),
                        resultSet.getLong("id_usuario_criador"),
                        resultSet.getString("documento")
                ));

            }

            return documentoProjetos;

        } catch (Exception exception){

            return null;

        } finally {

            conexao.desconectar();

        }

    }

    @Override
    public int update(DocumentoProjeto documentoProjeto){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try{

            String update = "update documento_projeto set documento = ? where id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(update);

            preparedStatement.setString(1, documentoProjeto.getDocumento() );
            preparedStatement.setLong(2, documentoProjeto.getId());

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

            String delete = "delete from documento_projeto where id = ?";

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