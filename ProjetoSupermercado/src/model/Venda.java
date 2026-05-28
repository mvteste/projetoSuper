package model;

import java.util.Date;


public class Venda {
    
    private int id;
    private int id_cliente;
    private int id_funcionario;
    private Date data_venda;
    private float valorTotal;
    private String forma_pagamento;
    private String status;

    public int getId() {
        return id;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public int getId_funcionario() {
        return id_funcionario;
    }

    public Date getData_venda() {
        return data_venda;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public String getForma_pagamento() {
        return forma_pagamento;
    }

    public String getStatus() {
        return status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public void setId_funcionario(int id_funcionario) {
        this.id_funcionario = id_funcionario;
    }

    public void setData_venda(Date data_venda) {
        this.data_venda = data_venda;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public void setForma_pagamento(String forma_pagamento) {
        this.forma_pagamento = forma_pagamento;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
