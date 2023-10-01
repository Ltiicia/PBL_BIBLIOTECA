package Model;

import DAO.DAO;
import Model.Livro;

import java.util.List;

public class Estoque {

    public Estoque(int numLivros) {
    }

    public Livro addLivro(Livro newLivro){
        return DAO.getLivroDAO().create(newLivro);
    }

    public void deleteLivro(Livro livro){
        DAO.getLivroDAO().delete(livro);
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
        return DAO.getLivroDAO().findMany();
    }

}


