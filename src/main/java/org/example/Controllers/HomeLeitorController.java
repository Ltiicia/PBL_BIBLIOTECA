package org.example.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class HomeLeitorController {

    @FXML
    private TableColumn<?, ?> autorColumn;

    @FXML
    private ImageView bookImage;

    @FXML
    private TableColumn<?, ?> categoriaColumn;

    @FXML
    private TableColumn<?, ?> isbnColumn;

    @FXML
    private TableColumn<?, ?> localizaColumn;

    @FXML
    private Label reservaLabel;

    @FXML
    private Label searcgLabel;

    @FXML
    private TextField searchBar;

    @FXML
    private Label searchLabel;

    @FXML
    private TableView<?> searchTable;

    @FXML
    private TableColumn<?, ?> tituloColumn;

   /* public void setLeitorCpf(String cpf) {
        this.cpfLeitor = cpf;
        loadData();
        try {
            this..setText(DAO.getTecnicoDAO().findByCPF(cpf).getFullName());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }*/
}
