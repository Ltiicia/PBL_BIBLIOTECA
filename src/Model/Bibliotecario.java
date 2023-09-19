package Model;

public class Bibliotecario extends Pessoa {
    public Bibliotecario(String nome, int id, String senha) {
        super(nome, id, senha);
    }

    // Método para pesquisar livros pelo título ou autor
    public Livro pesquisaLivros(String termo) {
        // Lógica para pesquisar livros no sistema e retornar o livro encontrado
        // ou null se não for encontrado
        return null;
    }

    // Método para registrar um novo livro no sistema
    public void registraLivro(Livro livro) {
        // Lógica para adicionar o livro à base de dados da biblioteca
    }

    // Método para realizar um empréstimo de um livro para um leitor
    public void fazEmprestimo(Leitor leitor, Livro livro) {
        // Lógica para registrar o empréstimo do livro para o leitor
    }

    // Método para registrar a devolução de um livro pelo leitor
    public void fazDevolucao(Leitor leitor, Livro livro) {
        // Lógica para registrar a devolução do livro pelo leitor
    }
}