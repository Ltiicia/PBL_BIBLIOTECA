package DAO.Emprestimo;

import Arquivo.Arquivos;
import Model.Emprestimo;
import java.io.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmprestimoDAOArq implements EmprestimoDAO{

    File arquivo;
    private static final String NOMEARQUIVO= "Emprestimo";

    public EmprestimoDAOArq(){
        arquivo = Arquivos.gerarArquivo(NOMEARQUIVO);
    }

    private final Map<Long, Emprestimo> emprestimoMap = new HashMap<>();
    //HashMap que guarda todos emprestimos feitos (id:emprestimo)

    public Map<Long, Emprestimo> getEmprestimoMap() {
        //retorna todos os emprestimos em formato Map
        return emprestimoMap;
    }
    private long proxId = 0;

    public long getProxId() {
        return proxId++;// retorna Id para o objeto
        // define o próximo Id incrementando do anterior
    }


    //Métodos CRUD
    @Override
    public Emprestimo create(Emprestimo emprestimo){
        long id = emprestimo.getIdEmprestimo();
        emprestimoMap.put(id, emprestimo);
        Arquivos.sobreescreverArquivo(arquivo,emprestimoMap);
        return emprestimo;
    }//guarda os emprestimos no Map e o id como chave


    @Override
    public List<Emprestimo> findMany(){
        return new ArrayList<>(emprestimoMap.values());
    }//retorna lista de emprestimos


    @Override
    public Emprestimo findById(long id){
        try {
            return emprestimoMap.get(id);
        } catch (Exception e){
            System.out.println("Emprestimo não encontrado");
            return null;
        }
    }//retorna o emprestimo por id


    @Override
    public Emprestimo update(Emprestimo emprestimo){
        emprestimoMap.put(emprestimo.getIdEmprestimo(), emprestimo);
        Arquivos.sobreescreverArquivo(arquivo,emprestimoMap);
        return null;
    }//atualiza o emprestimo no hashmap


    @Override
    public void delete(Emprestimo emprestimo){
        long id = emprestimo.getIdEmprestimo();
        emprestimoMap.remove(id);
        Arquivos.sobreescreverArquivo(arquivo,emprestimoMap);
    }//deleta o emprestimo


    public void deleteMany(){
        emprestimoMap.clear();
        Arquivos.apagarConteudoArquivo(arquivo);
    }//esvazia o HashMap emprestimoMap
}