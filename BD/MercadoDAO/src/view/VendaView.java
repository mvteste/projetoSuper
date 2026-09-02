package view;

import controller.VendaController;
import java.util.List;
import model.Vendas;

public class VendaView extends AbstractEntityView<Vendas> {
    private final VendaController controller = new VendaController();
    public VendaView() {
        super("Vendas", "ID", "Descrição", "Data", "Cliente", "Funcionário"); addField("descricao", "Descrição"); addField("data", "Data (AAAA-MM-DD)"); addField("cliente", "ID do cliente"); addField("funcionario", "ID do funcionário"); buildView();
    }
    protected List<Vendas> loadEntities() { return controller.obterVendas(); }
    protected Object[] toRow(Vendas v) { return new Object[]{v.getId(), v.getDescricao(), v.getData(), v.getCliente().getId(), v.getFuncionario().getId()}; }
    protected void fillForm(Vendas v) { value("descricao", v.getDescricao()); value("data", v.getData()); value("cliente", v.getCliente().getId()); value("funcionario", v.getFuncionario().getId()); }
    protected void saveEntity() { controller.salvarVenda(text("descricao"), text("data"), integer("cliente"), integer("funcionario")); }
    protected void updateEntity(Vendas v) { controller.atualizarVenda(v.getId(), text("descricao"), text("data"), integer("cliente"), integer("funcionario")); }
    protected void deleteEntity(Vendas v) { controller.excluirVenda(v.getId()); }
}
