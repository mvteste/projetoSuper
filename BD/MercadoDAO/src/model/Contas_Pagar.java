/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Emanuel
 */
public class Contas_Pagar {
    
    private int id;
    private String nome; 
    private double valor;
    private String data_vencimento;
    private Caixa caixa;
    private Pedido_Compra pedido_compra;
    private int status;

    public Contas_Pagar(int id, String nome, double valor, String data_vencimento, Caixa caixa, Pedido_Compra pedido_compra, int status) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
        this.data_vencimento = data_vencimento;
        this.caixa = caixa;
        this.pedido_compra = pedido_compra;
        this.status = status;
    }

    public Contas_Pagar(){
    
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getData_vencimento() {
        return data_vencimento;
    }

    public void setData_vencimento(String data_vencimento) {
        this.data_vencimento = data_vencimento;
    }

    public Caixa getCaixa() {
        return caixa;
    }

    public void setCaixa(Caixa caixa) {
        this.caixa = caixa;
    }

    public Pedido_Compra getPedido_compra() {
        return pedido_compra;
    }

    public void setPedido_compra(Pedido_Compra pedido_compra) {
        this.pedido_compra = pedido_compra;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    
}
