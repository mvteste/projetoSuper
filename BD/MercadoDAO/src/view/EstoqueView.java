package view;

import controller.EstoqueController;
import java.util.List;
import model.Estoque;

public class EstoqueView extends AbstractEntityView<Estoque> {
    private final EstoqueController controller = new EstoqueController();
    public EstoqueView() {
        super("Estoque", "ID", "Produto", "Quantidade"); addField("produto", "ID do produto"); addField("quantidade", "Quantidade"); configureActions(false, true, false); buildView();
    }
    protected List<Estoque> loadEntities() { return controller.obterEstoque(); }
    protected Object[] toRow(Estoque e) { return new Object[]{e.getId(), e.getProdutos().getId(), e.getQuantidade()}; }
    protected void fillForm(Estoque e) { value("produto", e.getProdutos().getId()); value("quantidade", e.getQuantidade()); }
    protected void saveEntity() { }
    protected void updateEntity(Estoque e) { controller.ajustarQuantidade(integer("produto"), integer("quantidade")); }
    protected void deleteEntity(Estoque e) { }
}
