package org.example.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.example.DAO.Livro.LivroDAO;
import org.example.Model.Livro;

import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class PesquisaController implements Initializable {

    @FXML
    private TextField barraPesquisa;

    @FXML
    private TableColumn<?, ?> colAnoPubli;

    @FXML
    private TableColumn<?, ?> colAutor;

    @FXML
    private TableColumn<?, ?> colCategoria;
    @FXML
    private ImageView image;
    @FXML
    private TableColumn<?, ?> colISBN;

    @FXML
    private TableColumn<?, ?> colLocalizacao;

    @FXML
    private TableColumn<?, ?> colQnt;

    @FXML
    private TableColumn<?, ?> colTitulo;

    @FXML
    private TableView<Livro> tabelaPesquisa;

    private ObservableList<Livro> livroData;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        File livroFile = new File("images/livro.png");
        Image livroImage = new Image(livroFile.toURI().toString());
        image.setImage(livroImage);

    }

    private void setBookTable(){
        livroData = FXCollections.observableArrayList();

        createLivroTable(this.tabelaPesquisa, livroData);
    }

    static void createLivroTable(TableView<Livro> tabelaPesquisa, ObservableList<Livro> livroData) {
        TableColumn titleCol = new TableColumn("Título");
        TableColumn authorCol = new TableColumn("Autor(a)");
        TableColumn publisherCol = new TableColumn("Editora");
        TableColumn categoryCol = new TableColumn("Categoria");
        TableColumn idCol = new TableColumn("ISBN");
        TableColumn yearOfCol = new TableColumn("Ano de publicação");
        TableColumn amountAvailable = new TableColumn("Quantidade disponíveis");
        TableColumn timesSearched = new TableColumn("Vezes pesquisado");

        titleCol.setCellValueFactory(new PropertyValueFactory<Livro, String>("titulo"));
        authorCol.setCellValueFactory(new PropertyValueFactory<Livro, String>("autor"));
        publisherCol.setCellValueFactory(new PropertyValueFactory<Livro, String>("editora"));
        categoryCol.setCellValueFactory(new PropertyValueFactory<Livro, String>("categoria"));
        idCol.setCellValueFactory(new PropertyValueFactory<Livro, String>("isbn"));
        yearOfCol.setCellValueFactory(new PropertyValueFactory<Livro, String>("anoPublicacao"));
        amountAvailable.setCellValueFactory(new PropertyValueFactory<Livro, String>("quantidadeDisponiveis"));
        timesSearched.setCellValueFactory(new PropertyValueFactory<Livro, String>("vezesPesquisado"));

        tabelaPesquisa.getColumns().setAll(titleCol, authorCol, publisherCol, categoryCol, idCol, yearOfCol, timesSearched);
        tabelaPesquisa.setItems(livroData);
    }

    @FXML
    void initialize() {
        assert barraPesquisa != null : "fx:id=\"barraPesquisa\" was not injected: check your FXML file 'pesquisa-view.fxml'.";
        assert colAnoPubli != null : "fx:id=\"colAnoPubli\" was not injected: check your FXML file 'pesquisa-view.fxml'.";
        assert colAutor != null : "fx:id=\"colAutor\" was not injected: check your FXML file 'pesquisa-view.fxml'.";
        assert colCategoria != null : "fx:id=\"colCategoria\" was not injected: check your FXML file 'pesquisa-view.fxml'.";
        assert colISBN != null : "fx:id=\"colISBN\" was not injected: check your FXML file 'pesquisa-view.fxml'.";
        assert colTitulo != null : "fx:id=\"colTitulo\" was not injected: check your FXML file 'pesquisa-view.fxml'.";
        assert image != null : "fx:id=\"image\" was not injected: check your FXML file 'pesquisa-view.fxml'.";
        assert tabelaPesquisa != null : "fx:id=\"tabelaPesquisa\" was not injected: check your FXML file 'pesquisa-view.fxml'.";

    }

    public void pesquisarAction(ActionEvent actionEvent) {

    }
}
