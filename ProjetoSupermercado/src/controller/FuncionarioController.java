package controller;

import dao.FuncionarioDAO;
import java.util.List;
import model.Funcionario;

public class FuncionarioController {

    private FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

    public List<Funcionario> obterFuncionarios() {
        return funcionarioDAO.listar();
    }

    public void salvarFuncionario(Funcionario funcionario) {
        funcionarioDAO.salvar(funcionario);
    }
}