package controller;

import dao.ItemVendaDAO;
import java.sql.SQLException;
import java.util.List;
import model.ItemVenda;

public class ItemVendaController {

    private final ItemVendaDAO itemVendaDAO = new ItemVendaDAO();

    public void inserir(ItemVenda itemVenda) throws SQLException {
        itemVendaDAO.inserir(itemVenda);
    }

    public void atualizar(ItemVenda itemVenda) throws SQLException {
        itemVendaDAO.atualizar(itemVenda);
    }

    public void excluir(int idItemVenda) throws SQLException {
        itemVendaDAO.excluir(idItemVenda);
    }

    public List<ItemVenda> listar() throws SQLException {
        return itemVendaDAO.listar();
    }

    public ItemVenda buscarPorId(int idItemVenda) throws SQLException {
        return itemVendaDAO.buscarPorId(idItemVenda);
    }
}
