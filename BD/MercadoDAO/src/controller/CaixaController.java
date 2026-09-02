package controller;

import dao.CaixaDAO;
import java.util.List;
import model.Caixa;

public class CaixaController extends ControllerSupport {
    private final CaixaDAO dao;

    public CaixaController() { this(new CaixaDAO()); }
    public CaixaController(CaixaDAO dao) { this.dao = requireEntity(dao, "DAO de caixas"); }

    public List<Caixa> obterCaixas() { return dao.listar(); }
    public void salvarCaixa(String nome, double valor) { dao.inserir(criar(nome, valor)); }

    public void atualizarCaixa(int id, String nome, double valor) {
        Caixa caixa = criar(nome, valor);
        caixa.setId(requirePositive(id, "ID do caixa"));
        dao.editar(caixa);
    }

    public void excluirCaixa(int id) {
        Caixa caixa = new Caixa();
        caixa.setId(requirePositive(id, "ID do caixa"));
        dao.deletar(caixa);
    }

    private Caixa criar(String nome, double valor) {
        Caixa caixa = new Caixa();
        caixa.setNome(requireNonBlank(nome, "Nome"));
        caixa.setValor(requireNonNegative(valor, "Valor"));
        return caixa;
    }
}
