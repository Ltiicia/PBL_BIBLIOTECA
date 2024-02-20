package org.example.DAO.Relatorios;

import org.example.Arquivo.Arquivos;
import org.example.Model.Relatorios;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class RelatoriosDAOArq implements RelatoriosDAO {

    File arquivo;
    private static final String NOMEARQUIVO= "Relatorios";

    public RelatoriosDAOArq(){
        arquivo = Arquivos.gerarArquivo(NOMEARQUIVO);
    }

    private final Map<String, Relatorios> relatoriosMap = new HashMap<>();
    public Map<String, Relatorios> getRelatoriosMap(){
        return relatoriosMap;
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
        String rela = null;
        for (int x = 0; x < 1; x++) {
            rela = "x";
        }
        getRelatoriosMap().put(rela, relatorios);
        Arquivos.sobreescreverArquivo(arquivo, relatoriosMap);
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
