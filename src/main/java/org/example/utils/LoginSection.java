package org.example.utils;

public abstract class LoginSection {
        /** O objeto que representa o usuário atualmente logado na sessão. */
        private static Object pessoaNaSessao;

    /**
     * Obtém o usuário atualmente logado na sessão.
     *
     * @return O usuário atualmente logado na sessão.
     */
    public static Object getPessoaNaSessao(){
        return pessoaNaSessao;
    }

    /**
     * Realiza o login do usuário na sessão.
     *
     * @param user O usuário a ser logado na sessão.
     */
    public static void loginPessoa(Object pessoa){
        pessoaNaSessao = pessoa;
    }

    /**
     * Realiza o logout do usuário na sessão, removendo-o da sessão.
     */
    public static void logoutPessoa(){
        pessoaNaSessao= null;
    }
    }

