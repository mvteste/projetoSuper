package controller;

import dao.VendaDAO;
import model.Venda;
import java.util.List;

public class VendaController {

    private VendaDAO vendaDAO = new VendaDAO();

    // Listar
    public List<Venda> obterVendas() {
        return vendaDAO.listar();
    }

    // Inserir
    public void salvarVenda(int idCliente,
                            String dataVenda,
                            float valorTotal,
                            int idFuncionario,
                            String status) {

        Venda v = new Venda();

        v.setId_cliente(idCliente);
        v.setData_venda(dataVenda);
        v.setValorTotal(valorTotal);
        v.setId_funcionario(idFuncionario);
        v.setStatus(status);

        vendaDAO.inserir(v);
    }

    // Atualizar
    public void atualizarVenda(int id,
                               int idCliente,
                               String dataVenda,
                               float valorTotal,
                               int idFuncionario,
                               String status) {

        Venda v = new Venda();

        v.setId(id);
        v.setId_cliente(idCliente);
        v.setData_venda(dataVenda);
        v.setValorTotal(valorTotal);
        v.setId_funcionario(idFuncionario);
        v.setStatus(status);

        vendaDAO.atualizar(v);
    }

    // Excluir
    public void excluirVenda(int id) {
        vendaDAO.deletar(id);
    }

    // Buscar por ID
    public Venda buscarVenda(int id) {
        return vendaDAO.buscarPorId(id);
    }
}