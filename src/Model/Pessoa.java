package Model;

public class Pessoa {
    private String nome;
    private int id;
    private String senha;

    public Pessoa(String nome, int id, String senha) {
        this.nome = nome;
        this.id = id;
        this.senha = senha;
    }

    // Métodos getter para acessar os atributos
    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }

    public String getSenha() {
        return senha;
    }

    // Métodos setter para definir os atributos (caso seja necessário)
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Model.Pessoa{" +
                "nome='" + nome + '\'' +
                ", id=" + id +
                ", senha='" + senha + '\'' +
                '}';
    }
}
