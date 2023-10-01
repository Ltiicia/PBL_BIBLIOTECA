package Excecao;

import Model.Pessoa;

public class PessoaExcecao extends Exception{

    //emprestar a leitor bloqueado
    public static final String LeitorBloqueadoEmprestimo = "Este leitor está bloqueado. ";

    //reservar livro estando bloqueado
    public static final String LeitorBloqueadoReserva = "Este leitor está bloqueado. ";

    //cadastrar mesmo usuario duas vezes
    public static final String UsuarioJaCadastrado = "Usuário já cadastrado. ";

    //inconsistencia de dados ao logar
    public static final String InconsistenciaLogin = "Erro no login. ";

    //bloquear leitor que já está bloquado
    public static final String LeitorJaBloqueado = "Este leitor já está bloqueado. ";

    //desbloquear leitor que já foi desbloqueado
    public static final String LeitorJaDesbloqueado = "Este leitor já foi desbloqueado. ";

    public PessoaExcecao(String message){
        super(message);
    }
}