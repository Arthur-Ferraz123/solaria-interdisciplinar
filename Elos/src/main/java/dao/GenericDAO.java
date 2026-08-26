package dao;

import enums.ErrosDoSQL;

import java.sql.SQLException;
import java.util.List;

import static enums.ErrosGerais.ERRO_POR_VIOLACAO_DE_REGRA_DO_BD;
import static enums.ErrosGerais.ERRO_GENERICO_NO_BD;

public interface GenericDAO<T> {

    //Métodos de assinatura
    public int insert(T objeto);

    public T readById(long id);

    public List<T> readAll();

    public int updateById(T objeto);

    public int deleteById(long id);

}