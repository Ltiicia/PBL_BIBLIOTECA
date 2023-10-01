package DAO.Leitor;

import DAO.CRUD;
import Model.Leitor;

import java.util.Map;

public interface LeitorDAO extends CRUD<Leitor> {
    public Map<Long, Leitor> getReaderMap();
    public long getProxId();
}
