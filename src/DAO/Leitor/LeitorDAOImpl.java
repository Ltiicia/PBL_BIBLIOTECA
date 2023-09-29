package DAO.Leitor;

import Model.Bibliotecario;
import Model.Leitor;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeitorDAOImpl implements LeitorDAO {

    private final Map<Integer, Leitor> leitorMap = new HashMap<>();
    @Override
    public Leitor create(Leitor leitor) {
        int id = leitor.getId();
        leitorMap.put(id, leitor);
        return leitor;
    }

    @Override
    public void delete(Leitor leitor) {
        int id = leitor.getId();
        leitorMap.remove(id);
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
    public Leitor findById(int id) {
        return leitorMap.get(id);
    }

}
