package DAO.Livro;

import Arquivo.Arquivos;
import Excecao.LivroExcecao;
import Model.Livro;

import java.io.*;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.io.File;

public class LivroDAOArq implements LivroDAO {

    File arquivo;
    private static final String NOMEARQUIVO= "Livros";

    public LivroDAOArq(){
        arquivo = Arquivos.gerarArquivo(NOMEARQUIVO);
    }

    public File getArquivo(){
        return arquivo;
    }


    //HashMap que guarda todos livros cadastrados (id:livro)

    //Métodos CRUD
    @Override
    public Livro create(Livro livro){ //criando um livro e colocando no map//o id do livro vai ser o proprio isbn
        Map<String, Livro> livrosMap = findManyMap();
        livrosMap.put(livro.getIsbn(), livro);
        Arquivos.sobreescreverArquivo(arquivo, livrosMap);
        return livro;
    }

    public Map<String, Livro> findManyMap() {
        return Arquivos.consultarArquivoMap(arquivo);
    }

    @Override
    public List<Livro> findMany() { //retorna lista de livros
        Collection<Livro> values = findManyMap().values();
        return new LinkedList<Livro>(values);
    }

    @Override
    public Livro findById(long id) {
        return null;
    }

    public Livro findById(String isbn){
        return findManyMap().get(isbn);
    }

    public Livro findByIsbn (String isbn) throws LivroExcecao {
        //retorna um livro pelo isbn
        Livro l = findById(isbn);
        if (l != null)
            return l;
        throw new LivroExcecao(LivroExcecao.ErroIsbn);
    }


    @Override
    public Livro update (Livro obj){
        Map<String, Livro> livrosMap = findManyMap();

        livrosMap.remove(obj.getIsbn());
        livrosMap.put(obj.getIsbn(), obj);

        Arquivos.sobreescreverArquivo(arquivo, livrosMap);

        return obj;
    }

    @Override
    public void delete (Livro obj){
        Map<String, Livro> livrosMap = findManyMap();
        livrosMap.remove(obj.getIsbn());
        Arquivos.sobreescreverArquivo(arquivo, livrosMap);
    }

    public void deleteMany () {
        Arquivos.apagarConteudoArquivo(arquivo);
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

    public Long QuantidadeLivros() {
        Map<String, Livro> livrosMap = findManyMap();
        return (long)livrosMap.size();
    }
}