package controller;

import dao.FornecedorDAO;
import model.Fornecedor;
import java.util.List;

public class FornecedorController {

    private FornecedorDAO fornecedorDAO = new FornecedorDAO();

    // Listar
    public List<Fornecedor> obterFornecedores() {
        return fornecedorDAO.listar();
    }

    // Inserir
    public void salvarFornecedor(String nome, String cnpj,
                                 String email, String telefone) {

        Fornecedor f = new Fornecedor();

        f.setNome(nome);
        f.setCnpj(cnpj);
        f.setEmail(email);
        f.setTelefone(telefone);

        fornecedorDAO.inserir(f);
    }

    // Atualizar
    public void atualizarFornecedor(int id, String nome,
                                    String cnpj,
                                    String email,
                                    String telefone) {

        Fornecedor f = new Fornecedor();

        f.setId(id);
        f.setNome(nome);
        f.setCnpj(cnpj);
        f.setEmail(email);
        f.setTelefone(telefone);

        fornecedorDAO.atualizar(f);
    }

    // Excluir
    public void excluirFornecedor(int id) {
        fornecedorDAO.deletar(id);
    }

    // Buscar por ID
    public Fornecedor buscarFornecedor(int id) {
        return fornecedorDAO.buscarPorId(id);
    }
}