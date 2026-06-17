package controller;

import dao.FornecedorDAO;
import java.sql.SQLException;
import java.util.List;
import model.Fornecedor;

public class FornecedorController {

    private final FornecedorDAO fornecedorDAO = new FornecedorDAO();

    public void inserir(Fornecedor fornecedor) throws SQLException {
        fornecedorDAO.inserir(fornecedor);
    }

    public void atualizar(Fornecedor fornecedor) throws SQLException {
        fornecedorDAO.atualizar(fornecedor);
    }

    public void excluir(int idFornecedor) throws SQLException {
        fornecedorDAO.excluir(idFornecedor);
    }

    public List<Fornecedor> listar() throws SQLException {
        return fornecedorDAO.listar();
    }

    public Fornecedor buscarPorId(int idFornecedor) throws SQLException {
        return fornecedorDAO.buscarPorId(idFornecedor);
    }
}
