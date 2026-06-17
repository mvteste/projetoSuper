package controller;

import dao.PedidoCompraDAO;
import java.sql.SQLException;
import java.util.List;
import model.PedidoCompra;

public class PedidoCompraController {

    private final PedidoCompraDAO pedidoCompraDAO = new PedidoCompraDAO();

    public void inserir(PedidoCompra pedidoCompra) throws SQLException {
        pedidoCompraDAO.inserir(pedidoCompra);
    }

    public void atualizar(PedidoCompra pedidoCompra) throws SQLException {
        pedidoCompraDAO.atualizar(pedidoCompra);
    }

    public void excluir(int idPedidoCompra) throws SQLException {
        pedidoCompraDAO.excluir(idPedidoCompra);
    }

    public List<PedidoCompra> listar() throws SQLException {
        return pedidoCompraDAO.listar();
    }

    public PedidoCompra buscarPorId(int idPedidoCompra) throws SQLException {
        return pedidoCompraDAO.buscarPorId(idPedidoCompra);
    }
}
