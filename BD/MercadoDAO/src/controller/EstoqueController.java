package controller;

import dao.EstoqueDAO;
import java.sql.Connection;
import java.util.List;
import model.Estoque;

public class EstoqueController extends ControllerSupport {
    private final EstoqueDAO dao;

    public EstoqueController() { this(new EstoqueDAO()); }
    public EstoqueController(EstoqueDAO dao) { this.dao = requireEntity(dao, "DAO de estoque"); }

    public List<Estoque> obterEstoque() { return dao.listarTudo(); }
    public void ajustarQuantidade(int produtoId, int quantidade) {
        dao.ajustarQuantidadeManual(requirePositive(produtoId, "ID do produto"), requireNonNegative(quantidade, "Quantidade"));
    }
    public void aumentarEstoque(Connection conexao, int produtoId, int quantidade) throws Exception {
        dao.aumentarEstoque(requireEntity(conexao, "Conexão"), requirePositive(produtoId, "ID do produto"), requirePositive(quantidade, "Quantidade"));
    }
    public void diminuirEstoque(Connection conexao, int produtoId, int quantidade) throws Exception {
        dao.diminuirEstoque(requireEntity(conexao, "Conexão"), requirePositive(produtoId, "ID do produto"), requirePositive(quantidade, "Quantidade"));
    }
}
