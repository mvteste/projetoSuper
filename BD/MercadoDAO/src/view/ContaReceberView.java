package view;

import controller.ContaReceberController;
import java.util.List;
import model.Contas_Receber;

public class ContaReceberView extends AbstractEntityView<Contas_Receber> {
    private final ContaReceberController controller = new ContaReceberController();
    public ContaReceberView() {
        super("Contas a receber", "ID", "Nome", "Valor", "Recebimento", "Caixa", "Venda", "Status");
        addField("nome", "Nome"); addField("valor", "Valor"); addField("recebimento", "Recebimento (AAAA-MM-DD)"); addField("caixa", "ID do caixa"); addField("venda", "ID da venda (opcional)"); setDeleteLabel("Receber"); buildView();
    }
    protected List<Contas_Receber> loadEntities() { return controller.obterContas(); }
    protected Object[] toRow(Contas_Receber c) { return new Object[]{c.getId(), c.getNome(), c.getValor(), c.getData_recebimento(), c.getCaixa().getId(), c.getVendas() == null ? "" : c.getVendas().getId(), c.getStatus()}; }
    protected void fillForm(Contas_Receber c) { value("nome", c.getNome()); value("valor", c.getValor()); value("recebimento", c.getData_recebimento()); value("caixa", c.getCaixa().getId()); value("venda", c.getVendas() == null ? "" : c.getVendas().getId()); }
    protected void saveEntity() { controller.salvarConta(text("nome"), decimal("valor"), text("recebimento"), integer("caixa"), optionalInteger("venda")); }
    protected void updateEntity(Contas_Receber c) { controller.atualizarConta(c.getId(), text("nome"), decimal("valor"), text("recebimento"), integer("caixa"), optionalInteger("venda")); }
    protected void deleteEntity(Contas_Receber c) { controller.receberConta(c.getId()); }
}
