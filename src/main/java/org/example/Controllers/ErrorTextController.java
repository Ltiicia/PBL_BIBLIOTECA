package org.example.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class ErrorTextController {

    @FXML
    private Text ErrorText;

    public void setAlert(String warning) {
        this.ErrorText.setText(warning);
    }

    //gracas ao GETCLASS nao pode ser um metodo static
    public void showErrorText(String mensage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/pbl_biblioteca/erroText-view.fxml"));
        Parent root = loader.load();
        ErrorTextController errorTextController = loader.getController();
        errorTextController.setAlert(mensage);
        Stage errorStage = new Stage();
        Scene scene = new Scene(root);
        errorStage.setResizable(false);
        errorStage.setScene(scene);
        errorStage.showAndWait();
        errorStage.setAlwaysOnTop(true);
        }


}
