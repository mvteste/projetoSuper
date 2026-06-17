package controller;

import dao.PagamentoDAO;
import model.Pagamento;
import java.util.List;

public class PagamentoController {

    private PagamentoDAO pagamentoDAO = new PagamentoDAO();

    // Listar
    public List<Pagamento> obterPagamentos() {
        return pagamentoDAO.listar();
    }

    // Inserir
    public void salvarPagamento(String formaPagamento,
                                float valor,
                                String dataPagamento,
                                int vendaId) {

        Pagamento p = new Pagamento();

        p.setForma_pagamento(formaPagamento);
        p.setValor(valor);
        p.setData_pagamento(dataPagamento);
        p.setId_venda(vendaId);

        pagamentoDAO.inserir(p);
    }

    // Atualizar
    public void atualizarPagamento(int id,
                                   String formaPagamento,
                                   float valor,
                                   String dataPagamento,
                                   int vendaId) {

        Pagamento p = new Pagamento();

        p.setId(id);
        p.setForma_pagamento(formaPagamento);
        p.setValor(valor);
        p.setData_pagamento(dataPagamento);
        p.setId_venda(vendaId);

        pagamentoDAO.atualizar(p);
    }

    // Excluir
    public void excluirPagamento(int id) {
        pagamentoDAO.deletar(id);
    }

    // Buscar por ID
    public Pagamento buscarPagamento(int id) {
        return pagamentoDAO.buscarPorId(id);
    }
}