package org.example.DAO.Bibliotecario;

import org.example.Arquivo.Arquivos;
import org.example.Model.Bibliotecario;

import java.io.File;
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

    private final Map<String, Bibliotecario> bibliotecarioMap = new HashMap<>();
    //HashMap que guarda todos bibliotecarios cadastrados (id:bibliotecario)


    /**
     * Método get para o HashMap do Bibliotecario
     *
     * @return bibliotecarioMap
     */
    @Override
    public Map<String, Bibliotecario> getBibliotecarioMap() {
        return bibliotecarioMap;
    }//retorna todos os bibliotecarios em um Map

    //Métodos CRUD
    @Override
    public Bibliotecario create(Bibliotecario bibliotecario) {
        bibliotecarioMap.put(bibliotecario.getCpf(), bibliotecario);
        Arquivos.sobreescreverArquivo(arquivo,bibliotecarioMap);
        return bibliotecario;
    }

    @Override
    public void delete(Bibliotecario bibliotecario) {
        String cpf = bibliotecario.getCpf();
        bibliotecarioMap.remove(cpf);
        Arquivos.sobreescreverArquivo(arquivo,bibliotecarioMap);
    }

    @Override
    public void deleteMany(){
        bibliotecarioMap.clear();
        Arquivos.apagarConteudoArquivo(arquivo);
    }

    @Override
    public Bibliotecario update(Bibliotecario bibliotecario){
        bibliotecarioMap.put(bibliotecario.getCpf(), bibliotecario);
        Arquivos.sobreescreverArquivo(arquivo,bibliotecarioMap);
        return bibliotecario;
    }

    @Override
    public boolean findByCPF(String cpf) {
        if (bibliotecarioMap.containsKey(cpf)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<Bibliotecario> findMany(){
        return new ArrayList<>(bibliotecarioMap.values());
    }

    @Override
    public Bibliotecario findById(String cpf){
        return bibliotecarioMap.get(cpf);
    }

}