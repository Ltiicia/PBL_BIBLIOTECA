package org.example.DAO.Emprestimo;
import org.example.Model.Emprestimo;
import org.example.DAO.CRUD;

import java.util.HashMap;


public interface EmprestimoDAO extends CRUD<Emprestimo> {

    //Interface DAO da Classe Emprestimo
    //Contem os Metodos de CRUD alem dos próprios
    public HashMap<Integer, Emprestimo> getEmprestimoMap();
    public int getProxId();

    Emprestimo findId(int id)//retorna o emprestimo por id
    ;
}