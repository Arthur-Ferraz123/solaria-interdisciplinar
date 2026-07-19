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
 * Classe responsável pelo DAO da entidade endereco
 *
 * @author Eduardo Vicente Bisneto
 * @version 1.0.0
 */
public class EnderecoDAO implements GenericDAO<Endereco> {

    @Override
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

    @Override
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
     * Variação do {@link #readById(long)}. A diferença é que o atributo idUsuario é usado como parametro de busca ao invés do atributo id.
     *
     * @param idUsuario Atributo idUsuario de um {@link model.Endereco}.
     * @return Todos os dados registrados da Assinatura buscada.
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
     * Variação do {@link #readAll}. A diferença é que o atributo estado é utilizado como parametro de filtragem.
     *
     * @param estado Valor do atributo estado dos {@link model.Endereco} que se buscam.
     * @return Todos os dados registrados de todos os Endereco encontradas.
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
     * Variação do {@link #readAll}. A diferença é que o atributo cidade é utilizado como parametro de filtragem.
     *
     * @param cidade Valor do atributo cidade dos {@link model.Endereco} que se buscam.
     * @return Todos os dados registrados de todos os Endereco encontradas.
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
     * Variação do {@link #readAll}. A diferença é que o atributo bairro é utilizado como parametro de filtragem.
     *
     * @param bairro Valor do atributo bairro dos {@link model.Endereco} que se buscam.
     * @return Todos os dados registrados de todos os Endereco encontradas.
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
     * Variação do {@link #readAll}. A diferença é que o atributo cep é utilizado como parametro de filtragem.
     *
     * @param cep Valor do atributo cep dos {@link model.Endereco} que se buscam.
     * @return Todos os dados registrados de todos os Endereco encontradas.
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

    @Override
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

            String delete = "delete from endereco where id = ?";

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