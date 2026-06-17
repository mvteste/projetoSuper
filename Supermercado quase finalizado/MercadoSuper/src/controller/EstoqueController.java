package controller;

import dao.EstoqueDAO;
import java.sql.SQLException;
import java.util.List;
import model.Estoque;

public class EstoqueController {

    private final EstoqueDAO estoqueDAO = new EstoqueDAO();

    public void inserir(Estoque estoque) throws SQLException {
        estoqueDAO.inserir(estoque);
    }

    public void atualizar(Estoque estoque) throws SQLException {
        estoqueDAO.atualizar(estoque);
    }

    public void excluir(int idEstoque) throws SQLException {
        estoqueDAO.excluir(idEstoque);
    }

    public List<Estoque> listar() throws SQLException {
        return estoqueDAO.listar();
    }

    public Estoque buscarPorId(int idEstoque) throws SQLException {
        return estoqueDAO.buscarPorId(idEstoque);
    }
}
