package Model;

import java.util.List;
import DAO.DAO.livroDAO;

import static DAO.DAO.livroDAO;

public class Pessoa {
    private String nome;
    private long id;
    private String senha;
    private int idade;
    private String celular;
    private String endereco;

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
    //o metodo equals verifica se as senhas de dois objetos são iguais
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

    public List<Livro> procuraPorTitulo(String titulo) {
        // Chama o método de pesquisa por título no DAO de livros
        return livroDAO.findTitulo(titulo);
    }

    public List<Livro> procuraPorAutor(String autor) {
        // Chama o método de pesquisa por autor no DAO de livros
        return livroDAO.findAutor(autor);
    }

    public List<Livro> procuraPorCategoria(String categoria) {
        // Chama o método de pesquisa por categoria no DAO de livros
        return livroDAO.findCategoria(categoria);
    }
}
