package Model;

import DAO.Emprestimo.EmprestimoDAO;
import DAO.Emprestimo.EmprestimoDAOImpl;
import DAO.Livro.LivroDAO;
import DAO.DAO;
import Excecao.EmprestimoExcecao;
import Excecao.LivroExcecao;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Bibliotecario extends Pessoa {

    Relatorios relatorios = DAO.getRelatoriosDAO().getRelatorios();

    EmprestimoDAOImpl emprestimoDAO = new EmprestimoDAOImpl();

    public Bibliotecario(String nome, long id, String senha, int idade, String celular, String endereco) {
        super(nome, id, senha, idade, celular, endereco);
    }
    public LocalDate dataHoje(){
        return LocalDate.now();
    }

    public LocalDate datafinal(LocalDate datahoje){ //data final com prazo de 7 dias
        // Convertendo a data atual para um objeto Calendar
        return dataHoje().plusDays(7);
    }

    public void registroEmprestimo(Leitor leitor, Livro livro) throws LivroExcecao, EmprestimoExcecao { // registrar emprestimo de leitor
        if(livro.getQuantidadeDisponivel() == 0){ //se tem livro disponivel
            throw new LivroExcecao(LivroExcecao.NotAvailable);}
        else{
            if(livro.getReservaFila().isEmpty()){  //retorna true se a fila estiver vazia e false se tiver um elemento ao menos tiver uma pessoa
                if(leitor.getBlock()){ //retorna true se estiver block
                    throw new EmprestimoExcecao(EmprestimoExcecao.UserBlock);}
                else{
                    // Gera automaticamente o ID do empréstimo
                    long emprestimoId = emprestimoDAO.getProxId();
                    LocalDate dataEmprestimo = dataHoje(); //diz a data do dia atual ou seja, a data do emprestimo
                    // Calcule a data de devolução (10 dias a partir da data de empréstimo)
                    LocalDate dataDevolucao = datafinal(dataEmprestimo);
                    // Criando um emprestimo
                    Emprestimo emprestimo = new Emprestimo(emprestimoId, leitor.getId(), livro, dataEmprestimo, dataDevolucao);
                    //Usando o DAO para adicionar o emprestimo ao banco de dados
                    EmprestimoDAO emprestimodao = DAO.getEmprestimoDAO();
                    emprestimodao.create(emprestimo);
                    livro.setQuantidadeEmprestimo(1); //soma a variavel da quantidade de emprestimo
                    livro.setQuantidadeDisponivel(livro.getQuantidadeDisponivel() - 1); // atualizando a quantidade disponível do livro
                    relatorios.guardaLivrosEmprestados(livro); //add na lista de livros emprestados no momento
                    DAO.getRelatoriosDAO().save(relatorios); // salva o relatório
                }
            }else{ //aq no caso de ter elementos na fila
                if(livro.getReservaFila().element() == leitor){  //no caso de o leitor ser o primeiro da fila, realiza o emprestimo, se não ele tem que reservar o livro
                    // Gere automaticamente o ID do empréstimo
                    long emprestimoId = emprestimoDAO.getProxId();
                    LocalDate dataEmprestimo = dataHoje(); //diz a data do dia atual ou seja, a data do emprestimo
                    // Calcule a data de devolução (10 dias a partir da data de empréstimo)
                    LocalDate dataDevolucao = datafinal(dataEmprestimo);
                    // Criando um emprestimo
                    Emprestimo emprestimo = new Emprestimo(emprestimoId, leitor.getId(), livro, dataEmprestimo, dataDevolucao);
                    //Usando o DAO para adicionar o emprestimo ao banco de dados
                    EmprestimoDAO emprestimodao = DAO.getEmprestimoDAO();
                    emprestimoDAO.create(emprestimo); //adicionando no banco de dados
                    livro.setQuantidadeEmprestimo(1); //soma a variavel da quantidade de emprestimo
                    livro.setQuantidadeDisponivel(livro.getQuantidadeDisponivel() - 1); // atualizando a quantidade disponível do livro
                    relatorios.guardaLivrosEmprestados(livro); //add na lista de livros emprestados no momento
                    DAO.getRelatoriosDAO().save(relatorios); // salva o relatório
                    livro.getReservaFila().remove(); //removendo o primeiro elemento após concluir o emprestimo
                }else{
                    throw new LivroExcecao(LivroExcecao.NotAvailable);}}}}


    public void registroLivro(String isbn, String titulo, String autor, String editora, int anoPublicacao, String categoria, String endereco, int quantidade) {
        Livro newLivro = new Livro(isbn, titulo, autor, editora, anoPublicacao, categoria, endereco, quantidade);

        for (Livro livro : DAO.getLivroDAO().findMany()) {
            if (livro.getIsbn() == newLivro.getIsbn()) { // se o isbn dos livros forem iguais
                // já existe esse livro cadastrado logo só se soma a quantidade existente do livro
                livro.setQuantidadeDisponivel(livro.getQuantidadeDisponivel() + newLivro.getQuantidadeDisponivel());
                DAO.getLivroDAO().update(livro); // atualizando os dados no DAO
                //System.out.println("\nsuccessfully registered book!");
                return; // sai do método pois o livro já foi cadastrado
            }
        }
        DAO.getLivroDAO().create(newLivro); // criou o livro e o armazenou no map tendo o seu isbn como id
        //System.out.println("\nsuccessfully registered book!");
    }
    public void registerDevolution(Emprestimo emprestimo, Leitor leitor){
        if(emprestimo.getAtivo()) { //se o emprestimo estiver ativo
            // verificar se a data de devolução condiz com o esperado
            LocalDate now = LocalDate.now();
            if (now.isAfter(emprestimo.getDataDevolucao())) { // se a data de devolução passou do esperado
                // leitor é multado
                long dias = ChronoUnit.DAYS.between(emprestimo.getDataDevolucao(), now) * 2; // dobro de dias de atraso
                leitor.prazo = LocalDate.now().plusDays(dias);
                leitor.block = true;
            }
            // devolve o livro
            emprestimo.setAtivo(false); // mudando o estado de ativo do emprestimo para falso
            Livro livro= emprestimo.getLivro();
            livro.setQuantidadeDisponivel(livro.getQuantidadeDisponivel() + 1); // atualizando a quantidade de determinado livro disponível
            relatorios.tiraLivrosEmprestados(livro); //remove da lista de livros emprestados no momento
        }
    }
}
