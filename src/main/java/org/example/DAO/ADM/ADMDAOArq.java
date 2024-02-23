package org.example.DAO.ADM;

import org.example.Model.Bibliotecario;
import org.example.utils.Arquivos;
import org.example.Model.ADM;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.example.utils.Arquivos.consultarArquivoMap;

public class ADMDAOArq implements ADMDAO{

    File arquivo;
    private static final String NOMEARQUIVO= "ADM";

    public ADMDAOArq(){
        arquivo = Arquivos.gerarArquivo(NOMEARQUIVO);
    }

    private final HashMap<String, ADM> AdmMap = new HashMap<>();

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
    public boolean findByCPFIsTrue(String cpf) {
        if (this.AdmMap.containsKey(cpf)) {
            return true;
        }
        return false;
    }
    public String achaCpf(String cpf){
        ADM adm = this.AdmMap.get(cpf);
        if(adm != null){
            return adm.getCpf();
        }
        throw new IllegalArgumentException("Tecnico não detectado no banco de dados");
    }

    @Override
    public List<ADM> findMany() {
        return new ArrayList<>(AdmMap.values());
    }

    @Override
    public ADM findById(String cpf) {
        ADM adm = this.AdmMap.get(cpf);
        if(adm != null){
            return adm;
        }
        throw new IllegalArgumentException("Administrador não detectado no banco de dados");
    }

    public void deleteMany(){
        Arquivos.apagarConteudoArquivo(arquivo);
    }
}