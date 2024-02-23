package org.example.DAO.Emprestimo;

import org.example.utils.Arquivos;
import org.example.Model.Emprestimo;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EmprestimoDAOArq implements EmprestimoDAO{

    File arquivo;
    private static final String NOMEARQUIVO= "Emprestimo";

    public EmprestimoDAOArq(){
        arquivo = Arquivos.gerarArquivo(NOMEARQUIVO);
    }

    private final HashMap<Integer, Emprestimo> emprestimoMap = new HashMap<>();
    //HashMap que guarda todos emprestimos feitos (id:emprestimo)

    public HashMap<Integer, Emprestimo> getEmprestimoMap() {
        //retorna todos os emprestimos em formato Map
        return emprestimoMap;
    }
    private int proxId = 0;

    public int getProxId() {
        return proxId++;// retorna Id para o objeto
        // define o próximo Id incrementando do anterior
    }

    @Override
    public Emprestimo findId(int id) {
        return null;
    }


    //Métodos CRUD
    @Override
    public Emprestimo create(Emprestimo emprestimo){
        int id = emprestimo.getId();
        emprestimoMap.put(id, emprestimo);
        Arquivos.sobreescreverArquivo(arquivo,emprestimoMap);
        return emprestimo;
    }//guarda os emprestimos no Map e o id como chave


    @Override
    public List<Emprestimo> findMany(){
        return new ArrayList<>(emprestimoMap.values());
    }//retorna lista de emprestimos


    @Override
    public Emprestimo findById(String cpf){
        try {
            return emprestimoMap.get(cpf);
        } catch (Exception e){
            System.out.println("Emprestimo não encontrado");
            return null;
        }
    }//retorna o emprestimo por id


    @Override
    public Emprestimo update(Emprestimo emprestimo){
        emprestimoMap.put(emprestimo.getId(), emprestimo);
        Arquivos.sobreescreverArquivo(arquivo,emprestimoMap);
        return null;
    }//atualiza o emprestimo no hashmap

    @Override
    public boolean findByCPFIsTrue(String cpf) {
        return false;
    }


    @Override
    public void delete(Emprestimo emprestimo){
        int id = emprestimo.getId();
        emprestimoMap.remove(id);
        Arquivos.sobreescreverArquivo(arquivo,emprestimoMap);
    }//deleta o emprestimo


    public void deleteMany(){
        emprestimoMap.clear();
        Arquivos.apagarConteudoArquivo(arquivo);
    }//esvazia o HashMap emprestimoMap
}