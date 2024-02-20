package org.example.Model;

import org.example.DAO.DAO;

import java.util.List;
import java.util.Objects;

/**
 * A classe é uma superclasse que implementa o
 * comportamento de uma pessoa (usuario). Portanto ela contém
 * os atributos de uma pessoa como nome, id, senha,
 * endereço e telefone. Além disso, ela contém um
 * construtor para criar o objeto e métodos getters e
 * setters para pegar e alterar os atributos privados.
 * Contém também metódos que são utlizados para
 * fazer pesquisas de livros.
 *
 * @author Letícia Gonçalves e Helena Filemon
 */
public class Pessoa {
    private String nome;
    private String cpf;
    private String senha;
    private String celular;
    private String endereco;


    /**
     * Contrutor da Classe Pessoa.
     * @param nome              Nome da Pessoa
     * @param cpf                Id da Pessoa
     * @param senha             Senha da Pessoa
     * @param celular           Celular da Pessoa
     * @param endereco          Endereço da Pessoa
     */
    public Pessoa(String nome, String cpf, String senha, String celular, String endereco){  //construtor
        this.nome = nome;
        this.cpf = cpf;  //ALTERADO NA CLASSE PESSOADAOIMPL
        this.senha = senha;
        this.celular = celular;
        this.endereco = endereco;
    }
    // Métodos Get
    public String getNome() {

        return nome;
    }
    public String getCpf() {

        return cpf;
    }
    public String getSenha() {

        return senha;
    }
    public String getCelular() {

        return celular;
    }
    public String getEndereco(){
        return endereco;
    }

    // Métodos Set
    public void setNome(String nome) {

        this.nome = nome;
    }
    public void setCpf(String cpf) {

        this.cpf = cpf;
    }
    public void setSenha(String Senha) {

        this.senha = Senha;
    }
    public void setCelular(String celular) {

        this.celular = celular;
    }

    public void setEndereco(String endereco){
        this.endereco = endereco;
    }
    @Override
    public String toString() {
        return "[Pessoa]: " + cpf + "\n -Informações-\n" + "nome: " + nome + "celular: " + celular + "endereço:" + endereco;
    }

    /**
     * Compara um objeto com outro para verificar se os IDs são iguais.
     * @param obj objeto a ser comparado
     * @return true se os IDs forem iguais e false se forem diferentes.
     */
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (obj == null || getClass() != obj.getClass()){
            return false;
        }
        Pessoa pessoa = (Pessoa) obj;
        return Objects.equals(cpf, pessoa.cpf);
    }

    /**
     * Pesquisa por titulo
     * @param titulo Titulo
     * @return livro encontrado
     */
    public List<Livro> procuraPorTitulo(String titulo) {
        // Chama o método de pesquisa por título no DAO de livros
        return DAO.livroDAO.findTitulo(titulo);
    }

    /**
     * Pesquisa por Autor
     * @param autor Autor
     * @return livro encontrado
     */
    public List<Livro> procuraPorAutor(String autor) {
        // Chama o método de pesquisa por autor no DAO de livros
        return DAO.livroDAO.findAutor(autor);
    }

    /**
     * Pesquisa por Categoria
     * @param categoria categoria
     * @return livro encontrado
     */
    public List<Livro> procuraPorCategoria(String categoria) {
        // Chama o método de pesquisa por categoria no DAO de livros
        return DAO.livroDAO.findCategoria(categoria);
    }
}
