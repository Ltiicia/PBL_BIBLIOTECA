package org.example.Excecao;

public class IdExistente extends Exception{
    public IdExistente() {
        super();
    }

    public IdExistente(String mensagem) {
        super(mensagem);
    }
}
