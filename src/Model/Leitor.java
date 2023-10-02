package Model;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import DAO.Leitor.LeitorDAO;
import Excecao.EmprestimoExcecao;
import Excecao.LivroExcecao;

public class Leitor extends Pessoa{  //leitor
    public boolean block;

    public LocalDate prazo;

    public Leitor(String nome, long id, String senha, int idade, String celular, String endereco) {
        super(nome, id, senha, idade, celular,endereco);
        this.prazo = null;
    }

    public Boolean getBlock() {
        if(block){
            return true;
        } else{
            return false;
        }
    }

    public void bloqueiaLeitor(Leitor leitor){
        leitor.block = true;
    }

    public void desbloqueiaLeitor(Leitor leitor){
        leitor.block = false;
    }

    public void reservaLivro(Leitor leitor, Livro livro) throws LivroExcecao{
        if(livro.getQuantidadeDisponivel() > 0){
            throw new LivroExcecao(LivroExcecao.Disponivel); //logo, vc pode ir fazer o emprestimo com o bibliotecario
        }
        else{
            livro.addReservaFila(leitor); }
    }

    public void removeReservaFila(Leitor leitor, Livro livro){
        livro.removeReservaFila(leitor);
    }

    public LocalDate datafinal(LocalDate data){
        return data.plusDays(7);
    }

    public void renova_emprestimo(Leitor leitor, Emprestimo emprestimo, Livro livro) throws EmprestimoExcecao {
        if (!emprestimo.getAtivo()) { //se for falso
              throw new EmprestimoExcecao(EmprestimoExcecao.EmprestimoFinalizado);}
        else if (livro.getReservaFila().isEmpty()) { //se contém elementos na fila, logo contém pessoas
                throw new EmprestimoExcecao(EmprestimoExcecao.FilaEmprestimo);}
        else if (leitor.getBlock()) {
                     throw new EmprestimoExcecao(EmprestimoExcecao.LeitorBloqueadoEmprestimo);}
        else if (emprestimo.getRenovacaoQuantidade() == 3) {
                        throw new EmprestimoExcecao(EmprestimoExcecao.LimiteDeRenovacoes);
                    } else {
                        emprestimo.setRenovacaoQuantidade(1); //soma uma renovação
                        emprestimo.setDataDevolucao(datafinal(emprestimo.getDataDevolucao())); //pega a data final e soma + 10 dias, e fica sendo a nova data devolução
                    }
        }

    public boolean desbloqueia (Leitor leitor){
        LocalDate now = LocalDate.now();
        if (prazo != null)
            if (now.isAfter(leitor.prazo)) { // se o dia atual é depois do prazo da multa
                leitor.block = false; // leitor é desbloqueado
                leitor.prazo = null; // retira a data referente a multa
        }
        return leitor.block;
    }
}