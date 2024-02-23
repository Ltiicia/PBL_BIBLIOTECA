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
import org.example.DAO.DAO;
import org.example.Model.Leitor;
import org.example.Model.Pessoa;
import org.example.utils.LoginSection;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ResourceBundle;



public class HomeLeitorController implements Initializable {

    @FXML
    private ImageView bookImage;
    @FXML
    private ImageView image;

    @FXML
    private Button pesquisarButton;

    @FXML
    private Button reservarButton;

    @FXML
    void pesquisarBttAction(ActionEvent event){
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
    void reservaBttAction(ActionEvent event) throws Exception {
        try {
            Stage currentScreen = (Stage) ((Node) event.getSource()).getScene().getWindow();
            currentScreen.close();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/pbl_biblioteca/reserva-view.fxml"));
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
    void initialize() {
        assert bookImage != null : "fx:id=\"bookImage\" was not injected: check your FXML file 'homeLeitor-view.fxml'.";
        assert pesquisarButton != null : "fx:id=\"pesquisarButton\" was not injected: check your FXML file 'homeLeitor-view.fxml'.";
        assert reservarButton != null : "fx:id=\"reservarButton\" was not injected: check your FXML file 'homeLeitor-view.fxml'.";

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        File livroFile = new File("images/livro.png");
        Image livroImage = new Image(livroFile.toURI().toString());
        image.setImage(livroImage);

    }
}
