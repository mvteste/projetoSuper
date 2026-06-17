package controller;

import dao.VendaDAO;
import java.sql.SQLException;
import java.util.List;
import model.Venda;

public class VendaController {

    private final VendaDAO vendaDAO = new VendaDAO();

    public void inserir(Venda venda) throws SQLException {
        vendaDAO.inserir(venda);
    }

    public void atualizar(Venda venda) throws SQLException {
        vendaDAO.atualizar(venda);
    }

    public void excluir(int idVenda) throws SQLException {
        vendaDAO.excluir(idVenda);
    }

    public List<Venda> listar() throws SQLException {
        return vendaDAO.listar();
    }

    public Venda buscarPorId(int idVenda) throws SQLException {
        return vendaDAO.buscarPorId(idVenda);
    }
}
