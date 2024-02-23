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
import org.example.Excecao.LivroExcecao;
import org.example.Excecao.PessoaExcecao;
import org.example.Model.Leitor;
import org.example.Model.Livro;
import org.example.utils.AbrirTelas;
import org.example.utils.LoginSection;

public class ReservaController implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField barraPesquisa;
    @FXML
    private ImageView image;
    @FXML
    private Button reservaBtt;

    @FXML
    private Button voltarBtt;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        File livroFile = new File("images/livro.png");
        Image livroImage = new Image(livroFile.toURI().toString());
        image.setImage(livroImage);

    }
    @FXML
    void reservaBttAction(ActionEvent event) throws Exception {
        try {
            String isbn= barraPesquisa.getText();
            Object login = LoginSection.getPessoaNaSessao();
            Leitor leitor = (Leitor) login;

            campos(isbn);
            camposInt(isbn);

            reservar(Integer.parseInt(isbn), leitor);
        } catch (Exception e) {
            barraPesquisa.clear();
            throw e;
        }
        informationAlert("SUCESSO", "O Livro foi reservado com sucesso!");
        barraPesquisa.clear();
    }

    private void reservar(Integer isbn, Leitor leitor) throws Exception {
        LocalDate dataHoje = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataFormatada = dataHoje.format(formatter);

        Livro livro = DAO.getLivroDAO().findById(String.valueOf(isbn));
        try {
             leitor.reservaLivro(leitor, livro);
        } catch (LivroExcecao | PessoaExcecao e) {
            ErrorTextController errorTextController = new ErrorTextController();
            errorTextController.showErrorText("ERROR");
            throw e;
        }
    }



    private void campos(String isbn) throws IOException {
        if (isbn.isEmpty()) {
            ErrorTextController errorTextController = new ErrorTextController();
            errorTextController.showErrorText("Por favor, preencha todos os campos");
            throw new IllegalArgumentException();
        }
    }



    private void camposInt(String isbn) throws IOException {
        try {
            int isbnInt = Integer.parseInt(isbn);
        } catch (NumberFormatException e) {
            ErrorTextController errorTextController = new ErrorTextController();
            errorTextController.showErrorText("Digite apenas números");
            throw e;
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
    void voltarBttAction(ActionEvent event) {
        AbrirTelas.proximaTela(event, "homeLeitor-view.fxml");
    }



    @FXML
    void initialize() {
        assert barraPesquisa != null : "fx:id=\"barraPesquisa\" was not injected: check your FXML file 'reserva-view.fxml'.";
        assert reservaBtt != null : "fx:id=\"reservaBtt\" was not injected: check your FXML file 'reserva-view.fxml'.";
        assert voltarBtt != null : "fx:id=\"voltarBtt\" was not injected: check your FXML file 'reserva-view.fxml'.";

    }

    public void pesquisarAction(ActionEvent actionEvent) {
    }
}
