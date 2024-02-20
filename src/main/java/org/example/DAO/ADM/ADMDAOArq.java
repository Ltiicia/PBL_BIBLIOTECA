package org.example.DAO.ADM;

import org.example.Arquivo.Arquivos;
import org.example.Model.ADM;

import java.io.File;
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

    private final Map<String, ADM> AdmMap = new HashMap<>();

    //HashMap que guarda todos ADMs cadastrados (id:ADM)
    //private long proxId = 0;

   /* public String getCpf(){

        return this.cpf;// retorna Id para o objeto
        // define o próximo Id incrementando do anterior
    }*/

    //Métodos CRUD
    @Override
    public ADM create(ADM Adm) {
        AdmMap.put(Adm.getCpf(), Adm);
        Arquivos.sobreescreverArquivo(arquivo, AdmMap);
        return Adm;
    }

    @Override
    public void delete(ADM Adm) {
        String cpf = Adm.getCpf();
        AdmMap.remove(cpf);
        Arquivos.sobreescreverArquivo(arquivo, AdmMap);
    }

    @Override
    public ADM update(ADM Adm) {
        AdmMap.put(Adm.getCpf(), Adm);

        Arquivos.sobreescreverArquivo(arquivo, AdmMap);
        return Adm;
    }

    @Override
    public boolean findByCPF(String cpf) {
        // Verifique se a chave está no HashMap
        if (AdmMap.containsKey(cpf)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<ADM> findMany() {
        return new ArrayList<>(AdmMap.values());
    }

    @Override
    public ADM findById(String cpf) {
        return AdmMap.get(cpf);
    }

    public void deleteMany(){
        Arquivos.apagarConteudoArquivo(arquivo);
    }
}
