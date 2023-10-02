package DAO.Leitor;

import DAO.CRUD;
import Model.Leitor;

import java.util.Map;

public interface LeitorDAO extends CRUD<Leitor> {

    //Interface DAO da Classe Leitor
    //Contem os Metodos de CRUD alem dos próprios
    public Map<Long, Leitor> getLeitorMap();
    public long getProxId();
}
