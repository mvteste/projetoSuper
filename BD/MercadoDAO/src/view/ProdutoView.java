package view;

import controller.ProdutoController;
import java.util.List;
import model.Produtos;

public class ProdutoView extends AbstractEntityView<Produtos> {
    private final ProdutoController controller = new ProdutoController();
    public ProdutoView() {
        super("Produtos", "ID", "Nome", "Preço", "Vencimento", "Categoria", "Status");
        addField("nome", "Nome"); addField("descricao", "Descrição"); addField("preco", "Preço"); addField("vencimento", "Vencimento (AAAA-MM-DD)"); addField("categoria", "ID da categoria"); addField("status", "Status (0/1)");
        setDeleteLabel("Desativar"); buildView();
    }
    protected List<Produtos> loadEntities() { return controller.obterProdutos(); }
    protected Object[] toRow(Produtos p) { return new Object[]{p.getId(), p.getNome(), p.getPreco(), p.getData_vencimento(), p.getCategoria_produto() == null ? "" : p.getCategoria_produto().getId(), p.getStatus()}; }
    protected void fillForm(Produtos p) { value("nome", p.getNome()); value("descricao", p.getDescricao()); value("preco", p.getPreco()); value("vencimento", p.getData_vencimento()); value("categoria", p.getCategoria_produto() == null ? "" : p.getCategoria_produto().getId()); value("status", p.getStatus()); }
    protected void saveEntity() { controller.salvarProduto(text("nome"), text("descricao"), decimal("preco"), text("vencimento"), integer("categoria")); }
    protected void updateEntity(Produtos p) { controller.atualizarProduto(p.getId(), text("nome"), text("descricao"), decimal("preco"), text("vencimento"), integer("categoria"), integer("status")); }
    protected void deleteEntity(Produtos p) { controller.desativarProduto(p.getId()); }
}
