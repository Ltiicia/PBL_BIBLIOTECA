package Testes.Modeltest;


import org.example.Model.ADM;
import org.example.Model.Bibliotecario;
import org.example.Model.Leitor;

import org.example.DAO.DAO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ADMTest {
    ADM adm = new ADM("Administrador", "Rogerio", "123", "42123","75 99827-3592", "Ali");

    public ADMTest() throws Exception {
    }

    @Test
    public void registerReader() throws Exception {
        // ADM REGISTRA O LEITOR
        Leitor leitor = adm.createLeitor("Adminstrador", "Rafael", "212345", "123456", "75 XXXX-XXXX", "ali");

        assertSame(leitor, DAO.getLeitorDAO().findById(leitor.getCpf())); // ASSERTE QUE EXISTE UM LEITOR IDÊNTICO AO CRIADO PELO ADM
    }

    @Test
    public void registerLibrarian() throws Exception {
        // ADM REGISTRA O BIBLIOTECÁRIO
        Bibliotecario bibliotecario = adm.createBibliotecario("bibliootecario", "edilene", "45", "75 XXXX-XXXX","Em casa", "ali");

        assertSame(bibliotecario, DAO.getBibliotecarioDAO().findById(bibliotecario.getCpf())); // ASSERTE QUE EXISTE UM BIBLIOTECÁRIO IDÊNTICO AO CRIADO PELO ADM
    }

    @Test
    public void registerAdm() throws Exception {
        // ADM REGISTRA UM ADM
        ADM newADM = adm.createAdm("bibliootecario", "Jessica", "45", "75 XXXX-XXXX","Em casa", "ali");

        assertSame(newADM, DAO.getAdmDAO().findById(newADM.getCpf())); // ASSERTE QUE EXISTE UM ADM IDÊNTICO AO CRIADO PELO ADM
    }
}

