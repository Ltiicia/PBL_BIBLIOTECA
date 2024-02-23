package org.example.Model;
import org.example.DAO.DAO;
import org.example.Excecao.EmprestimoExcecao;
import org.example.Excecao.LivroExcecao;
import org.example.Excecao.PessoaExcecao;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

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
    private Livro livro;
    private String idLivro;
    private String cpf;
    private int id;



    private String dataEmprestimo;
    private LocalDate dataDevolucao;
    private boolean ativo = true;
    private int renovacaoQuantidade;
    private Leitor leitor;


    /**
     * Construtor da Classe Emprestimo
     *          Id do leitor
     * @param livro                 Livro emprestado
     * @param dataEmprestimo        Data do emprestimo
     *         Data da devolução
     */

    public Emprestimo(Livro livro, String dataEmprestimo, Leitor leitor) {
        this.livro = livro;
        this.dataEmprestimo = dataEmprestimo;
        this.leitor = leitor;
        this.id= -1;
    }

    //Métodos get
    public String getIdLivro() {
        return idLivro;
    }

    public int getId() {
        return 0;
    }

    public void setId(int id){
        this.id=id;
    }
    public Livro getLivro(){
        return livro;
    }

    public String getCpf() { return cpf;
    }
    public String getDataEmprestimo(){
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
    public Leitor getLeitor() {
        return leitor;
    }

    public void setUsuario(Leitor usuario) {
        this.leitor = usuario;
    }

    //MÉTODOS SET
    public void setIdLivro(String idLivro){
        this.idLivro = idLivro;
    }

    public void setLivro(Livro livro){
        this.livro = livro;
    }

    public void setDataEmprestimo(String dataEmprestimo){
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
    private void multas (Livro livro, Leitor leitor, LocalDate dataQueDevolveu) throws Exception {
        Emprestimo emprestimo = DAO.getEmprestimoDAO().findById(livro.getIsbn());
        if (dataQueDevolveu.isAfter(emprestimo.getDataDevolucao())) {
            long diferencaEntreDias = ChronoUnit.DAYS.between(emprestimo.getDataDevolucao(),dataQueDevolveu);
            int diasDeMulta = Math.toIntExact(diferencaEntreDias * 2);
            leitor.setfimMulta(dataQueDevolveu.plusDays(diasDeMulta));
            DAO.getLeitorDAO().update(leitor);
        }
    }

    public void registraDevolucao(Livro livro, Leitor leitor, LocalDate dataQueDevolveu) throws Exception {
        this.multas(livro,leitor,dataQueDevolveu);
        this.setAtivo(false);
        DAO.getEmprestimoDAO().update(this);
        livro.setDisponibilidade(true);
        DAO.getLivroDAO().update(livro);
    }



}
