package DAO.Livro;
import Model.Livro;
import DAO.CRUD;

public interface LivroDAO extends CRUD<Livro, Exception>{

    public Livro findAutor(String autor) throws Exception;
    public Livro findCategoria(String categoria) throws Exception;
    public Livro findTitulo(String titulo) throws Exception;

}
