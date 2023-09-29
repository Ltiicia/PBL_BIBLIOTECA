package DAO.Emprestimo;
import Model.Emprestimo;
import DAO.CRUD;
import Model.Leitor;

import java.util.List;


public interface EmprestimoDAO extends CRUD<Emprestimo, Exception> {
    public Emprestimo returnEmprestimo(Emprestimo emprestimo);

    //public List<Emprestimo> findByLeitor(Leitor leitor);
}