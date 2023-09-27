package DAO.ADM;

import Model.ADM;

import java.util.ArrayList;
import java.util.List;

public class ADMDAOImpl implements ADMDAO{
    private final Map<Integer, ADM> AdmMap = new HashMap<>();

    @Override
    public ADM create(ADM Adm) {
        int id = Adm.getId();
        AdmMap.put(id, Adm);
        return Adm;
    }

    @Override
    public void delete(ADM Adm) {
        int id = Adm.getId();
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
    public ADM findById(int id) {
        return AdmMap.get(id);
    }
}
