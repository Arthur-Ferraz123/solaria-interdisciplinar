package dao;

import conexao.Conexao;

import model.Usuario;

import java.sql.Connection;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.util.List;

import java.util.ArrayList;

/**
 * Classe responsável pelo DAO da entidade usuario
 *
 * @author Eduardo Vicente Bisneto
 * @version 1.0.0
 */
public class UsuarioDAO implements GenericDAO<Usuario> {

    @Override
    public int insert(Usuario usuario){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try{

        String insert = "insert into usuario(email, senha, nome, tipo_usuario) values(?, ?, ?, ?)";

        PreparedStatement preparedStatement = connection.prepareStatement(insert);

        preparedStatement.setString(1, usuario.getEmail() );
        preparedStatement.setString(2, usuario.getSenha());
        preparedStatement.setString(3, usuario.getNome());
        preparedStatement.setString(4, usuario.getTipoUsuario() );

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
    public Usuario readById(long id){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try {

            String readById = "select * from usuario where id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(readById);

            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){

                return new Usuario(
                        resultSet.getLong("id"),
                        resultSet.getString("email"),
                        resultSet.getString("senha"),
                        resultSet.getString("nome"),
                        resultSet.getString("tipo_usuario")
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
     * Variação do {@link #readById(long)}. A diferença é que o atributo email é usado como parametro de busca ao invés do atributo id.
     *
     * @param email Atributo email de um {@link model.Usuario}.
     * @return Todos os dados registrados do Usuario buscado.
     */
    public Usuario readByEmail(String email){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try {

            String readById = "select * from usuario where email = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(readById);

            preparedStatement.setString(1, email);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){

                return new Usuario(
                        resultSet.getLong("id"),
                        resultSet.getString("email"),
                        resultSet.getString("senha"),
                        resultSet.getString("nome"),
                        resultSet.getString("tipo_usuario")
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
    public List<Usuario> readAll(){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();
        List<Usuario> usuarios = new ArrayList<>();

        try {

            String readAll = "select * from usuario";

            PreparedStatement preparedStatement = connection.prepareStatement(readAll);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){

                 usuarios.add(new Usuario(
                        resultSet.getLong("id"),
                        resultSet.getString("email"),
                        resultSet.getString("senha"),
                        resultSet.getString("nome"),
                        resultSet.getString("tipo_usuario")
                ));

            }

            return usuarios;

        } catch (Exception exception){

            return null;

        } finally {

            conexao.desconectar();

        }

    }

    /**
     * Variação do {@link #readAll}. A diferença é que o atributo tipoUsuario é utilizado como parametro de filtragem.
     *
     * @param tipoUsuario Valor do atributo tipoUsuario dos {@link model.Usuario} que se buscam.
     * @return Todos os dados registrados de todos os Usuario encontradas.
     */
    public List<Usuario> readAllbyTipoUsuario(String tipoUsuario){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();
        List<Usuario> usuarios = new ArrayList<>();

        try {

            String readAll = "select * from usuario where tipo_usuario = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(readAll);

            preparedStatement.setString(1, tipoUsuario);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){

                usuarios.add(new Usuario(
                        resultSet.getLong("id"),
                        resultSet.getString("email"),
                        resultSet.getString("senha"),
                        resultSet.getString("nome"),
                        resultSet.getString("tipo_usuario")
                ));

            }

            return usuarios;

        } catch (Exception exception){

            return null;

        } finally {

            conexao.desconectar();

        }

    }

    @Override
    public int update(Usuario usuario){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try{

            String update = "update usuario set email = ?, senha = ?, nome = ? where id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(update);

            preparedStatement.setString(1, usuario.getEmail() );
            preparedStatement.setString(2, usuario.getSenha() );
            preparedStatement.setString(3, usuario.getNome() );
            preparedStatement.setLong(4, usuario.getId());

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

            String delete = "delete from usuario where id = ?";

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
     * Variação do {@link #deleteById(long)}. A diferença é que o atributo email é utilizado como parametro de apagamento.
     *
     * @param email Atributo email de um {@link model.Usuario}.
     * @return A quantidade de registros apagados.
     */
    public int deleteByEmail(String email){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try{

            String delete = "delete from usuario where email = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(delete);

            preparedStatement.setString(1, email);

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