package controller;

import dao.ItemPedidoDAO;
import java.sql.SQLException;
import java.util.List;
import model.ItemPedido;

public class ItemPedidoController {

    private final ItemPedidoDAO itemPedidoDAO = new ItemPedidoDAO();

    public void inserir(ItemPedido itemPedido) throws SQLException {
        itemPedidoDAO.inserir(itemPedido);
    }

    public void atualizar(ItemPedido itemPedido) throws SQLException {
        itemPedidoDAO.atualizar(itemPedido);
    }

    public void excluir(int idItemPedido) throws SQLException {
        itemPedidoDAO.excluir(idItemPedido);
    }

    public List<ItemPedido> listar() throws SQLException {
        return itemPedidoDAO.listar();
    }

    public ItemPedido buscarPorId(int idItemPedido) throws SQLException {
        return itemPedidoDAO.buscarPorId(idItemPedido);
    }
}
