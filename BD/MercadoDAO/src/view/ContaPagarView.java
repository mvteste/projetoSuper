package view;

import controller.ContaPagarController;
import java.util.List;
import model.Contas_Pagar;

public class ContaPagarView extends AbstractEntityView<Contas_Pagar> {
    private final ContaPagarController controller = new ContaPagarController();
    public ContaPagarView() {
        super("Contas a pagar", "ID", "Nome", "Valor", "Vencimento", "Caixa", "Pedido", "Status");
        addField("nome", "Nome"); addField("valor", "Valor"); addField("vencimento", "Vencimento (AAAA-MM-DD)"); addField("caixa", "ID do caixa"); addField("pedido", "ID do pedido"); setDeleteLabel("Pagar"); buildView();
    }
    protected List<Contas_Pagar> loadEntities() { return controller.obterContas(); }
    protected Object[] toRow(Contas_Pagar c) { return new Object[]{c.getId(), c.getNome(), c.getValor(), c.getData_vencimento(), c.getCaixa().getId(), c.getPedido_compra().getId(), c.getStatus()}; }
    protected void fillForm(Contas_Pagar c) { value("nome", c.getNome()); value("valor", c.getValor()); value("vencimento", c.getData_vencimento()); value("caixa", c.getCaixa().getId()); value("pedido", c.getPedido_compra().getId()); }
    protected void saveEntity() { controller.salvarConta(text("nome"), decimal("valor"), text("vencimento"), integer("caixa"), integer("pedido")); }
    protected void updateEntity(Contas_Pagar c) { controller.atualizarConta(c.getId(), text("nome"), decimal("valor"), text("vencimento"), integer("caixa"), integer("pedido")); }
    protected void deleteEntity(Contas_Pagar c) { controller.pagarConta(c.getId()); }
}
