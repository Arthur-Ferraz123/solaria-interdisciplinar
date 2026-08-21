package dao;

import java.sql.SQLException;
import java.util.List;

public interface GenericDAO<T> {

    //Constantes para auxilo de validação de erro
    public final int ERRO_POR_VIOLACAO_DE_CONSTRAINT_NO_BD = -1;

    public final int ERRO_GENERICO_NO_BD = -2;

    public final int ERRO_GENERICO = -3;

    public final long REGISTRO_NAO_ENCONTRADO = -4L;

    //Métodos de assinatura
    public int insert(T objeto);

    public T readById(long id);

    public List<T> readAll();

    public int updateById(T objeto);

    public int deleteById(long id);

    //Método para realizar a validação de exceções dos métodos de insert, update e delete
    default public int descobrirErro(Exception exception){

        if (exception instanceof SQLException){

            SQLException sqlException = (SQLException) exception;

            String codigoSQLException = sqlException.getSQLState();

            //Verificação se a exceção foi causada por uma constranint violada.
            //A verificação ocorre usando o código das exceções relacionadas a esse fator.
            if ("23502".equals(codigoSQLException) ||
                "23503".equals(codigoSQLException) ||
                "23505".equals(codigoSQLException) ||
                "23514".equals(codigoSQLException) ){

                return ERRO_POR_VIOLACAO_DE_CONSTRAINT_NO_BD;
            }

            return ERRO_GENERICO_NO_BD;

        }

        return ERRO_GENERICO;

    }

}