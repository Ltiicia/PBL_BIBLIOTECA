package org.example.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.example.Model.Pessoa;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomeBiblioController implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView bookImage;
    @FXML
    private ImageView image;

    @FXML
    private Button devolucaoBtt;

    @FXML
    private Button emprestimoBtt;


    @FXML
    private Button pesquisarBtt;

    @FXML
    private Button registrarLivroBtt;

    @FXML
    void devolucaoBttAction(ActionEvent event) {
        try {
            Stage currentScreen = (Stage) ((Node) event.getSource()).getScene().getWindow();
            currentScreen.close();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/pbl_biblioteca/devolucao-view.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage registrarStage = new Stage();
            registrarStage.setScene(scene);
            registrarStage.show();

        } catch (Exception excep) {
            excep.printStackTrace();
        }
    }

    @FXML
    void emprestimoBttAction(ActionEvent event) {
        try {
            Stage currentScreen = (Stage) ((Node) event.getSource()).getScene().getWindow();
            currentScreen.close();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/pbl_biblioteca/emprestimo-view.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage registrarStage = new Stage();
            registrarStage.setScene(scene);
            registrarStage.show();

        } catch (Exception excep) {
            excep.printStackTrace();
        }
    }

    @FXML
    void pesquisarBttAction(ActionEvent event) throws Exception {
        try {
            Stage currentScreen = (Stage) ((Node) event.getSource()).getScene().getWindow();
            currentScreen.close();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/pbl_biblioteca/pesquisa-view.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage registrarStage = new Stage();
            registrarStage.setScene(scene);
            registrarStage.show();

        } catch (Exception excep) {
            excep.printStackTrace();
        }
    }

    @FXML
    void registrarBttAction(ActionEvent event) throws Exception {
        try {
            Stage currentScreen = (Stage) ((Node) event.getSource()).getScene().getWindow();
            currentScreen.close();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/pbl_biblioteca/registerLivro-view.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage registrarStage = new Stage();
            registrarStage.setScene(scene);
            registrarStage.show();

        } catch (Exception excep) {
            excep.printStackTrace();
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        File livroFile = new File("images/livro.png");
        Image livroImage = new Image(livroFile.toURI().toString());
        image.setImage(livroImage);

    }

    @FXML
    void initialize() {
        assert bookImage != null : "fx:id=\"bookImage\" was not injected: check your FXML file 'homeBiblio-view.fxml'.";
        assert devolucaoBtt != null : "fx:id=\"devolucaoBtt\" was not injected: check your FXML file 'homeBiblio-view.fxml'.";
        assert emprestimoBtt != null : "fx:id=\"emprestimoBtt\" was not injected: check your FXML file 'homeBiblio-view.fxml'.";
        assert pesquisarBtt != null : "fx:id=\"pesquisarBtt\" was not injected: check your FXML file 'homeBiblio-view.fxml'.";
        assert registrarLivroBtt != null : "fx:id=\"registrarBtt\" was not injected: check your FXML file 'homeBiblio-view.fxml'.";

    }


    public void setBiliotecarioCpf(String cpfText) {
    }
}
