package controller;

import dao.CarrinhoDAO;
import java.util.List;
import model.Carrinho;
import model.Produtos;
import model.Vendas;

public class CarrinhoController extends ControllerSupport {
    private final CarrinhoDAO dao;

    public CarrinhoController() { this(new CarrinhoDAO()); }
    public CarrinhoController(CarrinhoDAO dao) { this.dao = requireEntity(dao, "DAO do carrinho"); }

    public List<Carrinho> obterItens(int vendaId) { return dao.listarPorVenda(requirePositive(vendaId, "ID da venda")); }
    public void adicionarItem(int vendaId, int produtoId, int quantidade, double valor) {
        dao.inserir(criar(vendaId, produtoId, quantidade, valor));
    }
    public void atualizarItem(int vendaId, int produtoId, int quantidade, double valor) {
        dao.atualizar(criar(vendaId, produtoId, quantidade, valor));
    }
    public void removerItem(int vendaId, int produtoId) {
        dao.deletar(requirePositive(vendaId, "ID da venda"), requirePositive(produtoId, "ID do produto"));
    }

    private Carrinho criar(int vendaId, int produtoId, int quantidade, double valor) {
        Vendas venda = new Vendas();
        venda.setId(requirePositive(vendaId, "ID da venda"));
        Produtos produto = new Produtos();
        produto.setId(requirePositive(produtoId, "ID do produto"));
        return new Carrinho(venda, produto, requirePositive(quantidade, "Quantidade"), requireNonNegative(valor, "Valor"));
    }
}
