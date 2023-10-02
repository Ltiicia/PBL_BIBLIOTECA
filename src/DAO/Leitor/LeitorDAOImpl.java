package DAO.Leitor;

import Model.Bibliotecario;
import Model.Leitor;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeitorDAOImpl implements LeitorDAO {

    private final Map<Long, Leitor> leitorMap = new HashMap<>();
    private long proxId = 0;

    public long getProxId(){
        return this.proxId++;
    }
    @Override
    public Leitor create(Leitor leitor) {
        leitor.setId(getProxId());
        leitorMap.put(leitor.getId(), leitor);
        return leitor;
    }

    @Override
    public void delete(Leitor leitor) {
        leitorMap.remove(leitor.getId());
    }

    @Override
    public Leitor update(Leitor leitor) {
        leitorMap.put(leitor.getId(), leitor);
        return leitor;
    }

    @Override
    public List<Leitor> findMany() {
        return new ArrayList<>(leitorMap.values());
    }

    @Override
    public void deleteMany(){
        leitorMap.clear();
    }

    @Override
    public Leitor findById(long id) {
        return leitorMap.get(id);
    }
    @Override
    public Map<Long, Leitor> getLeitorMap() {
        return leitorMap;
    }


}
