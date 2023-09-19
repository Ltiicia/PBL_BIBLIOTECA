package Model;
import Pessoa.Pessoa;

import java.util.Date;

public class Emprestimo {
    private Date dataEmprestimo;
    private Pessoa usuario;
    private Livro livro;
    private Date dataPrevistaDevolucao;
    private String situacao;

    public Emprestimo(Date dataEmprestimo, Pessoa usuario, Livro livro, Date dataPrevistaDevolucao, String situacao) {
        this.dataEmprestimo = dataEmprestimo;
        this.usuario = usuario;
        this.livro = livro;
        this.dataPrevistaDevolucao = dataPrevistaDevolucao;
        this.situacao = situacao;
    }

    public Date getDataEmprestimo() {
        return dataEmprestimo;
    }

    public Pessoa getUsuario() {
        return usuario;
    }

    public Livro getLivro() {
        return livro;
    }

    public Date getDataPrevistaDevolucao() {
        return dataPrevistaDevolucao;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
    // Método para remover o livro do acervo
    public void removeDoAcervo() {
        // Lógica para remover o livro do acervo da biblioteca
        Biblioteca.getInstance().removerLivro(livro);
    }
}
