package view;

import controller.FuncionarioController;
import java.util.List;
import model.Funcionarios;

public class FuncionarioView extends AbstractEntityView<Funcionarios> {
    private final FuncionarioController controller = new FuncionarioController();
    public FuncionarioView() {
        super("Funcionários", "ID", "Nome", "CPF", "Telefone", "E-mail", "Cargo", "Status");
        addField("nome", "Nome"); addField("cpf", "CPF"); addField("telefone", "Telefone"); addField("email", "E-mail");
        addField("endereco", "Endereço"); addField("admissao", "Admissão (AAAA-MM-DD)"); addField("nascimento", "Nascimento (AAAA-MM-DD)"); addField("cargo", "ID do cargo");
        setDeleteLabel("Desativar"); buildView();
    }
    protected List<Funcionarios> loadEntities() { return controller.obterFuncionarios(); }
    protected Object[] toRow(Funcionarios f) { return new Object[]{f.getId(), f.getNome(), f.getCpf(), f.getTelefone(), f.getEmail(), f.getCargo_funcionario() == null ? "" : f.getCargo_funcionario().getId(), f.getStatus()}; }
    protected void fillForm(Funcionarios f) { value("nome", f.getNome()); value("cpf", f.getCpf()); value("telefone", f.getTelefone()); value("email", f.getEmail()); value("endereco", f.getEndereco()); value("admissao", f.getData_admissao()); value("nascimento", f.getData_nascimento()); value("cargo", f.getCargo_funcionario() == null ? "" : f.getCargo_funcionario().getId()); }
    protected void saveEntity() { controller.salvarFuncionario(text("nome"), text("cpf"), text("telefone"), text("email"), text("endereco"), text("admissao"), text("nascimento"), integer("cargo")); }
    protected void updateEntity(Funcionarios f) { controller.atualizarFuncionario(f.getId(), text("nome"), text("cpf"), text("telefone"), text("email"), text("endereco"), text("admissao"), text("nascimento"), integer("cargo")); }
    protected void deleteEntity(Funcionarios f) { controller.desativarFuncionario(f.getId()); }
}
