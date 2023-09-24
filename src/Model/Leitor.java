package Model;
import java.util.Date;

public class Leitor extends Pessoa{  //leitor
    public Boolean block;
    //public List<Emprestimo> loan_history;
    // Construtor para a classe Reader
    public Leitor(String nome, String id, String senha, int idade, int celular, Endereco endereco, Boolean block) {
        super(nome, id, senha, idade, celular, block);
        this.block = block;
    }
    public int reserva_livro(){ //EM DESENVOLVIMENTO
        return 1;};
    public void renova_emprestimo(){ //EM DESENVOLVIMENTO
    }
    public void update_historico(){ //EM DESENVOLVIMENTO
    }
}
