package controller;

import dao.CaixaDAO;
import java.sql.SQLException;
import java.util.List;
import model.Caixa;

public class CaixaController {

    private final CaixaDAO caixaDAO = new CaixaDAO();

    public void inserir(Caixa caixa) throws SQLException {
        caixaDAO.inserir(caixa);
    }

    public void atualizar(Caixa caixa) throws SQLException {
        caixaDAO.atualizar(caixa);
    }

    public void excluir(int idCaixa) throws SQLException {
        caixaDAO.excluir(idCaixa);
    }

    public List<Caixa> listar() throws SQLException {
        return caixaDAO.listar();
    }

    public Caixa buscarPorId(int idCaixa) throws SQLException {
        return caixaDAO.buscarPorId(idCaixa);
    }
}
