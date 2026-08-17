package dao;

import conexao.Conexao;

import model.Usuario;

import java.sql.Connection;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.util.List;

import java.util.ArrayList;

public class UsuarioDAO implements GenericDAO<Usuario> {

    @Override
    public int insert(Usuario usuario){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try{

        String insert = "insert into usuario(email, senha, nome, tipo_usuario, raio_procura_km) values(?, ?, ?, ?, ?)";

        PreparedStatement preparedStatement = connection.prepareStatement(insert);

        preparedStatement.setString(1, usuario.getEmail() );
        preparedStatement.setString(2, usuario.getSenha());
        preparedStatement.setString(3, usuario.getNome());
        preparedStatement.setString(4, usuario.getTipoUsuario());
        preparedStatement.setDouble(5, usuario.getRaioProcuraKm());

        return preparedStatement.executeUpdate();


        }catch (Exception exception){

            return descobrirErro(exception);

        } finally {

            conexao.desconectar();

        }

    }

    @Override
    public Usuario readById(long id){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try {

            String read = "select * from usuario where id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(read);

            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){

                return new Usuario(
                        resultSet.getLong("id"),
                        resultSet.getString("email"),
                        resultSet.getString("senha"),
                        resultSet.getString("nome"),
                        resultSet.getString("tipo_usuario"),
                        resultSet.getDouble("raio_procura_km")
                );

            }

            return new Usuario(REGISTRO_NAO_ENCONTRADO, null, null, null, null, REGISTRO_NAO_ENCONTRADO);

        } catch (Exception exception){

            return null;

        } finally {

            conexao.desconectar();

        }

    }

    public Usuario readByEmail(String email){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try {

            String read = "select * from usuario where email = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(read);

            preparedStatement.setString(1, email);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){

                return new Usuario(
                        resultSet.getLong("id"),
                        resultSet.getString("email"),
                        resultSet.getString("senha"),
                        resultSet.getString("nome"),
                        resultSet.getString("tipo_usuario"),
                        resultSet.getDouble("raio_procura_km")
                );

            }

            return new Usuario(REGISTRO_NAO_ENCONTRADO, null, null, null, null, REGISTRO_NAO_ENCONTRADO);

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

            String read = "select * from usuario";

            PreparedStatement preparedStatement = connection.prepareStatement(read);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){

                 usuarios.add(new Usuario(
                        resultSet.getLong("id"),
                        resultSet.getString("email"),
                        resultSet.getString("senha"),
                        resultSet.getString("nome"),
                        resultSet.getString("tipo_usuario"),
                        resultSet.getDouble("raio_procura_km")
                ));

            }

            return usuarios;

        } catch (Exception exception){

            return null;

        } finally {

            conexao.desconectar();

        }

    }

    public List<Usuario> readAllbyTipoUsuario(String tipoUsuario){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();
        List<Usuario> usuarios = new ArrayList<>();

        try {

            String read = "select * from usuario where tipo_usuario = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(read);

            preparedStatement.setString(1, tipoUsuario);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){

                usuarios.add(new Usuario(
                        resultSet.getLong("id"),
                        resultSet.getString("email"),
                        resultSet.getString("senha"),
                        resultSet.getString("nome"),
                        resultSet.getString("tipo_usuario"),
                        resultSet.getDouble("raio_procura_km")
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
    public int updateById(Usuario usuario){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try{

            String update = "update usuario set email = ?, senha = ?, nome = ?, raio_procura_km = ? where id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(update);

            preparedStatement.setString(1, usuario.getEmail() );
            preparedStatement.setString(2, usuario.getSenha() );
            preparedStatement.setString(3, usuario.getNome() );
            preparedStatement.setDouble(4, usuario.getRaioProcuraKm());
            preparedStatement.setLong(5, usuario.getId());

            return preparedStatement.executeUpdate();

        }catch (Exception exception){

            return descobrirErro(exception);

        } finally {

            conexao.desconectar();

        }

    }

    public int updateByEmail(Usuario usuario){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try{

            String update = "update usuario set senha = ?, nome = ?, raio_procura_km = ? where email = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(update);

            preparedStatement.setString(1, usuario.getSenha() );
            preparedStatement.setString(2, usuario.getNome() );
            preparedStatement.setDouble(3, usuario.getRaioProcuraKm());
            preparedStatement.setString(4, usuario.getEmail());

            return preparedStatement.executeUpdate();

        }catch (Exception exception){

            return descobrirErro(exception);

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

        }catch (Exception exception){

            return descobrirErro(exception);

        } finally {

            conexao.desconectar();

        }

    }

    public int deleteByEmail(String email){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try{

            String delete = "delete from usuario where email = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(delete);

            preparedStatement.setString(1, email);

            return preparedStatement.executeUpdate();

        }catch (Exception exception){

            return descobrirErro(exception);

        } finally {

            conexao.desconectar();

        }

    }

}