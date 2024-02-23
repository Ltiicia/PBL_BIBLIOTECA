package org.example.DAO.Leitor;

import org.example.utils.Arquivos;
import org.example.Model.Leitor;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.example.utils.Arquivos.consultarArquivoMap;

public class LeitorDAOArq implements LeitorDAO{

    File arquivo;
    private static final String NOMEARQUIVO= "Leitor";

    public LeitorDAOArq(){
        arquivo = Arquivos.gerarArquivo(NOMEARQUIVO);
    }

    //Leitor
    private final HashMap<String, Leitor> leitorMap = new HashMap<>();
    //HashMap que guarda todos leitores cadastrados (id:leitor)

    @Override
    public HashMap<String, Leitor> getLeitorMap() {
        return leitorMap;
    }//retorna todos os Leitores em formato Map

    @Override
    public Leitor findLeitor(String cpf) {
        return null;
    }


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
    public boolean findByCPFIsTrue(String cpf) {
        if (this.leitorMap.containsKey(cpf)) {
            return true;
        }
        return false;
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

    public String achaCpf(String cpf){
        Leitor leitor = this.leitorMap.get(cpf);
        if(leitor != null){
            return leitor.getCpf();
        }
        throw new IllegalArgumentException("Tecnico não detectado no banco de dados");
    }
    @Override
    public Leitor findById(String CPF){
        Leitor leitor = this.leitorMap.get(CPF);
        if(leitor != null){
            return leitor;
        }
        throw new IllegalArgumentException("Leitor não detectado no banco de dados");
    }

    @Override
    public String acharCpf(String cpfText) {
        return null;
    }


}