package view;

import controller.CargoFuncionarioController;
import java.util.List;
import model.Cargo_Funcionario;

public class CargoFuncionarioView extends AbstractEntityView<Cargo_Funcionario> {
    private final CargoFuncionarioController controller = new CargoFuncionarioController();
    public CargoFuncionarioView() {
        super("Cargos", "ID", "Nome", "Descrição"); addField("nome", "Nome"); addField("descricao", "Descrição"); buildView();
    }
    protected List<Cargo_Funcionario> loadEntities() { return controller.obterCargos(); }
    protected Object[] toRow(Cargo_Funcionario c) { return new Object[]{c.getId(), c.getNome(), c.getDescricao()}; }
    protected void fillForm(Cargo_Funcionario c) { value("nome", c.getNome()); value("descricao", c.getDescricao()); }
    protected void saveEntity() { controller.salvarCargo(text("nome"), text("descricao")); }
    protected void updateEntity(Cargo_Funcionario c) { controller.atualizarCargo(c.getId(), text("nome"), text("descricao")); }
    protected void deleteEntity(Cargo_Funcionario c) { controller.excluirCargo(c.getId()); }
}
