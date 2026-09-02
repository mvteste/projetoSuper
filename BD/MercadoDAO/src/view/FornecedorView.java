package view;

import controller.FornecedorController;
import java.util.List;
import model.Fornecedor;

public class FornecedorView extends AbstractEntityView<Fornecedor> {
    private final FornecedorController controller = new FornecedorController();
    public FornecedorView() {
        super("Fornecedores", "ID", "Nome", "CNPJ", "E-mail", "Endereço", "Status");
        addField("nome", "Nome"); addField("cnpj", "CNPJ"); addField("email", "E-mail"); addField("endereco", "Endereço");
        setDeleteLabel("Desativar"); buildView();
    }
    protected List<Fornecedor> loadEntities() { return controller.obterFornecedores(); }
    protected Object[] toRow(Fornecedor f) { return new Object[]{f.getId(), f.getNome(), f.getCnpj(), f.getEmail(), f.getEndereco(), f.getStatus()}; }
    protected void fillForm(Fornecedor f) { value("nome", f.getNome()); value("cnpj", f.getCnpj()); value("email", f.getEmail()); value("endereco", f.getEndereco()); }
    protected void saveEntity() { controller.salvarFornecedor(text("nome"), text("cnpj"), text("email"), text("endereco")); }
    protected void updateEntity(Fornecedor f) { controller.atualizarFornecedor(f.getId(), text("nome"), text("cnpj"), text("email"), text("endereco")); }
    protected void deleteEntity(Fornecedor f) { controller.desativarFornecedor(f.getId()); }
}
