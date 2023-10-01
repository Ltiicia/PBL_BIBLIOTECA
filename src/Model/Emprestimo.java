package Model;
import java.time.LocalDate;
import java.util.Date;

public class Emprestimo {
    private long idEmprestimo;
    private long idLeitor;
    private Livro livro;

    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;
    private boolean ativo;
    private int renovacaoQuantidade;



    public Emprestimo(int idEmprestimo, int idLeitor, Livro livro, LocalDate dataEmprestimo, LocalDate dataDevolucao,boolean ativo, int renovacaoQuantidade) {
        this.idEmprestimo = idEmprestimo;
        this.idLeitor = idLeitor;
        this.livro = livro;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
        this.ativo = ativo;
        this.renovacaoQuantidade = renovacaoQuantidade;
    }
    public long getIdEmprestimo() {
        return idEmprestimo;
    }
    public long getIdLeitor(){
        return idLeitor;
    }
    public Livro getLivro(){
        return livro;
    }
    public LocalDate getDataEmprestimo(){
        return dataEmprestimo;
    }
    public LocalDate getDataDevolucao(){
        return dataDevolucao;
    }

    public boolean getAtivo() {
        return ativo;
    }

    public int getRenovacaoQuantidade(){
        return renovacaoQuantidade;
    }

    //MÉTODOS SET
    public void setIdEmprestimo(long idEmprestimo){
        this.idEmprestimo = idEmprestimo;
    }
    public void setIdLeitor(long idLeitor){
        this.idLeitor = idLeitor;
    }

    public void setLivro(Livro livro){
        this.livro = livro;
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo){
        this.dataEmprestimo = dataEmprestimo;
    }
    public void setDataDevolucao(LocalDate dataDevolucao){
        this.dataDevolucao = dataDevolucao;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public void setRenovacaoQuantidade(int renovacaoQuantidade){
        this.renovacaoQuantidade = renovacaoQuantidade;

    }
}
