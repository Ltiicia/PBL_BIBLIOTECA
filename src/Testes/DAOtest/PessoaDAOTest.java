package Testes.DAOtest;

import Model.Pessoa;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import DAO.DAO;
public class PessoaDAOTest {
    Pessoa lele;
    Pessoa helen;
    Pessoa naynay;

    @BeforeEach
    void setUp() {
        lele = DAO.getPessoaDAO().create(new Pessoa("Leticia", 456, "48922", 24, "9741-5632","aqui",));
        helen = DAO.getPessoaDAO().create(new Pessoa("helena", 471, "567854", 47,"9654-6321","ala"));
        naynay = DAO.getPessoaDAO().create(new Pessoa("Naylane", 423, "128963",32,"9563-4215", "não sei"));
    }


    @Test
    void create() {
        Pessoa esperado = new Pessoa("lula",09, "4556", 74,"7852-6965","ali");
        esperado.setId(lele.getId());
        Pessoa atual = lele;
        assertEquals(esperado, atual);
    }

    @Test
    void delete() {
        DAO.getPessoaDAO().delete(helen);
        int tamanho_esperado = 2;
        assertEquals(tamanho_esperado, DAO.getPessoaDAO().findMany().size());
    }



    @Test
    void update() {
        lele.setNome("Kevin Cordeiro");
        lele.setCelular("75 98129-7333");
        Pessoa atual = DAO.getPessoaDAO().update(lele);
        assertEquals(lele, atual);
    }

    @Test
    void findMany() {
        DAO.getPessoaDAO().findMany();
        assertEquals(3,DAO.getPessoaDAO().findMany().size());
    }

    @Test
    void findById() {
        Pessoa esperado = new Pessoa("mario", 156, "as9876", 29, "4585-6236", "numsei");
        esperado.setId(naynay.getId());
        Pessoa atual = DAO.getPessoaDAO().findById(esperado.getId());
        assertEquals(esperado, atual);
    }
}
