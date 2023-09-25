package DAO;

import Model.Livro;
import DAO.Livro.LivroDAOImpl;

import DAO.Emprestimo.EmprestimoDAO;
import DAO.Empresimo.EmprestimoDAOImpl;
import Model.Emprestimo;

public class DAO {
    private static LivroDAO livroDAO;
    //private static PessoaDAO pessoaDAO;
    //private static EmprestimoDAO emprestimoDAO;

    public static LivroDAO getBookDAO(){
        if (livroDAO == null) {
            livroDAO = new LivroDAO();
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
