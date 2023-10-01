package Testes.DAOtest;

import Model.Leitor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import DAO.DAO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LeitorDAOTest { //revisar
    Leitor leticia;
    Leitor helena;
    Leitor mario;

    @BeforeEach
    void setUp() {
        leticia = DAO.getLeitorDAO().create(new Leitor("leticia", 123, "eu1548", 20,"6865-9878","ali",leticia.block, leticia.prazo));
        mario = DAO.getLeitorDAO().create(new Leitor("mario", 156, "ma9741",18,"9687-5424","na esquina",mario.block, mario.prazo));
        helena = DAO.getLeitorDAO().create(new Leitor("helena", 789, "he9875",19,"0800-7524","fim do mundo",helena.block, helena.prazo));
    }

    @Test
    void create() {
        Leitor esperado = DAO.getLeitorDAO().create(new Leitor("leticia", 123, "eu1548", 20,"6865-9878","ali",leticia.block, leticia.prazo));
        esperado.setId(leticia.getId());
        Leitor atual = leticia;
        assertEquals(esperado, atual);
    }

    @Test
    void delete() {
        DAO.getLeitorDAO().delete(mario);
        int tamanho_esperado = 2;
        Assertions.assertEquals(tamanho_esperado, DAO.getLeitorDAO().findMany().size());
    }

    @Test
    void update() {
        helena.setNome("Helena Filemon");
        helena.setCelular("75 98129-7333");
        Leitor atual = DAO.getLeitorDAO().update(helena);
        Assertions.assertEquals(helena, atual);
    }

    @Test
    int findMany() {
        DAO.getLeitorDAO().findMany();
        Assertions.assertEquals(3, DAO.getLeitorDAO().findMany().size());
        return 3;
    }

    @Test
    void findById() {
        Leitor esperado = new Leitor("Laiza", 452, "lala1546", 20,"6865-9838","ala",leticia.block, leticia.prazo);
        esperado.setId(mario.getId());
        Leitor atual = DAO.getLeitorDAO().findById(esperado.getId());
        Assertions.assertEquals(esperado, atual);
    }



}
