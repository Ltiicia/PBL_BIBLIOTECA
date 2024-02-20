package org.example.DAO.Leitor;

import org.example.DAO.CRUD;
import org.example.Model.Leitor;

import java.util.Map;

public interface LeitorDAO extends CRUD<Leitor> {

    //Interface DAO da Classe Leitor
    //Contem os Metodos de CRUD alem dos próprios
    public Map<String, Leitor> getLeitorMap();
}
