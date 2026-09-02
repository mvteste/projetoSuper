package view;

import controller.CaixaController;
import java.util.List;
import model.Caixa;

public class CaixaView extends AbstractEntityView<Caixa> {
    private final CaixaController controller = new CaixaController();
    public CaixaView() { super("Caixas", "ID", "Nome", "Valor"); addField("nome", "Nome"); addField("valor", "Valor"); buildView(); }
    protected List<Caixa> loadEntities() { return controller.obterCaixas(); }
    protected Object[] toRow(Caixa c) { return new Object[]{c.getId(), c.getNome(), c.getValor()}; }
    protected void fillForm(Caixa c) { value("nome", c.getNome()); value("valor", c.getValor()); }
    protected void saveEntity() { controller.salvarCaixa(text("nome"), decimal("valor")); }
    protected void updateEntity(Caixa c) { controller.atualizarCaixa(c.getId(), text("nome"), decimal("valor")); }
    protected void deleteEntity(Caixa c) { controller.excluirCaixa(c.getId()); }
}
