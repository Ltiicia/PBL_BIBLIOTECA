package DAO.Livro;
import Model.Livro;
import DAO.CRUD;
import java.util.List;

public interface LivroDAO extends CRUD<Livro>{

    //Interface DAO da Classe Livro
    //Contem os Metodos de CRUD alem dos próprios
    //pesquisar livro por: titulo, autor, isbn e categoria.
    // Obs: pesquisar por Id é o mesmo que ISBN
    public Livro findByIsbn(String id);
    public List<Livro> findAutor(String autor);
    public List<Livro> findCategoria(String categoria);
    public List<Livro> findTitulo(String titulo);


}
