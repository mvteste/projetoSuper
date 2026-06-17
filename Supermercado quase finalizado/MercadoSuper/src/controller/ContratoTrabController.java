package controller;

import dao.ContratoTrabDAO;
import java.sql.SQLException;
import java.util.List;
import model.ContratoTrab;

public class ContratoTrabController {

    private final ContratoTrabDAO contratoTrabDAO = new ContratoTrabDAO();

    public void inserir(ContratoTrab contratoTrab) throws SQLException {
        contratoTrabDAO.inserir(contratoTrab);
    }

    public void atualizar(ContratoTrab contratoTrab) throws SQLException {
        contratoTrabDAO.atualizar(contratoTrab);
    }

    public void excluir(int idContrato) throws SQLException {
        contratoTrabDAO.excluir(idContrato);
    }

    public List<ContratoTrab> listar() throws SQLException {
        return contratoTrabDAO.listar();
    }

    public ContratoTrab buscarPorId(int idContrato) throws SQLException {
        return contratoTrabDAO.buscarPorId(idContrato);
    }
}
