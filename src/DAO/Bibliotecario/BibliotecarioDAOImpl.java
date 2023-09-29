package DAO.Bibliotecario;

import Model.Bibliotecario;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BibliotecarioDAOImpl implements BibliotecarioDAO{

    private final Map<Integer, Bibliotecario> bibliotecarioMap = new HashMap<>();

    @Override
    public Bibliotecario create(Bibliotecario bibliotecario) {
        int id = bibliotecario.getId();
        bibliotecarioMap.put(id, bibliotecario);
        return bibliotecario;
    }

    @Override
    public void delete(Bibliotecario bibliotecario) {
        int id = bibliotecario.getId();
        bibliotecarioMap.remove(id);
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
    public Bibliotecario findById(int id) {
        return bibliotecarioMap.get(id);
    }

}
