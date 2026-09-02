package view;

import controller.CarrinhoController;
import java.util.Collections;
import java.util.List;
import model.Carrinho;

public class CarrinhoView extends AbstractEntityView<Carrinho> {
    private final CarrinhoController controller = new CarrinhoController();
    public CarrinhoView() {
        super("Itens das vendas", "Venda", "Produto", "Quantidade", "Valor"); addField("venda", "ID da venda"); addField("produto", "ID do produto"); addField("quantidade", "Quantidade"); addField("valor", "Valor"); buildView();
    }
    protected List<Carrinho> loadEntities() { return text("venda").isBlank() ? Collections.emptyList() : controller.obterItens(integer("venda")); }
    protected Object[] toRow(Carrinho c) { return new Object[]{c.getVenda().getId(), c.getProduto().getId(), c.getQuantidade(), c.getValor()}; }
    protected void fillForm(Carrinho c) { value("venda", c.getVenda().getId()); value("produto", c.getProduto().getId()); value("quantidade", c.getQuantidade()); value("valor", c.getValor()); }
    protected void saveEntity() { controller.adicionarItem(integer("venda"), integer("produto"), integer("quantidade"), decimal("valor")); }
    protected void updateEntity(Carrinho c) { controller.atualizarItem(c.getVenda().getId(), c.getProduto().getId(), integer("quantidade"), decimal("valor")); }
    protected void deleteEntity(Carrinho c) { controller.removerItem(c.getVenda().getId(), c.getProduto().getId()); }
}
