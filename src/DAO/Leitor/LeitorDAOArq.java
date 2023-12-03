package DAO.Leitor;

import Arquivo.Arquivos;
import Model.Leitor;
import java.io.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeitorDAOArq {

    File arquivo;
    private static final String NOMEARQUIVO= "Leitor";

    public LeitorDAOArq(){
        arquivo = Arquivos.gerarArquivo(NOMEARQUIVO);
    }

    private final Map<Long, Leitor> leitorMap = new HashMap<>();
    //HashMap que guarda todos leitores cadastrados (id:leitor)

    @Override
    public Map<Long, Leitor> getLeitorMap() {
        return leitorMap;
    }//retorna todos os Leitores em formato Map

    private long proxId = 0;

    public long getProxId(){
        return this.proxId++;// retorna Id para o objeto
        // define o próximo Id incrementando do anterior
    }

    //Métodos CRUD
    @Override
    public Leitor create(Leitor leitor) {
        leitor.setId(getProxId());
        leitorMap.put(leitor.getId(), leitor);
        Arquivo.sobreescreverArquivo(arquivo,leitorMap);
        return leitor;
    }

    @Override
    public void delete(Leitor leitor) {
        leitorMap.remove(leitor.getId());
        Arquivo.sobreescreverArquivo(arquivo,leitorMap);
    }

    @Override
    public Leitor update(Leitor leitor) {
        leitorMap.put(leitor.getId(), leitor);
        Arquivo.sobreescreverArquivo(arquivo,leitorMap);
        return leitor;
    }

    @Override
    public List<Leitor> findMany() {
        return new ArrayList<>(leitorMap.values());
    }

    @Override
    public void deleteMany(){
        leitorMap.clear();
        Arquivos.apagarConteudoArquivo(arquivo);
    }

    @Override
    public Leitor findById(long id) {
        return leitorMap.get(id);
    }

}