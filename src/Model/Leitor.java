package Model;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import DAO.Leitor.LeitorDAO;
import Excecao.EmprestimoExcecao;
import Excecao.LivroExcecao;

/**
 * A classe Leitor é subclasse da classe Pessoa,
 * herdando seus atributos e métodos.
 * Contém atributos como block, que indica se o
 * leitor está bloqueado, e prazo, que armazena a data final que o leitor
 * está bloqueado. Contém também um construtor
 * para criar o objeto e métodos getters e setters
 * para obter e alterar os atributos privados.
 * E metódos que são especificos para
 * as funcionalidades de um leitor, como fazer
 * reserva, renovar emprestimo, sair da fila de
 * reserva e verificar se está com multa ativa.
 *
 * @author Letícia Gonçalves e Helena Filemon
 */
public class Leitor extends Pessoa{  //leitor
    public boolean block;

    public LocalDate prazo;

    /**
     * Construtor da classe Leitor
     * @param nome          Nome do leitor
     * @param id            Id do leitor
     * @param senha         Senha do leitor
     * @param idade         Idade do leitor
     * @param celular       Celular do leitor
     * @param endereco      Endereço do leitor
     */
    public Leitor(String nome, long id, String senha, int idade, String celular, String endereco) {
        super(nome, id, senha, idade, celular,endereco);
        this.prazo = null;
    }

    /**
     * Estado de bloqueio do leitor
     * @return true se leitor bloqueado e false para desbloqueado
     */
    public Boolean getBlock() {
        if(block){
            return true;
        } else{
            return false;
        }
    }

    /**
     * Bloqueia leitor com block como true
     * @param leitor leitor bloqueado
     */
    public void bloqueiaLeitor(Leitor leitor){
        leitor.block = true;
    }

    /**
     * Desbloqueia leitor com block como false
     * @param leitor leitor desbloqueado
     */
    public void desbloqueiaLeitor(Leitor leitor){
        leitor.block = false;
    }

    /**
     * Adiciona leitor na fila de reserva do livro.
     * @param leitor    Leitor
     * @param livro     livro
     * @throws LivroExcecao Exceções de livro
     */
    public void reservaLivro(Leitor leitor, Livro livro) throws LivroExcecao{
        if(livro.getQuantidadeDisponivel() > 0){
            throw new LivroExcecao(LivroExcecao.Disponivel); //logo, vc pode ir fazer o emprestimo com o bibliotecario
        }
        else{
            livro.addReservaFila(leitor); }
    }

    /**
     * Remove da fila de reserva do livro.
     * @param leitor Leitor
     * @param livro Livro
     */
    public void removeReservaFila(Leitor leitor, Livro livro){
        livro.removeReservaFila(leitor);
    }

    /**
     * Calcula data final para devolução com prazo de 7 dias
     * @param data Data inicial
     * @return data final para devolução
     */
    public LocalDate datafinal(LocalDate data){
        return data.plusDays(7);
    }

    /**
     * Renova o emprestimo, adiando a data de devolução.
     * @param leitor                Leitor
     * @param emprestimo            Emprestimo
     * @param livro                 Livro
     * @throws EmprestimoExcecao    Exceções de Emprestimo
     */
    public void renova_emprestimo(Leitor leitor, Emprestimo emprestimo, Livro livro) throws EmprestimoExcecao {
        if (!emprestimo.getAtivo()) { //se for falso
              throw new EmprestimoExcecao(EmprestimoExcecao.EmprestimoFinalizado);}
        else if (livro.getReservaFila().isEmpty()) { //se contém elementos na fila, contém pessoas
                throw new EmprestimoExcecao(EmprestimoExcecao.FilaEmprestimo);}
        else if (leitor.getBlock()) {
                     throw new EmprestimoExcecao(EmprestimoExcecao.LeitorBloqueadoEmprestimo);}
        else if (emprestimo.getRenovacaoQuantidade() == 3) {
                        throw new EmprestimoExcecao(EmprestimoExcecao.LimiteDeRenovacoes);
                    } else {
                        emprestimo.setRenovacaoQuantidade(1); //soma renovação
                        emprestimo.setDataDevolucao(datafinal(emprestimo.getDataDevolucao())); //pega a data final e soma + 7 dias
                    }
        }

    /**
     *Verifica se o leitor está com multa
     * @param leitor Leitor
     * @return booleano referente ao leitor bloqueado ou desbloqueado
     */
    public boolean desbloqueia (Leitor leitor){
        LocalDate now = LocalDate.now();
        if (prazo != null)
            if (now.isAfter(leitor.prazo)) { // se  dia atual for depois do prazo da multa
                leitor.block = false; // leitor desbloqueado
                leitor.prazo = null; // retira a multa
        }
        return leitor.block;
    }
}