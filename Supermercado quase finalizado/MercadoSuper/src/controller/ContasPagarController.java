package controller;

import dao.ContasPagarDAO;
import java.sql.SQLException;
import java.util.List;
import model.ContasPagar;

public class ContasPagarController {

    private final ContasPagarDAO contasPagarDAO = new ContasPagarDAO();

    public void inserir(ContasPagar contasPagar) throws SQLException {
        contasPagarDAO.inserir(contasPagar);
    }

    public void atualizar(ContasPagar contasPagar) throws SQLException {
        contasPagarDAO.atualizar(contasPagar);
    }

    public void excluir(int idContaPagar) throws SQLException {
        contasPagarDAO.excluir(idContaPagar);
    }

    public List<ContasPagar> listar() throws SQLException {
        return contasPagarDAO.listar();
    }

    public ContasPagar buscarPorId(int idContaPagar) throws SQLException {
        return contasPagarDAO.buscarPorId(idContaPagar);
    }
}
