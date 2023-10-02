package DAO.Bibliotecario;

import DAO.CRUD;
import Model.Bibliotecario;

import java.util.Map;

public interface BibliotecarioDAO extends CRUD<Bibliotecario>{

    //Interface DAO da Classe Bibliotecario
    //Contem os metodos de CRUD alem dos próprios
    public long getProxId();

    public Map<Long, Bibliotecario> getBibliotecarioMap();
}