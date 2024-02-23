package org.example.DAO.Livro;

import org.example.utils.Arquivos;
import org.example.Model.Livro;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.io.File;

public class LivroDAOArq implements LivroDAO {

    File arquivo;
    private static final String NOMEARQUIVO= "Livros";

    public LivroDAOArq(){
        arquivo = Arquivos.gerarArquivo(NOMEARQUIVO);
    }

    private HashMap<String, Livro> livrosMap = new HashMap<>();
    //HashMap que guarda todos livros cadastrados (id:livro)

    public HashMap<String, Livro> getLivrosMap() {
        return livrosMap;
    }


    //HashMap que guarda todos livros cadastrados (id:livro)

    //Métodos CRUD
    @Override
    public Livro create(Livro livro){ //criando um livro e colocando no map//o id do livro vai ser o proprio isbn
        livrosMap.put(livro.getIsbn(), livro);
        Arquivos.sobreescreverArquivo(arquivo, livrosMap);
        return livro;
    }

    public HashMap<String, Livro> findManyMap() {
        return Arquivos.consultarArquivoMap(arquivo);
    }

    @Override
    public List<Livro> findMany() { //retorna lista de livros
        return new ArrayList<>(livrosMap.values());}

    @Override
    public Livro findById(String cpf) {
        return null;
    }

    @Override
    public boolean findByIsbn(String isbn){
        if(livrosMap.get(isbn) != null){
            return true;
        }else{
            return false;
        }
    }

    /*public Livro findByISBN(String isbn) throws LivroExcecao {
        //retorna um livro pelo isbn
        Livro l = findByIsbn(isbn);
        if (l != null)
            return l;
        throw new LivroExcecao(LivroExcecao.ErroIsbn);
    }*/


    @Override
    public Livro update (Livro obj){
        livrosMap = findManyMap();

        livrosMap.remove(obj.getIsbn());
        livrosMap.put(obj.getIsbn(), obj);

        Arquivos.sobreescreverArquivo(arquivo, livrosMap);

        return obj;
    }

    @Override
    public boolean findByCPFIsTrue(String cpf) {
        return false;
    }

    @Override
    public void delete (Livro obj){
        Map<String, Livro> livrosMap = findManyMap();
        livrosMap.remove(obj.getIsbn());
        Arquivos.sobreescreverArquivo(arquivo, livrosMap);
    }

    public void deleteMany () {
        livrosMap.clear();
        Arquivos.sobreescreverArquivo(arquivo, livrosMap);
    }

    public List<Livro> findTitulo (String titulo){
        return findBooksBy(l -> l.getTitulo().toLowerCase().contains(titulo.toLowerCase()));
    }//retorna lista de livros por titulo

    private List<Livro> findBooksBy(Predicate<Livro> rule){
        return findMany()
                .stream()
                .filter(rule)
                .collect(Collectors.toList());
    }


    public List<Livro> findAutor (String autor){
        return findBooksBy(l -> l.getAutor().equals(autor));
    }//retorna lista livros por autor


    public List<Livro> findCategoria (String categoria){
        return findBooksBy(l -> l.getCategoria().equals(categoria));
    }//retorna lista de livros por categoria

    @Override
    public Livro findIsbn(String isbn) {
        return null;
    }

    public Long QuantidadeLivros() {
        Map<String, Livro> livrosMap = findManyMap();
        return (long)livrosMap.size();
    }
}