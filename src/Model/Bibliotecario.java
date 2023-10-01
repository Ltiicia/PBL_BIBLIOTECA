package Model;

import DAO.Livro.LivroDAO;
import DAO.DAO;
import java.util.Calendar;
import java.util.Date;

public class Bibliotecario extends Pessoa {

    private int idEmprestimo = 0;

    private int generateId(int idEmprestimo){ //Gera id automaticamente
        return idEmprestimo+=1;
    }
    public Bibliotecario(String nome, long id, String senha, int idade, String celular, String endereco) {
        super(nome, id, senha, idade, celular, endereco);
    }
    public Date datahoje(){
        return new Date();
    }

    public Date datafinal(Date datahoje){ //data final com prazo de 7 dias
        // Convertendo a data atual para um objeto Calendar
        Calendar calendario = Calendar.getInstance();
        calendario.setTime(datahoje);
        // Somando 10 dias à data de hoje
        calendario.add(Calendar.DAY_OF_MONTH, 7);
        // Obtendo a nova data após a adição de 7 dias
        return calendario.getTime();
    }

    public void registro_emprestimo(Leitor leitor, Livro livro){

        int emprestimoId = generateId(idEmprestimo);
        Date dataEmprestimo = datahoje();
        Date dataDevolucao = datafinal(dataEmprestimo);


        Emprestimo emprestimo = new Emprestimo(emprestimoId, leitor.getId(), livro, dataEmprestimo, dataDevolucao, 0);
        System.out.println("\nEmprestimo realizado!");

    }
    public void registrar_livro(String titulo, String autor, String editora, int Isbn, Date anoPublicacao, String categoria, LocalizaLivro localizacao, int quantidade){
        Livro livro = new Livro(titulo, autor, editora, Isbn, anoPublicacao, categoria, localizacao, quantidade);
        LivroDAO livroDAO = DAO.getLivroDAO(); //Usando o DAO para adicionar o livro ao banco de dados
        livroDAO.create(livro); //criou o book no banco de dados e armazenou no map tendo o seu isbn como id
        System.out.println("\nRegistro realizado!");

    }
    public void registro_devolucao(Leitor leitor, Livro livro){
        //fazer
    }
}
