package Testes.DAOtest;

import org.example.Model.Livro;
import org.example.DAO.DAO;
import org.example.Model.LocalizaLivro;
import org.junit.jupiter.api.Test;

import java.time.Year;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LivroDAOTest {

    Year ano = Year.parse("2010");
    private final LocalizaLivro localizacao = new LocalizaLivro("1", "4", "12");
    private final Livro livro = new Livro("Percy Jackson", "Rick Riordan", "Intrinseca",
            "1564913", ano, "Aventura", localizacao, 1);

    @Test
    public void testAdicionaLivro() throws Exception {
        DAO.getLivroDAO().create(this.livro);

        assertFalse(DAO.getLivroDAO().findMany().isEmpty()); // verifica se a lista de livros está vazia
    }

    @Test
    public void testFindByIsbn() throws Exception {
        assertNotNull(DAO.getLivroDAO().findByIsbn("1564913")); // verifica se é encontrado um livro pelo isbn
    }

    @Test
    public void findTitulo() throws Exception {
        // verifica se o livro adicionando é o mesmo que foi encontrado pelo título
        for (Livro livros : DAO.getLivroDAO().findTitulo("Percy Jackson")) {
            assertEquals(livros.getTitulo(), this.livro.getTitulo());
        }
    }

    @Test
    public void findAutor() throws Exception {
        // verifica se o livro adicionando é o mesmo que foi encontrado pelo autor
        for (Livro livros : DAO.getLivroDAO().findAutor("Rick Riordan")) {
            assertEquals(livros.getAutor(), this.livro.getAutor());
        }
    }

    @Test
    public void findCategoria() throws Exception {
        // verifica se o livro adicionando é o mesmo que foi encontrado pelo autor
        for (Livro livros : DAO.getLivroDAO().findCategoria("Aventura")) {
            assertEquals(livros.getCategoria(), this.livro.getCategoria());
        }
    }

    @Test
    public void testUpdateLivro() throws Exception {
        // CRIANDO LIVRO DIFERENTE
        Year ano = Year.parse("2010");
        Livro livroAlterado = new Livro("Percy Jackson", "Rick Riordan", "Intrinseca",
                "1564913", ano, "Aventura", localizacao, 2);

        // ATUALIZANDO
        DAO.getLivroDAO().update(livroAlterado);

        boolean livroTest = DAO.getLivroDAO().findByIsbn("1564913");

        assertNotEquals(this.livro, livroTest); // asserta que os objetos são diferentes
    }

    @Test
    public void testDeleteBook() throws Exception {
        DAO.getLivroDAO().deleteMany();
        assertTrue(DAO.getLivroDAO().findMany().isEmpty());
    }
}