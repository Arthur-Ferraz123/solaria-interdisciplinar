package dao;

import conexao.Conexao;

import model.EmpresaTecnica;
import model.Fornecedor;
import model.Usuario;

import java.sql.Connection;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.util.List;

import java.util.ArrayList;

/**
 * Classe responsável pelo DAO da entidade Empresa técnica
 *
 * @author Eduardo Vicente Bisneto
 * @version 1.0.0
 */
public class EmpresaTecnicaDAO implements GenericDAO<EmpresaTecnica> {

    public int insert(EmpresaTecnica empresaTecnica){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try{

            String insert = "insert into empresa_tecnica(id_usuario, cnpj, razao_social) values(?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(insert);

            preparedStatement.setLong(1, empresaTecnica.getIdUsuario() );
            preparedStatement.setString(2, empresaTecnica.getCnpj());
            preparedStatement.setString(3, empresaTecnica.getRazaoSocial());


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

    public EmpresaTecnica readById(long id){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try {

            String readById = "select * from empresa_tecnica where id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(readById);

            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){

                return new EmpresaTecnica(
                        resultSet.getLong("id"),
                        resultSet.getLong("id_usuario"),
                        resultSet.getString("tipo_usuario"),
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
     * @param idUsuario Identificador único (PK) do {@link model.Usuario} que é a Empresa Técnica.
     * @return A Empresa Técnica com todos os seus dados.
     */
    public EmpresaTecnica readByIdUsuario(long idUsuario){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try {

            String readById = "select * from empresa_tecnica where id_usuario = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(readById);

            preparedStatement.setLong(1, idUsuario);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){

                return new EmpresaTecnica(
                        resultSet.getLong("id"),
                        resultSet.getLong("id_usuario"),
                        resultSet.getString("tipo_usuario"),
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
     * @param cnpj CNPJ da {@link EmpresaTecnica} que se está buscando.
     * @return A Empresa Técnica com todos os seus dados.
     */
    public EmpresaTecnica readByCnpj(String cnpj){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try {

            String readById = "select * from empresa_tecnica where cnpj = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(readById);

            preparedStatement.setString(1, cnpj);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){

                return new EmpresaTecnica(
                        resultSet.getLong("id"),
                        resultSet.getLong("id_usuario"),
                        resultSet.getString("tipo_usuario"),
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

    public List<EmpresaTecnica> readAll(){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();
        List<EmpresaTecnica> empresaTecnicas = new ArrayList<>();

        try {

            String readAll = "select * from empresa_tecnica";

            PreparedStatement preparedStatement = connection.prepareStatement(readAll);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){

                empresaTecnicas.add(new EmpresaTecnica(
                        resultSet.getLong("id"),
                        resultSet.getLong("id_usuario"),
                        resultSet.getString("tipo_usuario"),
                        resultSet.getString("cnpj"),
                        resultSet.getString("razao_social")
                ));

            }

            return empresaTecnicas;

        } catch (Exception exception){

            return null;

        } finally {

            conexao.desconectar();

        }

    }

    public int update(EmpresaTecnica empresaTecnica){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try{

            String update = "update empresa_tecnica set razao_social = ? where id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(update);

            preparedStatement.setString(1, empresaTecnica.getRazaoSocial() );
            preparedStatement.setLong(2, empresaTecnica.getId());

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

            String delete = "delete from empresa_tecnica where id = ?";

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
     * @param idUsuario Identificador único (PK) do {@link Usuario} que é a Empresa Técnica.
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
     * @param cnpj CNPJ da Empresa Técnica.
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