package controller;

import dao.CategoriaDAO;
import dao.ProdutoDAO;
import model.Categoria;
import model.Produto;
import java.util.List;


public class ProdutoController {
    private CategoriaDAO categoriaDAO = new CategoriaDAO();
    private ProdutoDAO produtoDAO = new ProdutoDAO();
    
public List<Categoria>obterCategorias(){
        return categoriaDAO.listarTodos();
    }

public void salvarProduto(String nome, double preco, Categoria categoria){
    Produto p = new Produto();
    p.setNome(nome);
    p.setPreco(preco);
    p.setCategoria(categoria);
    
    produtoDAO.salvar(p);
    
    }
}
