package org.example.Controllers;

import java.io.File;
import java.net.URL;
import java.time.Year;
import java.util.ResourceBundle;

import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.example.DAO.DAO;
import org.example.Model.Bibliotecario;
import org.example.Model.Livro;
import org.example.Model.LocalizaLivro;

public class RegistraLivroController implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField anoPubliTextField;

    @FXML
    private TextField autorTextField;

    @FXML
    private TextField categoriaTextField;

    @FXML
    private TextField corredorTextField;
    @FXML
    private ImageView image;
    @FXML
    private TextField editoraTextField;

    @FXML
    private TextField isbnTextField;

    @FXML
    private TextField prateleiraTextField;

    @FXML
    private TextField qntTextField;

    @FXML
    private Button registrarButton;

    @FXML
    private TextField secaoTextField;

    @FXML
    private TextField tituloTextField;

    @FXML
    private Button voltarButton;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        File livroFile = new File("images/livro.png");
        Image livroImage = new Image(livroFile.toURI().toString());
        image.setImage(livroImage);

    }
    @FXML
    void registrarBttAction(ActionEvent event) throws Exception {
        String isbnText= isbnTextField.getText();
        String anoPubli = anoPubliTextField.getText();
        String titulo = tituloTextField.getText();
        String autor = autorTextField.getText();
        String categoria = categoriaTextField.getText();
        String editora = editoraTextField.getText();
        String prateleira = prateleiraTextField.getText();
        String corredor = corredorTextField.getText();
        String secao = secaoTextField.getText();

        // Verificação de erros nos campos
        verificaCampos(titulo,autor,categoria,editora,isbnText,anoPubli);
        verificaInt(isbnText,anoPubli);

        Year ano = Year.parse(anoPubli);

        LocalizaLivro localizacao = new LocalizaLivro(prateleira, secao, corredor);
        // Registro do livro
        Livro livroRegistrado = DAO.getLivroDAO().create(new Livro(titulo, autor, editora,
                isbnText, ano, categoria,localizacao, 1));

        // Exibição do resultado do registro
        if (livroRegistrado != null) {
            informationAlert("Registro completo", "O livro foi registrado com sucesso, com ID: " + livroRegistrado.getIsbn());
        } else {
            informationAlert("ERROR", "Ocorreu um erro ao registrar o livro. Por favor, tente novamente.");
        }

        // Limpeza dos campos
        limparCampos(tituloTextField,autorTextField,categoriaTextField,editoraTextField,isbnTextField,anoPubliTextField);
    }

    private void limparCampos(TextField titulo, TextField autor, TextField categoria,
                                     TextField editora, TextField isbnText, TextField anoPublicacaoText){
        PauseTransition delay = new PauseTransition(Duration.seconds(1));
        delay.setOnFinished(event -> {
            titulo.clear(); autor.clear(); categoria.clear();
            editora.clear(); isbnText.clear(); anoPublicacaoText.clear();
        });
        delay.play();
    }
    private void verificaCampos(String titulo, String autor, String categoria, String editora, String isbnText, String anoPublicacaoText){
        if (titulo.isEmpty() || autor.isEmpty() || categoria.isEmpty() || editora.isEmpty()
                || isbnText.isEmpty() || anoPublicacaoText.isEmpty()) {
            informationAlert("ERROR", "Por favor, preencha todos os campos.");
            throw new IllegalArgumentException();
        }
    }

    private void limparAposDelay(TextField textField) {
        PauseTransition delay = new PauseTransition(Duration.seconds(1));
        delay.setOnFinished(event -> {
            textField.getStyleClass().remove("text-field-error");
            textField.clear();
        });
        delay.play();
    }

    private void verificaInt(String isbnText, String anoPublicacaoText){
        try {
            int isbn = Integer.parseInt(isbnText);
            int anoPublicacao = Integer.parseInt(anoPublicacaoText);
        } catch (NumberFormatException e) {
            informationAlert("ERROR", "Por favor, insira valores válidos para ISBN e Ano de Publicação.");
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
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();

        // Fechando a janela
        stage.close();
    }

    @FXML
    void initialize() {
        assert anoPubliTextField != null : "fx:id=\"anoPubliTextField\" was not injected: check your FXML file 'registerLivro-view.fxml'.";
        assert autorTextField != null : "fx:id=\"autorTextField\" was not injected: check your FXML file 'registerLivro-view.fxml'.";
        assert categoriaTextField != null : "fx:id=\"categoriaTextField\" was not injected: check your FXML file 'registerLivro-view.fxml'.";
        assert corredorTextField != null : "fx:id=\"corredorTextField\" was not injected: check your FXML file 'registerLivro-view.fxml'.";
        assert editoraTextField != null : "fx:id=\"editoraTextField\" was not injected: check your FXML file 'registerLivro-view.fxml'.";
        assert isbnTextField != null : "fx:id=\"isbnTextField\" was not injected: check your FXML file 'registerLivro-view.fxml'.";
        assert prateleiraTextField != null : "fx:id=\"prateleiraTextField\" was not injected: check your FXML file 'registerLivro-view.fxml'.";
        assert qntTextField != null : "fx:id=\"qntTextField\" was not injected: check your FXML file 'registerLivro-view.fxml'.";
        assert registrarButton != null : "fx:id=\"registrarButton\" was not injected: check your FXML file 'registerLivro-view.fxml'.";
        assert secaoTextField != null : "fx:id=\"secaoTextField\" was not injected: check your FXML file 'registerLivro-view.fxml'.";
        assert tituloTextField != null : "fx:id=\"tituloTextField\" was not injected: check your FXML file 'registerLivro-view.fxml'.";
        assert voltarButton != null : "fx:id=\"voltarButton\" was not injected: check your FXML file 'registerLivro-view.fxml'.";

    }

}
