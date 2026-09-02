/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Emanuel
 */
public class Pedido_Compra {
    
    private int id;
    private int quantidade;
    private double total;
    private Fornecedor fornecedor;
    private Produtos produtos;

    public Pedido_Compra(int id, int quantidade, double total, Fornecedor fornecedor, Produtos produtos) {
        this.id = id;
        this.quantidade = quantidade;
        this.total = total;
        this.fornecedor = fornecedor;
        this.produtos = produtos;
    }

    
    
    public Pedido_Compra(){
    
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Produtos getProdutos() {
        return produtos;
    }

    public void setProdutos(Produtos produtos) {
        this.produtos = produtos;
    }

    
 
}
