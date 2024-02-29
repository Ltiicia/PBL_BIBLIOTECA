package Testes.Modeltest;

import org.example.DAO.DAO;
import org.example.Excecao.EmprestimoExcecao;
import org.example.Excecao.LivroExcecao;
import org.example.Model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Year;

import static org.junit.jupiter.api.Assertions.*;

public class BibliotecarioTest {
    private Bibliotecario bibliotecario;
    private Leitor leitor;
    private LocalizaLivro localizacao;
    private Livro livro;

    @BeforeEach
    public void setUp() throws Exception {
        Year ano = Year.parse("2023");
        // Configurando objetos para teste
        bibliotecario = new Bibliotecario("Bibliotecário", "nome", "1234", "12", "9945-8695", "la");
        leitor = new Leitor("leito", "nome", "5678", "75","75 98765-3210","Ali");
        localizacao = new LocalizaLivro("Prateleira", "Seção", "corredor");
        livro = new Livro("Título", "Autor", "Editora","ISBN156", ano, "Categoria", localizacao, 1);
    }

    @Test
    public void testRegistroLivro() throws Exception {
        Year ano = Year.parse("2010");
        bibliotecario.registroLivro("Percy Jackson", "Rick Riordan", "Intrinseca",
                "1564913", ano, "Aventura", localizacao, 4);

        assertNotNull(DAO.getLivroDAO().findByIsbn("1564913")); // verifica se o pesquisar por id retorna o livro cadastrado
    }


    @Test
    public void testRegistroLivroDuplo() throws Exception {
        Year ano = Year.parse("2010");
        bibliotecario.registroLivro("Percy Jackson", "Rick Riordan", "Intrinseca",
                "1564913", ano, "Aventura", localizacao, 1);

        // Registrando livro igual com quantidade diferente
        bibliotecario.registroLivro("Percy Jackson", "Rick Riordan", "Intrinseca",
                "1564913", ano, "Aventura", localizacao, 4);

        assertSame(5, DAO.getLivroDAO().findByIsbn("1564913"));
    }

    @Test
    public void testRegistroEmprestimo() throws Exception {
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
        Emprestimo ativoEmprestimo = new Emprestimo(livro, "23", leitor);
        ativoEmprestimo.setAtivo(true);
        livro.setQuantidadeDisponivel(livro.getQuantidadeDisponivel() - 1);

        bibliotecario.registroDevolucao(ativoEmprestimo, leitor);

        assertFalse(ativoEmprestimo.getAtivo()); // Verificando que o empréstimo não está mais ativo
    }
}
