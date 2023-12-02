package DAO.ADM;

import Arquivo.Arquivos;
import Model.ADM;
import java.io.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ADMDAOArq implements ADMDAO{

    File arquivo;
    private static final String NOMEARQUIVO= "ADM";

    public ADMDAOArq(){
        arquivo = Arquivos.gerarArquivo(NOMEARQUIVO);
    }

    private final Map<Long, ADM> AdmMap = new HashMap<>();

    //HashMap que guarda todos ADMs cadastrados (id:ADM)
    private long proxId = 0;

    public long getProxId(){

        return this.proxId++;// retorna Id para o objeto
        // define o próximo Id incrementando do anterior
    }

    //Métodos CRUD
    @Override
    public ADM create(ADM Adm) {
        Adm.setId(getProxId());
        AdmMap.put(Adm.getId(), Adm);
        Arquivos.sobreescreverArquivo(arquivo, AdmMap);
        return Adm;
    }

    @Override
    public void delete(ADM Adm) {
        long id = Adm.getId();
        AdmMap.remove(id);
        Arquivos.sobreescreverArquivo(arquivo, AdmMap);
    }

    @Override
    public ADM update(ADM Adm) {
        AdmMap.put(Adm.getId(), Adm);

        Arquivos.sobreescreverArquivo(arquivo, AdmMap);
        return Adm;
    }

    @Override
    public List<ADM> findMany() {
        return new ArrayList<>(AdmMap.values());
    }

    @Override
    public ADM findById(long id) {
        return AdmMap.get(id);
    }

    public void deleteMany(){
        Arquivos.apagarConteudoArquivo(arquivo);
    }
}
