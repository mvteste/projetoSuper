
package model;

import java.util.Date;


public class Pedido_compra {
   
    private int id;
    private int fornecedor_id;
    private int funcionarios_id;
    private Date data_pedido;
    private Date data_entrega;
    private float valor_total;
    private String status;

    public int getId() {
        return id;
    }

    public int getFornecedor_id() {
        return fornecedor_id;
    }

    public int getFuncionarios_id() {
        return funcionarios_id;
    }

    public Date getData_pedido() {
        return data_pedido;
    }

    public Date getData_entrega() {
        return data_entrega;
    }

    public float getValor_total() {
        return valor_total;
    }

    public String getStatus() {
        return status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFornecedor_id(int fornecedor_id) {
        this.fornecedor_id = fornecedor_id;
    }

    public void setFuncionarios_id(int funcionarios_id) {
        this.funcionarios_id = funcionarios_id;
    }

    public void setData_pedido(Date data_pedido) {
        this.data_pedido = data_pedido;
    }

    public void setData_entrega(Date data_entrega) {
        this.data_entrega = data_entrega;
    }

    public void setValor_total(float valor_total) {
        this.valor_total = valor_total;
    }

    public void setStatus(String status) {
        this.status = status;
    }
   
}