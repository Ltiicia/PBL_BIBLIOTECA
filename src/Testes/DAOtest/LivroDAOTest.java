package Testes.DAOtest;
import Model.Livro;
import DAO.DAO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LivroDAOTest { //revisar

    Livro l, m, n;

    @BeforeEach
    void setUp() {
        l = new Livro("test", "joao", "editora", "1234", 2000, "abc", "Exemplo", 10);
        m = new Livro("test", "joao", "editora", "1", 2000, "abc", "Exemplo", 10);
        n = new Livro("test", "maria", "editora", "12", 2000, "abc", "Exemplo", 10);
        DAO.getLivroDAO().create(l);
        DAO.getLivroDAO().create(m);
        DAO.getLivroDAO().create(n);
    }

    @Test
    void create() {
        DAO.getLivroDAO().create(new Livro("a", "a", "a", 54321, 2000, "o", "Prateleira", 10));
        assertEquals(l, DAO.getLivroDAO().findById(l.getIsbn()));
        assertEquals(4, DAO.getLivroDAO().findMany().size());
    }

    @Test
    void delete() {

        assertEquals(3, DAO.getLivroDAO().findMany().size());
        DAO.getLivroDAO().delete(m);

        assertEquals(2, DAO.getLivroDAO().findMany().size());
        assertNull(DAO.getLivroDAO().findById(m.getIsbn()));
    }

    @Test
    void update() {
        assertEquals(l, DAO.getLivroDAO().findById(l.getIsbn()));
        l.setAnoPublicacao(2010);
        DAO.getLivroDAO().update(l);
        assertEquals(2010, DAO.getLivroDAO().findById(l.getIsbn()).getAnoPublicacao());
    }

    @Test
    void findMany() {
        assertEquals(3, DAO.getLivroDAO().findMany().size());
        assertEquals(l, DAO.getLivroDAO().findMany().get(2));
        assertEquals(m, DAO.getLivroDAO().findMany().get(0));
        assertEquals(n, DAO.getLivroDAO().findMany().get(1));
    }

    @Test
    void findById() throws LivroException {
        assertEquals(l, DAO.getLivroDAO().findById(l.getIsbn()));
    }

    @Test
    void findTitulo() throws LivroException {
        assertEquals(DAO.getLivroDAO().findMany(), DAO.getLivroDAO().findTitulo("test"));
        assertEquals(DAO.getLivroDAO().findMany(), DAO.getLivroDAO().findTitulo("te"));
        assertTrue(DAO.getLivroDAO().findTitulo("abc").isEmpty());

        Livro o = DAO.getLivroDAO().create(new Livro("Dom Casmurro", "maria", "editora", "125",
                2000, "abc", "Exemplo",10));
        assertEquals(DAO.getLivroDAO().findTitulo("Dom").get(0), o);
        assertEquals(DAO.getLivroDAO().findTitulo("dom").get(0), o);
        assertEquals(DAO.getLivroDAO().findTitulo("DOM").get(0), o);
    }

    @Test
    void findCategoria() {
        DAO.getLivroDAO().create(l);
        DAO.getLivroDAO().create(m);
        assertEquals(l, DAO.getLivroDAO().findCategoria("Exemplo").get(0));
        assertEquals(m, DAO.getLivroDAO().findCategoria("Exemplo").get(1));
    }

    @Test
    void findByAutor() {
        DAO.getLivroDAO().create(n);
        assertEquals(n, DAO.getLivroDAO().findAutor("maria").get(0));
    }

}
