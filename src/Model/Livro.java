package Model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;

public class Livro {
    private String titulo;
    private String autor;
    private String editora;
    private String isbn;
    private int anoPublicacao;
    private String categoria;
    private LocalizaLivro localizacao;
    private int quantidadeDisponivel;
    private int quantidadetotal;
    private int quantidadeEmprestimo = 0;
    private Queue<Leitor> reservaFila = new LinkedList<>();
    public Livro(String titulo, String autor, String editora, String isbn, int anoPublicacao, String categoria, LocalizaLivro localizacao, int quantidade) {
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
        this.isbn = isbn;
        this.anoPublicacao = anoPublicacao;
        this.categoria = categoria;
        this.localizacao = localizacao;
        this.quantidadeDisponivel = quantidade;
        this.quantidadetotal = quantidade;

    }
    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

    public void addReservaFila(Leitor leitor){  // Adicionando leitores à fila do livro
        reservaFila.offer(leitor);}

    public void removeReservaFila(Leitor leitor){ // removendo leitores da fila
        reservaFila.remove(leitor);
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
    public int getAnoPublicacao() {

        return anoPublicacao;
    }
    public String getCategoria() {

        return categoria;
    }
    public LocalizaLivro getLocalizacao(){
        return localizacao;
    }
    public int getQuantidadeDisponivel(){
        return quantidadeDisponivel;
    }

    public int getQuantidadetotal() {
        return quantidadetotal;
    }

    public int getQuantidadeEmprestimo() {
        return quantidadeEmprestimo;
    }

    public Queue<Leitor> getReservaFila(){
        return reservaFila;
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
    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    public void setLocalizacao(LocalizaLivro localizacao){
        this.localizacao = localizacao;
    }

    public void setQuantidadeDisponivel(int quantidadeDisponivel) {
        this.quantidadeDisponivel = quantidadeDisponivel;
    }

    public void setQuantidadetotal(int quantidadetotal) {
        this.quantidadetotal = quantidadetotal;
    }

    public void setQuantidadeEmprestimo(int quantidadeEmprestimo) {
        this.quantidadeEmprestimo = quantidadeEmprestimo;
    }

    public void setReservaFila(Queue<Leitor> reservaFila) {
        this.reservaFila = reservaFila;
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
