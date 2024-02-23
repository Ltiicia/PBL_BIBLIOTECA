package org.example.Controllers;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.example.DAO.DAO;
import org.example.Excecao.LivroExcecao;

public class RelatorioController implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button histEmpresBtt;

    @FXML
    private ListView<Integer> listAtrasados;
    @FXML
    private ImageView image;
    @FXML
    private ListView<Integer> listEmprestados;

    @FXML
    private ListView<Integer> listReservados;

    @FXML
    private Button popBtt;

    @FXML
    void histEmpresBttAction(ActionEvent event) {

    }

    @FXML
    void popBttAction(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        File livroFile = new File("images/livro.png");
        Image livroImage = new Image(livroFile.toURI().toString());
        image.setImage(livroImage);

    }

    private void mostraView(ListView<Integer> localDeExibir, Integer exibicao) {
        localDeExibir.setItems(FXCollections.observableArrayList(exibicao).sorted());
    }

    @FXML
    void initialize() throws Exception {
        assert histEmpresBtt != null : "fx:id=\"histEmpresBtt\" was not injected: check your FXML file 'relatorio-view.fxml'.";
        assert listAtrasados != null : "fx:id=\"listAtrasados\" was not injected: check your FXML file 'relatorio-view.fxml'.";
        assert listEmprestados != null : "fx:id=\"listEmprestados\" was not injected: check your FXML file 'relatorio-view.fxml'.";
        assert listReservados != null : "fx:id=\"listReservados\" was not injected: check your FXML file 'relatorio-view.fxml'.";
        assert popBtt != null : "fx:id=\"popBtt\" was not injected: check your FXML file 'relatorio-view.fxml'.";

        mostraView(listAtrasados, DAO.getRelatoriosDAO().getRelatorios().quantidadeLivrosAtrasados());
        mostraView(listEmprestados, DAO.getRelatoriosDAO().getRelatorios().quantidadeLivrosEmprestados());
        mostraView(listReservados, DAO.getRelatoriosDAO().getRelatorios().quantidadeReservados());
    }
}

