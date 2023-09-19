package DAO.Livro;
import Model.Livro;
import java.util.Map;
import DAO.CRUD;

public interface LivroDAO extends CRUD<Livro>{
    void adicionarLivro(Livro livro);
    void atualizarLivro(Livro livro);
    void excluirLivro(String isbn);
    Livro buscarLivro(String isbn, String titulo, String autor, String categoria);
    Map<String, Livro> listarLivros();
}
