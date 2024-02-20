package Testes.DAOtest;

import org.example.Model.Livro;
import org.example.DAO.DAO;
import org.example.Model.LocalizaLivro;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LivroDAOTest {

    private final LocalizaLivro localizacao = new LocalizaLivro("1", "4", "12");
    private final Livro livro = new Livro("Percy Jackson", "Rick Riordan", "Intrinseca",
            "1564913", 2010, "Aventura", localizacao, 1);

    @Test
    public void testAdicionaLivro() {
        DAO.getLivroDAO().create(this.livro);

        assertFalse(DAO.getLivroDAO().findMany().isEmpty()); // verifica se a lista de livros está vazia
    }

    @Test
    public void testFindByIsbn() {
        assertNotNull(DAO.getLivroDAO().findByIsbn("1564913")); // verifica se é encontrado um livro pelo isbn
    }

    @Test
    public void findTitulo() {
        // verifica se o livro adicionando é o mesmo que foi encontrado pelo título
        for (Livro livros : DAO.getLivroDAO().findTitulo("Percy Jackson")) {
            assertEquals(livros.getTitulo(), this.livro.getTitulo());
        }
    }

    @Test
    public void findAutor() {
        // verifica se o livro adicionando é o mesmo que foi encontrado pelo autor
        for (Livro livros : DAO.getLivroDAO().findAutor("Rick Riordan")) {
            assertEquals(livros.getAutor(), this.livro.getAutor());
        }
    }

    @Test
    public void findCategoria() {
        // verifica se o livro adicionando é o mesmo que foi encontrado pelo autor
        for (Livro livros : DAO.getLivroDAO().findCategoria("Aventura")) {
            assertEquals(livros.getCategoria(), this.livro.getCategoria());
        }
    }

    @Test
    public void testUpdateLivro() {
        // CRIANDO LIVRO DIFERENTE
        Livro livroAlterado = new Livro("Percy Jackson", "Rick Riordan", "Intrinseca",
                "1564913", 2010, "Aventura", localizacao, 2);

        // ATUALIZANDO
        DAO.getLivroDAO().update(livroAlterado);

        Livro livroTest = DAO.getLivroDAO().findByIsbn("1564913");

        assertNotEquals(this.livro, livroTest); // asserta que os objetos são diferentes
    }

    @Test
    public void testDeleteBook() {
        DAO.getLivroDAO().deleteMany();
        assertTrue(DAO.getLivroDAO().findMany().isEmpty());
    }
}