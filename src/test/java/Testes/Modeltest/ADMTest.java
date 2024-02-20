package Testes.Modeltest;


import org.example.Model.ADM;
import org.example.Model.Bibliotecario;
import org.example.Model.Leitor;

import org.example.DAO.DAO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ADMTest {
    ADM adm = new ADM("Rogerio", 1, "123", 42,"75 99827-3592", "Ali");

    @Test
    public void registerReader() {
        // ADM REGISTRA O LEITOR
        Leitor leitor = adm.createLeitor("Rafael", "eu9745", 25, "75 XXXX-XXXX", "acola");

        assertSame(leitor, DAO.getLeitorDAO().findById(leitor.getId())); // ASSERTE QUE EXISTE UM LEITOR IDÊNTICO AO CRIADO PELO ADM
    }

    @Test
    public void registerLibrarian() {
        // ADM REGISTRA O BIBLIOTECÁRIO
        Bibliotecario bibliotecario = adm.createBibliotecario("Edilene", "fe87523", 45, "75 XXXX-XXXX","Em casa");

        assertSame(bibliotecario, DAO.getBibliotecarioDAO().findById(bibliotecario.getId())); // ASSERTE QUE EXISTE UM BIBLIOTECÁRIO IDÊNTICO AO CRIADO PELO ADM
    }

    @Test
    public void registerAdm() {
        // ADM REGISTRA UM ADM
        ADM newADM = adm.createAdm("Jessica", "jeje9561", 23,"75 9 0000-0000", "Na kitnet");

        assertSame(newADM, DAO.getAdmDAO().findById(newADM.getId())); // ASSERTE QUE EXISTE UM ADM IDÊNTICO AO CRIADO PELO ADM
    }
}

