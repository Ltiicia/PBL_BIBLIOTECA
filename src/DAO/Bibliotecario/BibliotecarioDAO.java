package DAO.Bibliotecario;

import DAO.CRUD;
import Model.Bibliotecario;

import java.util.Map;

public interface BibliotecarioDAO extends CRUD<Bibliotecario, Exception>{
    public long getProxId();

    public Map<Long, Bibliotecario> getBibliotecarioMap();
}