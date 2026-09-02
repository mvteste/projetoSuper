package controller;

import dao.Pedido_Compra_ProdutosDAO;
import java.util.List;
import model.Pedido_Compra;
import model.Pedido_Compra_Produtos;
import model.Produtos;

public class PedidoCompraProdutoController extends ControllerSupport {
    private final Pedido_Compra_ProdutosDAO dao;

    public PedidoCompraProdutoController() { this(new Pedido_Compra_ProdutosDAO()); }
    public PedidoCompraProdutoController(Pedido_Compra_ProdutosDAO dao) { this.dao = requireEntity(dao, "DAO de itens do pedido"); }

    public List<Pedido_Compra_Produtos> obterProdutosDoPedido(int pedidoId) {
        return dao.listarPorPedido(requirePositive(pedidoId, "ID do pedido"));
    }
    public void adicionarProduto(int pedidoId, int produtoId) { dao.inserir(criar(pedidoId, produtoId)); }
    public void removerProduto(int pedidoId, int produtoId) { dao.deletarProdutoDoPedido(criar(pedidoId, produtoId)); }

    private Pedido_Compra_Produtos criar(int pedidoId, int produtoId) {
        Pedido_Compra pedido = new Pedido_Compra();
        pedido.setId(requirePositive(pedidoId, "ID do pedido"));
        Produtos produto = new Produtos();
        produto.setId(requirePositive(produtoId, "ID do produto"));
        return new Pedido_Compra_Produtos(pedido, produto);
    }
}
