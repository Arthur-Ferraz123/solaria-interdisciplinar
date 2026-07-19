package dao;

import conexao.Conexao;

import model.Fornecedor;

import model.PlacaSolar;

import java.sql.Connection;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.util.List;

import java.util.ArrayList;

/**
 * Classe responsável pelo DAO da entidade placa_solar
 *
 * @author Eduardo Vicente Bisneto
 * @version 1.0.0
 */
public class PlacaSolarDAO implements GenericDAO<PlacaSolar> {

    @Override
    public int insert(PlacaSolar placaSolar){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try{

            String insert = "insert into placa_solar(id_fornecedor, modelo, sku, tecnologia, dimensoes, em_estoque, potencia, fabricante, peso, grau_protecao, eficiencia, descricao) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(insert);

            preparedStatement.setLong(1, placaSolar.getIdFornecedor() );
            preparedStatement.setString(2, placaSolar.getModelo());
            preparedStatement.setString(3, placaSolar.getSku());
            preparedStatement.setString(4, placaSolar.getTecnologia() );
            preparedStatement.setString(5, placaSolar.getDimensoes() );
            preparedStatement.setBoolean(6, placaSolar.isEmEstoque() );
            preparedStatement.setDouble(7, placaSolar.getPotencia() );
            preparedStatement.setString(8, placaSolar.getFabricante() );
            preparedStatement.setDouble(9, placaSolar.getPeso() );
            preparedStatement.setString(10, placaSolar.getGrauProtecao() );
            preparedStatement.setDouble(11, placaSolar.getEficiencia() );
            preparedStatement.setString(12, placaSolar.getDescricao() );

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
    public PlacaSolar readById(long id){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try {

            String readById = "select * from placa_solar where id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(readById);

            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){

                return new PlacaSolar(
                        resultSet.getLong("id"),
                        resultSet.getLong("id_fornecedor"),
                        resultSet.getString("modelo"),
                        resultSet.getString("sku"),
                        resultSet.getString("tecnologia"),
                        resultSet.getString("dimensoes"),
                        resultSet.getBoolean("em_estoque"),
                        resultSet.getDouble("potencia"),
                        resultSet.getString("fabricante"),
                        resultSet.getDouble("peso"),
                        resultSet.getString("grau_protecao"),
                        resultSet.getDouble("eficiencia"),
                        resultSet.getString("descricao")
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
    public List<PlacaSolar> readAll(){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();
        List<PlacaSolar> placaSolares = new ArrayList<>();

        try {

            String readAll = "select * from placa_solar";

            PreparedStatement preparedStatement = connection.prepareStatement(readAll);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){

                placaSolares.add(new PlacaSolar(
                        resultSet.getLong("id"),
                        resultSet.getLong("id_fornecedor"),
                        resultSet.getString("modelo"),
                        resultSet.getString("sku"),
                        resultSet.getString("tecnologia"),
                        resultSet.getString("dimensoes"),
                        resultSet.getBoolean("em_estoque"),
                        resultSet.getDouble("potencia"),
                        resultSet.getString("fabricante"),
                        resultSet.getDouble("peso"),
                        resultSet.getString("grau_protecao"),
                        resultSet.getDouble("eficiencia"),
                        resultSet.getString("descricao")
                ));

            }

            return placaSolares;

        } catch (Exception exception){

            return null;

        } finally {

            conexao.desconectar();

        }

    }

    /**
     * Variação do {@link #readAll}. A diferença é que o atributo idFornecedor é utilizado como parametro de filtragem.
     *
     * @param idFornecedor Valor do atributo idFornecedor das {@link model.PlacaSolar} que se buscam.
     * @return Todos os dados registrados de todas as PlacaSolar encontradas.
     */
    public List<PlacaSolar> readAllByIdFornecedor(long idFornecedor){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();
        List<PlacaSolar> placaSolares = new ArrayList<>();

        try {

            String readAll = "select * from placa_solar where id_fornecedor = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(readAll);

            preparedStatement.setLong(1, idFornecedor);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){

                placaSolares.add(new PlacaSolar(
                        resultSet.getLong("id"),
                        resultSet.getLong("id_fornecedor"),
                        resultSet.getString("modelo"),
                        resultSet.getString("sku"),
                        resultSet.getString("tecnologia"),
                        resultSet.getString("dimensoes"),
                        resultSet.getBoolean("em_estoque"),
                        resultSet.getDouble("potencia"),
                        resultSet.getString("fabricante"),
                        resultSet.getDouble("peso"),
                        resultSet.getString("grau_protecao"),
                        resultSet.getDouble("eficiencia"),
                        resultSet.getString("descricao")
                ));

            }

            return placaSolares;

        } catch (Exception exception){

            return null;

        } finally {

            conexao.desconectar();

        }

    }

    @Override
    public int update(PlacaSolar placaSolar){

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();

        try{

            String update = "update placa_solar set modelo = ?, sku = ?, tecnologia = ?, dimensoes = ?, em_estoque = ?, potencia = ?, fabricante = ?, peso = ?, grau_protecao = ?, eficiencia = ?, descricao = ?  where id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(update);

            preparedStatement.setString(1, placaSolar.getModelo() );
            preparedStatement.setString(2, placaSolar.getSku() );
            preparedStatement.setString(3, placaSolar.getTecnologia() );
            preparedStatement.setString(4, placaSolar.getDimensoes() );
            preparedStatement.setBoolean(5, placaSolar.isEmEstoque() );
            preparedStatement.setDouble(6, placaSolar.getPotencia() );
            preparedStatement.setString(7, placaSolar.getFabricante() );
            preparedStatement.setDouble(8, placaSolar.getPeso() );
            preparedStatement.setString(9, placaSolar.getGrauProtecao() );
            preparedStatement.setDouble(10, placaSolar.getEficiencia() );
            preparedStatement.setString(11, placaSolar.getDescricao() );
            preparedStatement.setLong(12, placaSolar.getId());

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

            String delete = "delete from placa_solar where id = ?";

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