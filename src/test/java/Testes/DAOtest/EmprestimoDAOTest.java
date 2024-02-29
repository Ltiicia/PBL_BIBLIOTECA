package Testes.DAOtest;

import org.example.Model.Leitor;
import org.example.Model.LocalizaLivro;
import org.junit.jupiter.api.BeforeEach;

import java.time.LocalDate;
import java.time.Year;

import org.example.DAO.DAO;
import org.example.Model.Livro;
import org.example.Model.Emprestimo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EmprestimoDAOTest {

    private LocalizaLivro localizacao;
    private Livro livro;
    private Leitor leitor;
    private Emprestimo emprestimo1;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;

    @BeforeEach
    public void setUp() {
        // Configurando objetos para teste

        Year ano = Year.parse("2023");
        localizacao = new LocalizaLivro("Estante", "Sessao", "Corredor");
        livro = new Livro("Título", "Autor", "Editora","ISBN1234", ano, "Categoria", localizacao, 1);
        leitor = new Leitor("leitor", "nome", "123", "20", "1234", "ali");
        dataEmprestimo = LocalDate.now();
        dataDevolucao = dataEmprestimo.plusDays(7);
        emprestimo1 = new Emprestimo(livro, "23", leitor);
    }

    @Test
    public void testAddEmprestimo() throws Exception {
        LocalDate dataEmprestimo = LocalDate.now(); //diz a data do dia atual ou seja, a data do emprestimo
        LocalDate dataDevolucao = dataEmprestimo.plusDays(7); // Calcule a data de devolução (10 dias a partir da data de empréstimo)
        Emprestimo emprestimo = new Emprestimo(livro, "23", leitor);

        DAO.getEmprestimoDAO().create(emprestimo);
        assertFalse(DAO.getEmprestimoDAO().findMany().isEmpty()); // verifica se a lista está vazia
    }

    @Test
    public void testFindById() throws Exception {
        assertNotNull(DAO.getEmprestimoDAO().findById("9")); // verifica se é encontrado um livro pelo isbn
    }

    @Test
    public void testUpdateEmprestimo() throws Exception {
        // Salvando um empréstimo no DAO
        DAO.getEmprestimoDAO().create(emprestimo1);

        // Atualizando o empréstimo cujo número de identificação é igual a 7
        Emprestimo emprestimo2 = new Emprestimo(livro, "23", leitor);
        DAO.getEmprestimoDAO().update(emprestimo2);

        // Pegando o retorno que a busca por ID retorna para fins de comparação
        Emprestimo emprestimoTest = DAO.getEmprestimoDAO().findById("7");

        assertNotEquals(emprestimo1, emprestimoTest); // asserta que o conteúdo dos objetos são diferentes
    }

    @Test
    public void testDeleteEmprestimo() throws Exception {
        // Salvando um empréstimo no DAO
        DAO.getEmprestimoDAO().create(emprestimo1);

        // Deletando empréstimo
        DAO.getEmprestimoDAO().delete(emprestimo1);

        for (Emprestimo obj : DAO.getEmprestimoDAO().findMany()) {
            assertNotSame(obj, emprestimo1);
        }
    }

    @Test
    public void testDeleteMany() throws Exception {
        // Salvando um empréstimo no DAO
        DAO.getEmprestimoDAO().create(emprestimo1);
        // Deletando toda a lista de empréstimos
        DAO.getEmprestimoDAO().deleteMany();

        assertTrue(DAO.getEmprestimoDAO().findMany().isEmpty());
    }
}
