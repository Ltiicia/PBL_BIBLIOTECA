package Model;

import Model.Livro;

import java.util.Date;

public class LocalizaLivro extends Livro {
    private String prateleira;
    private String sessao;
    private String corredor;

    public LocalizaLivro(String titulo, String autor, String editora, String isbn, Date anoPublicacao, String categoria, String prateleira, String sessao, String corredor) {
        super(titulo, autor, editora, isbn, anoPublicacao, categoria);
        this.prateleira = prateleira;
        this.sessao = sessao;
        this.corredor = corredor;
    }

    // Métodos getter para acessar os atributos da localização
    public String getPrateleira() {
        return prateleira;
    }

    public String getSessao() {
        return sessao;
    }

    public String getCorredor() {
        return corredor;
    }

    // Métodos setter para definir os atributos da localização (caso seja necessário)
    public void setPrateleira(String prateleira) {
        this.prateleira = prateleira;
    }

    public void setSessao(String sessao) {
        this.sessao = sessao;
    }

    public void setCorredor(String corredor) {
        this.corredor = corredor;
    }

    @Override
    public String toString() {
        return super.toString() + ", Prateleira: " + prateleira + ", Sessão: " + sessao + ", Corredor: " + corredor;
    }
}