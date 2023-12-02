package DAO.Livro;

import Model.Livro;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LivroDAOArq {
    private final Map<String, Livro> livrosmap = new HashMap<>();
    //HashMap que guarda todos livros cadastrados (id:livro)

    public Map<String, Livro> getLivroMap(){
        return livrosmap;
    }//retorna todos os livros em formato Map

    public long QuantidadeLivros(){
        return (long)livrosmap.size();
    }//retorna quantidade de livros

    //Métodos CRUD
    @Override
    public Livro create(Livro livro){ //criando um livro e colocando no map
        String id = livro.getIsbn(); //o id do livro vai ser o proprio isbn
        livrosmap.put(id, livro);
        return livro;
    }

    @Override
    public List<Livro> findMany() { //retorna lista de livros
        return new ArrayList<>(livrosmap.values());}

    @Override
    public Livro findById(long id) {
        return null;}

    public Livro findById(String id) {
        //retorna um livro pelo isbn
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
    }//retorna lista de livros por titulo

    public List<Livro> findAutor(String autor) {
        List<Livro> livrosAutor = new ArrayList<>();
        for (Livro livro : livrosmap.values()) {
            if (livro.getAutor().equalsIgnoreCase(autor)){
                livrosAutor.add(livro);
            }
        }
        return livrosAutor;
    }//retorna lista livros por autor

    public List<Livro> findCategoria(String categoria) {
        List<Livro> livrosCategoria = new ArrayList<>();
        for (Livro livro : livrosmap.values()) {
            if (livro.getCategoria().equalsIgnoreCase(categoria)){
                livrosCategoria.add(livro);
            }
        }
        return livrosCategoria;
    }//retorna lista de livros por categoria
}
