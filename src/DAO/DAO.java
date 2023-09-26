package DAO;

import Model.Livro;
import DAO.Livro.LivroDAO;
import DAO.Livro.LivroDAOImpl;

import DAO.Emprestimo.EmprestimoDAO;
import DAO.Emprestimo.EmprestimoDAOImpl;
import Model.Emprestimo;

public class DAO {
    private static LivroDAO livroDAO;
    //private static PessoaDAO pessoaDAO;
    private static EmprestimoDAO emprestimoDAO;

    public static LivroDAO getLivroDAO(){
        if (livroDAO == null) {
            livroDAO = new LivroDAOImpl();
        }
        return livroDAO;
    }

   /* public static PessoaDAO getUserDAO(){
        if (PessoaDAO == null){
            PessoaDAO = new PessoaDAOImpl();
        }
        return pessoaDAO;
    }*/

    public static EmprestimoDAO getEmprestimoDAO() {
        if(emprestimoDAO == null) {
            emprestimoDAO = new EmprestimoDAOImpl();
        }
        return emprestimoDAO;
    }

}
