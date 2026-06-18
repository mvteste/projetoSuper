package controller;

import dao.ContasReceberDAO;
import java.sql.SQLException;
import java.util.List;
import model.ContasReceber;

public class ContasReceberController {

    private final ContasReceberDAO contasReceberDAO = new ContasReceberDAO();

    public void inserir(ContasReceber contasReceber) throws SQLException {
        contasReceberDAO.inserir(contasReceber);
    }

    public void atualizar(ContasReceber contasReceber) throws SQLException {
        contasReceberDAO.atualizar(contasReceber);
    }

    public void excluir(int idContaReceber) throws SQLException {
        contasReceberDAO.excluir(idContaReceber);
    }

    public List<ContasReceber> listar() throws SQLException {
        return contasReceberDAO.listar();
    }

    public ContasReceber buscarPorId(int idContaReceber) throws SQLException {
        return contasReceberDAO.buscarPorId(idContaReceber);
    }
}
