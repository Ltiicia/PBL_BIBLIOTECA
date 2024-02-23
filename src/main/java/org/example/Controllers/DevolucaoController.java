package org.example.Controllers;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.example.DAO.DAO;
import org.example.Excecao.EmprestimoExcecao;
import org.example.Excecao.LivroExcecao;
import org.example.Excecao.PessoaExcecao;
import org.example.Model.Emprestimo;
import org.example.Model.Livro;
import org.example.utils.AbrirTelas;

public class DevolucaoController implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    @FXML
    private ImageView image;
    @FXML
    private TextField barraPesquisa;

    @FXML
    private Button devolverBtt;

    @FXML
    private Button voltarBtt;

    @FXML
    void devolverBttAction(ActionEvent event) throws Exception {
        Livro livroEncontrado = null;
        try {
            String isbn = barraPesquisa.getText();

            verificaCampos(isbn);

            livroEncontrado = buscarLivro(String.valueOf(Integer.parseInt(isbn)));
            Emprestimo emprestimosEncontrado = buscaEmprestimo(livroEncontrado);

            devolve(livroEncontrado, emprestimosEncontrado);
        } catch (Exception e) {
            barraPesquisa.clear();
            throw e;
        }
        informationAlert( "O Livro " + livroEncontrado.getTitulo() + " devolvido com sucesso");
        barraPesquisa.clear();
    }

    private void devolve(Livro livro, Emprestimo emprestimos) throws Exception {
        LocalDate dataHoje= LocalDate.now();
        try {
            emprestimos.registraDevolucao(livro,emprestimos.getLeitor(),dataHoje);
        } catch (Exception e) {
            ErrorTextController errorTextController = new ErrorTextController();
            errorTextController.showErrorText("ERROR");
            throw e;
        }
    }

    private Emprestimo buscaEmprestimo(Livro livro) throws Exception {
        Emprestimo emprestimo;
        try {
            emprestimo = DAO.getEmprestimoDAO().findById(livro.getIsbn());
        } catch(Exception e) {
            ErrorTextController errorTextController = new ErrorTextController();
            errorTextController.showErrorText("Este livro não está emprestado!");
            throw e;
        }
        return emprestimo;
    }

    private Livro buscarLivro(String isbn) throws Exception {
        ErrorTextController errorTextController = new ErrorTextController();
        Livro livro = null;
        try {
            livro = DAO.getLivroDAO().findById(isbn);
        } catch (Exception e) {
            if (isbn.isEmpty()) {
                errorTextController.showErrorText("Preencha todos os campos corretamente");
            } else if (!DAO.getLivroDAO().findByIsbn(isbn)) {
                errorTextController.showErrorText("Livro não encontrado");
            }
        }
        return livro;
    }

    private void verificaCampos(String barraPesquisa) throws IOException {
        if (barraPesquisa.isEmpty()) {
            ErrorTextController errorTextController = new ErrorTextController();
            errorTextController.showErrorText( "Por favor, preencha todos os campos");
            throw new IllegalArgumentException();
        }
    }

    @FXML
    void pesquisarAction(ActionEvent event) {

    }

    @FXML
    void voltarBttAction(ActionEvent event) {

        AbrirTelas.proximaTela(event, "/org/example/pbl_biblioteca/homeBiblio-view.fxml");


    }

    private void informationAlert(String texto) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText(texto);
        alert.showAndWait();
    }

    @FXML
    void initialize() {
        assert barraPesquisa != null : "fx:id=\"barraPesquisa\" was not injected: check your FXML file 'devolucao-view.fxml'.";
        assert devolverBtt != null : "fx:id=\"devolverBtt\" was not injected: check your FXML file 'devolucao-view.fxml'.";
        assert voltarBtt != null : "fx:id=\"voltarBtt\" was not injected: check your FXML file 'devolucao-view.fxml'.";

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
