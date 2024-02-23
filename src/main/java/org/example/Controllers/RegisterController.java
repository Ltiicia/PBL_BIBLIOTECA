package org.example.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.example.DAO.DAO;
import org.example.Model.ADM;
import org.example.Model.Bibliotecario;
import org.example.Model.Leitor;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class RegisterController implements Initializable {

    @FXML
    private RadioButton admCheckButton;

    @FXML
    private RadioButton biblioCheckButton;

    @FXML
    private TextField cpfTextField;

    @FXML
    private TextField enderecoTextField;

    @FXML
    private RadioButton leitorCheckButton;
    @FXML
    private ImageView image;
    @FXML
    private TextField nomeTextField;

    @FXML
    private Button registrarButton;

    @FXML
    private TextField senhaTextField;

    @FXML
    private TextField telefoneTextField;

    @FXML
    private ToggleGroup tiposUsuarios;

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
        RadioButton selectedRadioButton = (RadioButton) tiposUsuarios.getSelectedToggle();
        String userType = selectedRadioButton.getText();
        String userNome = nomeTextField.getText();
        String userCPF = cpfTextField.getText();
        String userSenha = senhaTextField.getText();
        String userTelefone = telefoneTextField.getText();
        String userEndereco = enderecoTextField.getText();

        if (userType.isEmpty() || userNome.isEmpty() || userCPF.isEmpty() || userSenha.isEmpty() || userTelefone.isEmpty() || userEndereco.isEmpty()) {
            ErrorTextController errorTextController = new ErrorTextController();
            errorTextController.showErrorText("Você se esqueceu de preencher todos os campos...");
        } else {
            if (!userTelefone.matches("\\d+")) {
                ErrorTextController errorTextController = new ErrorTextController();
                errorTextController.showErrorText("Por favor, insira somente números inteiros no campo de telefone.");
                return;
            }

            int telefone = Integer.parseInt(userTelefone);
        }

        switch (userType) {
            case "Leitor":
                registerLeitor(userType, userNome, userCPF, userSenha, userTelefone, userEndereco);
                break;
            case "Bibliotecario":
                registerBiblio(userType, userNome, userCPF, userSenha, userTelefone, userEndereco);
                break;
            case "Administrador":
                registerAdmin(userType, userNome, userCPF, userSenha, userTelefone, userEndereco);
                break;
        }

    }


    private void registerLeitor(String userType, String userNome, String userCPF, String userSenha, String userTelefone, String userEndereco) throws Exception {
        // Implemente a lógica para registrar um leitor aqui

        Leitor leitor = new Leitor(userType, userNome, userCPF, userSenha, userTelefone, userEndereco);
        DAO.getLeitorDAO().create(leitor);

        Stage stage = (Stage) enderecoTextField.getScene().getWindow();
        stage.close();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/pbl_biblioteca/login-view.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage loginStage = new Stage();
        loginStage.setScene(scene);
        loginStage.show();

    }

    private void registerBiblio(String userType, String userNome, String userCPF, String userSenha, String userTelefone, String userEndereco) throws Exception {
        // Implemente a lógica para registrar um bibliotecário aqui
        Bibliotecario bibliotecario = new Bibliotecario(userType, userNome, userCPF, userSenha, userTelefone, userEndereco);
        DAO.getBibliotecarioDAO().create(bibliotecario);

        Stage stage = (Stage) enderecoTextField.getScene().getWindow();
        stage.close();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/pbl_biblioteca/login-view.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage loginStage = new Stage();
        loginStage.setScene(scene);
        loginStage.show();
    }

    private void registerAdmin(String userType, String userNome, String userCPF, String userSenha, String userTelefone, String userEndereco) throws Exception {
        // Implemente a lógica para registrar um administrador aqui
        ADM adm = new ADM(userType, userNome, userCPF, userSenha, userTelefone, userEndereco);
        DAO.getAdmDAO().create(adm);

        Stage stage = (Stage) enderecoTextField.getScene().getWindow();
        stage.close();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/pbl_biblioteca/login-view.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage loginStage = new Stage();
        loginStage.setScene(scene);
        loginStage.show();
    }

    @FXML
    void voltarBttAction(ActionEvent event) {
        try {
            Stage currentScreen = (Stage) ((Node) event.getSource()).getScene().getWindow();
            currentScreen.close();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/pbl_biblioteca/login-view.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage loginStage = new Stage();
            loginStage.setScene(scene);
            loginStage.show();

        } catch (Exception excep) {
            excep.printStackTrace();
        }

    }

    @FXML
    void initialize() {
        assert admCheckButton != null : "fx:id=\"admCheckButton\" was not injected: check your FXML file 'register-view.fxml'.";
        assert biblioCheckButton != null : "fx:id=\"biblioCheckButton\" was not injected: check your FXML file 'register-view.fxml'.";
        assert cpfTextField != null : "fx:id=\"cpfTextField\" was not injected: check your FXML file 'register-view.fxml'.";
        assert enderecoTextField != null : "fx:id=\"enderecoTextField\" was not injected: check your FXML file 'register-view.fxml'.";
        assert leitorCheckButton != null : "fx:id=\"leitorCheckButton\" was not injected: check your FXML file 'register-view.fxml'.";
        assert nomeTextField != null : "fx:id=\"nomeTextField\" was not injected: check your FXML file 'register-view.fxml'.";
        assert registrarButton != null : "fx:id=\"registrarButton\" was not injected: check your FXML file 'register-view.fxml'.";
        assert senhaTextField != null : "fx:id=\"senhaTextField\" was not injected: check your FXML file 'register-view.fxml'.";
        assert telefoneTextField != null : "fx:id=\"telefoneTextField\" was not injected: check your FXML file 'register-view.fxml'.";
        assert tiposUsuarios != null : "fx:id=\"tiposUsuarios\" was not injected: check your FXML file 'register-view.fxml'.";
        assert voltarButton != null : "fx:id=\"voltarButton\" was not injected: check your FXML file 'register-view.fxml'.";

    }

}
