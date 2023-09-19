package Model;

public class Leitor extends Pessoa {
    private String cpf;

    public Leitor(String nome, int id, String senha, String cpf) {
        super(nome, id, senha);
        this.cpf = cpf;
    }

    // Métodos getter e setter para o atributo CPF
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    // Método para pesquisar livros pelo título ou autor
    public Livro pesquisaLivros(String termo) {
        // Lógica para pesquisar livros no sistema
        for (Livro livro : biblioteca.getLivros()) {
            if (livro.getTitulo().contains(termo) || livro.getAutor().contains(termo)) {
                return livro; // Retorna o primeiro livro encontrado
            }
        }
        return null; // Retorna null se nenhum livro for encontrado
    }

    // Método para reservar um livro
    public void reservarLivro(Livro livro) {
        // Lógica para registrar a reserva do livro
        Reserva reserva = new Reserva(this, livro);
        biblioteca.registrarReserva(reserva);
    }

    // Método para renovar o empréstimo de um livro
    public void renovarEmprestimo(Livro livro) {
        // Lógica para renovar o empréstimo do livro pelo leitor
        Emprestimo emprestimo = biblioteca.obterEmprestimoAtivo(this, livro);
        if (emprestimo != null) {
            emprestimo.renovar();
        }
    }
}