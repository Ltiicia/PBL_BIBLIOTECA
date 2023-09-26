package DAO.Emprestimo;

import DAO.Emprestimo.EmprestimoDAO;
import Model.Livro;
import Model.Emprestimo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmprestimoDAOImpl implements EmprestimoDAO {
    private final Map<Integer, Emprestimo> emprestimoMap = new HashMap<>();

    public Emprestimo create(Emprestimo emprestimo){
        int id = emprestimo.getIdEmprestimo();
        emprestimoMap.put(id, emprestimo);
        return emprestimo;
    }

    @Override
    public List<Emprestimo> findMany(){
        return new ArrayList<>(emprestimoMap.values());
    }

    @Override
    public Emprestimo findById(int id){

        return emprestimoMap.get(id);
    }

    @Override
    public Emprestimo update(Emprestimo emprestimo){
        emprestimoMap.put(emprestimo.getIdEmprestimo(), emprestimo);
        return null;
    }

    @Override
    public void delete(Emprestimo emprestimo){
        int id = emprestimo.getIdEmprestimo();
        emprestimoMap.remove(id);
    }
    @Override
    public Emprestimo returnEmprestimo(Emprestimo emprestimo){

        return emprestimo;
    }
}