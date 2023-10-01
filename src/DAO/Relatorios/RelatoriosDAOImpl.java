package DAO.Relatorios;

import Model.Relatorios;


public class RelatoriosDAOImpl implements RelatoriosDAO {

    private Relatorios relatorios;

    public Relatorios getRelatorios(){
        if(relatorios == null){
            relatorios = new Relatorios();
        }
        return this.relatorios;
    }
    @Override
    public Relatorios save(Relatorios relatorios) {
        this.relatorios = relatorios;
        return relatorios;
    }

    @Override
    public void delete(Relatorios relatorios) {
        this.relatorios = new Relatorios();
    }

}
