package controller;

import dao.EstoqueDAO;
import model.Estoque;
import java.util.List;

public class EstoqueController {

    private EstoqueDAO estoqueDAO = new EstoqueDAO();

    // Listar
    public List<Estoque> obterEstoques() {
        return estoqueDAO.listar();
    }

    // Inserir
    public void salvarEstoque(int quantidade, int produtoId,
                              String dataValidade, String lote) {

        Estoque e = new Estoque();

        e.setQuantidade(quantidade);
        e.setProduto_id(produtoId);
        e.setData_validade(dataValidade);
        e.setLote(lote);

        estoqueDAO.inserir(e);
    }

    // Atualizar
    public void atualizarEstoque(int id, int quantidade,
                                 int produtoId,
                                 String dataValidade,
                                 String lote) {

        Estoque e = new Estoque();

        e.setId(id);
        e.setQuantidade(quantidade);
        e.setProduto_id(produtoId);
        e.setData_validade(dataValidade);
        e.setLote(lote);

        estoqueDAO.atualizar(e);
    }

    // Excluir
    public void excluirEstoque(int id) {
        estoqueDAO.deletar(id);
    }

    // Buscar por ID
    public Estoque buscarEstoque(int id) {
        return estoqueDAO.buscarPorId(id);
    }
}