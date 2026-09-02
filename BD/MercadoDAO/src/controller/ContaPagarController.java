package controller;

import dao.Contas_PagarDAO;
import java.util.List;
import model.Caixa;
import model.Contas_Pagar;
import model.Pedido_Compra;

public class ContaPagarController extends ControllerSupport {
    private final Contas_PagarDAO dao;

    public ContaPagarController() { this(new Contas_PagarDAO()); }
    public ContaPagarController(Contas_PagarDAO dao) { this.dao = requireEntity(dao, "DAO de contas a pagar"); }

    public List<Contas_Pagar> obterContas() { return dao.listar(); }
    public void salvarConta(String nome, double valor, String vencimento, int caixaId, int pedidoId) {
        dao.inserir(criar(nome, valor, vencimento, caixaId, pedidoId));
    }
    public void atualizarConta(int id, String nome, double valor, String vencimento, int caixaId, int pedidoId) {
        Contas_Pagar conta = criar(nome, valor, vencimento, caixaId, pedidoId);
        conta.setId(requirePositive(id, "ID da conta"));
        dao.editar(conta);
    }
    public void pagarConta(int id) { dao.pagarConta(requirePositive(id, "ID da conta")); }
    public void excluirConta(int id) {
        Contas_Pagar conta = new Contas_Pagar();
        conta.setId(requirePositive(id, "ID da conta"));
        dao.deletar(conta);
    }

    private Contas_Pagar criar(String nome, double valor, String vencimento, int caixaId, int pedidoId) {
        Caixa caixa = new Caixa();
        caixa.setId(requirePositive(caixaId, "ID do caixa"));
        Pedido_Compra pedido = new Pedido_Compra();
        pedido.setId(requirePositive(pedidoId, "ID do pedido"));
        Contas_Pagar conta = new Contas_Pagar();
        conta.setNome(requireNonBlank(nome, "Nome"));
        conta.setValor(requireNonNegative(valor, "Valor"));
        conta.setData_vencimento(requireNonBlank(vencimento, "Data de vencimento"));
        conta.setCaixa(caixa);
        conta.setPedido_compra(pedido);
        return conta;
    }
}
