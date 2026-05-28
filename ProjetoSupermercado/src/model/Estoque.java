package model;


public class Estoque {
    private int id;
    private int produto_id;
    private int quantidade;
    private int quantidade_minima;

    public int getId() {
        return id;
    }

    public int getProduto_id() {
        return produto_id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public int getQuantidade_minima() {
        return quantidade_minima;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setProduto_id(int produto_id) {
        this.produto_id = produto_id;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setQuantidade_minima(int quantidade_minima) {
        this.quantidade_minima = quantidade_minima;
    }

}
