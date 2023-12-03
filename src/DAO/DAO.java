package DAO;


import DAO.ADM.ADMDAO;
import DAO.ADM.ADMDAOArq;
import DAO.Bibliotecario.BibliotecarioDAO;
import DAO.Bibliotecario.BibliotecarioDAOArq;
import DAO.Emprestimo.EmprestimoDAOArq;
import DAO.Leitor.LeitorDAO;
import DAO.Leitor.LeitorDAOArq;
import DAO.Livro.LivroDAO;
import DAO.Livro.LivroDAOArq;

import DAO.Emprestimo.EmprestimoDAO;


import DAO.Relatorios.RelatoriosDAO;
import DAO.Relatorios.RelatoriosDAOArq;

/*A classe DAO é usada para acessar os objetos DAO nas classes específicas.
Para facilitar o acesso e tornar o código mais fácil de manter.
Podendo usá-lo para acessar os dados do cliente.*/

public class DAO {
    public static LivroDAO livroDAO;
    private static RelatoriosDAO relatoriosDAO;
    private static EmprestimoDAO emprestimoDAO;

    private static BibliotecarioDAO bibliotecarioDAO;

    private static ADMDAO admDAO;
    private static LeitorDAO leitorDAO;


    public static LivroDAO getLivroDAO() {
        if (livroDAO == null) {
            livroDAO = new LivroDAOArq();
        }
        return livroDAO;
    }

    public static RelatoriosDAO getRelatoriosDAO() {
        if (relatoriosDAO == null) {
            relatoriosDAO = new RelatoriosDAOArq();
        }
        return relatoriosDAO;
    }

    public static EmprestimoDAO getEmprestimoDAO() {
        if (emprestimoDAO == null) {
            emprestimoDAO = new EmprestimoDAOArq();
        }
        return emprestimoDAO;
    }

    public static BibliotecarioDAO getBibliotecarioDAO() {
        if (bibliotecarioDAO == null) {
            bibliotecarioDAO = new BibliotecarioDAOArq();
        }
        return bibliotecarioDAO;
    }

    public static ADMDAO getAdmDAO(){
        if(admDAO == null){
            admDAO = new ADMDAOArq();
        }
        return admDAO;
    }

    public static LeitorDAO getLeitorDAO(){
        if(leitorDAO == null){
            leitorDAO = new LeitorDAOArq();
        }
        return leitorDAO;
    }
}
