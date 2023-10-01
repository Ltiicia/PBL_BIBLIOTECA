package Excecao;

import Model.Emprestimo;
import Model.Leitor;

public class EmprestimoExcecao extends Exception{

    //emprestar com limite de emprestimos atingido
    public static final String LimiteDeEmprestimos = "O limite de emprestimos para este leitor já foi atingido. ";

    //renovar livro mais que o limite de renovações
    public static final String LimiteDeRenovacoes = "Impossível renovar pois o limite de Renovações já foi ultrapassado. ";

    //fila de emprestimo já tem gente
    public static final String FilaEmprestimo = "Já há pessoas na fila";

    //
    //public static final String

    public EmprestimoExcecao(String message){
        super(message);
    }
}
