package dao;

import conexao.Conexao;

import model.Endereco;

import java.sql.Connection;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.util.List;

import java.util.ArrayList;

/**
 * Classe responsável pelo DAO da entidade Endereço
 *
 * @author Eduardo Vicente Bisneto
 * @version 1.0.0
 */
public class EnderecoDAO implements GenericDAO<Endereco> {

    public int insert(Endereco endereco){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try{

            String insert = "insert into endereco(id_usuario, estado, cidade, bairro, cep, logradouro, numero, complemento) values(?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(insert);

            preparedStatement.setLong(1, endereco.getIdUsuario() );
            preparedStatement.setString(2, endereco.getEstado());
            preparedStatement.setString(3, endereco.getCidade());
            preparedStatement.setString(4, endereco.getBairro() );
            preparedStatement.setString(5, endereco.getCep() );
            preparedStatement.setString(6, endereco.getLogradouro() );
            preparedStatement.setString(7, endereco.getNumero() );
            preparedStatement.setString(8, endereco.getComplemento() );

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

    public Endereco readById(long id){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try {

            String readById = "select * from endereco where id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(readById);

            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){

                return new Endereco(
                        resultSet.getLong("id"),
                        resultSet.getLong("id_usuario"),
                        resultSet.getString("estado"),
                        resultSet.getString("cidade"),
                        resultSet.getString("bairro"),
                        resultSet.getString("cep"),
                        resultSet.getString("logradouro"),
                        resultSet.getString("numero"),
                        resultSet.getString("complemento")
                );

            }

            return null;

        } catch (Exception exception){

            return null;

        } finally {

            conexao.desconectar();

        }

    }

    public List<Endereco> readAll(){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();
        List<Endereco> enderecos = new ArrayList<>();

        try {

            String readAll = "select * from endereco";

            PreparedStatement preparedStatement = connection.prepareStatement(readAll);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){

                enderecos.add(new Endereco(
                        resultSet.getLong("id"),
                        resultSet.getLong("id_usuario"),
                        resultSet.getString("estado"),
                        resultSet.getString("cidade"),
                        resultSet.getString("bairro"),
                        resultSet.getString("cep"),
                        resultSet.getString("logradouro"),
                        resultSet.getString("numero"),
                        resultSet.getString("complemento")
                ));

            }

            return enderecos;

        } catch (Exception exception){

            return null;

        } finally {

            conexao.desconectar();

        }

    }

    /**
     * Variação do método {@link #readAll()}. A diferença é que o idUsuario é usado como parametro de busca.
     * @param idUsuario ID de quem possuí o endereço buscado.
     * @return Uma lista com todos os registro da tabela que possuem o mesmo idUsuario que o parametro.
     */
    public List<Endereco> readAllByIdUsuario(long idUsuario){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();
        List<Endereco> enderecos = new ArrayList<>();

        try {

            String readAll = "select * from endereco where id_usuario = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(readAll);

            preparedStatement.setLong(1, idUsuario);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){

                enderecos.add(new Endereco(
                        resultSet.getLong("id"),
                        resultSet.getLong("id_usuario"),
                        resultSet.getString("estado"),
                        resultSet.getString("cidade"),
                        resultSet.getString("bairro"),
                        resultSet.getString("cep"),
                        resultSet.getString("logradouro"),
                        resultSet.getString("numero"),
                        resultSet.getString("complemento")
                ));

            }

            return enderecos;

        } catch (Exception exception){

            return null;

        } finally {

            conexao.desconectar();

        }

    }

    /**
     * Variação do método {@link #readAll()}. A diferença é que o estado é usado como parametro de busca.
     * @param estado Sigla de um estado brasileiro.
     * @return Uma lista com todos os registro da tabela que possuem o mesmo estado que o parametro.
     */
    public List<Endereco> readAllByEstado(String estado){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();
        List<Endereco> enderecos = new ArrayList<>();

        try {

            String readAll = "select * from endereco where estado = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(readAll);

            preparedStatement.setString(1, estado);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){

                enderecos.add(new Endereco(
                        resultSet.getLong("id"),
                        resultSet.getLong("id_usuario"),
                        resultSet.getString("estado"),
                        resultSet.getString("cidade"),
                        resultSet.getString("bairro"),
                        resultSet.getString("cep"),
                        resultSet.getString("logradouro"),
                        resultSet.getString("numero"),
                        resultSet.getString("complemento")
                ));

            }

            return enderecos;

        } catch (Exception exception){

            return null;

        } finally {

            conexao.desconectar();

        }

    }

    /**
     * Variação do método {@link #readAll()}. A diferença é que a cidade é usada como parametro de busca.
     * @param cidade Uma cidade brasileira.
     * @return Uma lista com todos os registro da tabela que possuem o mesmo estado que o parametro.
     */
    public List<Endereco> readAllByCidade(String cidade){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();
        List<Endereco> enderecos = new ArrayList<>();

        try {

            String readAll = "select * from endereco where cidade = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(readAll);

            preparedStatement.setString(1, cidade);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){

                enderecos.add(new Endereco(
                        resultSet.getLong("id"),
                        resultSet.getLong("id_usuario"),
                        resultSet.getString("estado"),
                        resultSet.getString("cidade"),
                        resultSet.getString("bairro"),
                        resultSet.getString("cep"),
                        resultSet.getString("logradouro"),
                        resultSet.getString("numero"),
                        resultSet.getString("complemento")
                ));

            }

            return enderecos;

        } catch (Exception exception){

            return null;

        } finally {

            conexao.desconectar();

        }

    }

    /**
     * Variação do método {@link #readAll()}. A diferença é que o bairro é usado como parametro de busca.
     * @param bairro Um bairro brasileiro
     * @return Uma lista com todos os registro da tabela que possuem o mesmo estado que o parametro.
     */
    public List<Endereco> readAllByBairro(String bairro){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();
        List<Endereco> enderecos = new ArrayList<>();

        try {

            String readAll = "select * from endereco where bairro = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(readAll);

            preparedStatement.setString(1, bairro);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){

                enderecos.add(new Endereco(
                        resultSet.getLong("id"),
                        resultSet.getLong("id_usuario"),
                        resultSet.getString("estado"),
                        resultSet.getString("cidade"),
                        resultSet.getString("bairro"),
                        resultSet.getString("cep"),
                        resultSet.getString("logradouro"),
                        resultSet.getString("numero"),
                        resultSet.getString("complemento")
                ));

            }

            return enderecos;

        } catch (Exception exception){

            return null;

        } finally {

            conexao.desconectar();

        }

    }

    /**
     * Variação do método {@link #readAll()}. A diferença é que o cep é usado como parametro de busca.
     * @param cep Um CEP brasileiro.
     * @return Uma lista com todos os registro da tabela que possuem o mesmo estado que o parametro.
     */
    public List<Endereco> readAllByCep(String cep){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();
        List<Endereco> enderecos = new ArrayList<>();

        try {

            String readAll = "select * from endereco where cep = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(readAll);

            preparedStatement.setString(1, cep);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){

                enderecos.add(new Endereco(
                        resultSet.getLong("id"),
                        resultSet.getLong("id_usuario"),
                        resultSet.getString("estado"),
                        resultSet.getString("cidade"),
                        resultSet.getString("bairro"),
                        resultSet.getString("cep"),
                        resultSet.getString("logradouro"),
                        resultSet.getString("numero"),
                        resultSet.getString("complemento")
                ));

            }

            return enderecos;

        } catch (Exception exception){

            return null;

        } finally {

            conexao.desconectar();

        }

    }

    public int update(Endereco endereco){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try{

            String update = "update endereco set estado = ?, cidade = ?, bairro = ?, cep = ?, logradouro = ?, numero = ?, complemento = ? where id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(update);

            preparedStatement.setString(1, endereco.getEstado() );
            preparedStatement.setString(2, endereco.getCidade() );
            preparedStatement.setString(3, endereco.getBairro() );
            preparedStatement.setString(4, endereco.getCep() );
            preparedStatement.setString(5, endereco.getLogradouro() );
            preparedStatement.setString(6, endereco.getNumero() );
            preparedStatement.setString(7, endereco.getComplemento() );
            preparedStatement.setLong(8, endereco.getId());

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

            String delete = "delete from endereco where id = ?";

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