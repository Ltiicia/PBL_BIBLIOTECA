package org.example.Model;

import org.example.DAO.ADM.ADMDAO;
import org.example.DAO.ADM.ADMDAOArq;
import org.example.DAO.Bibliotecario.BibliotecarioDAOArq;
import org.example.DAO.DAO;
import org.example.DAO.Leitor.LeitorDAO;
import org.example.DAO.Leitor.LeitorDAOArq;
import org.example.DAO.Livro.LivroDAOArq;

import org.example.DAO.Bibliotecario.BibliotecarioDAO;
import org.example.Excecao.PessoaExcecao;

/**
 * A classe Adm é uma subclasse da classe
 * Bibliotecario. Ela herda os atributos e
 * métodos da superclasse Bibliotecario. Contém um
 * construtor para criar o objeto e os
 * métodos getters e setters para obter e alterar
 * os atributos privados. Contém metódos que
 * são especificos para as funcionalidades de um administrador,
 * como criar novos usuarios, operações para usuarios
 * e gerenciar o acervo.
 *
 * @author Leticia Gonçalves e Helena Filemon
 */
public class ADM extends Bibliotecario{ //ADM cria os usuarios

    LeitorDAOArq leitorDAO = new LeitorDAOArq();
    BibliotecarioDAOArq bibliotecarioDAO = new BibliotecarioDAOArq();
    ADMDAOArq admDAO = new ADMDAOArq();
    LivroDAOArq livros = new LivroDAOArq();

    /**
     * Construtor da classe Adm para criar um novo administrador.
     *
     * @param cpf      O ID do administrador.
     * @param nome    O nome do administrador.
     * @param senha     A senha do administrador
     * @param celular   O número de telefone do administrador.
     * @param endereco O endereço do administrador.
     */
    public ADM(String nome, String cpf, String senha, String celular, String endereco) {
        super(nome, cpf, senha, celular, endereco);
    }

    //CRIAÇÃO DE PESSOAS(USUARIOS)

    /**
     * Cria um novo leitor.
     *
     * @param nome        nome do leitor.
     * @param senha        senha do leitor
     * @param celular   O número de telefone do leitor.
     * @param endereco O endereço do leitor.
     * @return leitor
     */
    public Leitor createLeitor(String nome, String cpf, String senha, String celular, String endereco){
        Leitor leitor = new Leitor(nome, cpf, senha,  celular, endereco);
        LeitorDAO leitorDao = DAO.getLeitorDAO();
        leitorDao.create(leitor);
        return leitor;}

    /**
     * Cria um novo bibliotecário no sistema.
     *
     * @param nome    O nome do bibliotecário.
     * @param senha     A senha do bibliotecário.
     * @param celular   O número de telefone do bibliotecário.
     * @param endereco O endereço do bibliotecário.
     * @return O bibliotecário
     */
    public Bibliotecario createBibliotecario(String nome, String cpf, String senha, String celular, String endereco){ //bibliotecario não tem id
        Bibliotecario bibliotecario = new Bibliotecario(nome, cpf, senha, celular, endereco);
        BibliotecarioDAO bibliotecarioDao = DAO.getBibliotecarioDAO();
        bibliotecarioDao.create(bibliotecario);
        return bibliotecario;}

    /**
     * Cria um novo administrador no sistema.
     *
     * @param nome    O nome do administrador.
     * @param senha     A senha do administrador.
     * @param celular   O número de telefone do administrador.
     * @param endereco O endereço do administrador.
     * @return O administrador recém-criado.
     */
    public ADM createAdm(String nome, String cpf, String senha, String celular, String endereco){
        ADM adm = new ADM(nome, cpf, senha, celular, endereco);
        ADMDAO admDao = DAO.getAdmDAO();
        admDao.create(adm);
        return adm;
    }

    //OPERAÇÕES DE USUARIOS

    /**
     * Bloqueia um leitor no sistema.
     *
     * @param leitor O leitor bloqueado.
     * @throws PessoaExcecao se ocorrer um erro durante o bloqueio do leitor.
     */
    public void blockLeitor(Leitor leitor) throws PessoaExcecao{
        if(leitor.getBlock()){
            throw new PessoaExcecao(PessoaExcecao.LeitorJaBloqueado);
        } else{
            leitor.bloqueiaLeitor(leitor);
        }}

    /**
     * Desbloqueia um leitor no sistema.
     *
     * @param leitor O leitor desbloqueado.
     * @throws PessoaExcecao se ocorrer um erro durante o desbloqueio do leitor.
     */
    public void desbloqueiaLeitor(Leitor leitor) throws PessoaExcecao {
            if (!leitor.getBlock()) {
                throw new PessoaExcecao(PessoaExcecao.LeitorJaDesbloqueado);
            } else {
                leitor.desbloqueiaLeitor(leitor);
            }
        }

    //GERENCIAMENTO DO ACERVO - ADM herda do bibliotecario -> adição de livros

    public void removeLivro(Livro livro){
        livros.delete(livro);//deleta um livro do acervo
    }
    /**
     * Atualiza um livro do acervo.
     *
     * @param livro O livro a ser atualizado.
     */
    public void updateLivro(Livro livro){
        livros.update(livro);}

    /**
     * Obtém a quantidade livros no acervo.
     */
    public void quantidadeLivros(){
        livros.QuantidadeLivros();}
}

