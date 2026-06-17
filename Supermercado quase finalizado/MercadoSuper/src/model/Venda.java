package model;

import java.math.BigDecimal;
import java.sql.Date;

public class Venda {

    private int idVenda;
    private int idCliente;
    private Date dataVenda;
    private BigDecimal valorTotal;

    public Venda() {
    }

    public Venda(int idVenda, int idCliente, Date dataVenda, BigDecimal valorTotal) {
        this.idVenda = idVenda;
        this.idCliente = idCliente;
        this.dataVenda = dataVenda;
        this.valorTotal = valorTotal;
    }

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }
}
