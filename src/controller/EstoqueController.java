
package controller;

import dao.EstoqueDAO;
import model.Estoque;
import java.util.List;


public class EstoqueController {
    
    private EstoqueDAO estoqueDAO = new EstoqueDAO();
    
    public List<Estoque>obterEstoque(){
        return estoqueDAO.listar();
    
    }
    
    public void salvarEstoque (int quantidade, int produto_id, String data_validade, String lote){
    
        Estoque e = new Estoque();
        e.setQuantidade(quantidade);
        e.setProduto_id(produto_id);
        e.setData_validade(data_validade);
        e.setLote(lote);
        
        estoqueDAO.inserir(e);
        
    
    }
    
}
