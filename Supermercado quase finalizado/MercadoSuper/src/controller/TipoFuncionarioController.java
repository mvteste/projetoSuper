package controller;

import dao.TipoFuncionarioDAO;
import java.sql.SQLException;
import java.util.List;
import model.TipoFuncionario;

public class TipoFuncionarioController {

    private final TipoFuncionarioDAO tipoFuncionarioDAO = new TipoFuncionarioDAO();

    public void inserir(TipoFuncionario tipoFuncionario) throws SQLException {
        tipoFuncionarioDAO.inserir(tipoFuncionario);
    }

    public void atualizar(TipoFuncionario tipoFuncionario) throws SQLException {
        tipoFuncionarioDAO.atualizar(tipoFuncionario);
    }

    public void excluir(int idTipoFuncionario) throws SQLException {
        tipoFuncionarioDAO.excluir(idTipoFuncionario);
    }

    public List<TipoFuncionario> listar() throws SQLException {
        return tipoFuncionarioDAO.listar();
    }

    public TipoFuncionario buscarPorId(int idTipoFuncionario) throws SQLException {
        return tipoFuncionarioDAO.buscarPorId(idTipoFuncionario);
    }
}
