package org.example.Controllers;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
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

public class HomeAdmController implements Initializable {


    @FXML
    private ImageView bookImage;

    @FXML
    private ImageView image;
    @FXML
    private Button devolucaoBtt;


    @FXML
    private Button registraLivro;

    @FXML
    private Button registraUsuarioBtt;

    @FXML
    private Button relatorioBtt;

    @FXML
    void devolucaoBtt(ActionEvent event) {
        try {
            Stage currentScreen = (Stage) ((Node) event.getSource()).getScene().getWindow();
            currentScreen.close();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/pbl_biblioteca/devolucao-view.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage devolucaoStage = new Stage();
            devolucaoStage.setScene(scene);
            devolucaoStage.show();

        } catch (Exception excep) {
            excep.printStackTrace();
        }
    }

    @FXML
    void registraLivro(ActionEvent event) {
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

    @FXML
    void registraUsuarioBtt(ActionEvent event) {
        try {
            Stage currentScreen = (Stage) ((Node) event.getSource()).getScene().getWindow();
            currentScreen.close();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/pbl_biblioteca/register-view.fxml"));
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
    void relatorioBttAction(ActionEvent event) {
        try {
            Stage currentScreen = (Stage) ((Node) event.getSource()).getScene().getWindow();
            currentScreen.close();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/pbl_biblioteca/relatorio-view.fxml"));
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
        assert bookImage != null : "fx:id=\"bookImage\" was not injected: check your FXML file 'homeAdm-view.fxml'.";
        assert devolucaoBtt != null : "fx:id=\"devolucaoBtt\" was not injected: check your FXML file 'homeAdm-view.fxml'.";
        assert registraLivro != null : "fx:id=\"registraLivro\" was not injected: check your FXML file 'homeAdm-view.fxml'.";
        assert registraUsuarioBtt != null : "fx:id=\"registraUsuarioBtt\" was not injected: check your FXML file 'homeAdm-view.fxml'.";
        assert relatorioBtt != null : "fx:id=\"relatorioBtt\" was not injected: check your FXML file 'homeAdm-view.fxml'.";

    }

    public void setAdmCpf(String cpfText) {
    }
}
