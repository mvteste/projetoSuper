/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Emanuel
 */
public class Contas_Receber {
    
    private int id;
    private String nome;
    private double valor;
    private String data_recebimento;
    private Caixa caixa;
    private Vendas vendas;
    private int status;

    public Contas_Receber(int id, String nome, double valor, String data_recebimento, Caixa caixa, Vendas vendas, int status) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
        this.data_recebimento = data_recebimento;
        this.caixa = caixa;
        this.vendas = vendas;
        this.status = status;
    }

    public Contas_Receber(){

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

    public String getData_recebimento() {
        return data_recebimento;
    }

    public void setData_recebimento(String data_recebimento) {
        this.data_recebimento = data_recebimento;
    }

    public Caixa getCaixa() {
        return caixa;
    }

    public void setCaixa(Caixa caixa) {
        this.caixa = caixa;
    }

    public Vendas getVendas() {
        return vendas;
    }

    public void setVendas(Vendas vendas) {
        this.vendas = vendas;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    


    
}
