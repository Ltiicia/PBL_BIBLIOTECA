package Model;
import java.time.LocalDate;
import java.util.Date;

/**
 *A classe Emprestimo contém atributos para a realização do
 *emprestimo, como, id do leitor, id do emprestimo, livro, data de
 *devolução, data de emprestimo, quantidade de
 *renovações um booleano que indica se o emprestimo está ativo ou não.
 *Além disso, ela contém um construtor para criar o
 *objeto e métodos getters e setters para obter e alterar
 *os atributos privados.
 *
 * @author Letícia Gonçalves e Helena Filemon
 */
public class Emprestimo {
    private long idEmprestimo;
    private long idLeitor;
    private Livro livro;

    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;
    private boolean ativo = true;
    private int renovacaoQuantidade;

    /**
     * Construtor da Classe Emprestimo
     * @param idEmprestimo          Id do emprestimo
     * @param idLeitor              Id do leitor
     * @param livro                 Livro emprestado
     * @param dataEmprestimo        Data do emprestimo
     * @param dataDevolucao         Data da devolução
     */

    public Emprestimo(long idEmprestimo, long idLeitor, Livro livro, LocalDate dataEmprestimo, LocalDate dataDevolucao) {
        this.idEmprestimo = idEmprestimo;
        this.idLeitor = idLeitor;
        this.livro = livro;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
    }

    //Métodos get
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
        this.renovacaoQuantidade += renovacaoQuantidade;

    }
}
