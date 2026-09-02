package view;

import controller.ClienteController;
import java.util.List;
import model.Clientes;

public class ClienteView extends AbstractEntityView<Clientes> {
    private final ClienteController controller = new ClienteController();
    public ClienteView() {
        super("Clientes", "ID", "Nome", "CPF", "Telefone", "Nascimento", "Status");
        addField("nome", "Nome"); addField("cpf", "CPF"); addField("telefone", "Telefone"); addField("nascimento", "Nascimento (AAAA-MM-DD)");
        setDeleteLabel("Desativar"); buildView();
    }
    protected List<Clientes> loadEntities() { return controller.obterClientes(); }
    protected Object[] toRow(Clientes c) { return new Object[]{c.getId(), c.getNome(), c.getCpf(), c.getTelefone(), c.getData_nascimento(), c.getStatus()}; }
    protected void fillForm(Clientes c) { value("nome", c.getNome()); value("cpf", c.getCpf()); value("telefone", c.getTelefone()); value("nascimento", c.getData_nascimento()); }
    protected void saveEntity() { controller.salvarCliente(text("nome"), text("cpf"), text("telefone"), text("nascimento")); }
    protected void updateEntity(Clientes c) { controller.atualizarCliente(c.getId(), text("nome"), text("cpf"), text("telefone"), text("nascimento")); }
    protected void deleteEntity(Clientes c) { controller.desativarCliente(c.getId()); }
}
