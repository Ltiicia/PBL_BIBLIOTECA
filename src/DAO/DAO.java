package DAO;


import DAO.ADM.ADMDAO;
import DAO.ADM.ADMDAOImpl;
import DAO.Bibliotecario.BibliotecarioDAO;
import DAO.Bibliotecario.BibliotecarioDAOImpl;
import DAO.Leitor.LeitorDAO;
import DAO.Leitor.LeitorDAOImpl;
import DAO.Livro.LivroDAO;
import DAO.Livro.LivroDAOImpl;

import DAO.Emprestimo.EmprestimoDAO;
import DAO.Emprestimo.EmprestimoDAOImpl;


import DAO.Relatorios.RelatoriosDAO;
import DAO.Relatorios.RelatoriosDAOImpl;

public class DAO {
    public static LivroDAO livroDAO;
    private static RelatoriosDAO relatoriosDAO;
    private static EmprestimoDAO emprestimoDAO;

    private static BibliotecarioDAO bibliotecarioDAO;

    private static ADMDAO admDAO;
    private static LeitorDAO leitorDAO;


    public static LivroDAO getLivroDAO() {
        if (livroDAO == null) {
            livroDAO = new LivroDAOImpl();
        }
        return livroDAO;
    }

    public static RelatoriosDAO getRelatoriosDAO() {
        if (relatoriosDAO == null) {
            relatoriosDAO = new RelatoriosDAOImpl();
        }
        return relatoriosDAO;
    }

    public static EmprestimoDAO getEmprestimoDAO() {
        if (emprestimoDAO == null) {
            emprestimoDAO = new EmprestimoDAOImpl();
        }
        return emprestimoDAO;
    }

    public static BibliotecarioDAO getBibliotecarioDAO() {
        if (bibliotecarioDAO == null) {
            bibliotecarioDAO = new BibliotecarioDAOImpl();
        }
        return bibliotecarioDAO;
    }

    public static ADMDAO getAdmDAO(){
        if(admDAO == null){
            admDAO = new ADMDAOImpl();
        }
        return admDAO;
    }

    public static LeitorDAO getLeitorDAO(){
        if(leitorDAO == null){
            leitorDAO = new LeitorDAOImpl();
        }
        return leitorDAO;
    }
}
