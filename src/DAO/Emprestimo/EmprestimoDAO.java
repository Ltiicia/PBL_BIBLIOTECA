package DAO.Pessoa;
import Model.Pessoa;
import DAO.CRUD;


public interface Emprestimo extends CRUD<Emprestimo> {
    public Emprestimo returnEmprestimo(Emprestimo emprestimo);
}