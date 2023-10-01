package DAO.Emprestimo;
import Model.Emprestimo;
import DAO.CRUD;
import Model.Leitor;

import java.util.List;
import java.util.Map;


public interface EmprestimoDAO extends CRUD<Emprestimo, Exception> {
    public Map<Long, Emprestimo> getEmprestimoMap();
    public long getProxId();
}