package org.example.DAO.Bibliotecario;

import org.example.DAO.CRUD;
import org.example.Model.Bibliotecario;

import java.util.Map;

public interface BibliotecarioDAO extends CRUD<Bibliotecario> {

    //Interface DAO da Classe Bibliotecario
    //Contem os metodos de CRUD alem dos próprios

    public Map<String, Bibliotecario> getBibliotecarioMap();
}