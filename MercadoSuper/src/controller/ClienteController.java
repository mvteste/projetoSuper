package controller;

import dao.ClienteDAO;
import java.sql.SQLException;
import java.util.List;
import model.Cliente;

public class ClienteController {

    private final ClienteDAO clienteDAO = new ClienteDAO();

    public void inserir(Cliente cliente) throws SQLException {
        clienteDAO.inserir(cliente);
    }

    public void atualizar(Cliente cliente) throws SQLException {
        clienteDAO.atualizar(cliente);
    }

    public void excluir(int idCliente) throws SQLException {
        clienteDAO.excluir(idCliente);
    }

    public List<Cliente> listar() throws SQLException {
        return clienteDAO.listar();
    }

    public Cliente buscarPorId(int idCliente) throws SQLException {
        return clienteDAO.buscarPorId(idCliente);
    }
}
