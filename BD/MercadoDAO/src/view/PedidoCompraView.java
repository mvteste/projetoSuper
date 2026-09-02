package view;

import controller.PedidoCompraController;
import java.util.List;
import model.Pedido_Compra;

public class PedidoCompraView extends AbstractEntityView<Pedido_Compra> {
    private final PedidoCompraController controller = new PedidoCompraController();
    public PedidoCompraView() {
        super("Pedidos de compra", "ID", "Quantidade", "Total", "Fornecedor", "Produto");
        addField("quantidade", "Quantidade"); addField("total", "Total"); addField("fornecedor", "ID do fornecedor"); addField("produto", "ID do produto"); buildView();
    }
    protected List<Pedido_Compra> loadEntities() { return controller.obterPedidos(); }
    protected Object[] toRow(Pedido_Compra p) { return new Object[]{p.getId(), p.getQuantidade(), p.getTotal(), p.getFornecedor().getId(), p.getProdutos().getId()}; }
    protected void fillForm(Pedido_Compra p) { value("quantidade", p.getQuantidade()); value("total", p.getTotal()); value("fornecedor", p.getFornecedor().getId()); value("produto", p.getProdutos().getId()); }
    protected void saveEntity() { controller.salvarPedido(integer("quantidade"), decimal("total"), integer("fornecedor"), integer("produto")); }
    protected void updateEntity(Pedido_Compra p) { controller.atualizarPedido(p.getId(), integer("quantidade"), decimal("total"), integer("fornecedor"), integer("produto")); }
    protected void deleteEntity(Pedido_Compra p) { controller.excluirPedido(p.getId()); }
}
