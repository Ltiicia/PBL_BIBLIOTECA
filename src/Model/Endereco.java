package Model;

public class Endereco {
    private String estado;
    private String cidade;
    private String bairro;
    private String rua;
    private int numero;
    private int cep;
    // Construtor
    public Endereço(String estado, String cidade, String bairro, String rua, int numero, int cep) {
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.numero = numero;
        this.cep = cep;}
    // Métodos Get
    public String getEstado() {
        return estado;
    }
    public String getCidade() {
        return cidade;
    }
    public String getBairro() {
        return bairro;
    }
    public String getRua() {
        return rua;
    }
    public int getNumero() {
        return numero;
    }
    public int getCep() {
        return cep;
    }
    // Métodos Set
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    public void setRua(String rua) {
        this.rua = rua;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public void setCep(int cep) {
        this.cep = cep;
    }
}