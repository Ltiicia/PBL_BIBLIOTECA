package Model;
import java.util.Date;
public class Emprestimo {
    public int idEmprestimo;
    public int idLeitor;
    public Livro livro;
    public Date dataEmprestimo;
    public Date dataDevolucao;
    public int renovacaoQuantidade;
    public Boolean ativo;

}
