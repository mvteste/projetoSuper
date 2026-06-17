package model;

public class Produto {

    private int idProduto;
    private String nome;
    private double preco;
    private int quantidade;
    private int idCategoria;

    public Produto() {
    }

    public Produto( String nome, double preco, int quantidade, int idCategoria){
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
        this.idCategoria = idCategoria;
    }
     public Produto(int idProduto, String nome, double preco, int quantidade, int idCategoria) {
        this.idProduto = idProduto;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
        this.idCategoria = idCategoria;
    }
    

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }
}
