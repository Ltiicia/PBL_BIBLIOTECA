package Testes.DAOtest;

import org.junit.jupiter.api.BeforeEach;

import java.time.LocalDate;
import DAO.DAO;
import Model.Leitor;
import Model.Livro;
import Model.Emprestimo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class EmprestimoDAOTest {

    Emprestimo esperado;
    Leitor leitor;
    Livro livro;
    @BeforeEach
    void setUp() {
        leitor = DAO.getLeitorDAO().create(new Leitor("Fulano", 1654, "123", 165, "7599-6541", "Rua canal, Tomba", true, leitor.prazo));
        livro = DAO.getLivroDAO().create(new Livro("a", "a",
                "a", 12354, 1999, "a", livro.getLocalizacao(), 10));
        esperado = DAO.getEmprestimoDAO().create(new Emprestimo(165, leitor.getId(), livro, esperado.getDataEmprestimo(), esperado.getDataDevolucao(),esperado.getAtivo(), esperado.getRenovacaoQuantidade()));
    }

    @Test
    void create() {

        Emprestimo atual = new Emprestimo(165, leitor.getId(), livro, LocalDate.now(), LocalDate.now().plusDays(7),esperado.getAtivo(), esperado.getRenovacaoQuantidade());
        atual.setIdEmprestimo(esperado.getIdEmprestimo());
        assertEquals(atual, esperado);
        assertEquals(atual, DAO.getEmprestimoDAO().findById(+ atual.getIdEmprestimo()));
    }

    @Test
    void delete() {
        DAO.getEmprestimoDAO().delete(esperado);
        assertEquals(0, DAO.getEmprestimoDAO().findMany().size());
        assertNull(DAO.getEmprestimoDAO().findById( + esperado.getIdEmprestimo()));
    }

    void update() {
        assertEquals(esperado, DAO.getEmprestimoDAO().findById( + esperado.getIdEmprestimo()));
        esperado.setLivro(livro);
        DAO.getEmprestimoDAO().update(esperado);
        assertEquals(livro, DAO.getEmprestimoDAO().findById( +  esperado.getIdEmprestimo()).getLivro());
    }

    void findMany() {
        assertEquals(1, DAO.getEmprestimoDAO().findMany().size());
    }

    @Test
    void findByID() {
        assertEquals(esperado, DAO.getEmprestimoDAO().findById( + esperado.getIdEmprestimo()));
    }


}
