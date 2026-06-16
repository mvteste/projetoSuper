
package controller;

import dao.ContasPagarDAO;
import model.ContasPagar;
import java.util.List;

public class ContasPagarController {
    
    private ContasPagarDAO contasPagarDAO = new ContasPagarDAO();
    
    public List<ContasPagar> obterContas(){
        return contasPagarDAO.listar();
    
    
    
    }
    
    public void salvarContas(Float valor, String data, int id_fornecedor, String status){
    
        ContasPagar cp = new ContasPagar();
        cp.setId_fornecedor(id_fornecedor);
        cp.setStatus(status);
        cp.setValor(valor);
        cp.setData(data);
        
        contasPagarDAO.inserir(cp);
    
    
    }
    
    
}
