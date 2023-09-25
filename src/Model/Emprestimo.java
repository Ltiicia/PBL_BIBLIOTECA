package Model;
import java.util.Date;

public class Emprestimo {
    private int idEmprestimo;
    private int idLeitor;
    private Livro livro;
    private Date dataEmprestimo;
    private Date dataDevolucao;
    private int renovacaoQuantidade;

    public Emprestimo(int idEmprestimo, int idLeitor, Livro livro, Date dataEmprestimo, Date dataDevolucao, int renovacaoQuantidade) {
        this.idEmprestimo = idEmprestimo;
        this.idLeitor = idLeitor;
        this.livro = livro;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
        this.renovacaoQuantidade = renovacaoQuantidade;
    }
    public int getIdEmprestimo() {return idEmprestimo;}

    public int getIdLeitor(){
        return idLeitor;
    }
    public Livro getLivro(){
        return livro;
    }
    public Date getDataEmprestimo(){
        return dataEmprestimo;
    }
    public Date getDataDevolucao(){
        return dataDevolucao;
    }
    public int getRenovacaoQuantidade(){
        return renovacaoQuantidade;
    }

    //MÉTODOS SET
    public void setIdEmprestimo(int idEmprestimo){
        this.idEmprestimo = idEmprestimo;
    }
    public void setIdLeitor(int idLeitor){
        this.idLeitor = idLeitor;
    }

    public void setLivro(Livro livro){
        this.livro = livro;
    }

    public void setDataEmprestimo(Date dataEmprestimo){
        this.dataEmprestimo = dataEmprestimo;
    }
    public void setDataDevolucao(Date dataDevolucao){
        this.dataDevolucao = dataDevolucao;
    }
    public void setRenovacaoQuantidade(int renovacaoQuantidade){
        this.renovacaoQuantidade = renovacaoQuantidade;

    }
}
