package DAO.Livro;

import Model.Livro;

import java.util.*;

public class LivroDAOImpl implements LivroDAO {
    private final Map<String, Livro> livrosmap = new HashMap<>(); //map que guarda os livros numa estrutura Isbn:livro
    public Map<String, Livro> getLivroMap(){
        return livrosmap;
    }
    public long QuantidadeLivros(){
        return (long)livrosmap.size();
    }
    @Override
    public Livro create(Livro livro){ //criando um livro e colocando no map
        String id = livro.getIsbn(); //o id do livro vai ser o proprio isbn
        livrosmap.put(id, livro);
        return livro;}

    @Override
    public List<Livro> findMany() { //retorna lista de livros
        return new ArrayList<>(livrosmap.values());}

    @Override
    public Livro findById(long id) {
        return null;}

    public Livro findById(String id) {  //retorna um livro pelo Id (id é o isbn)
        return livrosmap.get(id);}

    @Override
    public Livro update(Livro livro) {
        livrosmap.put(livro.getIsbn(), livro);
        return null;}

    @Override
    public void delete(Livro obj) {
        String id = obj.getIsbn();
        livrosmap.remove(id);}

    public void deleteMany(){
        livrosmap.clear();
    }

    public List<Livro> findTitulo(String titulo) {
        List<Livro> livrosTitulo = new ArrayList<>();
        for (Livro livro : livrosmap.values())
            if (livro.getTitulo().equalsIgnoreCase(titulo))
                livrosTitulo.add(livro);
        return livrosTitulo;
    }

    public List<Livro> findAutor(String autor) {
        List<Livro> livrosAutor = new ArrayList<>();
        for (Livro livro : livrosmap.values()) {
            if (livro.getAutor().equalsIgnoreCase(autor)){
                livrosAutor.add(livro);
            }
        }
        return livrosAutor;
    }
    public List<Livro> findCategoria(String categoria) {
        List<Livro> livrosCategoria = new ArrayList<>();
        for (Livro livro : livrosmap.values()) {
            if (livro.getCategoria().equalsIgnoreCase(categoria)){
                livrosCategoria.add(livro);
            }
        }
        return livrosCategoria;
    }

}
