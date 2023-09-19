package DAO.Livro;

import Model.Livro;

import java.util.HashMap;
import java.util.Map;

public class LivroDAOImpl implements LivroDAO {
    private Map<String, Livro> acervo = new HashMap<>();

    @Override
    public void adicionarLivro(Livro livro) {
        acervo.put(livro.getIsbn(), livro);
    }

    @Override
    public void atualizarLivro(Livro livro) {
        acervo.put(livro.getIsbn(), livro);
    }

    @Override
    public void excluirLivro(String isbn) {
        acervo.remove(isbn);
    }

    @Override
    public Livro buscarLivroPorISBN(String isbn) {
        if(procura == isbn){
            return acervo.get(isbn);
        }

        return acervo.get(titulo);
    }

    @Override
    public Map<String, Livro> listarLivros() {
        return acervo;
    }
}
