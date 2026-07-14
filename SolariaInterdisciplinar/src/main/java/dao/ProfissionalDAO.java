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
 * Classe responsável pelo DAO da entidade Profissional
 *
 * @author Eduardo Vicente Bisneto
 * @version 1.0.0
 */
public class ProfissionalDAO implements GenericDAO<Profissional> {

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

                return -1;
            }

            return -2;

        } catch (Exception exception){

            return -3;

        } finally {

            conexao.desconectar();

        }

    }

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
     * Variação do método {@link #readById(long)}. A diferença é que o parametro de busca é o idUsuario.
     *
     * @param idUsuario Identificador único (PK) do {@link model.Usuario} que é o Profissional.
     * @return O Profissional com todos os seus dados.
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
     * Variação do método {@link #readById(long)}. A diferença é que o parametro de busca é o cnpj.
     *
     * @param cpf CPF do {@link Profissional} que se está buscando.
     * @return O Profissional com todos os seus dados.
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
     * Variação do método {@link #readAll()}. A diferença é que o idEmpresaTecnica é usado como parametro de busca.
     * @param idEmpresaTecnica Identificador único (PK) da {@link model.EmpresaTecnica} que os profissionais trabalham
     * @return Uma lista com todos os registro da tabela de profissionais que trabalham na empresa técnica do id recebido como parâmetro.
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

            String delete = "delete from profissional where id = ?";

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

    /**
     * Variação do método {@link #deleteById(long)}. A diferença é que o idUsuario é usado como clausula de apagamento.
     * @param idUsuario Identificador único (PK) do {@link Usuario} que é o Profissional.
     * @return Mesmo padrão de retorno que o {@link #deleteById(long)}.
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

                return -1;
            }

            return -2;

        }catch (Exception exception){

            return -3;

        } finally {

            conexao.desconectar();

        }

    }

    /**
     * Variação do método {@link #deleteById(long)}. A diferença é que o idUsuario é usado como clausula de apagamento.
     * @param cpf CPF do Profissional.
     * @return Mesmo padrão de retorno que o {@link #deleteById(long)}.
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