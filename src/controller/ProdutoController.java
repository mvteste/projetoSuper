package controller;

import dao.CategoriaDAO;
import dao.ProdutoDAO;
import model.Categoria;
import model.Produto;
import java.util.List;

public class ProdutoController {
    
    // 1. CORREÇÃO: Adicionados os parênteses () após o nome das classes
    private CategoriaDAO categoriaDAO = new CategoriaDAO(); 
    private ProdutoDAO produtoDAO = new ProdutoDAO(); 
    
    public List<Categoria> obterCategorias(){
        // 2. CORREÇÃO: Alterado para listarTodas() (ou mantenha listarTodos se você mudou no DAO)
        return categoriaDAO.listarTodos(); 
    }
    
    public void salvarProduto(String nome, double preco, String descricao, Categoria categoria, java.util.Date dataVencimento){
        Produto p = new Produto(); 
        
        p.setNome(nome);
        p.setPreco(preco); 
        p.setDescricao(descricao); 
        p.setCategoria(categoria);
        
        // Passando a data para o produto
        p.setDataVencimento(dataVencimento);
        
        produtoDAO.salvar(p);
    }
    
    public java.util.List<model.Produto> listarProdutos() {
        return produtoDAO.listarTodos();
    }

    public java.util.List<model.Produto> buscarProdutosPorNome(String nome) {
        return produtoDAO.buscarPorNome(nome);
    }

    public void excluirProduto(int id) {
        produtoDAO.excluir(id);
    }
}