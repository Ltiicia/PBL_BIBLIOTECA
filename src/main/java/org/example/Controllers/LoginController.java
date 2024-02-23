/**
 * Sample Skeleton for 'login-view.fxml' Controller Class
 */

package org.example.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.example.DAO.DAO;
import org.example.Model.Leitor;

import java.io.File;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class LoginController implements Initializable {


    @FXML
    private RadioButton admCheck;

    @FXML
    private RadioButton bibliotecarioCheck;

    @FXML
    private Label errorMessage;
    @FXML
    private ImageView image;
    @FXML
    private TextField idTextField;

    @FXML
    private RadioButton leitorCheck;

    @FXML
    private ImageView livrosImageView;

    @FXML
    private Button loginButton;

    @FXML
    private Button registroButton;

    @FXML
    private PasswordField senhaTextField;

    @FXML
    private ToggleGroup usuarios;
    @FXML
    void admBttAction(ActionEvent event) {

    }

    @FXML
    void biblioBttAction(ActionEvent event) {

    }

    @FXML
    void leitorBttAction(ActionEvent event) {

    }


    @FXML
    void loginBttAction(ActionEvent event) throws Exception{
        RadioButton selectedRadioButton = (RadioButton) usuarios.getSelectedToggle();
        String userType = selectedRadioButton.getText();
        String senhaText = senhaTextField.getText();
        String cpfText = idTextField.getText();


        switch (userType) {
            case "Leitor":
                if (!senhaText.isEmpty() && !cpfText.isEmpty() && DAO.getLeitorDAO().findByCPFIsTrue(senhaTextField.getText()) ) {
                    try {
                        Stage currentScreen = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        currentScreen.close();
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/pbl_biblioteca/homeLeitor-view.fxml"));
                        Parent root = loader.load();
                        HomeLeitorController homeLeitorController = loader.getController();

                        Stage registerStage = new Stage();
                        Scene scene = new Scene(root);
                        registerStage.setResizable(false);
                        registerStage.setScene(scene);
                        registerStage.show();
                       // registerStage.getIcons().add(new Image(getClass().getResourceAsStream("/com/example/sistema_gerenciamentofx/images/1.png")));
                    } catch (Exception excep) {
                        ErrorTextController errorTextController = new ErrorTextController();
                        errorTextController.showErrorText("Preencha todos os campos corretamente para efetuar o login");
                        excep.printStackTrace();
                    }
                } else {
                    ErrorTextController errorTextController = new ErrorTextController();
                    if(usuarios.getSelectedToggle() == null || userType.isEmpty() || senhaText.isEmpty() || cpfText.isEmpty()){
                        errorTextController.showErrorText("Preencha todos os campos corretamente para efetuar o login");
                    } else if (!DAO.getLeitorDAO().findByCPFIsTrue(cpfText) && !Objects.equals(DAO.getLeitorDAO().findById(cpfText).getUserTipo(), userType)) {
                        errorTextController.showErrorText("Login não cadastrado\nPor favor registre-se");
                    }
                }
                break;
            case "Bibliotecário":
               // loginBiblio();
                if (!senhaText.isEmpty() && !cpfText.isEmpty() && DAO.getBibliotecarioDAO().findByCPFIsTrue(senhaTextField.getText())) {
                    try {
                        Stage currentScreen = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        currentScreen.close();
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/pbl_biblioteca/homeBiblio-view.fxml"));
                        Parent root = loader.load();
                        HomeBiblioController homeBiblioController = loader.getController();
                        homeBiblioController.setBiliotecarioCpf(cpfText);

                        Stage registerStage = new Stage();
                        Scene scene = new Scene(root);
                        registerStage.setResizable(false);
                        registerStage.setScene(scene);
                        registerStage.show();
                        // registerStage.getIcons().add(new Image(getClass().getResourceAsStream("/com/example/sistema_gerenciamentofx/images/1.png")));
                    } catch (Exception excep) {
                        ErrorTextController errorTextController = new ErrorTextController();
                        errorTextController.showErrorText("Preencha todos os campos corretamente para efetuar o login");
                        excep.printStackTrace();
                    }
                } else {
                    ErrorTextController errorTextController = new ErrorTextController();
                    if(usuarios.getSelectedToggle() == null || userType.isEmpty() || senhaText.isEmpty() || cpfText.isEmpty()){
                        errorTextController.showErrorText("Preencha todos os campos corretamente para efetuar o login");
                    } else if (!DAO.getBibliotecarioDAO().findByCPFIsTrue(cpfText) && !Objects.equals(DAO.getBibliotecarioDAO().findById(cpfText).getUserTipo(), userType)) {
                        errorTextController.showErrorText("Login não cadastrado\nPor favor registre-se");
                    }
                }
                break;
            case "Administrador":
              //  loginAdmin();
                if (!senhaText.isEmpty() && !cpfText.isEmpty() && DAO.getAdmDAO().findByCPFIsTrue(senhaTextField.getText())) {
                    try {
                        Stage currentScreen = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        currentScreen.close();
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/pbl_biblioteca/homeAdm-view.fxml"));
                        Parent root = loader.load();
                        HomeAdmController homeAdmController = loader.getController();
                        homeAdmController.setAdmCpf(cpfText);

                        Stage registerStage = new Stage();
                        Scene scene = new Scene(root);
                        registerStage.setResizable(false);
                        registerStage.setScene(scene);
                        registerStage.show();
                        // registerStage.getIcons().add(new Image(getClass().getResourceAsStream("/com/example/sistema_gerenciamentofx/images/1.png")));
                    } catch (Exception excep) {
                        ErrorTextController errorTextController = new ErrorTextController();
                        errorTextController.showErrorText("Preencha todos os campos corretamente para efetuar o login");
                        excep.printStackTrace();
                    }
                } else {
                    ErrorTextController errorTextController = new ErrorTextController();
                    if(usuarios.getSelectedToggle() == null || userType.isEmpty() || senhaText.isEmpty() || cpfText.isEmpty()){
                        errorTextController.showErrorText("Preencha todos os campos corretamente para efetuar o login");
                    } else if (!DAO.getAdmDAO().findByCPFIsTrue(cpfText) && !Objects.equals(DAO.getAdmDAO().findById(cpfText).getUserTipo(), userType)) {
                        errorTextController.showErrorText("Login não cadastrado\nPor favor registre-se");
                }
                break;
        }

    }}

    @FXML
    void registroBttAction(ActionEvent event) {
        try {
            Stage currentScreen = (Stage) ((Node) event.getSource()).getScene().getWindow();
            currentScreen.close();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/pbl_biblioteca/register-view.fxml"));
            Parent root = loader.load();
            Stage registerStage = new Stage();
            Scene scene = new Scene(root);
            registerStage.setResizable(false);
            registerStage.setScene(scene);
            registerStage.show();

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

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert admCheck != null : "fx:id=\"admCheck\" was not injected: check your FXML file 'login-view.fxml'.";
        assert bibliotecarioCheck != null : "fx:id=\"bibliotecarioCheck\" was not injected: check your FXML file 'login-view.fxml'.";
        assert errorMessage != null : "fx:id=\"errorMessage\" was not injected: check your FXML file 'login-view.fxml'.";
        assert idTextField != null : "fx:id=\"idTextField\" was not injected: check your FXML file 'login-view.fxml'.";
        assert leitorCheck != null : "fx:id=\"leitorCheck\" was not injected: check your FXML file 'login-view.fxml'.";
        assert livrosImageView != null : "fx:id=\"livrosImageView\" was not injected: check your FXML file 'login-view.fxml'.";
        assert loginButton != null : "fx:id=\"loginButton\" was not injected: check your FXML file 'login-view.fxml'.";
        assert registroButton != null : "fx:id=\"registroButton\" was not injected: check your FXML file 'login-view.fxml'.";
        assert senhaTextField != null : "fx:id=\"senhaTextField\" was not injected: check your FXML file 'login-view.fxml'.";

    }



}
