package org.example.Model;

/**
 * A classe contém atributos para armazenar o local de
 * um livro com atributos como prateleira, sessão e corredor.
 * Além disso, ela contém um construtor para criar o objeto
 * e métodos getters e setters para pegar e alterar os atributos privados.
 *
 * @author Letícia Gonçalves e Helena Filemon
 */
public class LocalizaLivro{
    private String prateleira;
    private String sessao;
    private String corredor;

    /**
     * Construtor para a Classe LocalizaLivro
     *
     * @param prateleira        Prateleira do livro
     * @param sessao            Seção do livro
     * @param corredor          Corredor do livro
     */
    public LocalizaLivro(String prateleira, String sessao, String corredor) {
        this.prateleira = prateleira;
        this.sessao = sessao;
        this.corredor = corredor;
    }

    // Métodos getter para acessar os atributos da localização
    public String getPrateleira() {
        return prateleira;
    }

    public String getSessao() {
        return sessao;
    }

    public String getCorredor() {
        return corredor;
    }

    // Métodos setter para definir os atributos da localização (caso seja necessário)
    public void setPrateleira(String prateleira) {
        this.prateleira = prateleira;
    }

    public void setSessao(String sessao) {
        this.sessao = sessao;
    }

    public void setCorredor(String corredor) {
        this.corredor = corredor;
    }

    @Override
    public String toString() {
        return super.toString() + ", Prateleira: " + prateleira + ", Sessão: " + sessao + ", Corredor: " + corredor;
    }
}