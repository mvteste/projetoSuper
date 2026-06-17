package controller;

import model.Funcionario;
import dao.FuncionarioDAO;
import java.util.List;

public class FuncionarioController {

    private FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

    // Listar
    public List<Funcionario> obterFuncionarios() {
        return funcionarioDAO.listar();
    }

    // Inserir
    public void salvarFuncionario(String nome,
                                  String dataNascimento,
                                  String telefone,
                                  int tipoFuncionarioId) {

        Funcionario f = new Funcionario();

        f.setNome(nome);
        f.setData_nascimento(dataNascimento);
        f.setTelefone(telefone);
        f.setId_tipoFuncionario(tipoFuncionarioId);

        funcionarioDAO.inserir(f);
    }

    // Atualizar
    public void atualizarFuncionario(int id,
                                     String nome,
                                     String dataNascimento,
                                     String telefone,
                                     int tipoFuncionarioId) {

        Funcionario f = new Funcionario();

        f.setId(id);
        f.setNome(nome);
        f.setData_nascimento(dataNascimento);
        f.setTelefone(telefone);
        f.setId_tipoFuncionario(tipoFuncionarioId);

        funcionarioDAO.atualizar(f);
    }

    // Excluir
    public void excluirFuncionario(int id) {
        funcionarioDAO.deletar(id);
    }

    // Buscar por ID
    public Funcionario buscarFuncionario(int id) {
        return funcionarioDAO.buscarPorId(id);
    }
}