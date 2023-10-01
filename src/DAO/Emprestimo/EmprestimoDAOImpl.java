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
    private final Map<Integer, Emprestimo> emprestimoMap = new HashMap<>();
    //dicionario p/ guardar os emprestimos

    private List<Emprestimo> emprestimos;
    //???

    public Emprestimo create(Emprestimo emprestimo){
        int id = emprestimo.getIdEmprestimo();
        emprestimoMap.put(id, emprestimo);
        return emprestimo;
    }
    //guarda os emprestimos na lista

    @Override
    public List<Emprestimo> findMany(){
        return new ArrayList<>(emprestimoMap.values());
    }
    //retorna lista de emprestimos

    @Override
    public Emprestimo findById(int id){

        return emprestimoMap.get(id);
    }
    //retorna o emprestimo por id

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

    /*
    @Override
    public List<Emprestimo> findByLeitor(Leitor leitor) {
        emprestimosLeitor = new ArrayList<>(emprestimoMap.values());
        for(Emprestimo emprestimosLeitor: emprestimoMap.values()){
            if(emprestimosLeitor.getLeitor().equals(leitor.getId()))
                emprestimosLeitor.add(emprestimosLeitor);
        }
        return emprestimosLeitor;
    }*/
}