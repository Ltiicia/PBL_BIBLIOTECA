package org.example.DAO.Emprestimo;
import org.example.Model.Emprestimo;
import org.example.DAO.CRUD;

import java.util.Map;


public interface EmprestimoDAO extends CRUD<Emprestimo> {

    //Interface DAO da Classe Emprestimo
    //Contem os Metodos de CRUD alem dos próprios
    public Map<Long, Emprestimo> getEmprestimoMap();
    public long getProxId();
}