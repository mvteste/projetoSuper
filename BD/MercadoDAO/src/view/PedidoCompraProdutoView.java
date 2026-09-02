package view;

import controller.PedidoCompraProdutoController;
import java.util.Collections;
import java.util.List;
import model.Pedido_Compra_Produtos;

public class PedidoCompraProdutoView extends AbstractEntityView<Pedido_Compra_Produtos> {
    private final PedidoCompraProdutoController controller = new PedidoCompraProdutoController();
    public PedidoCompraProdutoView() {
        super("Itens dos pedidos", "Pedido", "Produto"); addField("pedido", "ID do pedido"); addField("produto", "ID do produto"); configureActions(true, false, true); buildView();
    }
    protected List<Pedido_Compra_Produtos> loadEntities() { return text("pedido").isBlank() ? Collections.emptyList() : controller.obterProdutosDoPedido(integer("pedido")); }
    protected Object[] toRow(Pedido_Compra_Produtos i) { return new Object[]{i.getPedidoCompra().getId(), i.getProdutos().getId()}; }
    protected void fillForm(Pedido_Compra_Produtos i) { value("pedido", i.getPedidoCompra().getId()); value("produto", i.getProdutos().getId()); }
    protected void saveEntity() { controller.adicionarProduto(integer("pedido"), integer("produto")); }
    protected void updateEntity(Pedido_Compra_Produtos i) { }
    protected void deleteEntity(Pedido_Compra_Produtos i) { controller.removerProduto(i.getPedidoCompra().getId(), i.getProdutos().getId()); }
}
