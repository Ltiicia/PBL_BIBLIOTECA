package Excecao;

public class LivroExcecao extends Exception{
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

    public LivroExcecao(String message){
        super(message);
}