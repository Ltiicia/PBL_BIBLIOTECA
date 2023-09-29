package DAO.Emprestimo;
import Model.Emprestimo;
import DAO.CRUD;


public interface EmprestimoDAO extends CRUD<Emprestimo, Exception> {
    public Emprestimo returnEmprestimo(Emprestimo emprestimo);
}