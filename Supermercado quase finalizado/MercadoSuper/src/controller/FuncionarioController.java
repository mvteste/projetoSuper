package controller;

import dao.FuncionarioDAO;
import java.sql.SQLException;
import java.util.List;
import model.Funcionario;

public class FuncionarioController {

    private final FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

    public void inserir(Funcionario funcionario) throws SQLException {
        funcionarioDAO.inserir(funcionario);
    }

    public void atualizar(Funcionario funcionario) throws SQLException {
        funcionarioDAO.atualizar(funcionario);
    }

    public void excluir(int idFuncionario) throws SQLException {
        funcionarioDAO.excluir(idFuncionario);
    }

    public List<Funcionario> listar() throws SQLException {
        return funcionarioDAO.listar();
    }

    public Funcionario buscarPorId(int idFuncionario) throws SQLException {
        return funcionarioDAO.buscarPorId(idFuncionario);
    }
}
