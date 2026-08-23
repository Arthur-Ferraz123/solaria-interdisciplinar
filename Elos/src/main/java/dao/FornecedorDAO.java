package dao;

import conexao.Conexao;

import model.Fornecedor;

import java.sql.Connection;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.util.List;

import java.util.ArrayList;

import static enums.ErrosGerais.REGISTRO_NAO_ENCONTRADO;

public class FornecedorDAO implements GenericDAO<Fornecedor> {

    @Override
    public int insert(Fornecedor fornecedor){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try{

            String insert = "insert into fornecedor(id_usuario, tipo_usuario, tipo_fornecedor, cnpj, razao_social) values(?, ?, ?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(insert);

            preparedStatement.setLong(1, fornecedor.getIdUsuario() );
            preparedStatement.setString(2, fornecedor.getTipoUsuario());
            preparedStatement.setString(3, fornecedor.getTipoFornecedor());
            preparedStatement.setString(4, fornecedor.getCnpj());
            preparedStatement.setString(5, fornecedor.getRazaoSocial() );

            return preparedStatement.executeUpdate();

        }catch (Exception exception){

            return classificarErro(exception);

        } finally {

            conexao.desconectar();

        }

    }

    @Override
    public Fornecedor readById(long id){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try {

            String read = "select * from fornecedor where id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(read);

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

            return new Fornecedor(REGISTRO_NAO_ENCONTRADO.getCodigo(), REGISTRO_NAO_ENCONTRADO.getCodigo(), null, null, null, null);

        } catch (Exception exception){

            return null;

        } finally {

            conexao.desconectar();

        }

    }

    public Fornecedor readByIdUsuario(long idUsuario){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try {

            String read = "select * from fornecedor where id_usuario = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(read);

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

            return new Fornecedor(REGISTRO_NAO_ENCONTRADO.getCodigo(), REGISTRO_NAO_ENCONTRADO.getCodigo(), null, null, null, null);

        } catch (Exception exception){

            return null;

        } finally {

            conexao.desconectar();

        }

    }

    public Fornecedor readByCnpj(String cnpj){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try {

            String read = "select * from fornecedor where cnpj = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(read);

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

            return new Fornecedor(REGISTRO_NAO_ENCONTRADO.getCodigo(), REGISTRO_NAO_ENCONTRADO.getCodigo(), null, null, null, null);


        } catch (Exception exception){

            return null;

        } finally {

            conexao.desconectar();

        }

    }

    @Override
    public List<Fornecedor> readAll(){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();
        List<Fornecedor> fornecedores = new ArrayList<>();

        try {

            String read = "select * from fornecedor";

            PreparedStatement preparedStatement = connection.prepareStatement(read);

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

            return fornecedores;

        } finally {

            conexao.desconectar();

        }

    }

    public List<Fornecedor> readAllByTipoFornecedor(String tipoFornecedor){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();
        List<Fornecedor> fornecedores = new ArrayList<>();

        try {

            String read = "select * from fornecedor where tipo_fornecedor = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(read);

            preparedStatement.setString(1, tipoFornecedor);

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

            return fornecedores;

        } finally {

            conexao.desconectar();

        }

    }

    @Override
    public int updateById(Fornecedor fornecedor){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try{

            String update = "update fornecedor set tipo_fornecedor = ?, razao_social =  where id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(update);

            preparedStatement.setString(1, fornecedor.getTipoFornecedor() );
            preparedStatement.setString(2, fornecedor.getRazaoSocial() );
            preparedStatement.setLong(3, fornecedor.getId());

            return preparedStatement.executeUpdate();

        }catch (Exception exception){

            return classificarErro(exception);

        } finally {

            conexao.desconectar();

        }

    }

    public int updateByIdUsuario(Fornecedor fornecedor){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try{

            String update = "update fornecedor set tipo_fornecedor = ?, razao_social =  where id_usuario = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(update);

            preparedStatement.setString(1, fornecedor.getTipoFornecedor() );
            preparedStatement.setString(2, fornecedor.getRazaoSocial() );
            preparedStatement.setLong(3, fornecedor.getIdUsuario());

            return preparedStatement.executeUpdate();

        }catch (Exception exception){

            return classificarErro(exception);

        } finally {

            conexao.desconectar();

        }

    }

    public int updateByCnpj(Fornecedor fornecedor){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try{

            String update = "update fornecedor set tipo_fornecedor = ?, razao_social =  where cnpj = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(update);

            preparedStatement.setString(1, fornecedor.getTipoFornecedor() );
            preparedStatement.setString(2, fornecedor.getRazaoSocial() );
            preparedStatement.setString(3, fornecedor.getCnpj());

            return preparedStatement.executeUpdate();

        }catch (Exception exception){

            return classificarErro(exception);

        } finally {

            conexao.desconectar();

        }

    }

    @Override
    public int deleteById(long id){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try{

            String delete = "delete from fornecedor where id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(delete);

            preparedStatement.setLong(1, id);

            return preparedStatement.executeUpdate();

        }catch (Exception exception){

            return classificarErro(exception);

        } finally {

            conexao.desconectar();

        }

    }

    public int deleteByIdUsuario(long idUsuario){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try{

            String delete = "delete from fornecedor where id_usuario = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(delete);

            preparedStatement.setLong(1, idUsuario);

            return preparedStatement.executeUpdate();

        }catch (Exception exception){

            return classificarErro(exception);

        } finally {

            conexao.desconectar();

        }

    }

    public int deleteByCnpj(String cnpj){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try{

            String delete = "delete from fornecedor where cnpj = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(delete);

            preparedStatement.setString(1, cnpj);

            return preparedStatement.executeUpdate();

        }catch (Exception exception){

            return classificarErro(exception);

        } finally {

            conexao.desconectar();

        }

    }

}