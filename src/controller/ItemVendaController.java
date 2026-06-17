package controller;

import dao.ItemVendaDAO;
import model.ItemVenda;
import java.util.List;

public class ItemVendaController {

    private ItemVendaDAO itemVendaDAO = new ItemVendaDAO();

    // Listar
    public List<ItemVenda> obterItens() {
        return itemVendaDAO.listar();
    }

    // Inserir
    public void salvarItem(int idProduto, int quantidade, int idVenda) {

        ItemVenda iv = new ItemVenda();

        iv.setId_produto(idProduto);
        iv.setQuantidade(quantidade);
        iv.setId_venda(idVenda);

        itemVendaDAO.inserir(iv);
    }

    // Atualizar
    public void atualizarItem(int id,
                              int idProduto,
                              int quantidade,
                              int idVenda) {

        ItemVenda iv = new ItemVenda();

        iv.setId(id);
        iv.setId_produto(idProduto);
        iv.setQuantidade(quantidade);
        iv.setId_venda(idVenda);

        itemVendaDAO.atualizar(iv);
    }

    // Excluir
    public void excluirItem(int id) {
        itemVendaDAO.deletar(id);
    }

    // Buscar por ID
    public ItemVenda buscarItem(int id) {
        return itemVendaDAO.buscarPorId(id);
    }
}