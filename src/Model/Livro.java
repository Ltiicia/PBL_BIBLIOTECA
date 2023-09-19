package Model;

import java.util.Date;

public class Livro {
    private String titulo;
    private String autor;
    private String editora;
    private int isbn;
    private Date anoPublicacao;
    private String categoria;
    private LocalizaLivro localizacao;

    private int quantidade;

    public Livro(String titulo, String autor, String editora, int isbn, Date anoPublicacao, String categoria, LocalizaLivro localizacao, int quantidade ) {
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
        this.isbn = isbn;
        this.anoPublicacao = anoPublicacao;
        this.categoria = categoria;
        this.localizacao = localizacao;
        this.quantidade = quantidade;
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
    public Integer getIsbn() {

        return isbn;
    }
    public Date getAnoPublicacao() {

        return anoPublicacao;
    }
    public String getCategoria() {

        return categoria;
    }
    public LocalizaLivro getLocalizacao(){
        return localizacao;
    }
    public int getQuantidade(){
        return quantidade;
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
    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }
    public void setAnoPublicacao(Date anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    public void setLocalizacao(LocalizaLivro localizacao){
        this.localizacao = localizacao;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void alterarTitulo(){

    }
    public void alterarAutor(){

    }
    public void alterarEditora(){

    }
    public void alterarIsbn(){

    }
    public void alterarAnoDePubli(){

    }
    public void alterarCategoria(){

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
                "localizacao:" + "corredor - " + localizacao.getCorredor() + ", prateleira - " + localizacao.getPrateleira() + ", sessao - " + localizacao.getSessao();

    }
}
