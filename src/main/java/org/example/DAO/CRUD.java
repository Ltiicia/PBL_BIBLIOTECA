package org.example.DAO;

import java.io.File;
import java.util.List;

public interface CRUD <T>{

    //Interface que contem os métodos utilizados nas interfaces DAO
    public T create(T obj);

    public void delete(T obj);

    public T update(T obj);
    public boolean findByCPFIsTrue(String cpf);

    public List<T> findMany(); //retorna lista de obj

    public T findById(String cpf); // retorna um obj
    public void deleteMany();
}