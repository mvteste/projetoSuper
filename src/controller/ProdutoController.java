package controller;

import dao.ProdutoDAO;
import model.Produto;
import java.util.List;

public class ProdutoController {

    private ProdutoDAO produtoDAO = new ProdutoDAO();

    // Listar
    public List<Produto> obterProdutos() {
        return produtoDAO.listar();
    }

    // Inserir
    public void salvarProduto(String nome, float preco,
                              int idCategoria,
                              int idFornecedor,
                              String marca,
                              int codigoBarras,
                              String descricao) {

        Produto p = new Produto();

        p.setNome(nome);
        p.setPreco(preco);
        p.setId_categoria(idCategoria);
        p.setId_fornecedor(idFornecedor);
        p.setMarca(marca);
        p.setCodigo_barras(codigoBarras);
        p.setDescricao(descricao);

        produtoDAO.inserir(p);
    }

    // Atualizar
    public void atualizarProduto(int id,
                                 String nome,
                                 float preco,
                                 int idCategoria,
                                 int idFornecedor,
                                 String marca,
                                 int codigoBarras,
                                 String descricao) {

        Produto p = new Produto();

        p.setId(id);
        p.setNome(nome);
        p.setPreco(preco);
        p.setId_categoria(idCategoria);
        p.setId_fornecedor(idFornecedor);
        p.setMarca(marca);
        p.setCodigo_barras(codigoBarras);
        p.setDescricao(descricao);

        produtoDAO.atualizar(p);
    }

    // Excluir
    public void excluirProduto(int id) {
        produtoDAO.deletar(id);
    }

    // Buscar por ID
    public Produto buscarProduto(int id) {
        return produtoDAO.buscarPorId(id);
    }
}