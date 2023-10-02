package DAO.Emprestimo;
import Model.Emprestimo;
import DAO.CRUD;
import Model.Leitor;

import java.util.List;
import java.util.Map;


public interface EmprestimoDAO extends CRUD<Emprestimo> {

    //Interface DAO da Classe Emprestimo
    //Contem os Metodos de CRUD alem dos próprios
    public Map<Long, Emprestimo> getEmprestimoMap();
    public long getProxId();
}