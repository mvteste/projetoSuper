package controller;

import dao.Contas_ReceberDAO;
import java.util.List;
import model.Caixa;
import model.Contas_Receber;
import model.Vendas;

public class ContaReceberController extends ControllerSupport {
    private final Contas_ReceberDAO dao;

    public ContaReceberController() { this(new Contas_ReceberDAO()); }
    public ContaReceberController(Contas_ReceberDAO dao) { this.dao = requireEntity(dao, "DAO de contas a receber"); }

    public List<Contas_Receber> obterContas() { return dao.listar(); }
    public void salvarConta(String nome, double valor, String recebimento, int caixaId, Integer vendaId) {
        dao.inserir(criar(nome, valor, recebimento, caixaId, vendaId));
    }
    public void atualizarConta(int id, String nome, double valor, String recebimento, int caixaId, Integer vendaId) {
        Contas_Receber conta = criar(nome, valor, recebimento, caixaId, vendaId);
        conta.setId(requirePositive(id, "ID da conta"));
        dao.editar(conta);
    }
    public void receberConta(int id) { dao.receberConta(requirePositive(id, "ID da conta")); }

    private Contas_Receber criar(String nome, double valor, String recebimento, int caixaId, Integer vendaId) {
        Caixa caixa = new Caixa();
        caixa.setId(requirePositive(caixaId, "ID do caixa"));
        Vendas venda = null;
        if (vendaId != null) {
            venda = new Vendas();
            venda.setId(requirePositive(vendaId, "ID da venda"));
        }
        Contas_Receber conta = new Contas_Receber();
        conta.setNome(requireNonBlank(nome, "Nome"));
        conta.setValor(requireNonNegative(valor, "Valor"));
        conta.setData_recebimento(requireNonBlank(recebimento, "Data de recebimento"));
        conta.setCaixa(caixa);
        conta.setVendas(venda);
        return conta;
    }
}
