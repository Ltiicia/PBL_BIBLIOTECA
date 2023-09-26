package DAO.Emprestimo;
import Model.Emprestimo;
import DAO.CRUD;


public interface EmprestimoDAO extends CRUD<Emprestimo> {
    public Emprestimo returnEmprestimo(Emprestimo emprestimo);
}