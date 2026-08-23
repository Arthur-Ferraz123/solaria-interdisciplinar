package dao;

import java.sql.SQLException;
import java.util.List;

import static enums.ErrosGerais.ERRO_POR_VIOLACAO_DE_REGRA_DO_BD;
import static enums.ErrosGerais.ERRO_GENERICO_NO_BD;
import static enums.ErrosGerais.ERRO_GENERICO;

public interface GenericDAO<T> {

    //Métodos de assinatura
    public int insert(T objeto);

    public T readById(long id);

    public List<T> readAll();

    public int updateById(T objeto);

    public int deleteById(long id);

    //Método para realizar a validação de exceções dos métodos de insert, update e delete
    default public int classificarErro(Exception exception){

        if (exception instanceof SQLException){

            SQLException sqlException = (SQLException) exception;

            String codigoSQLException = sqlException.getSQLState();

            //Verificação se a exceção foi causada por uma constraint violada ou por tamanho inválido.
            //A verificação ocorre usando o código das exceções relacionadas a elas no PostgreSQL.
            if ("23502".equals(codigoSQLException) ||
                "23503".equals(codigoSQLException) ||
                "23505".equals(codigoSQLException) ||
                "23514".equals(codigoSQLException) ||
                "22001".equals(codigoSQLException) ){

                return ERRO_POR_VIOLACAO_DE_REGRA_DO_BD.getCodigo();
            }

            return ERRO_GENERICO_NO_BD.getCodigo();

        }

        return ERRO_GENERICO.getCodigo();

    }

}