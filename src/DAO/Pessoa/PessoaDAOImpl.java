package DAO.Pessoa;

import Model.Pessoa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PessoaDAOImpl implements PessoaDAO {

    private final Map<Integer, Pessoa> pessoaMap = new HashMap<>(); //map dos usuarios

    private int proxID=1000;
    private int getProxID() {
        /**
         * A++ -> usa o valor de A e depois incrementa A
         * ++A -> incrementa o valor de A e depois utiliza o valor de A
         */
        return this.proxID++; //Retorna ID para o objeto atual e define o próximo ID
    }
    @Override
    public Pessoa create(Pessoa pessoa) {
        pessoa.setId(getProxID()); //aq vai adicionar o id automaticamente no atributo id
        pessoaMap.put(pessoa.getId(), pessoa);
        return pessoa;
    }

    @Override
    public void delete(Pessoa pessoa) {
        int id = pessoa.getId();
        pessoaMap.remove(id);
    }

    @Override
    public Pessoa update(Pessoa pessoa) {
        pessoaMap.put(pessoa.getId(), pessoa);
        return null;
    }

    @Override
    public List<Pessoa> findMany() {
        return new ArrayList<>(pessoaMap.values());
    }

    @Override
    public Pessoa findById(int id) {
        return pessoaMap.get(id);
    }
}
