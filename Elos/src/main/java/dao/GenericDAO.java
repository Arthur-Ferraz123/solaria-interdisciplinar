package dao;

import java.util.List;

public interface GenericDAO<T> {

    public int insert(T objeto);

    public T readById(long id);

    public List<T> readAll();

    public int updateById(T objeto);

    public int deleteById(long id);

}
