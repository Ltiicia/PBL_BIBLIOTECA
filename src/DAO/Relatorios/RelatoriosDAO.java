package DAO.Relatorios;

import DAO.CRUD;
import Model.Relatorios;

public interface RelatoriosDAO {

    //Interface DAO da Classe Relatorios
    Relatorios getRelatorios();
    Relatorios save(Relatorios relatorios);
    void delete(Relatorios relatorios);
}
