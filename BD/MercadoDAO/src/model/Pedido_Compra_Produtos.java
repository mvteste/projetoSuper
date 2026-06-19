package model;

/**
 *
 * @author Emanuel
 */
public class Pedido_Compra_Produtos {
    
    private Pedido_Compra pedidoCompra;
    private Produtos produtos;

    public Pedido_Compra_Produtos(Pedido_Compra pedidoCompra, Produtos produtos) {
        this.pedidoCompra = pedidoCompra;
        this.produtos = produtos;
    }

    public Pedido_Compra_Produtos() {
    }

    public Pedido_Compra getPedidoCompra() {
        return pedidoCompra;
    }

    public void setPedidoCompra(Pedido_Compra pedidoCompra) {
        this.pedidoCompra = pedidoCompra;
    }

    public Produtos getProdutos() {
        return produtos;
    }

    public void setProdutos(Produtos produtos) {
        this.produtos = produtos;
    }
}