package Testes.Modeltest;

import org.example.Excecao.EmprestimoExcecao;
import org.example.Model.Emprestimo;
import org.example.Model.Leitor;
import org.example.Model.Livro;
import org.example.Model.LocalizaLivro;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class LeitorTest {
    private Leitor leitor;
    private LocalizaLivro localizacao;
    private Livro livro;
    private LocalDate dateLoan;
    private LocalDate dateDevolution;

    @BeforeEach
    public void setUp() {
        leitor = new Leitor("Nome", 1, "123", 20, "xx xxxxx-xxxx", "Ali");
        localizacao = new LocalizaLivro("Prateleira", "Seção", "Corredor");
        livro = new Livro("Titulo", "Autor", "Editora","ISBN157", 2023, "Categoria", localizacao, 1);
        dateLoan = LocalDate.now();
        dateDevolution = dateLoan.plusDays(7);
    }

    @Test
    public void testDesbloqueiaComAtraso() {
        leitor.bloqueiaLeitor(leitor); // definindo leitor previamente como bloqueado
        leitor.prazo = LocalDate.now().minusDays(1); // Data de vencimento expirada
        boolean taBlock = leitor.desbloqueia(leitor);

        assertFalse(taBlock); // Deve retornar false após a chamada ao método
    }

    @Test
    public void testDesbloqueiaSemAtraso() {
        leitor.bloqueiaLeitor(leitor); // definindo leitor previamente como bloqueado
        leitor.prazo = LocalDate.now().plusDays(1); // Data de vencimento futura
        boolean taBlock = leitor.desbloqueia(leitor);

        assertTrue(taBlock); // Deve retornar true após a chamada ao método
    }

    @Test
    public void testDesbloqueiaSemVencimento() {
        leitor.prazo = null; // Sem data de vencimento da multa
        boolean taBlock = leitor.desbloqueia(leitor);

        assertFalse(taBlock); // Deve retornar false após a chamada ao método
    }

    @Test
    public void testRenovaEmprestimo() throws EmprestimoExcecao {
        Emprestimo emprestimo = new Emprestimo(1, 1, livro, dateLoan, dateDevolution);
        emprestimo.setAtivo(false);

        try {
            leitor.renova_emprestimo(leitor, emprestimo, livro);
        } catch (EmprestimoExcecao e) {
            // Verifique se a exceção tem a mensagem correta.
            assertEquals(EmprestimoExcecao.EmprestimoFinalizado, e.getMessage());
        }
    }

    @Test
    public void testRenovaComReservaFila() {
        Emprestimo emprestimo = new Emprestimo(1, 1, livro, dateLoan, dateDevolution);
        emprestimo.setAtivo(true);

        // Garantindo que a fila não está vazia
        Leitor l = new Leitor("Nome",2, "S12348", 25, "xx xxxxx-xxxx", "ALI");
        livro.getReservaFila().add(l);

        try {
            leitor.renova_emprestimo(leitor,emprestimo, livro);
        } catch (EmprestimoExcecao e) {
            assertEquals(EmprestimoExcecao.FilaEmprestimo, e.getMessage());
        }
    }



}
