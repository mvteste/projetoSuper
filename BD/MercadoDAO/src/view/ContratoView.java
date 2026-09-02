package view;

import controller.ContratoController;
import java.util.List;
import model.Contratos;

public class ContratoView extends AbstractEntityView<Contratos> {
    private final ContratoController controller = new ContratoController();
    public ContratoView() {
        super("Contratos", "Cargo", "Funcionário", "Salário", "Início", "Fim");
        addField("cargo", "ID do cargo"); addField("funcionario", "ID do funcionário"); addField("salario", "Salário"); addField("inicio", "Início (AAAA-MM-DD)"); addField("fim", "Fim (opcional)"); buildView();
    }
    protected List<Contratos> loadEntities() { return controller.obterContratos(); }
    protected Object[] toRow(Contratos c) { return new Object[]{c.getCargo_funcionario().getId(), c.getFuncionario().getId(), c.getSalario(), c.getData_inicio(), c.getData_fim()}; }
    protected void fillForm(Contratos c) { value("cargo", c.getCargo_funcionario().getId()); value("funcionario", c.getFuncionario().getId()); value("salario", c.getSalario()); value("inicio", c.getData_inicio()); value("fim", c.getData_fim()); }
    protected void saveEntity() { controller.salvarContrato(integer("cargo"), integer("funcionario"), decimal("salario"), text("inicio"), text("fim")); }
    protected void updateEntity(Contratos c) { controller.atualizarContrato(c.getCargo_funcionario().getId(), c.getFuncionario().getId(), decimal("salario"), text("inicio"), text("fim")); }
    protected void deleteEntity(Contratos c) { controller.excluirContrato(c.getCargo_funcionario().getId(), c.getFuncionario().getId()); }
}
