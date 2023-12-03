package DAO.Bibliotecario;

import Arquivo.Arquivos;
import Model.Bibliotecario;
import java.io.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BibliotecarioDAOArq implements BibliotecarioDAO{

    File arquivo;
    private static final String NOMEARQUIVO= "Bibliotecario";

    public BibliotecarioDAOArq(){
        arquivo = Arquivos.gerarArquivo(NOMEARQUIVO);
    }

    private final Map<Long, Bibliotecario> bibliotecarioMap = new HashMap<>();
    //HashMap que guarda todos bibliotecarios cadastrados (id:bibliotecario)
    private long proxId = 0;

    @Override
    public long getProxId() {

        return proxId++;// retorna Id para o objeto
        // define o próximo Id incrementando do anterior
    }

    /**
     * Método get para o HashMap do Bibliotecario
     *
     * @return bibliotecarioMap
     */
    @Override
    public Map<Long, Bibliotecario> getBibliotecarioMap() {
        return bibliotecarioMap;
    }//retorna todos os bibliotecarios em um Map

    //Métodos CRUD
    @Override
    public Bibliotecario create(Bibliotecario bibliotecario) {
        bibliotecario.setId(getProxId());
        bibliotecarioMap.put(bibliotecario.getId(), bibliotecario);
        Arquivos.sobreescreverArquivo(arquivo,bibliotecarioMap);
        return bibliotecario;
    }

    @Override
    public void delete(Bibliotecario bibliotecario) {
        long id = bibliotecario.getId();
        bibliotecarioMap.remove(id);
        Arquivos.sobreescreverArquivo(arquivo,bibliotecarioMap);
    }

    @Override
    public void deleteMany(){
        bibliotecarioMap.clear();
        Arquivos.apagarConteudoArquivo(arquivo);
    }

    @Override
    public Bibliotecario update(Bibliotecario bibliotecario){
        bibliotecarioMap.put(bibliotecario.getId(), bibliotecario);
        Arquivos.sobreescreverArquivo(arquivo,bibliotecarioMap);
        return bibliotecario;
    }

    @Override
    public List<Bibliotecario> findMany(){
        return new ArrayList<>(bibliotecarioMap.values());
    }

    @Override
    public Bibliotecario findById(long id){
        return bibliotecarioMap.get(id);
    }

}