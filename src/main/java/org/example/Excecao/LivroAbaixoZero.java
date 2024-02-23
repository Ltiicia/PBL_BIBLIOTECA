package org.example.Excecao;

public class LivroAbaixoZero extends Exception{
    public LivroAbaixoZero() {
        super();
    }

    public LivroAbaixoZero(String mensagem) {
        super(mensagem);
    }
}
