package controller;

import dao.ProdutoDAO;
import java.sql.SQLException;
import java.util.List;
import model.Produto;

public class ProdutoController {

    private final ProdutoDAO produtoDAO = new ProdutoDAO();

    public void inserir(Produto produto) throws SQLException {
        produtoDAO.inserir(produto);
    }

    public void atualizar(Produto produto) throws SQLException {
        produtoDAO.atualizar(produto);
    }

    public void excluir(int idProduto) throws SQLException {
        produtoDAO.excluir(idProduto);
    }

    public List<Produto> listar() throws SQLException {
        return produtoDAO.listar();
    }

    public Produto buscarPorId(int idProduto) throws SQLException {
        return produtoDAO.buscarPorId(idProduto);
    }
}
