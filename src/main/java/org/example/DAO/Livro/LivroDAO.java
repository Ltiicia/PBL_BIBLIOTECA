package org.example.DAO.Livro;
import org.example.Model.Livro;
import org.example.DAO.CRUD;
import java.util.List;
import java.util.Map;

public interface LivroDAO extends CRUD<Livro>{


    Map<String, Livro> getLivrosMap();

    //Interface DAO da Classe Livro
    //Contem os Metodos de CRUD alem dos próprios
    //pesquisar livro por: titulo, autor, isbn e categoria.
    // Obs: pesquisar por Id é o mesmo que ISBN
    public boolean findByIsbn(String id);
    public List<Livro> findAutor(String autor);
    public List<Livro> findCategoria(String categoria);

    Livro findIsbn(String isbn);

    public List<Livro> findTitulo(String titulo);


}
