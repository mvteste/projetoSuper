package model;

import java.math.BigDecimal;
import java.sql.Date;

public class PedidoCompra {

    private int idPedidoCompra;
    private int idFornecedor;
    private Date dataPedido;
    private BigDecimal valorTotal;

    public PedidoCompra() {
    }

    public PedidoCompra(int idPedidoCompra, int idFornecedor, Date dataPedido, BigDecimal valorTotal) {
        this.idPedidoCompra = idPedidoCompra;
        this.idFornecedor = idFornecedor;
        this.dataPedido = dataPedido;
        this.valorTotal = valorTotal;
    }

    public int getIdPedidoCompra() {
        return idPedidoCompra;
    }

    public void setIdPedidoCompra(int idPedidoCompra) {
        this.idPedidoCompra = idPedidoCompra;
    }

    public int getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(int idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }
}
