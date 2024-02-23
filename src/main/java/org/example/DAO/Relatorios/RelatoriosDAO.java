package org.example.DAO.Relatorios;

import org.example.Model.Relatorios;

public interface RelatoriosDAO {

    //Interface DAO da Classe Relatorios
    Relatorios getRelatorios() throws Exception;
    Relatorios save(Relatorios relatorios);
    void delete(Relatorios relatorios) throws Exception;
}
