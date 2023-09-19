package DAO;

import java.util.List;

public interface CRUD <T>{

    public T create(T obj);

    public void delete(T obj);

    public T update(T obj);

    public List<T> findMany(); //retorna lista de obj

    public T findById(int id); // retorna um obj

}