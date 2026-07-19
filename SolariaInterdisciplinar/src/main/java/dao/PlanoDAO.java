package dao;

import conexao.Conexao;

import model.Plano;

import java.sql.Connection;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.util.List;

import java.util.ArrayList;

/**
 * Classe responsável pelo DAO da entidade plano
 *
 * @author Eduardo Vicente Bisneto
 * @version 1.0.0
 */
public class PlanoDAO implements GenericDAO<Plano> {

    public int insert(Plano plano){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try{

            String insert = "insert into plano(nome, tipo_usuario_destinado, valor, tipo_mensalidade) values(?, ?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(insert);

            preparedStatement.setString(1, plano.getNome() );
            preparedStatement.setString(2, plano.getTipoUsuarioDestinado());
            preparedStatement.setDouble(3, plano.getValor());
            preparedStatement.setString(4, plano.getTipoMensalidade() );

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

    public Plano readById(long id){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try {

            String readById = "select * from plano where id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(readById);

            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){

                return new Plano(
                        resultSet.getLong("id"),
                        resultSet.getString("nome"),
                        resultSet.getString("tipo_usuario_destinado"),
                        resultSet.getDouble("valor"),
                        resultSet.getString("tipo_mensalidade")
                );

            }

            return null;

        } catch (Exception exception){

            return null;

        } finally {

            conexao.desconectar();

        }

    }

    public List<Plano> readAll(){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();
        List<Plano> planos = new ArrayList<>();

        try {

            String readAll = "select * from plano";

            PreparedStatement preparedStatement = connection.prepareStatement(readAll);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){

                planos.add(new Plano(
                        resultSet.getLong("id"),
                        resultSet.getString("nome"),
                        resultSet.getString("tipo_usuario_destinado"),
                        resultSet.getDouble("valor"),
                        resultSet.getString("tipo_mensalidade")
                ));

            }

            return planos;

        } catch (Exception exception){

            return null;

        } finally {

            conexao.desconectar();

        }

    }

    /**
     * Variação do {@link #readAll}. A diferença é que o tipoUsuarioDestinado cep é utilizado como parametro de filtragem.
     *
     * @param tipoUsuarioDestinado Valor do tipoUsuarioDestinado cep dos {@link model.Plano} que se buscam.
     * @return Todos os dados registrados de todos os Plano encontradas.
     */
    public List<Plano> readAllByTipoUsuarioDestinado(String tipoUsuarioDestinado){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();
        List<Plano> planos = new ArrayList<>();

        try {

            String readAll = "select * from plano where tipo_usuario_destinado = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(readAll);

            preparedStatement.setString(1, tipoUsuarioDestinado);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){

                planos.add(new Plano(
                        resultSet.getLong("id"),
                        resultSet.getString("nome"),
                        resultSet.getString("tipo_usuario_destinado"),
                        resultSet.getDouble("valor"),
                        resultSet.getString("tipo_mensalidade")
                ));

            }

            return planos;

        } catch (Exception exception){

            return null;

        } finally {

            conexao.desconectar();

        }

    }

    /**
     * Variação do {@link #readAll}. A diferença é que o tipoMensalidade cep é utilizado como parametro de filtragem.
     *
     * @param tipoMensalidade Valor do tipoMensalidade cep dos {@link model.Plano} que se buscam.
     * @return Todos os dados registrados de todos os Plano encontradas.
     */
    public List<Plano> readAllByTipoMensalidade(String tipoMensalidade){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();
        List<Plano> planos = new ArrayList<>();

        try {

            String readAll = "select * from plano where tipo_mensalidade = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(readAll);

            preparedStatement.setString(1, tipoMensalidade);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){

                planos.add(new Plano(
                        resultSet.getLong("id"),
                        resultSet.getString("nome"),
                        resultSet.getString("tipo_usuario_destinado"),
                        resultSet.getDouble("valor"),
                        resultSet.getString("tipo_mensalidade")
                ));

            }

            return planos;

        } catch (Exception exception){

            return null;

        } finally {

            conexao.desconectar();

        }

    }

    public int update(Plano plano){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try{

            String update = "update plano set nome = ?, tipo_usuario_destinado = ?, valor = ?, tipo_mensalidade = ? where id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(update);

            preparedStatement.setString(1, plano.getNome() );
            preparedStatement.setString(2, plano.getTipoUsuarioDestinado() );
            preparedStatement.setDouble(3, plano.getValor() );
            preparedStatement.setString(4, plano.getTipoMensalidade());
            preparedStatement.setLong(5, plano.getId());

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

    public int deleteById(long id){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try{

            String delete = "delete from plano where id = ?";

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