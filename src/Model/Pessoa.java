package model;
import Model.Endereco;

import java.util.Date;
public class Pessoa {
    private String nome;
    private int id;
    private String senha;
    private int idade;
    private int celular;
    private Endereco endereco;

    public Pessoa(String nome, String senha, int idade, int celular, Endereco endereco){  //construtor
        this.nome = nome;
        this.id = -1;  //ALTERADO NA CLASSE PESSOADAOIMPL
        this.senha = senha;
        this.idade = idade;
        this.celular = celular;
        this.endereco = endereco;
    }
    // Métodos Get
    public String getNome() {

        return nome;
    }
    public int getId() {

        return id;
    }
    public String getSenha() {

        return senha;
    }
    public int getIdade() {

        return idade;
    }
    public int getCelular() {

        return celular;
    }
    public Endereco getEndereco() {

        return endereco;
    }

    // Métodos Set
    public void setNome(String nome) {

        this.nome = nome;
    }
    public void setId(int id) {

        this.id = id;
    }
    public void setSenha(String Senha) {

        this.Senha = Senha;
    }
    public void setIdade(int idade) {

        this.idade = idade;
    }
    public void setCelular(int celular) {

        this.celular = celular;
    }
    public void setEndereco(Endereco endereco) {

        this.endereco = endereco;
    }
    @Override
    public String toString() {
        return "[Pessoa]: " + id + "\n -Informações-\n" + "nome: " + nome + "idade: " + idade + "celular: " + celular;
    }
    //o metodo equals verifica se as senhas de dois objetos são iguais
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (o == null || getClass() != o.getClass()){
            return false;
        }
       Pessoa pessoa = (Pessoa) o;
        return id == Pessoa.id;
    }
}
