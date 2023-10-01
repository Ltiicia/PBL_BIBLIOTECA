package DAO.Relatorios;

import DAO.CRUD;
import Model.Relatorios;

public interface RelatoriosDAO {
    Relatorios getRelatorios();
    Relatorios save(Relatorios relatorios);
    void delete(Relatorios relatorios);
}
