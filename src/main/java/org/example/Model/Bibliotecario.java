package org.example.Model;

import org.example.DAO.Emprestimo.EmprestimoDAO;
import org.example.DAO.Emprestimo.EmprestimoDAOArq;
import org.example.DAO.DAO;
import org.example.Excecao.EmprestimoExcecao;
import org.example.Excecao.LivroExcecao;

import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

/**
 * A classe Bibliotecario é uma subclasse da classe Pessoa,
 * herdandado os seus atributos e métodos.
 * Contém um construtor para criar o
 * objeto e métodos getters e setters para obter e
 * alterar os atributos privados. Contémmetódos que são
 * especificos para um bibliotecario, fazer emprestimo
 * devolução e registrar livro.
 *
 * @author Letícia Gonçalves e Helena Filemon
 */
public class Bibliotecario extends Pessoa {

    Relatorios relatorios = DAO.getRelatoriosDAO().getRelatorios();

    EmprestimoDAOArq emprestimoDAO = new EmprestimoDAOArq();

    /**
     *
     * @param nome    nome do bibliotecario
     * @param cpf        id do bibliotecario
     * @param senha     senha do biliotecario
     *
     * @param celular   número do bibliotecario
     * @param endereco  endereco do bibliotecario
     */
    public Bibliotecario(String tipo, String nome, String cpf, String senha, String celular, String endereco) throws Exception {
        super(tipo, nome, cpf, senha, celular, endereco);
    }

    /**
     * Obtem a data atual
     *
     * @return data hoje
     */
    public LocalDate dataHoje(){
        return LocalDate.now();
    }

    /**
     * Calcula o prazo de 7 a partir da data atual
     *
     * @param datahoje data atual
     * @return datafinal
     */
    public LocalDate datafinal(LocalDate datahoje){ //data final com prazo de 7 dias
        // Convertendo a data atual para um objeto Calendar
        return dataHoje().plusDays(7);
    }

    /**
     * Registra o emprestimo do leitor
     * @param leitor leitor fazendo o emprestimo
     * @param livro livro a ser emprestado
     * @throws LivroExcecao tratando os erros relacionados ao livro
     * @throws EmprestimoExcecao tratando os erros relacionados ao emprestimo
     */
    public void registroEmprestimo(Leitor leitor, Livro livro) throws Exception { // registrar emprestimo de leitor
        if(livro.getQuantidadeDisponivel() == 0){ //se livro disponivel
            throw new LivroExcecao(LivroExcecao.Indisponivel);}
        else{
            if(livro.getReservaFila().isEmpty()){  //retorna true se fila vazia, false se elemento tiver pessoa
                if(leitor.getBlock()){ //retorna true se estiver bloqueado
                    throw new EmprestimoExcecao(EmprestimoExcecao.LeitorBloqueadoEmprestimo);}
                else{
                    // Gera ID do empréstimo
                    long emprestimoId = emprestimoDAO.getProxId();
                    LocalDate dataEmprestimo = dataHoje(); //data do emprestimo
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    String dataFormatada = dataEmprestimo.format(formatter);
                    // Calcule data de devolução (7 dias a partir da data de empréstimo)
                    LocalDate dataDevolucao = datafinal(dataEmprestimo);
                    Emprestimo emprestimo = new Emprestimo(livro, dataFormatada, leitor);
                    //Usa DAO para add o emprestimo no banco de dados
                    EmprestimoDAO emprestimodao = DAO.getEmprestimoDAO();
                    emprestimodao.create(emprestimo);
                    livro.setQuantidadeEmprestimo(1); //soma variavel da quantidade de emprestimo
                    livro.setQuantidadeDisponivel(livro.getQuantidadeDisponivel() - 1); // atuaza quantidade disponível do livro
                    relatorios.guardaLivrosEmprestados(livro); //add na lista livros emprestados no momento
                    DAO.getRelatoriosDAO().save(relatorios); // salva relatório
                }
            }else{
                if(livro.getReservaFila().element() == leitor){  //se o leitor for o primeiro da fila, realiza o emprestimo, se não ele reserva o livro
                    //Gera ID do empréstimo
                    int emprestimoId = emprestimoDAO.getProxId();
                    LocalDate dataEmprestimo = dataHoje();//data do emprestimo
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    String dataFormatada = dataEmprestimo.format(formatter);
                    //Calcula data de devolução (7 dias a partir da data de empréstimo)
                    LocalDate dataDevolucao = datafinal(dataEmprestimo);
                    //Cria um emprestimo
                    Emprestimo emprestimo = new Emprestimo(livro, dataFormatada, leitor);
                    //Usa DAO para adicionar o emprestimo ao banco de dados
                    EmprestimoDAO emprestimodao = DAO.getEmprestimoDAO();
                    emprestimoDAO.create(emprestimo); //adiciona no banco de dados
                    livro.setQuantidadeEmprestimo(1); //soma a variavel da quantidade de emprestimo
                    livro.setQuantidadeDisponivel(livro.getQuantidadeDisponivel() - 1); // atualiza quantidade disponível do livro
                    relatorios.guardaLivrosEmprestados(livro); //add na lista de livros emprestados
                    DAO.getRelatoriosDAO().save(relatorios); // salva o relatório
                    livro.getReservaFila().remove(); //remove o primeiro elemento depois do emprestimo
                }else{
                    throw new LivroExcecao(LivroExcecao.Indisponivel);}}}}

    /**
     * Registra um livro novo no sistema
     * @param isbn              ISBN do livro
     * @param titulo            Titulo do livro
     * @param autor             Autor do livro
     * @param editora           Editora do livro
     * @param anoPublicacao     Publicação do livro
     * @param categoria         Categoria do livro
     * @param localizacao       Localização do livro
     * @param quantidade        Quantidade do livro
     */

    public void registroLivro(String isbn, String titulo, String autor, String editora, Year anoPublicacao, String categoria, LocalizaLivro localizacao, int quantidade) throws Exception {
        Livro newLivro = new Livro(isbn, titulo, autor, editora, anoPublicacao, categoria,localizacao , quantidade);

        for (Livro livro : DAO.getLivroDAO().findMany()) {
            if (Objects.equals(livro.getIsbn(), newLivro.getIsbn())) { // verifica isbn dos livros se iguais
                // se já existe esse livro cadastrado só soma a quantidade existente do livro
                livro.setQuantidadeDisponivel(livro.getQuantidadeDisponivel() + newLivro.getQuantidadeDisponivel());
                DAO.getLivroDAO().update(livro); // atualiza os dados no DAO
                return ;
            }
        }
        DAO.getLivroDAO().create(newLivro); // cria o livro e armazena no HashMap com o isbn como chave
    }

    /**
     * Método que faz a devolução de um empréstimo
     *
     * @param emprestimo  emprestimo a ser devolvido
     * @param leitor      leitor devolvendo
     */
    public void registroDevolucao(Emprestimo emprestimo, Leitor leitor){
        if(emprestimo.getAtivo()) { //se emprestimo ativo
            // verifica se a data de devolução condiz com o esperado
            LocalDate now = LocalDate.now();
            if (now.isAfter(emprestimo.getDataDevolucao())) { // se data da devolução passou do prazo
                // leitor multado
                long dias = ChronoUnit.DAYS.between(emprestimo.getDataDevolucao(), now) * 2; // dobro de dias de atraso
                leitor.prazo = LocalDate.now().plusDays(dias);
                leitor.block = true;
            }
            // devolve o livro
            emprestimo.setAtivo(false); // muda o estado de ativo do emprestimo para falso
            Livro livro= emprestimo.getLivro();
            livro.setQuantidadeDisponivel(livro.getQuantidadeDisponivel() + 1); // atualiza a quantidade do livro disponível
            relatorios.tiraLivrosEmprestados(livro); //remove da lista de livros emprestados
        }
    }
}
