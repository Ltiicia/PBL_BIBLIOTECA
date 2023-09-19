import javax.xml.crypto.Data;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Livros{
    private string titulo, autor, editora, categoria;
    private Data anoPublicacao;
    //construtores
    public Livros(string nomeTitulo, string nomeAutor, string nomeEditora, string nomeCategoria, Data AnoPublicacao){
        this.titulo = nomeTitulo;
        this.autor = nomeAutor;
        this.editora = nomeEditora;
        this.categoria = nomeCategoria;
        this.anoPublicacao = AnoPublicacao;
    }
    //gatters
    public string getTitulo() {
        return this.titulo;
    }
    public string getAutor() {
        return this.autor;
    }
    public string getEditora() {
        return this.editora;
    }
    public string getCategoria() {
        return this.categoria;
    }
    public String getAnoPublicacao() {
        return this.anaPublicacao.toString();
    }
}
interface LivrosDAO{
    public Livros create(string titulo);
    public void update(string titulo, string autor, string editora, string categoria);
    public void delete(string titulo);
    public Curso findbyname(strinf titulo);

}
public class LocalLivros extends Livros{
    private string prateleira, corredor, sessao;

    public LocalLivros(string nomePrateleira, string nomeCorredor, string nomeSessao){
        super(nomeTitulo, nomeAutor, nomeEditora, nomeCategoria, AnoPublicacao);
        this.corredor = nomeCorredor;
        this.prateleira = nomePrateleira;
        this.sessao = nomeSessao;
    }
    public string getPrateleira(){
        return this.prateleira;
    }
    public string getCorredor() {
        return this.corredor;
    }
    public string getSessao() {
        return this.sessao;
    }
}

public class Main {

}