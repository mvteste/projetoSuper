package controller;

import dao.ProdutosDAO;
import java.util.List;
import model.Categoria_Produtos;
import model.Produtos;

public class ProdutoController extends ControllerSupport {
    private final ProdutosDAO dao;

    public ProdutoController() { this(new ProdutosDAO()); }
    public ProdutoController(ProdutosDAO dao) { this.dao = requireEntity(dao, "DAO de produtos"); }

    public List<Produtos> obterProdutos() { return dao.listarTodos(); }
    public Produtos buscarPorId(int id) { return dao.buscarPorId(requirePositive(id, "ID do produto")); }

    public void salvarProduto(String nome, String descricao, double preco, String dataVencimento, int categoriaId) {
        dao.cadastrar(criar(nome, descricao, preco, dataVencimento, categoriaId));
    }

    public void atualizarProduto(int id, String nome, String descricao, double preco,
            String dataVencimento, int categoriaId, int status) {
        Produtos produto = criar(nome, descricao, preco, dataVencimento, categoriaId);
        produto.setId(requirePositive(id, "ID do produto"));
        produto.setStatus(requireNonNegative(status, "Status"));
        dao.atualizar(produto);
    }

    public void desativarProduto(int id) { dao.deletar(requirePositive(id, "ID do produto")); }

    private Produtos criar(String nome, String descricao, double preco, String dataVencimento, int categoriaId) {
        Categoria_Produtos categoria = new Categoria_Produtos();
        categoria.setId(requirePositive(categoriaId, "ID da categoria"));
        Produtos produto = new Produtos();
        produto.setNome(requireNonBlank(nome, "Nome"));
        produto.setDescricao(requireNonBlank(descricao, "Descrição"));
        produto.setPreco(requireNonNegative(preco, "Preço"));
        produto.setData_vencimento(requireNonBlank(dataVencimento, "Data de vencimento"));
        produto.setCategoria_produto(categoria);
        return produto;
    }
}
