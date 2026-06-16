
package controller;

import dao.ProdutoDAO;
import model.Produto;
import java.util.List;


public class ProdutoController {
    
    private ProdutoDAO produtoDAO = new ProdutoDAO();
    
    public List<Produto> obterProduto(){
        return produtoDAO.listar();
    
    
    }
    
    public void salvarProduto(String nome, float preco, int id_categoria, int id_fornecedor, String marca, int codigo_barras, String descricao){
    
        Produto p = new Produto();
        
        p.setNome(nome);
        p.setPreco(preco);
        p.setId_categoria(id_categoria);
        p.setId_fornecedor(id_fornecedor);
        p.setMarca(marca);
        p.setCodigo_barras(codigo_barras);
        p.setDescricao(descricao);
        
        
        produtoDAO.inserir(p);
                
    
    
    }
    

      


    
}
