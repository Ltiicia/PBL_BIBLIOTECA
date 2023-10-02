package Testes.Modeltest;

import DAO.DAO;
import Excecao.EmprestimoExcecao;
import Excecao.LivroExcecao;
import Model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class BibliotecarioTest {
    private Bibliotecario bibliotecario;
    private Leitor leitor;
    private LocalizaLivro localizacao;
    private Livro livro;

    @BeforeEach
    public void setUp() {
        // Configurando objetos para teste
        bibliotecario = new Bibliotecario("Nome do Bibliotecário", 1, "1234", 12, "9945-8695", "la");
        leitor = new Leitor("Nome", 2, "5678", 75,"75 98765-3210","Ali");
        localizacao = new LocalizaLivro("Prateleira", "Seção", "corredor");
        livro = new Livro("Título", "Autor", "Editora","ISBN156", 2023, "Categoria", localizacao, 1);
    }

    @Test
    public void testRegistroLivro() {
        bibliotecario.registroLivro("Percy Jackson", "Rick Riordan", "Intrinseca",
                "1564913", 2010, "Aventura", localizacao, 4);

        assertNotNull(DAO.getLivroDAO().findById("1564913")); // verifica se o pesquisar por id retorna o livro cadastrado
    }

    @Test
    public void testRegistroLivroDuplo() {
        bibliotecario.registroLivro("Percy Jackson", "Rick Riordan", "Intrinseca",
                "1564913", 2010, "Aventura", localizacao, 1);

        // Registrando livro igual com quantidade diferente
        bibliotecario.registroLivro("Percy Jackson", "Rick Riordan", "Intrinseca",
                "1564913", 2010, "Aventura", localizacao, 4);

        assertSame(5, DAO.getLivroDAO().findById("1564913").getQuantidadeDisponivel());
    }

    @Test
    public void testRegistroEmprestimo() throws LivroExcecao, EmprestimoExcecao {
        // Garantindo que o livro está disponível
        livro.setQuantidadeDisponivel(1);
        // Garantindo de que o leitor não está bloqueado
        leitor.block = false;
        // Bibliotecário registra o empréstimo
        bibliotecario.registroEmprestimo(leitor, livro);

        assertEquals(0, livro.getQuantidadeDisponivel()); // verificando que o livro não está mais disponível
    }

    @Test
    public void testRegistroDevolucao() {
        // Configurando um empréstimo ativo
        Emprestimo ativoEmprestimo = new Emprestimo(1, leitor.getId(), livro, LocalDate.now(), LocalDate.now().plusDays(7));
        ativoEmprestimo.setAtivo(true);
        livro.setQuantidadeDisponivel(livro.getQuantidadeDisponivel() - 1);

        bibliotecario.registroDevolucao(ativoEmprestimo, leitor);

        assertFalse(ativoEmprestimo.getAtivo()); // Verificando que o empréstimo não está mais ativo
    }
}
