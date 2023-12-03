package DAO.Relatorios;

import Arquivo.Arquivos;
import Model.Relatorios;
import java.io.*;

public class RelatoriosDAOArq {

    File arquivo;
    private static final String NOMEARQUIVO= "Relatorios";

    public RelatoriosDAOArq(){
        arquivo = Arquivos.gerarArquivo(NOMEARQUIVO);
    }

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
        Arquivo.sobreescreverArquivo(arquivo,relatorios);
        return relatorios;
    }

    /**
     * Método que deleta um relatorio antes criado
     * @param relatorios
     */

    @Override
    public void delete(Relatorios relatorios) {
        this.relatorios = new Relatorios();
        Arquivos.apagarConteudoArquivo(arquivo);
    }

}
