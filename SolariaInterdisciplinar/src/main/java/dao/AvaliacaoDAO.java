package dao;

import conexao.Conexao;

import model.Avaliacao;

import java.sql.Connection;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.util.List;

import java.util.ArrayList;

/**
 * Classe responsável pelo DAO da entidade Usuário
 *
 * @author Eduardo Vicente Bisneto
 * @version 1.0.0
 */
public class AvaliacaoDAO implements GenericDAO<Avaliacao> {

    public int insert(Avaliacao avaliacao){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try{

            String insert = "insert into avaliacao(id_usuario_avaliador, id_usuario_avaliado, comentario, quantidade_estrelas) values(?, ?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(insert);

            preparedStatement.setLong(1, avaliacao.getIdUsuarioAvaliador() );
            preparedStatement.setLong(2, avaliacao.getIdUsuarioAvaliado());
            preparedStatement.setString(3, avaliacao.getComentario());
            preparedStatement.setInt(4, avaliacao.getQuantidadeEstrelas() );

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

    public Avaliacao readById(long id){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try {

            String readById = "select * from avaliacao where id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(readById);

            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){

                return new Avaliacao(
                        resultSet.getLong("id"),
                        resultSet.getLong("id_usuario_avaliador"),
                        resultSet.getLong("id_usuario_avaliado"),
                        resultSet.getString("comentario"),
                        resultSet.getInt("quantidade_estrelas")
                );

            }

            return null;

        } catch (Exception exception){

            return null;

        } finally {

            conexao.desconectar();

        }

    }

    public List<Avaliacao> readAll(){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();
        List<Avaliacao> avaliacaos = new ArrayList<>();

        try {

            String readAll = "select * from avaliacao";

            PreparedStatement preparedStatement = connection.prepareStatement(readAll);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){

                avaliacaos.add(new Avaliacao(
                        resultSet.getLong("id"),
                        resultSet.getLong("id_usuario_avaliador"),
                        resultSet.getLong("id_usuario_avaliado"),
                        resultSet.getString("comentario"),
                        resultSet.getInt("quantidade_estrelas")
                ));

            }

            return avaliacaos;

        } catch (Exception exception){

            return null;

        } finally {

            conexao.desconectar();

        }

    }

    /**
     * Variação do método {@link #readAll()}. A diferença é que o idUsuarioAvaliador é usada como parametro de busca.
     * @param idUsuarioAvaliador O id de quem se deseja buscar as avaliações enviada.
     * @return Uma lista com todos os registro da tabela que possuem o mesmo estado que o parametro.
     */
    public List<Avaliacao> readAllByIdUsuarioAvaliador(long idUsuarioAvaliador){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();
        List<Avaliacao> avaliacaos = new ArrayList<>();

        try {

            String readAll = "select * from avaliacao where id_usuario_avaliador = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(readAll);

            preparedStatement.setLong(1, idUsuarioAvaliador);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){

                avaliacaos.add(new Avaliacao(
                        resultSet.getLong("id"),
                        resultSet.getLong("id_usuario_avaliador"),
                        resultSet.getLong("id_usuario_avaliado"),
                        resultSet.getString("comentario"),
                        resultSet.getInt("quantidade_estrelas")
                ));

            }

            return avaliacaos;

        } catch (Exception exception){

            return null;

        } finally {

            conexao.desconectar();

        }

    }

    /**
     * Variação do método {@link #readAll()}. A diferença é que o idUsuarioAvaliado é usada como parametro de busca.
     * @param idUsuarioAvaliado O id de quem se deseja buscar as avaliações recebidas.
     * @return Uma lista com todos os registro da tabela que possuem o mesmo estado que o parametro.
     */
    public List<Avaliacao> readAllByIdUsuarioAvaliado(long idUsuarioAvaliado){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();
        List<Avaliacao> avaliacaos = new ArrayList<>();

        try {

            String readAll = "select * from avaliacao where id_usuario_avaliado = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(readAll);

            preparedStatement.setLong(1, idUsuarioAvaliado);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){

                avaliacaos.add(new Avaliacao(
                        resultSet.getLong("id"),
                        resultSet.getLong("id_usuario_avaliador"),
                        resultSet.getLong("id_usuario_avaliado"),
                        resultSet.getString("comentario"),
                        resultSet.getInt("quantidade_estrelas")
                ));

            }

            return avaliacaos;

        } catch (Exception exception){

            return null;

        } finally {

            conexao.desconectar();

        }

    }

    public int update(Avaliacao avaliacao){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try{

            String update = "update avaliacao set comentario = ?, quantidade_estrelas = ? where id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(update);

            preparedStatement.setString(1, avaliacao.getComentario() );
            preparedStatement.setInt(2, avaliacao.getQuantidadeEstrelas() );
            preparedStatement.setLong(3, avaliacao.getId());

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

            String delete = "delete from avaliacao where id = ?";

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