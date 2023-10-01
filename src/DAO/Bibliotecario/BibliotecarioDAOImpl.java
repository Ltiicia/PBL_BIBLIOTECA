package DAO.Bibliotecario;

import Model.Bibliotecario;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BibliotecarioDAOImpl implements BibliotecarioDAO{

    private final Map<Long, Bibliotecario> bibliotecarioMap = new HashMap<>();

    private long proxId = 0;

    @Override
    public long getProxId() {
        return proxId++;
    }

    @Override
    public Map<Long, Bibliotecario> getBibliotecarioMap() {
        return bibliotecarioMap;
    }

    @Override
    public Bibliotecario create(Bibliotecario bibliotecario) {
        bibliotecario.setId(getProxId());
        bibliotecarioMap.put(bibliotecario.getId(), bibliotecario);
        return bibliotecario;
    }

    @Override
    public void delete(Bibliotecario bibliotecario) {
        long id = bibliotecario.getId();
        bibliotecarioMap.remove(id);
    }

    @Override
    public void deleteMany() {
        bibliotecarioMap.clear();
    }

    @Override
    public Bibliotecario update(Bibliotecario bibliotecario) {
        bibliotecarioMap.put(bibliotecario.getId(), bibliotecario);
        return bibliotecario;
    }

    @Override
    public List<Bibliotecario> findMany() {
        return new ArrayList<>(bibliotecarioMap.values());
    }

    @Override
    public Bibliotecario findById(long id) {
        return bibliotecarioMap.get(id);
    }

}
