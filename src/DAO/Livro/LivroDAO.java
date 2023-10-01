package DAO.Livro;
import Model.Livro;
import DAO.CRUD;
import java.util.List;

public interface LivroDAO extends CRUD<Livro, Exception>{

    public Livro findById(String id);
    public List<Livro> findAutor(String autor) throws Exception;
    public List<Livro> findCategoria(String categoria) throws Exception;
    public List<Livro> findTitulo(String titulo) throws Exception;


}
