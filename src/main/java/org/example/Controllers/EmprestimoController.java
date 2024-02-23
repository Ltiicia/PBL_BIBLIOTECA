package org.example.Controllers;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
import org.example.Model.Leitor;
import org.example.Model.Livro;
import org.example.utils.AbrirTelas;

public class EmprestimoController implements Initializable {

    @FXML
    private ResourceBundle resources;
    @FXML
    private ImageView image;
    @FXML
    private URL location;

    @FXML
    private TextField barraCPFPesquisa;

    @FXML
    private TextField barraISBNPesquisa;

    @FXML
    private Button emprestaBtt;

    @FXML
    private Button voltarBtt;

    @FXML
    void emprestarBttAction(ActionEvent event) throws Exception {
        Livro livroEcontrado;
        try {
            String isbn = barraISBNPesquisa.getText();
            String cpf = barraCPFPesquisa.getText();

            campos(isbn, cpf);
            camposInt(isbn, cpf);

            livroEcontrado = achaLivro(Integer.parseInt(isbn));
            Leitor leitorEncontrado = buscaUsuario(Integer.parseInt(cpf));
            emprestimos(livroEcontrado, leitorEncontrado);
        } catch (Exception e) {
            barraISBNPesquisa.clear();
            barraCPFPesquisa.clear();
            throw e;
        }
        informationAlert("SUCESSO", "O Livro " + livroEcontrado.getTitulo() + " foi emprestado com sucesso");
        barraISBNPesquisa.clear();
        barraCPFPesquisa.clear();
    }

    private Leitor buscaUsuario(Integer cpf) throws Exception {
        Leitor leitor;
        try {
            leitor = DAO.getLeitorDAO().findLeitor(String.valueOf(cpf));
        } catch (Exception e) {
            ErrorTextController errorTextController = new ErrorTextController();
            errorTextController.showErrorText("Usuário não encontrado");
            throw e;
        }
        return leitor;
    }

    private Livro achaLivro(Integer isbn) throws Exception {
        Livro livro;
        try {
            livro = DAO.getLivroDAO().findById(String.valueOf(isbn));
        } catch (Exception e) {
            ErrorTextController errorTextController = new ErrorTextController();
            errorTextController.showErrorText( "Livro não encontrado");
            throw e;
        }
        return livro;
    }

    private void camposInt(String isbn, String cpf) throws IOException {
        try {
            int isbnInt = Integer.parseInt(isbn);
            int cpfInt = Integer.parseInt(cpf);
        } catch (NumberFormatException e) {
            ErrorTextController errorTextController = new ErrorTextController();
            errorTextController.showErrorText("Digite apenas números");
            throw e;
        }
    }

    private void emprestimos(Livro livro, Leitor leitor) throws Exception {
        LocalDate dataHoje = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataFormatada = dataHoje.format(formatter);
        try {
            Emprestimo emprestimo = DAO.getEmprestimoDAO().create(new Emprestimo(livro, dataFormatada, leitor));
        } catch (Exception e) {
            ErrorTextController errorTextController = new ErrorTextController();
            errorTextController.showErrorText("ERROR");
            throw e;
        }
    }

    private void campos(String isbn, String cpf) throws IOException {
        if (isbn.isEmpty() || cpf.isEmpty()) {
            ErrorTextController errorTextController = new ErrorTextController();
            errorTextController.showErrorText("Por favor, preencha todos os campos");
            throw new IllegalArgumentException();
        }
    }

    private void informationAlert(String title, String texto) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(texto);
        alert.showAndWait();
    }



    @FXML
    void voltarBttAction(ActionEvent event) { AbrirTelas.proximaTela(event, "/org/example/pbl_biblioteca/homeBiblio-view.fxml");

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        File livroFile = new File("images/livro.png");
        Image livroImage = new Image(livroFile.toURI().toString());
        image.setImage(livroImage);

    }

    @FXML
    void initialize() {
        assert barraCPFPesquisa != null : "fx:id=\"barraCPFPesquisa1\" was not injected: check your FXML file 'emprestimo-view.fxml'.";
        assert barraISBNPesquisa != null : "fx:id=\"barraISBNPesquisa\" was not injected: check your FXML file 'emprestimo-view.fxml'.";
        assert emprestaBtt != null : "fx:id=\"emprestaBtt\" was not injected: check your FXML file 'emprestimo-view.fxml'.";
        assert voltarBtt != null : "fx:id=\"voltarBtt\" was not injected: check your FXML file 'emprestimo-view.fxml'.";

    }

}
