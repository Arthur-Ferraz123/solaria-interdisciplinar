package dao;

import conexao.Conexao;

import model.Fornecedor;
import model.Profissional;
import model.Usuario;

import java.sql.Connection;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.util.List;

import java.util.ArrayList;

/**
 * Classe responsável pelo DAO da entidade profissional
 *
 * @author Eduardo Vicente Bisneto
 * @version 1.0.0
 */
public class ProfissionalDAO implements GenericDAO<Profissional> {

    @Override
    public int insert(Profissional profissional){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try{

            String insert = "insert into profissional(id_usuario, profissao, cpf, id_empresa_tecnica) values(?, ?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(insert);

            preparedStatement.setLong(1, profissional.getIdUsuario() );
            preparedStatement.setString(2, profissional.getProfissao());
            preparedStatement.setString(3, profissional.getCpf());
            preparedStatement.setLong(4, profissional.getIdEmpresaTecnica() );

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
    public Profissional readById(long id){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try {

            String readById = "select * from profissional where id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(readById);

            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){

                return new Profissional(
                        resultSet.getLong("id"),
                        resultSet.getLong("id_usuario"),
                        resultSet.getString("tipo_usuario"),
                        resultSet.getString("profissao"),
                        resultSet.getString("cpf"),
                        resultSet.getLong("id_empresa_tecnica")
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
     * Variação do {@link #readById(long)}. A diferença é que o atributo idUsuario é usado como parametro de busca ao invés do atributo id.
     *
     * @param idUsuario Atributo idUsuario de um {@link model.Profissional}.
     * @return Todos os dados registrados do Profissional buscado.
     */
    public Profissional readByIdUsuario(long idUsuario){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try {

            String readById = "select * from profissional where id_usuario = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(readById);

            preparedStatement.setLong(1, idUsuario);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){

                return new Profissional(
                        resultSet.getLong("id"),
                        resultSet.getLong("id_usuario"),
                        resultSet.getString("tipo_usuario"),
                        resultSet.getString("profissao"),
                        resultSet.getString("cpf"),
                        resultSet.getLong("id_empresa_tecnica")
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
     * Variação do {@link #readById(long)}. A diferença é que o atributo cpf é usado como parametro de busca ao invés do atributo id.
     *
     * @param cpf Atributo cpf de um {@link model.Profissional}.
     * @return Todos os dados registrados do Profissional buscado.
     */
    public Profissional readByCpf(String cpf){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try {

            String readById = "select * from profissional where cpf = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(readById);

            preparedStatement.setString(1, cpf);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){

                return new Profissional(
                        resultSet.getLong("id"),
                        resultSet.getLong("id_usuario"),
                        resultSet.getString("tipo_usuario"),
                        resultSet.getString("profissao"),
                        resultSet.getString("cpf"),
                        resultSet.getLong("id_empresa_tecnica")
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
    public List<Profissional> readAll(){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();
        List<Profissional> profissionals = new ArrayList<>();

        try {

            String readAll = "select * from profissional";

            PreparedStatement preparedStatement = connection.prepareStatement(readAll);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){

                profissionals.add(new Profissional(
                        resultSet.getLong("id"),
                        resultSet.getLong("id_usuario"),
                        resultSet.getString("tipo_usuario"),
                        resultSet.getString("profissao"),
                        resultSet.getString("cpf"),
                        resultSet.getLong("id_empresa_tecnica")
                ));

            }

            return profissionals;

        } catch (Exception exception){

            return null;

        } finally {

            conexao.desconectar();

        }

    }

    /**
     * Variação do {@link #readAll}. A diferença é que o atributo idEmpresaTecnica é utilizado como parametro de filtragem.
     *
     * @param idEmpresaTecnica Valor do atributo idEmpresaTecnica dos {@link model.Profissional} que se buscam.
     * @return Todos os dados registrados de todos os Profissional encontradas.
     */
    public List<Profissional> readAllByIdEmpresaTecnica(long idEmpresaTecnica){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();
        List<Profissional> profissionals = new ArrayList<>();

        try {

            String readAll = "select * from profissional wher id_empresa_tecnica = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(readAll);

            preparedStatement.setLong(1, idEmpresaTecnica);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){

                profissionals.add(new Profissional(
                        resultSet.getLong("id"),
                        resultSet.getLong("id_usuario"),
                        resultSet.getString("tipo_usuario"),
                        resultSet.getString("profissao"),
                        resultSet.getString("cpf"),
                        resultSet.getLong("id_empresa_tecnica")
                ));

            }

            return profissionals;

        } catch (Exception exception){

            return null;

        } finally {

            conexao.desconectar();

        }

    }

    @Override
    public int update(Profissional profissional){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try{

            String update = "update profissional set profissao = ?, id_empresa_tecnica = ? where id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(update);

            preparedStatement.setString(1, profissional.getProfissao() );
            preparedStatement.setLong(2, profissional.getIdEmpresaTecnica() );
            preparedStatement.setLong(3, profissional.getId());

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

            String delete = "delete from profissional where id = ?";

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
     * Variação do {@link #deleteById(long)}. A diferença é que o atributo idUsuario é utilizado como parametro de apagamento.
     *
     * @param idUsuario Atributo idUsuario de um {@link model.Profissional}.
     * @return A quantidade de registros pagados.
     */
    public int deleteByIdUsuario(long idUsuario){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try{

            String delete = "delete from profissional where id_usuario = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(delete);

            preparedStatement.setLong(1, idUsuario);

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
     * Variação do {@link #deleteById(long)}. A diferença é que o atributo cpf é utilizado como parametro de apagamento.
     *
     * @param cpf Atributo cpf de um {@link model.Profissional}.
     * @return A quantidade de registros pagados.
     */
    public int deleteByCpf(String cpf){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try{

            String delete = "delete from profissional where cpf = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(delete);

            preparedStatement.setString(1, cpf);

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