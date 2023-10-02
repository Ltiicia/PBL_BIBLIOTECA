package Model;

import java.util.List;


import static DAO.DAO.livroDAO;

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
    private long id;
    private String senha;
    private int idade;
    private String celular;
    private String endereco;


    /**
     * Contrutor da Classe Pessoa.
     * @param nome              Nome da Pessoa
     * @param id                Id da Pessoa
     * @param senha             Senha da Pessoa
     * @param idade             Idade da Pessoa
     * @param celular           Celular da Pessoa
     * @param endereco          Endereço da Pessoa
     */
    public Pessoa(String nome, long id, String senha, int idade, String celular, String endereco){  //construtor
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
    public long getId() {

        return id;
    }
    public String getSenha() {

        return senha;
    }
    public int getIdade() {

        return idade;
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
    public void setId(long id) {

        this.id = id;
    }
    public void setSenha(String Senha) {

        this.senha = Senha;
    }
    public void setIdade(int idade) {

        this.idade = idade;
    }
    public void setCelular(String celular) {

        this.celular = celular;
    }

    public void setEndereco(String endereco){
        this.endereco = endereco;
    }
    @Override
    public String toString() {
        return "[Pessoa]: " + id + "\n -Informações-\n" + "nome: " + nome + "idade: " + idade + "celular: " + celular + "endereço:" + endereco;
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
        return id == pessoa.id;
    }

    /**
     * Pesquisa por titulo
     * @param titulo Titulo
     * @return livro encontrado
     */
    public List<Livro> procuraPorTitulo(String titulo) {
        // Chama o método de pesquisa por título no DAO de livros
        return livroDAO.findTitulo(titulo);
    }

    /**
     * Pesquisa por Autor
     * @param autor Autor
     * @return livro encontrado
     */
    public List<Livro> procuraPorAutor(String autor) {
        // Chama o método de pesquisa por autor no DAO de livros
        return livroDAO.findAutor(autor);
    }

    /**
     * Pesquisa por Categoria
     * @param categoria categoria
     * @return livro encontrado
     */
    public List<Livro> procuraPorCategoria(String categoria) {
        // Chama o método de pesquisa por categoria no DAO de livros
        return livroDAO.findCategoria(categoria);
    }
}
