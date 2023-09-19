package Model;

import java.util.Date;

public class Devolucao {
    private Date dataDevolucao;
    private Pessoa usuario;
    private Livro livro;
    private Date dataPrevistaDevolucao;
    private String situacao;

    public Devolucao(Date dataDevolucao, Pessoa usuario, Livro livro, Date dataPrevistaDevolucao, String situacao) {
        this.dataDevolucao = dataDevolucao;
        this.usuario = usuario;
        this.livro = livro;
        this.dataPrevistaDevolucao = dataPrevistaDevolucao;
        this.situacao = situacao;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
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

    // Método para incluir o livro no acervo após a devolução
    public void incluirLivroNoAcervo() {
        // Lógica para adicionar o livro de volta ao acervo da biblioteca
        Biblioteca.getInstance().adicionarLivro(livro);
    }
}
