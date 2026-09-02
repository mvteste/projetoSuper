package controller;

import dao.Categoria_ProdutosDAO;
import java.util.List;
import model.Categoria_Produtos;

public class CategoriaProdutoController extends ControllerSupport {
    private final Categoria_ProdutosDAO dao;

    public CategoriaProdutoController() { this(new Categoria_ProdutosDAO()); }
    public CategoriaProdutoController(Categoria_ProdutosDAO dao) { this.dao = requireEntity(dao, "DAO de categorias"); }

    public List<Categoria_Produtos> obterCategorias() { return dao.listarTodos(); }
    public Categoria_Produtos buscarPorId(int id) { return dao.buscarPorId(requirePositive(id, "ID da categoria")); }
    public void salvarCategoria(String nome, String descricao) { dao.cadastrar(criar(nome, descricao)); }

    public void atualizarCategoria(int id, String nome, String descricao) {
        Categoria_Produtos categoria = criar(nome, descricao);
        categoria.setId(requirePositive(id, "ID da categoria"));
        dao.atualizar(categoria);
    }

    public void excluirCategoria(int id) { dao.deletar(requirePositive(id, "ID da categoria")); }

    private Categoria_Produtos criar(String nome, String descricao) {
        Categoria_Produtos categoria = new Categoria_Produtos();
        categoria.setNome(requireNonBlank(nome, "Nome"));
        categoria.setDescricao(requireNonBlank(descricao, "Descrição"));
        return categoria;
    }
}
