package org.example.Excecao;

public class LivroExcecao extends Exception{

    //disponibilidade de um livro
    public static final String Disponivel = "Este livro está disponível. ";
    public static final String Indisponivel = "Esse livro está indisponível. ";

    //emprestar livro emprestado
    public static final String LivroJaEmprestado = "Este livro está emprestado no momento. ";

    //renovar livro reservado
    public static final String RenovarLivroReservado = "Este livro não pode ser renovado pois já foi reservado. ";

    //inconsistencia de dados do livro
    public static final String InconsistenciaDeDados = "Há erro nos dados do livro. ";

    //livro já cadastrado
    public static final String LivroJaCriado = "Este livro já foi criado. ";

    //erro no isbn
    public static final String ErroIsbn = "Erro no ISBN. ";

    //
    public static final String ErroNaQuantidade = "A quantidade tem que ser maior que 0.";

    //dados para relatório
    public static final String SemLivrosEmprestados = "Nenhum livro emprestado. ";
    public static final String SemLivrosReservados = "Nenhum livro reservado. ";
    public static final String SemLivrosAtrasados = "Nenhum livro atrasado. ";


    public LivroExcecao(String message) {
        super(message);
    }
}