package dao;

import conexao.Conexao;

import model.Cliente;
import model.Fornecedor;
import model.Usuario;

import java.sql.Connection;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.util.List;

import java.util.ArrayList;

/**
 * Classe responsável pelo DAO da entidade Fornecedor
 *
 * @author Eduardo Vicente Bisneto
 * @version 1.0.0
 */
public class FornecedorDAO implements GenericDAO<Fornecedor> {

    public int insert(Fornecedor fornecedor){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try{

            String insert = "insert into fornecedor(id_usuario, tipo_fornecedor, cnpj, razao_social) values(?, ?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(insert);

            preparedStatement.setLong(1, fornecedor.getIdUsuario() );
            preparedStatement.setString(2, fornecedor.getTipoFornecedor());
            preparedStatement.setString(3, fornecedor.getCnpj());
            preparedStatement.setString(4, fornecedor.getRazaoSocial() );

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

    public Fornecedor readById(long id){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try {

            String readById = "select * from fornecedor where id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(readById);

            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){

                return new Fornecedor(
                        resultSet.getLong("id"),
                        resultSet.getLong("id_usuario"),
                        resultSet.getString("tipo_usuario"),
                        resultSet.getString("tipo_fornecedor"),
                        resultSet.getString("cnpj"),
                        resultSet.getString("razao_social")
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
     * @param idUsuario Identificador único (PK) do {@link model.Usuario} que é o Fornecedor.
     * @return O Fornecedor com todos os seus dados.
     */
    public Fornecedor readByIdUsuario(long idUsuario){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try {

            String readById = "select * from fornecedor where id_usuario = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(readById);

            preparedStatement.setLong(1, idUsuario);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){

                return new Fornecedor(
                        resultSet.getLong("id"),
                        resultSet.getLong("id_usuario"),
                        resultSet.getString("tipo_usuario"),
                        resultSet.getString("tipo_fornecedor"),
                        resultSet.getString("cnpj"),
                        resultSet.getString("razao_social")
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
     * @param cnpj CNPJ do {@link Fornecedor} que se está buscando.
     * @return O Fornecedor com todos os seus dados.
     */
    public Fornecedor readByCnpj(String cnpj){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try {

            String readById = "select * from fornecedor where cnpj = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(readById);

            preparedStatement.setString(1, cnpj);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){

                return new Fornecedor(
                        resultSet.getLong("id"),
                        resultSet.getLong("id_usuario"),
                        resultSet.getString("tipo_usuario"),
                        resultSet.getString("tipo_fornecedor"),
                        resultSet.getString("cnpj"),
                        resultSet.getString("razao_social")
                );

            }

            return null;

        } catch (Exception exception){

            return null;

        } finally {

            conexao.desconectar();

        }

    }

    public List<Fornecedor> readAll(){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();
        List<Fornecedor> fornecedores = new ArrayList<>();

        try {

            String readAll = "select * from fornecedor";

            PreparedStatement preparedStatement = connection.prepareStatement(readAll);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){

                fornecedores.add(new Fornecedor(
                        resultSet.getLong("id"),
                        resultSet.getLong("id_usuario"),
                        resultSet.getString("tipo_usuario"),
                        resultSet.getString("tipo_fornecedor"),
                        resultSet.getString("cnpj"),
                        resultSet.getString("razao_social")
                ));

            }

            return fornecedores;

        } catch (Exception exception){

            return null;

        } finally {

            conexao.desconectar();

        }

    }

    /**
     * Variação do método {@link #readAll()}. A diferença é que o tipoFornecedor é usado como parametro de busca.
     * @param tipoFornecedor Veja os valores possíveis em {@link Fornecedor}.
     * @return Uma lista com todos os registro da tabela que possuem o mesmo tipoFornecedor que o parametro.
     */
    public List<Fornecedor> readAllByTipoFornecedor(String tipoFornecedor){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();
        List<Fornecedor> fornecedors = new ArrayList<>();

        try {

            String readAll = "select * from fornecedor where tipo_fornecedor = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(readAll);

            preparedStatement.setString(1, tipoFornecedor);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){

                fornecedors.add(new Fornecedor(
                        resultSet.getLong("id"),
                        resultSet.getLong("id_usuario"),
                        resultSet.getString("tipo_usuario"),
                        resultSet.getString("tipo_fornecedor"),
                        resultSet.getString("cnpj"),
                        resultSet.getString("razao_social")
                ));

            }

            return fornecedors;

        } catch (Exception exception){

            return null;

        } finally {

            conexao.desconectar();

        }

    }

    public int update(Fornecedor fornecedor){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try{

            String update = "update fornecedor set tipo_fornecedor = ?, razao_social =  where id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(update);

            preparedStatement.setString(1, fornecedor.getTipoFornecedor() );
            preparedStatement.setString(2, fornecedor.getRazaoSocial() );
            preparedStatement.setLong(3, fornecedor.getId());

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

            String delete = "delete from fornecedor where id = ?";

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
     * @param idUsuario Identificador único (PK) do {@link Usuario} que é o Fornecedor.
     * @return Mesmo padrão de retorno que o {@link #deleteById(long)}.
     */
    public int deleteByIdUsuario(long idUsuario){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try{

            String delete = "delete from fornecedor where id_usuario = ?";

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
     * Variação do método {@link #deleteById(long)}. A diferença é que o CNPJ é usado como clausula de apagamento.
     * @param cnpj CNPJ do Fornecedor.
     * @return Mesmo padrão de retorno que o {@link #deleteById(long)}.
     */
    public int deleteByCnpj(String cnpj){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try{

            String delete = "delete from fornecedor where cnpj = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(delete);

            preparedStatement.setString(1, cnpj);

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