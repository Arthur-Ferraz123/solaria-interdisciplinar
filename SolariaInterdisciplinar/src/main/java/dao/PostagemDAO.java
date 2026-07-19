package dao;

import conexao.Conexao;

import model.Postagem;

import java.sql.Connection;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import java.util.ArrayList;

/**
 * Classe responsável pelo DAO da entidade postagem
 *
 * @author Eduardo Vicente Bisneto
 * @version 1.0.0
 */
public class PostagemDAO implements GenericDAO<Postagem> {

    @Override
    public int insert(Postagem postagem){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try{

            String insert = "insert into postagem(id_perfil, texto) values(?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(insert);

            preparedStatement.setLong(1, postagem.getIdPerfil() );
            preparedStatement.setString(2, postagem.getTexto());

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
    public Postagem readById(long id){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try {

            String readById = "select * from postagem where id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(readById);

            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){

                return new Postagem(
                        resultSet.getLong("id"),
                        resultSet.getLong("id_perfil"),
                        resultSet.getString("texto"),
                        resultSet.getObject("data_publicacao", LocalDate.class),
                        resultSet.getInt("quantidade_visualizacoes"),
                        resultSet.getObject("horario_publicacao", LocalTime.class)
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
    public List<Postagem> readAll(){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();
        List<Postagem> postagens = new ArrayList<>();

        try {

            String readAll = "select * from postagem";

            PreparedStatement preparedStatement = connection.prepareStatement(readAll);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){

                postagens.add(new Postagem(
                        resultSet.getLong("id"),
                        resultSet.getLong("id_perfil"),
                        resultSet.getString("texto"),
                        resultSet.getObject("data_publicacao", LocalDate.class),
                        resultSet.getInt("quantidade_visualizacoes"),
                        resultSet.getObject("horario_publicacao", LocalTime.class)
                ));

            }

            return postagens;

        } catch (Exception exception){

            return null;

        } finally {

            conexao.desconectar();

        }

    }

    /**
     * Variação do {@link #readAll}. A diferença é que o atributo idPerfil é utilizado como parametro de filtragem.
     *
     * @param idPerfil Valor do atributo idPerfil das {@link model.Postagem} que se buscam.
     * @return Todos os dados registrados de todas as Postagem encontradas.
     */
    public List<Postagem> readAllByIdPerfil(long idPerfil){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();
        List<Postagem> postagens = new ArrayList<>();

        try {

            String readAll = "select * from postagem where id_perfil = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(readAll);

            preparedStatement.setLong(1, idPerfil);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){

                postagens.add(new Postagem(
                        resultSet.getLong("id"),
                        resultSet.getLong("id_perfil"),
                        resultSet.getString("texto"),
                        resultSet.getObject("data_publicacao", LocalDate.class),
                        resultSet.getInt("quantidade_visualizacoes"),
                        resultSet.getObject("horario_publicacao", LocalTime.class)
                ));

            }

            return postagens;

        } catch (Exception exception){

            return null;

        } finally {

            conexao.desconectar();

        }

    }

    @Override
    public int update(Postagem postagem){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try{

            String update = "update postagem set texto = ?, quantidade_visualizacoes = ? where id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(update);

            preparedStatement.setString(1, postagem.getTexto() );
            preparedStatement.setLong(2, postagem.getQuantidadeVisualizacoes() );
            preparedStatement.setLong(3, postagem.getId());

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

            String delete = "delete from postagem where id = ?";

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
