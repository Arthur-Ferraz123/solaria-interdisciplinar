package dao;

import conexao.Conexao;

import model.Profissional;

import java.sql.Connection;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.util.List;

import java.util.ArrayList;

import static enums.ErrosGerais.REGISTRO_NAO_ENCONTRADO;

public class ProfissionalDAO implements GenericDAO<Profissional> {

    @Override
    public int insert(Profissional profissional){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try{

            String insert = "insert into profissional(id_usuario, tipo_usuario, profissao, cpf, id_fornecedor) values(?, ?, ?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(insert);

            preparedStatement.setLong(1, profissional.getIdUsuario() );
            preparedStatement.setString(2, profissional.getTipoUsuario());
            preparedStatement.setString(3, profissional.getProfissao());
            preparedStatement.setString(4, profissional.getCpf());
            preparedStatement.setLong(5, profissional.getIdFornecedor() );

            return preparedStatement.executeUpdate();

        }catch (Exception exception){

            return classificarErro(exception);

        } finally {

            conexao.desconectar();

        }

    }

    @Override
    public Profissional readById(long id){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try {

            String read = "select * from profissional where id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(read);

            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){

                return new Profissional(
                        resultSet.getLong("id"),
                        resultSet.getLong("id_usuario"),
                        resultSet.getString("tipo_usuario"),
                        resultSet.getString("profissao"),
                        resultSet.getString("cpf"),
                        resultSet.getLong("id_fornecedor")
                );

            }

            return new Profissional(REGISTRO_NAO_ENCONTRADO.getCodigo(), REGISTRO_NAO_ENCONTRADO.getCodigo(), null, null, null, REGISTRO_NAO_ENCONTRADO.getCodigo());

        } catch (Exception exception){

            return null;

        } finally {

            conexao.desconectar();

        }

    }

    public Profissional readByIdUsuario(long idUsuario){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try {

            String read = "select * from profissional where id_usuario = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(read);

            preparedStatement.setLong(1, idUsuario);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){

                return new Profissional(
                        resultSet.getLong("id"),
                        resultSet.getLong("id_usuario"),
                        resultSet.getString("tipo_usuario"),
                        resultSet.getString("profissao"),
                        resultSet.getString("cpf"),
                        resultSet.getLong("id_fornecedor")
                );

            }

            return new Profissional(REGISTRO_NAO_ENCONTRADO.getCodigo(), REGISTRO_NAO_ENCONTRADO.getCodigo(), null, null, null, REGISTRO_NAO_ENCONTRADO.getCodigo());

        } catch (Exception exception){

            return null;

        } finally {

            conexao.desconectar();

        }

    }

    public Profissional readByCpf(String cpf){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try {

            String read = "select * from profissional where cpf = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(read);

            preparedStatement.setString(1, cpf);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){

                return new Profissional(
                        resultSet.getLong("id"),
                        resultSet.getLong("id_usuario"),
                        resultSet.getString("tipo_usuario"),
                        resultSet.getString("profissao"),
                        resultSet.getString("cpf"),
                        resultSet.getLong("id_fornecedor")
                );

            }

            return new Profissional(REGISTRO_NAO_ENCONTRADO.getCodigo(), REGISTRO_NAO_ENCONTRADO.getCodigo(), null, null, null, REGISTRO_NAO_ENCONTRADO.getCodigo());

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
        List<Profissional> profissionais = new ArrayList<>();

        try {

            String read = "select * from profissional";

            PreparedStatement preparedStatement = connection.prepareStatement(read);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){

                profissionais.add(new Profissional(
                        resultSet.getLong("id"),
                        resultSet.getLong("id_usuario"),
                        resultSet.getString("tipo_usuario"),
                        resultSet.getString("profissao"),
                        resultSet.getString("cpf"),
                        resultSet.getLong("id_fornecedor")
                ));

            }

            return profissionais;

        } catch (Exception exception){

            return profissionais;

        } finally {

            conexao.desconectar();

        }

    }

    public List<Profissional> readAllByIdEmpresaTecnica(long idFornecedor){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();
        List<Profissional> profissionais = new ArrayList<>();

        try {

            String read = "select * from profissional where id_fornecedor = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(read);

            preparedStatement.setLong(1, idFornecedor);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){

                profissionais.add(new Profissional(
                        resultSet.getLong("id"),
                        resultSet.getLong("id_usuario"),
                        resultSet.getString("tipo_usuario"),
                        resultSet.getString("profissao"),
                        resultSet.getString("cpf"),
                        resultSet.getLong("id_fornecedor")
                ));

            }

            return profissionais;

        } catch (Exception exception){

            return profissionais;

        } finally {

            conexao.desconectar();

        }

    }

    @Override
    public int updateById(Profissional profissional){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try{

            String update = "update profissional set profissao = ?, id_fornecedor = ? where id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(update);

            preparedStatement.setString(1, profissional.getProfissao() );
            preparedStatement.setLong(2, profissional.getIdFornecedor() );
            preparedStatement.setLong(3, profissional.getId());

            return preparedStatement.executeUpdate();

        }catch (Exception exception){

            return classificarErro(exception);

        } finally {

            conexao.desconectar();

        }

    }

    public int updateByIdUsuario(Profissional profissional){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try{

            String update = "update profissional set profissao = ?, id_fornecedor = ? where id_usuario = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(update);

            preparedStatement.setString(1, profissional.getProfissao() );
            preparedStatement.setLong(2, profissional.getIdFornecedor() );
            preparedStatement.setLong(3, profissional.getIdUsuario());

            return preparedStatement.executeUpdate();

        }catch (Exception exception){

            return classificarErro(exception);

        } finally {

            conexao.desconectar();

        }

    }

    public int updateByCpf(Profissional profissional){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try{

            String update = "update profissional set profissao = ?, id_fornecedor = ? where cpf = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(update);

            preparedStatement.setString(1, profissional.getProfissao() );
            preparedStatement.setLong(2, profissional.getIdFornecedor() );
            preparedStatement.setString(3, profissional.getCpf());

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

            String delete = "delete from profissional where id = ?";

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

            String delete = "delete from profissional where id_usuario = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(delete);

            preparedStatement.setLong(1, idUsuario);

            return preparedStatement.executeUpdate();

        }catch (Exception exception){

            return classificarErro(exception);

        } finally {

            conexao.desconectar();

        }

    }

    public int deleteByCpf(String cpf){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try{

            String delete = "delete from profissional where cpf = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(delete);

            preparedStatement.setString(1, cpf);

            return preparedStatement.executeUpdate();

        }catch (Exception exception){

            return classificarErro(exception);

        } finally {

            conexao.desconectar();

        }

    }

}