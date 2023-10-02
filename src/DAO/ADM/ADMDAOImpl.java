package DAO.ADM;

import Model.ADM;

import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

public class ADMDAOImpl implements ADMDAO{
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
        return Adm;
    }

    @Override
    public void delete(ADM Adm) {
        long id = Adm.getId();
        AdmMap.remove(id);
    }

    @Override
    public ADM update(ADM Adm) {
        AdmMap.put(Adm.getId(), Adm);
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
        AdmMap.clear();
    }
}
