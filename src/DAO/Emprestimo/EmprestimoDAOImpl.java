package DAO.Emprestimo;

import DAO.Emprestimo.EmprestimoDAO;
import Model.Leitor;
import Model.Livro;
import Model.Emprestimo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmprestimoDAOImpl implements EmprestimoDAO {
    private final Map<Long, Emprestimo> emprestimoMap = new HashMap<>();

    public Map<Long, Emprestimo> getEmprestimoMap() { //para retornar o banco de dados com todos livros cadastrados em  formato map
        return emprestimoMap;
    }
    private long proxId = 0;

    public long getProxId() {
        return proxId++;
    }

    public Emprestimo create(Emprestimo emprestimo){
        long id = emprestimo.getIdEmprestimo();
        emprestimoMap.put(id, emprestimo);
        return emprestimo;
    }

    @Override
    public List<Emprestimo> findMany(){
        return new ArrayList<>(emprestimoMap.values());
    }



    @Override
    public Emprestimo findById(long id){
        try {
            return emprestimoMap.get(id);
        } catch (Exception e){
            System.out.println("Emprestimo não encontrado");
            return null;
        }

    }

    @Override
    public Emprestimo update(Emprestimo emprestimo){
        emprestimoMap.put(emprestimo.getIdEmprestimo(), emprestimo);
        return null;
    }

    @Override
    public void delete(Emprestimo emprestimo){
        long id = emprestimo.getIdEmprestimo();
        emprestimoMap.remove(id);
    }

    public void deleteMany(){
        emprestimoMap.clear();
    }
}