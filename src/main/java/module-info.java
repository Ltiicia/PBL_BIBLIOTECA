module org.example.pbl_biblioteca {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example to javafx.fxml;
    exports org.example;
    exports org.example.Controllers;
    opens org.example.Controllers to javafx.fxml;
    exports org.example.Model;
    exports org.example.DAO.ADM;
    exports org.example.DAO.Bibliotecario;
    exports org.example.DAO.Emprestimo;
    exports org.example.DAO.Leitor;
    exports org.example.DAO.Livro;
    exports org.example.DAO.Relatorios;

    opens org.example.DAO.ADM;
    opens org.example.DAO.Bibliotecario;
    opens org.example.DAO.Emprestimo;
    opens org.example.DAO.Leitor;
    opens org.example.DAO.Livro;
    opens org.example.DAO.Relatorios;
}