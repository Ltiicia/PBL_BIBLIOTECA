package Testes.DAOtest;

import Model.LocalizaLivro;
import org.junit.jupiter.api.BeforeEach;

import java.time.LocalDate;
import DAO.DAO;
import Model.Leitor;
import Model.Livro;
import Model.Emprestimo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EmprestimoDAOTest {

    private LocalizaLivro localizacao;
    private Livro livro;
    private Emprestimo emprestimo1;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;

    @BeforeEach
    public void setUp() {
        // Configurando objetos para teste
        localizacao = new LocalizaLivro("Estante", "Sessao", "Corredor");
        livro = new Livro("Título", "Autor", "Editora","ISBN1234", 2023, "Categoria", localizacao, 1);
        dataEmprestimo = LocalDate.now();
        dataDevolucao = dataEmprestimo.plusDays(7);
        emprestimo1 = new Emprestimo(7, 23, livro, dataEmprestimo, dataDevolucao);
    }

    @Test
    public void testAddEmprestimo() {
        LocalDate dataEmprestimo = LocalDate.now(); //diz a data do dia atual ou seja, a data do emprestimo
        LocalDate dataDevolucao = dataEmprestimo.plusDays(7); // Calcule a data de devolução (10 dias a partir da data de empréstimo)
        Emprestimo emprestimo = new Emprestimo(9, 23, livro, dataEmprestimo, dataDevolucao);

        DAO.getEmprestimoDAO().create(emprestimo);
        assertFalse(DAO.getEmprestimoDAO().findMany().isEmpty()); // verifica se a lista está vazia
    }

    @Test
    public void testFindById() {
        assertNotNull(DAO.getEmprestimoDAO().findById(9)); // verifica se é encontrado um livro pelo isbn
    }

    @Test
    public void testUpdateEmprestimo() {
        // Salvando um empréstimo no DAO
        DAO.getEmprestimoDAO().create(emprestimo1);

        // Atualizando o empréstimo cujo número de identificação é igual a 7
        Emprestimo emprestimo2 = new Emprestimo(7, 23, livro, dataEmprestimo, dataDevolucao);
        DAO.getEmprestimoDAO().update(emprestimo2);

        // Pegando o retorno que a busca por ID retorna para fins de comparação
        Emprestimo emprestimoTest = DAO.getEmprestimoDAO().findById(7);

        assertNotEquals(emprestimo1, emprestimoTest); // asserta que o conteúdo dos objetos são diferentes
    }

    @Test
    public void testDeleteEmprestimo() {
        // Salvando um empréstimo no DAO
        DAO.getEmprestimoDAO().create(emprestimo1);

        // Deletando empréstimo
        DAO.getEmprestimoDAO().delete(emprestimo1);

        for (Emprestimo obj : DAO.getEmprestimoDAO().findMany()) {
            assertNotSame(obj, emprestimo1);
        }
    }

    @Test
    public void testDeleteMany() {
        // Salvando um empréstimo no DAO
        DAO.getEmprestimoDAO().create(emprestimo1);
        // Deletando toda a lista de empréstimos
        DAO.getEmprestimoDAO().deleteMany();

        assertTrue(DAO.getEmprestimoDAO().findMany().isEmpty());
    }
}
