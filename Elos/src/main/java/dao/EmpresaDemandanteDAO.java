package dao;

import conexao.Conexao;

import model.EmpresaDemandante;

import java.sql.Connection;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.util.List;

import java.util.ArrayList;

public class EmpresaDemandanteDAO implements GenericDAO<EmpresaDemandante> {

    @Override
    public int insert(EmpresaDemandante empresaDemandante){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try{

            String insert = "insert into empresa_demandante(id_usuario, tipo_usuario, cnpj, razao_social, eh_mandante) values(?, ?, ?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(insert);

            preparedStatement.setLong(1, empresaDemandante.getIdUsuario() );
            preparedStatement.setString(2, empresaDemandante.getTipoUsuario());
            preparedStatement.setString(3, empresaDemandante.getCnpj());
            preparedStatement.setString(4, empresaDemandante.getRazaoSocial());
            preparedStatement.setBoolean(5, empresaDemandante.isEhMandante());

            return preparedStatement.executeUpdate();

        } catch (Exception exception){

            return descobrirErro(exception);

        } finally {

            conexao.desconectar();

        }

    }

    @Override
    public EmpresaDemandante readById(long id){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try {

            String read = "select * from empresa_demandante where id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(read);

            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){

                return new EmpresaDemandante(
                        resultSet.getLong("id"),
                        resultSet.getLong("id_usuario"),
                        resultSet.getString("tipo_usuario"),
                        resultSet.getString("cnpj"),
                        resultSet.getString("razao_social"),
                        resultSet.getBoolean("eh_mandante")
                );

            }

            return new EmpresaDemandante(REGISTRO_NAO_ENCONTRADO, REGISTRO_NAO_ENCONTRADO, null, null,
                                        null, false);

        } catch (Exception exception){

            return null;

        } finally {

            conexao.desconectar();

        }

    }

    public EmpresaDemandante readByIdUsuario(long idUsuario){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try {

            String read = "select * from empresa_demandante where id_usuario = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(read);

            preparedStatement.setLong(1, idUsuario);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){

                return new EmpresaDemandante(
                        resultSet.getLong("id"),
                        resultSet.getLong("id_usuario"),
                        resultSet.getString("tipo_usuario"),
                        resultSet.getString("cnpj"),
                        resultSet.getString("razao_social"),
                        resultSet.getBoolean("eh_mandante")
                );

            }

            return new EmpresaDemandante(REGISTRO_NAO_ENCONTRADO, REGISTRO_NAO_ENCONTRADO, null, null,
                    null, false);

        } catch (Exception exception){

            return null;

        } finally {

            conexao.desconectar();

        }

    }

    public EmpresaDemandante readByCnpj(String cnpj){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try {

            String read = "select * from empresa_demandante where cnpj = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(read);

            preparedStatement.setString(1, cnpj);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){

                return new EmpresaDemandante(
                        resultSet.getLong("id"),
                        resultSet.getLong("id_usuario"),
                        resultSet.getString("tipo_usuario"),
                        resultSet.getString("cnpj"),
                        resultSet.getString("razao_social"),
                        resultSet.getBoolean("eh_mandante")
                );

            }

            return new EmpresaDemandante(REGISTRO_NAO_ENCONTRADO, REGISTRO_NAO_ENCONTRADO, null, null,
                    null, false);

        } catch (Exception exception){

            return null;

        } finally {

            conexao.desconectar();

        }

    }

    @Override
    public List<EmpresaDemandante> readAll(){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();
        List<EmpresaDemandante> empresaDemandantes = new ArrayList<>();

        try {

            String read = "select * from empresa_demandante";

            PreparedStatement preparedStatement = connection.prepareStatement(read);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){

                empresaDemandantes.add(new EmpresaDemandante(
                        resultSet.getLong("id"),
                        resultSet.getLong("id_usuario"),
                        resultSet.getString("tipo_usuario"),
                        resultSet.getString("cnpj"),
                        resultSet.getString("razao_social"),
                        resultSet.getBoolean("eh_mandante")
                ));

            }

            return empresaDemandantes;

        } catch (Exception exception){

            return null;

        } finally {

            conexao.desconectar();

        }

    }

    @Override
    public int updateById(EmpresaDemandante empresaDemandante){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try{

            String update = "update empresa_demandante set razao_social = ? where id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(update);

            preparedStatement.setString(1, empresaDemandante.getRazaoSocial() );
            preparedStatement.setLong(2, empresaDemandante.getId());

            return preparedStatement.executeUpdate();

        } catch (Exception exception){

            return descobrirErro(exception);

        } finally {

            conexao.desconectar();

        }

    }

    public int updateByIdUsuario(EmpresaDemandante empresaDemandante){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try{

            String update = "update empresa_demandante set razao_social = ? where id_usuario = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(update);

            preparedStatement.setString(1, empresaDemandante.getRazaoSocial() );
            preparedStatement.setLong(2, empresaDemandante.getIdUsuario());

            return preparedStatement.executeUpdate();

        } catch (Exception exception){

            return descobrirErro(exception);

        } finally {

            conexao.desconectar();

        }

    }

    public int updateByCnpj(EmpresaDemandante empresaDemandante){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try{

            String update = "update empresa_demandante set razao_social = ? where cnpj = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(update);

            preparedStatement.setString(1, empresaDemandante.getRazaoSocial() );
            preparedStatement.setString(2, empresaDemandante.getCnpj());

            return preparedStatement.executeUpdate();

        } catch (Exception exception){

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

            String delete = "delete from empresaDemandante where id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(delete);

            preparedStatement.setLong(1, id);

            return preparedStatement.executeUpdate();

        }catch (Exception exception){

            return descobrirErro(exception);

        } finally {

            conexao.desconectar();

        }

    }

    public int deleteByIdUsuario(long idUsuario){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try{

            String delete = "delete from empresa_demandante where id_usuario = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(delete);

            preparedStatement.setLong(1, idUsuario);

            return preparedStatement.executeUpdate();

        }catch (Exception exception){

            return descobrirErro(exception);

        } finally {

            conexao.desconectar();

        }

    }

    public int deleteByCnpj(String cnpj){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try{

            String delete = "delete from empresa_demandante where cnpj = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(delete);

            preparedStatement.setString(1, cnpj);

            return preparedStatement.executeUpdate();

        }catch (Exception exception){

            return descobrirErro(exception);

        } finally {

            conexao.desconectar();

        }

    }

}