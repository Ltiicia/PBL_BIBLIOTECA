package org.example.DAO.Leitor;

import org.example.Arquivo.Arquivos;
import org.example.Model.Leitor;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeitorDAOArq implements LeitorDAO {

    File arquivo;
    private static final String NOMEARQUIVO= "Leitor";

    public LeitorDAOArq(){
        arquivo = Arquivos.gerarArquivo(NOMEARQUIVO);
    }

    //Leitor
    private final Map<String, Leitor> leitorMap = new HashMap<>();
    //HashMap que guarda todos leitores cadastrados (id:leitor)

    @Override
    public Map<String, Leitor> getLeitorMap() {
        return leitorMap;
    }//retorna todos os Leitores em formato Map


    //Métodos CRUD
    @Override
    public Leitor create(Leitor leitor) {
        leitorMap.put(leitor.getCpf(), leitor);
        Arquivos.sobreescreverArquivo(arquivo,leitorMap);
        return leitor;
    }

    @Override
    public void delete(Leitor leitor) {
        leitorMap.remove(leitor.getCpf());
        Arquivos.sobreescreverArquivo(arquivo,leitorMap);
    }

    @Override
    public Leitor update(Leitor leitor) {
        leitorMap.put(leitor.getCpf(), leitor);
        Arquivos.sobreescreverArquivo(arquivo,leitorMap);
        return leitor;
    }

    @Override
    public boolean findByCPF(String cpf) {
        if (leitorMap.containsKey(cpf)) {
            return true;
        } else {
            return false;
        }
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
    public Leitor findById(String cpf) {
        return leitorMap.get(cpf);
    }

}