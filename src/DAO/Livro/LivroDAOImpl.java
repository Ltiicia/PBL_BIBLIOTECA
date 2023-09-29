package DAO.Livro;

import Model.Livro;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LivroDAOImpl implements LivroDAO {
    private final Map<Integer, Livro> livrosmap = new HashMap<>(); //map que guarda os livros numa estrutura Isbn:livro
    @Override
    public Livro create(Livro livro){ //criando um livro e colocando no map
        int idlivro= livro.getIsbn(); //o id do livro vai ser o proprio isbn
        livrosmap.put(idlivro, livro);
        return livro;}

    @Override
    public List<Livro> findMany() { //retorna lista de livros
        return new ArrayList<>(livrosmap.values());}

    @Override
    public Livro findById(int id) {  //retorna um livro pelo Id (id é o isbn)
        return livrosmap.get(id);}

    @Override
    public Livro update(Livro livro) {
        livrosmap.put(livro.getIsbn(), livro);
        return null;}

    @Override
    public void delete(Livro obj) {
        int id = obj.getIsbn();
        livrosmap.remove(id);}


    public Livro findTitulo(String titulo) {
        for (Livro livro : livrosmap.values()) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                return livro;
            }
        }
        return null;
    }
    public Livro findAutor(String autor) {
        for (Livro livro : livrosmap.values()) {
            if (livro.getAutor().equalsIgnoreCase(autor)) {
                return livro;
            }
        }
        return null;
    }
    public Livro findCategoria(String categoria) {
        for (Livro livro : livrosmap.values()) {
            if (livro.getCategoria().equalsIgnoreCase(categoria)) {
                return livro;
            }
        }
        return null;
    }

}
