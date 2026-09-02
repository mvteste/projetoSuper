package controller;

import dao.FornecedorDAO;
import java.util.List;
import model.Fornecedor;

public class FornecedorController extends ControllerSupport {
    private final FornecedorDAO dao;

    public FornecedorController() { this(new FornecedorDAO()); }
    public FornecedorController(FornecedorDAO dao) { this.dao = requireEntity(dao, "DAO de fornecedores"); }

    public List<Fornecedor> obterFornecedores() { return dao.listar(); }

    public void salvarFornecedor(String nome, String cnpj, String email, String endereco) {
        dao.inserir(criar(nome, cnpj, email, endereco));
    }

    public void atualizarFornecedor(int id, String nome, String cnpj, String email, String endereco) {
        Fornecedor fornecedor = criar(nome, cnpj, email, endereco);
        fornecedor.setId(requirePositive(id, "ID do fornecedor"));
        dao.editar(fornecedor);
    }

    public void desativarFornecedor(int id) {
        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setId(requirePositive(id, "ID do fornecedor"));
        dao.desativar(fornecedor);
    }

    private Fornecedor criar(String nome, String cnpj, String email, String endereco) {
        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setNome(requireNonBlank(nome, "Nome"));
        fornecedor.setCnpj(requireNonBlank(cnpj, "CNPJ"));
        fornecedor.setEmail(requireNonBlank(email, "E-mail"));
        fornecedor.setEndereco(requireNonBlank(endereco, "Endereço"));
        return fornecedor;
    }
}
