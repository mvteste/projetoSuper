package controller;

import dao.PedidoDAO;
import java.util.List;
import model.Pedido;

public class PedidoController {

    private PedidoDAO pedidoDAO = new PedidoDAO();

    public List<Pedido> obterPedidos() {
        return pedidoDAO.listar();
    }

    public void salvarPedido(Pedido pedido) {
        pedidoDAO.salvar(pedido);
    }
}