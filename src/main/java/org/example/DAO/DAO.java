package org.example.DAO;


import org.example.DAO.ADM.ADMDAO;
import org.example.DAO.ADM.ADMDAOArq;
import org.example.DAO.Bibliotecario.BibliotecarioDAO;
import org.example.DAO.Bibliotecario.BibliotecarioDAOArq;
import org.example.DAO.Emprestimo.EmprestimoDAOArq;
import org.example.DAO.Leitor.LeitorDAO;
import org.example.DAO.Leitor.LeitorDAOArq;
import org.example.DAO.Livro.LivroDAO;
import org.example.DAO.Livro.LivroDAOArq;

import org.example.DAO.Emprestimo.EmprestimoDAO;


import org.example.DAO.Relatorios.RelatoriosDAO;
import org.example.DAO.Relatorios.RelatoriosDAOArq;

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


    public static LivroDAO getLivroDAO() throws Exception {
        if (livroDAO == null) {
            livroDAO = new LivroDAOArq();
        }
        return livroDAO;
    }

    public static RelatoriosDAO getRelatoriosDAO() throws Exception {
        if (relatoriosDAO == null) {
            relatoriosDAO = new RelatoriosDAOArq();
        }
        return relatoriosDAO;
    }

    public static EmprestimoDAO getEmprestimoDAO() throws Exception {
        if (emprestimoDAO == null) {
            emprestimoDAO = new EmprestimoDAOArq();
        }
        return emprestimoDAO;
    }

    public static BibliotecarioDAO getBibliotecarioDAO() throws Exception {
        if (bibliotecarioDAO == null) {
            bibliotecarioDAO = new BibliotecarioDAOArq();
        }
        return bibliotecarioDAO;
    }

    public static ADMDAO getAdmDAO() throws Exception {
        if(admDAO == null){
            admDAO = new ADMDAOArq();
        }
        return admDAO;
    }

    public static LeitorDAO getLeitorDAO() throws Exception {
        if(leitorDAO == null){
            leitorDAO = new LeitorDAOArq();
        }
        return leitorDAO;
    }
}
