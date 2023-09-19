package Model;

import java.util.Date;

public class Livro {
    private String titulo;
    private String autor;
    private String editora;
    private String isbn;
    private Date anoPublicacao;
    private String categoria;

    public Livro(String titulo, String autor, String editora, String isbn, Date anoPublicacao, String categoria) {
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
        this.isbn = isbn;
        this.anoPublicacao = anoPublicacao;
        this.categoria = categoria;
    }

    // Métodos getter para acessar os atributos
    public String getTitulo() {
        return titulo;
    }
    public String getAutor() {
        return autor;
    }
    public String getEditora() {
        return editora;
    }
    public String getIsbn() {
        return isbn;
    }
    public Date getAnoPublicacao() {
        return anoPublicacao;
    }
    public String getCategoria() {
        return categoria;
    }

    // Métodos setter para definir os atributos (caso seja necessário)
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public void setEditora(String editora) {
        this.editora = editora;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public void setAnoPublicacao(Date anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    @Override
    public String toString() {
        return "Model.DAO.Livro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", editora='" + editora + '\'' +
                ", isbn='" + isbn + '\'' +
                ", anoPublicacao=" + anoPublicacao +
                ", categoria='" + categoria + '\'' +
                '}';
    }
}
