package controller;

import dao.ContasPagarDAO;
import model.ContasPagar;
import java.util.List;

public class ContasPagarController {

    private ContasPagarDAO contasPagarDAO = new ContasPagarDAO();

    // Listar
    public List<ContasPagar> obterContas() {
        return contasPagarDAO.listar();
    }

    // Inserir
    public void salvarContas(float valor, String data, int idFornecedor, String status) {

        ContasPagar cp = new ContasPagar();

        cp.setValor(valor);
        cp.setData(data);
        cp.setId_fornecedor(idFornecedor);
        cp.setStatus(status);

        contasPagarDAO.inserir(cp);
    }

    // Atualizar
    public void atualizarContas(int id, float valor, String data,
            int idFornecedor, String status) {

        ContasPagar cp = new ContasPagar();

        cp.setId(id);
        cp.setValor(valor);
        cp.setData(data);
        cp.setId_fornecedor(idFornecedor);
        cp.setStatus(status);

        contasPagarDAO.atualizar(cp);
    }

    // Excluir
    public void excluirContas(int id) {
        contasPagarDAO.deletar(id);
    }

    // Buscar por ID
    public ContasPagar buscarConta(int id) {
        return contasPagarDAO.buscarPorId(id);
    }
}