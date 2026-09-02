package controller;

import dao.VendasDAO;
import java.util.List;
import model.Clientes;
import model.Funcionarios;
import model.Vendas;

public class VendaController extends ControllerSupport {
    private final VendasDAO dao;

    public VendaController() { this(new VendasDAO()); }
    public VendaController(VendasDAO dao) { this.dao = requireEntity(dao, "DAO de vendas"); }

    public List<Vendas> obterVendas() { return dao.listar(); }
    public void salvarVenda(String descricao, String data, int clienteId, int funcionarioId) {
        dao.inserir(criar(descricao, data, clienteId, funcionarioId));
    }
    public void atualizarVenda(int id, String descricao, String data, int clienteId, int funcionarioId) {
        Vendas venda = criar(descricao, data, clienteId, funcionarioId);
        venda.setId(requirePositive(id, "ID da venda"));
        dao.editar(venda);
    }
    public void excluirVenda(int id) { dao.deletar(requirePositive(id, "ID da venda")); }

    private Vendas criar(String descricao, String data, int clienteId, int funcionarioId) {
        Clientes cliente = new Clientes();
        cliente.setId(requirePositive(clienteId, "ID do cliente"));
        Funcionarios funcionario = new Funcionarios();
        funcionario.setId(requirePositive(funcionarioId, "ID do funcionário"));
        return new Vendas(0, requireNonBlank(descricao, "Descrição"),
                requireNonBlank(data, "Data"), cliente, funcionario);
    }
}
