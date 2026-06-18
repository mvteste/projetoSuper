package controller;

import dao.ContasReceberDAO;
import model.ContasReceber;
import java.util.List;

public class ContasReceberController {

    private ContasReceberDAO contasReceberDAO = new ContasReceberDAO();

    // Listar
    public List<ContasReceber> obterContas() {
        return contasReceberDAO.listar();
    }

    // Inserir
    public void salvarContas(float valor, String dataVencimento,
                             int itemVendaId) {

        ContasReceber cr = new ContasReceber();

        cr.setValor(valor);
        cr.setData_vencimento(dataVencimento);
        cr.setId_item_venda(itemVendaId);

        contasReceberDAO.inserir(cr);
    }

    // Atualizar
    public void atualizarContas(int id, float valor,
                                String dataVencimento,
                                int itemVendaId) {

        ContasReceber cr = new ContasReceber();

        cr.setId(id);
        cr.setValor(valor);
        cr.setData_vencimento(dataVencimento);
        cr.setId_item_venda(itemVendaId);

        contasReceberDAO.atualizar(cr);
    }

    // Excluir
    public void excluirConta(int id) {
        contasReceberDAO.deletar(id);
    }

    // Buscar por ID
    public ContasReceber buscarConta(int id) {
        return contasReceberDAO.buscarPorId(id);
    }
}