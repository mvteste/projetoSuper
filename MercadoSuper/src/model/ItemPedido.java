package model;

import java.math.BigDecimal;

public class ItemPedido {

    private int idItemPedido;
    private int idPedidoCompra;
    private int idProduto;
    private int quantidade;
    private BigDecimal precoUnitario;

    public ItemPedido() {
    }

    public ItemPedido(int idItemPedido, int idPedidoCompra, int idProduto, int quantidade, BigDecimal precoUnitario) {
        this.idItemPedido = idItemPedido;
        this.idPedidoCompra = idPedidoCompra;
        this.idProduto = idProduto;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
    }

    public int getIdItemPedido() {
        return idItemPedido;
    }

    public void setIdItemPedido(int idItemPedido) {
        this.idItemPedido = idItemPedido;
    }

    public int getIdPedidoCompra() {
        return idPedidoCompra;
    }

    public void setIdPedidoCompra(int idPedidoCompra) {
        this.idPedidoCompra = idPedidoCompra;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(BigDecimal precoUnitario) {
        this.precoUnitario = precoUnitario;
    }
}
