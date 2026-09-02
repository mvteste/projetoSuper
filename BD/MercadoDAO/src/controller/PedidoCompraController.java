package controller;

import dao.Pedido_CompraDAO;
import java.util.List;
import model.Fornecedor;
import model.Pedido_Compra;
import model.Produtos;

public class PedidoCompraController extends ControllerSupport {
    private final Pedido_CompraDAO dao;

    public PedidoCompraController() { this(new Pedido_CompraDAO()); }
    public PedidoCompraController(Pedido_CompraDAO dao) { this.dao = requireEntity(dao, "DAO de pedidos de compra"); }

    public List<Pedido_Compra> obterPedidos() { return dao.listar(); }
    public void salvarPedido(int quantidade, double total, int fornecedorId, int produtoId) {
        dao.inserir(criar(quantidade, total, fornecedorId, produtoId));
    }
    public void atualizarPedido(int id, int quantidade, double total, int fornecedorId, int produtoId) {
        Pedido_Compra pedido = criar(quantidade, total, fornecedorId, produtoId);
        pedido.setId(requirePositive(id, "ID do pedido"));
        dao.editar(pedido);
    }
    public void excluirPedido(int id) {
        Pedido_Compra pedido = new Pedido_Compra();
        pedido.setId(requirePositive(id, "ID do pedido"));
        dao.deletar(pedido);
    }

    private Pedido_Compra criar(int quantidade, double total, int fornecedorId, int produtoId) {
        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setId(requirePositive(fornecedorId, "ID do fornecedor"));
        Produtos produto = new Produtos();
        produto.setId(requirePositive(produtoId, "ID do produto"));
        Pedido_Compra pedido = new Pedido_Compra();
        pedido.setQuantidade(requirePositive(quantidade, "Quantidade"));
        pedido.setTotal(requireNonNegative(total, "Total"));
        pedido.setFornecedor(fornecedor);
        pedido.setProdutos(produto);
        return pedido;
    }
}
