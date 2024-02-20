package org.example.Model;

import org.example.Arquivo.Arquivos;
import org.example.DAO.Emprestimo.EmprestimoDAOArq;
import org.example.DAO.Livro.LivroDAOArq;
import org.example.Excecao.EmprestimoExcecao;
import org.example.Excecao.LivroExcecao;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * A classe serve para armazenar dados para
 * gerar os relatorios do sistema, contendo
 * atributos como livros emprestados, livros atrasados,
 * e livros reservados.
 * Contém métodos para gerar os dados dos
 * livros que estão emprestados, atrasados e reservados, e
 * métodos para gerar o historico de um usuario especifico
 * e pegar o livro mais popular.
 *
 * @author Letícia Gonçalves e Helena Filemon
 */
public class Relatorios {

    File arquivo;
    LivroDAOArq livros = new LivroDAOArq();
    EmprestimoDAOArq emprestimos = new EmprestimoDAOArq();
    private List<Livro> livrosEmprestados; //armazena livros que estão emprestados
    private List<Livro> livrosAtrasados; //armazena livros que estão atrasados
    private List<Livro> livrosReservados; //armazena livros que já estão reservados


    public Relatorios() {
        this.livrosEmprestados = new ArrayList<>();
        this.livrosAtrasados = new ArrayList<>();
        this.livrosReservados = new ArrayList<>();
    }

    /**
     * Guarda os livros emprestados em uma lista
     * @param livro livro
     */
    public void guardaLivrosEmprestados(Livro livro) {
        livrosEmprestados.add(livro);
    }

    /**
     * Remove o livro da lista emprestados
     * @param livro livro
     */
    public void tiraLivrosEmprestados(Livro livro) {
        livrosAtrasados.remove(livro);
    }

    /**
     * Retorna a quantidade de livros emprestados
     * @return quantidade livros emprestados
     * @throws LivroExcecao
     */
    public int quantidadeLivrosEmprestados() throws LivroExcecao {
        if (livrosEmprestados.isEmpty()) {
            throw new LivroExcecao(LivroExcecao.SemLivrosEmprestados);
        } else {
            return livrosEmprestados.size();
        }
    }

    /**
     * Retorna lista de livros emprestados
     * @return lista de emprestados
     * @throws LivroExcecao
     */
    public List<Livro> geraLivrosEmprestados() throws LivroExcecao {
        if (livrosEmprestados.isEmpty()) {
            throw new LivroExcecao(LivroExcecao.SemLivrosEmprestados);
        } else {
            return livrosEmprestados;
        }
    }

    /**
     * Retorna lista de livros atrasados
     * @return lista de atrasados
     * @throws LivroExcecao exceção de livro
     */
    public List<Livro> geraLivrosAtrasados() throws LivroExcecao {
        Map<Long, Emprestimo> emprestimoMap = emprestimos.getEmprestimoMap();
        for (Emprestimo emprestimo : emprestimoMap.values()) {
            LocalDate now = LocalDate.now();
            if (now.isAfter(emprestimo.getDataDevolucao())) {
                livrosAtrasados.add(emprestimo.getLivro());
            }
        }
        if (livrosAtrasados.isEmpty()) {
            throw new LivroExcecao(LivroExcecao.SemLivrosAtrasados);
        } else {
            return livrosAtrasados;
        }
    }

    /**
     * Gera quantidade de livros atrasdos
     * @return quantidade de atrasados
     * @throws LivroExcecao
     */
    public int quantidadeLivrosAtrasados() throws LivroExcecao {
        if (livrosAtrasados.isEmpty()) {
            throw new LivroExcecao(LivroExcecao.SemLivrosAtrasados);
        } else {
            return livrosAtrasados.size();
        }
    }

    /**
     * Retorna lista de livros reservados
     * @return lista de reservados
     */
    public List<Livro> geraReservos() {
        Map<String, Livro> livroMap = findManyMap();
        for (Livro livro : livroMap.values()) {
            if (!livro.getReservaFila().isEmpty()) {
                livrosReservados.add(livro);
            }
        }
        return livrosReservados;
    }

    private Map<String, Livro> findManyMap() {
        return Arquivos.consultarArquivoMap(arquivo);
    }

    /**
     * Gera quantidade de livros reservados
     * @return quantidade de reservados
     * @throws LivroExcecao Exceção de livro
     */
    public int quantidadeReservados() throws LivroExcecao {
        if (livrosReservados.isEmpty()) {
            throw new LivroExcecao(LivroExcecao.SemLivrosReservados);
        } else {
            return livrosReservados.size();
        }
    }

    /**
     * Retorna lista dos livros mais emprestados
     * @return livros populares
     * @throws EmprestimoExcecao Exceção emprestimo
     */
    public List<Livro> geraLivroPopular() throws EmprestimoExcecao {
        int maiorValor = 0;
        List<Livro> livroPopular = null;
        Map<String, Livro> livroMap = livros.findManyMap();
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
            throw new EmprestimoExcecao(EmprestimoExcecao.SemEmprestimo);
        } else {
            return livroPopular;
        }
    }

    /**
     * Gera o historico de emprestimos de uma pessoa especifica
     * @param Leitor leitor
     * @return historico do leitor
     * @throws EmprestimoExcecao Exceção emprestimo
     */
    public List<Emprestimo> geraPessoaEmprestimo(Leitor Leitor) throws EmprestimoExcecao {
        List<Emprestimo> emprestimoHistorico = null;
        Map<Long, Emprestimo> emprestimoMap = emprestimos.getEmprestimoMap();
        String cpf = Leitor.getCpf();
        for (Emprestimo emprestimo : emprestimoMap.values()) {
            if ((cpf) == emprestimo.getCpf()) {
                emprestimoHistorico.add(emprestimo);
            }
        }
        if (emprestimoHistorico == null) {
            throw new EmprestimoExcecao(EmprestimoExcecao.UsuarioSemEmprestimo);
        } else {
            return emprestimoHistorico;
        }}
}