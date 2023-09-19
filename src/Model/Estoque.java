package model;

import DAO.DAO;
import Model.Livro;

import java.util.List;

public class Estoque {
    private int numLivros;

    public Estoque(int numLivros) {
        this.numLivros = numLivros;
    }

    public Livro addLivro(Livro newLivro){
        return DAO.getLivroDAO().creat(newLivro);
    }

    public void deleteLivro(Livro livro){
        DAO.getBookDAO().delete(livro);
    }

    /*
    public void deleteAll(){ // não implementado
        DAO.getLivroDAO().apagarTodos();
    */

    public Livro updateLivro(Livro livro){

        return DAO.getLivroDAO().update(livro);
    }

    public Livro getLivro(int isbn){

        return DAO.getLivroDAO().findById(isbn);
    }

    public List<Livro> getLivro(){
        return DAO.getLivroDAO().findAll();
    }

}


