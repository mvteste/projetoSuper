package view;

import controller.CategoriaProdutoController;
import java.util.List;
import model.Categoria_Produtos;

public class CategoriaProdutoView extends AbstractEntityView<Categoria_Produtos> {
    private final CategoriaProdutoController controller = new CategoriaProdutoController();
    public CategoriaProdutoView() { super("Categorias", "ID", "Nome", "Descrição"); addField("nome", "Nome"); addField("descricao", "Descrição"); buildView(); }
    protected List<Categoria_Produtos> loadEntities() { return controller.obterCategorias(); }
    protected Object[] toRow(Categoria_Produtos c) { return new Object[]{c.getId(), c.getNome(), c.getDescricao()}; }
    protected void fillForm(Categoria_Produtos c) { value("nome", c.getNome()); value("descricao", c.getDescricao()); }
    protected void saveEntity() { controller.salvarCategoria(text("nome"), text("descricao")); }
    protected void updateEntity(Categoria_Produtos c) { controller.atualizarCategoria(c.getId(), text("nome"), text("descricao")); }
    protected void deleteEntity(Categoria_Produtos c) { controller.excluirCategoria(c.getId()); }
}
