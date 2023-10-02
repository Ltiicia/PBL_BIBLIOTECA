package DAO.Relatorios;

import Model.Relatorios;


public class RelatoriosDAOImpl implements RelatoriosDAO {

    private Relatorios relatorios;

    /**
     * Método que retorna o relatorio que ja existe
     * @return relatorios
     */
    public Relatorios getRelatorios(){
        if(relatorios == null){
            relatorios = new Relatorios();
        }
        return this.relatorios;
    }

    /**
     * Método que salva o relatorio
     * @param relatorios
     * @return relatorios
     */
    @Override
    public Relatorios save(Relatorios relatorios) {
        this.relatorios = relatorios;
        return relatorios;
    }

    /**
     * Método que deleta um relatorio antes criado
     * @param relatorios
     */
    @Override
    public void delete(Relatorios relatorios) {
        this.relatorios = new Relatorios();
    }

}
