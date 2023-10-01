package Model;

import DAO.ADM.ADMDAO;
import DAO.Bibliotecario.BibliotecarioDAOImpl;
import DAO.DAO;
import DAO.Leitor.LeitorDAO;
import DAO.Leitor.LeitorDAOImpl;
import DAO.Livro.LivroDAOImpl;
import DAO.ADM.ADMDAOImpl;

import DAO.Bibliotecario.BibliotecarioDAO;
public class ADM extends Bibliotecario{

    LeitorDAOImpl leitorDAO = new LeitorDAOImpl();
    BibliotecarioDAOImpl bibliotecarioDAO = new BibliotecarioDAOImpl();
    ADMDAOImpl admDAO = new ADMDAOImpl();
    LivroDAOImpl livros = new LivroDAOImpl();

    /**
     * Construtor da classe Adm para criar um novo administrador.
     *
     * @param id      O ID do administrador.
     * @param nome    O nome do administrador.
     * @param senha     A senha do administrador.
     * @param celular   O número de telefone do administrador.
     * @param endereco O endereço do administrador.
     */
    public ADM(String nome,long id, String senha, int idade, String celular, String endereco) {
        super(nome, id, senha, idade, celular, endereco);
    }

    //CRIAÇÃO DE PESSOAS(USUARIOS)

    /**
     * Cria um novo leitor.
     *
     * @param nome        nome do leitor.
     * @param id
     * @param senha        senha do leitor
     * @param idade     .
     * @param celular   O número de telefone do leitor.
     * @param endereco O endereço do leitor.
     * @return O leitor recém-criado.
     */
    public Leitor createLeitor(String nome, String senha, int idade, String celular, String endereco){
        long id = leitorDAO.getProxId(); //ADD NA DAO LEITOR
        Leitor reader = new Leitor(nome, id, senha, idade, celular, endereco);
        //adicionar o reader ao banco de dados - falta fazer o dao reader
        LeitorDAO leitorDao = DAO.getLeitorDAO();
        leitorDao.create(reader); //criou o book no banco de dados e armazenou no map tendo o seu id como chave
        return reader;}

    /**
     * Cria um novo bibliotecário no sistema.
     *
     * @param name    O nome do bibliotecário.
     * @param pin     A senha do bibliotecário.
     * @param phone   O número de telefone do bibliotecário.
     * @param address O endereço do bibliotecário.
     * @return O bibliotecário recém-criado.
     */
    public Bibliotecario createBibliotecario(String nome, String senha, int idade, String celular, String endereco){ //bibliotecario não tem id
        long id = bibliotecarioDAO.getProxId();
        Bibliotecario bibliotecario = new Bibliotecario(nome, id, senha, idade, celular, endereco);
        //adicionar o reader ao banco de dados
        BibliotecarioDAO bibliotecarioDao = DAO.getBibliotecarioDAO();
        bibliotecarioDao.create(bibliotecario); //criou o book no banco de dados e armazenou no map tendo o seu id como chave
        return bibliotecario;}

    /**
     * Cria um novo administrador no sistema.
     *
     * @param name    O nome do administrador.
     * @param pin     A senha do administrador.
     * @param phone   O número de telefone do administrador.
     * @param address O endereço do administrador.
     * @return O administrador recém-criado.
     */
    public ADM createAdm(String nome, String senha, int idade, String celular, String endereco){
        long id = admDAO.getProxId();
        ADM adm = new ADM(nome, id, senha, idade, celular, endereco);

        ADMDAO admDao = DAO.getAdmDAO();
        admDao.create(ADM); //criou o book no banco de dados e armazenou no map tendo o seu id como chave
        return adm;}

    //OPERAÇÕES DE USUARIOS

    /**
     * Bloqueia um leitor no sistema.
     *
     * @param reader O leitor a ser bloqueado.
     * @throws UsersException se ocorrer um erro durante o bloqueio do leitor.
     */
    public void blockLeitor(Leitor leitor) throws UsersException{
        if(leitor.getBlock()){throw new UsersException(UsersException.AlreadyUserBlock);}
        else{leitor.bloqueiaLeitor(leitor);}

    /**
     * Desbloqueia um leitor no sistema.
     *
     * @param reader O leitor a ser desbloqueado.
     * @throws UsersException se ocorrer um erro durante o desbloqueio do leitor.
     */
    public void desbloqueiaLeitor(Leitor leitor) throws UsersException {
        if(!leitor.getBlock()){throw new UsersException(UsersException.AlreadyUserUnlock);}
        else{leitor.desbloqueiaLeitor(leitor);}


    //GERENCIAMENTO DO ACERVO - a adição de livros o adm herda do bibliotecario

    /**
     * Remove um livro do sistema.
     *
     * @param book O livro a ser removido.
     */
    public void removeLivro(Livro livro){
        livros.delete(livro);
    }

    /**
     * Atualiza as informações de um livro no sistema.
     *
     * @param book O livro a ser atualizado.
     */
    public void updateBook(Book book){books.update(book);}

    /**
     * Obtém a quantidade total de livros no sistema.
     */
    public void quantityBooks(){books.QuantityBooks();}
}

}
