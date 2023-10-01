package Model;

import DAO.Emprestimo.EmprestimoDAOImpl;
import DAO.Livro.LivroDAO;
import DAO.Livro.LivroDAOImpl;
import Excecao.EmprestimoExcecao;
import Excecao.LivroExcecao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Relatorios {
    LivroDAOImpl livros = new LivroDAOImpl();
    EmprestimoDAOImpl emprestimos = new EmprestimoDAOImpl();
    private List<Livro> livrosEmprestados; //armazena todos livros que estão emprestados no momento
    private List<Livro> livrosAtrasados; //armazena todos livros que estão atrasados no momento
    private List<Livro> livrosReservados; //armazena todos livros que já estão reservados no momento

    public Relatorios() {
        this.livrosEmprestados = new ArrayList<>();
        this.livrosAtrasados = new ArrayList<>();
        this.livrosReservados = new ArrayList<>();
    }

    public void guardaLivrosEmprestados(Livro livro) {
        livrosEmprestados.add(livro);
    }

    public void tiraLivrosEmprestados(Livro livro) {
        livrosAtrasados.remove(livro);
    }


    public int quantidadeLivrosEmprestados() throws LivroExcecao {
        if (livrosEmprestados.isEmpty()) {
            throw new LivroExcecao(LivroExcecao.NoBorrowedBooks);
        } else {
            return livrosEmprestados.size();
        }
    }


    public List<Livro> geraLivrosEmprestados() throws LivroExcecao {
        if (livrosEmprestados.isEmpty()) {
            throw new LivroExcecao(LivroExcecao.NoBorrowedBooks);
        } else {
            return livrosEmprestados;
        }
    }

    public List<Livro> geraLivrosAtrasados() throws LivroExcecao {
        Map<Long, Emprestimo> emprestimoMap = emprestimos.getEmprestimoMap();
        for (Emprestimo emprestimo : emprestimoMap.values()) {
            LocalDate now = LocalDate.now();
            if (now.isAfter(Emprestimo.getDataDevolucao())) {
                livrosAtrasados.add(emprestimo.getLivro());
            }
        }
        if (livrosAtrasados.isEmpty()) {
            throw new LivroExcecao(LivroExcecao.NoLateBooks);
        } else {
            return livrosAtrasados;
        }
    }
    public int quantidadeLivrosAtrasados() throws LivroExcecao {
        if (livrosAtrasados.isEmpty()) {
            throw new LivroExcecao(LivroExcecao.NoLateBooks);
        } else {
            return livrosAtrasados.size();
        }
    }


    public List<Livro> geraReservos() {
        Map<String, Livro> livroMap = livros.getLivroMap();
        for (Livro livro : livroMap.values()) {
            if (!livro.getReservaFila().isEmpty()) {
                livrosReservados.add(livro);
            }
        }
        return livrosReservados;
    }

    public int quantidadeReservados() throws LivroExcecao {
        if (livrosReservados.isEmpty()) {
            throw new LivroExcecao(LivroExcecao.NoReservedBooks);
        } else {
            return livrosReservados.size();
        }
    }

    public List<Livro> geraLivroPopular() throws EmprestimoExcecao {
        int maiorValor = 0;
        List<Livro> livroPopular = null;
        Map<String, Livro> livroMap = livros.getLivroMap();
        for (Livro livro : livroMap.values()) {
            int valor = livro.getQuantidadeEmprestimo();
            if (valor == 0) {
                maiorValor = 0;
            } else if (valor >= maiorValor) {
                maiorValor = valor;
                livroPopular.add(livro);
            }
        }
        if (livroPopular == null) {
            throw new EmprestimoExcecao(EmprestimoExcecao.NoLoan);
        } else {
            return livroPopular;
        }
    }

    public List<Emprestimo> geraPessoaEmprestimo(Leitor Leitor) throws EmprestimoExcecao {
        List<Emprestimo> emprestimoHistorico = null;
        Map<Long, Emprestimo> emprestimoMap = emprestimos.getEmprestimoMap();
        long idLeitor = Leitor.getId();
        for (Emprestimo emprestimo : emprestimoMap.values()) {
            if (idLeitor == emprestimo.getIdLeitor()) {
                emprestimoHistorico.add(emprestimo);
            }
        }
        if (emprestimoHistorico == null) {
            throw new EmprestimoExcecao(EmprestimoExcecao.NoUserLoan);
        } else {
            return emprestimoHistorico;
        }}
}