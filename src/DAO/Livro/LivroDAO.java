package DAO.Livro;
import Model.Livro;
import DAO.CRUD;
import java.util.List;

public interface LivroDAO extends CRUD<Livro>{

    public Livro findById(String id);
    public List<Livro> findAutor(String autor);
    public List<Livro> findCategoria(String categoria);
    public List<Livro> findTitulo(String titulo);


}
