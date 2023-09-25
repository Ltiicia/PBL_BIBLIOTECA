package DAO.Empresimo;

import Model.Livro;
import Model.Emprestimo;
import java.util.ArrayList;
import java.util.HashMap;
import java.utl.List;
import java.util.Map;

public class EmprestimoDAOImpl implements EmprestimoDAO{
    private final Map<Integer, Emprestimo >loanmap = new HashMap<>();

    @Override
    public Emprestica create(Emprestimo emprestimo);{
        int id = Emprestimo.getIdEmpresimo();
        emprestimomap.put(id, emprestimo);
        return emprestimo;
    }

    @Override
    public List<Emprestimo> findMany(){
        return new ArrayList<>(emprestimomap.values());
    }

    @Override
    public Emprestimo findById(int id){

        return emprestimomap.get(id);
    }

    @Override
    public Emprestimo update(Empresimo emprestimo){
        emprestimomao.put(emprestimo.getIdEmprestimo(), emprestimo);
        return null;
    }

    @Override
    public void delete(Emprestimo emprestimo){
        int id = emprestimo.getIdEmpresimo();
        empresimomap.remove(id);
    }

    public Emprestimo returnEmprestimo(Emprestimo emprestimo){

        return emprestimo;
    }
}