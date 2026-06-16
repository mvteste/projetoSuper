
package controller;

import dao.ContratoTrabDAO;
import model.ContratoTrab;
import java.util.List;
        

public class ContratoTrabController {
    
    private ContratoTrabDAO contratoDAO = new ContratoTrabDAO();
    
    public List<ContratoTrab> obterContrato(){
        return contratoDAO.listar();
    
    
    
    }
    
    public void salvarContrato(String cargo, float salario, String data_inicio, String data_fim, String tipo_contrato, int funcionario_id ){
    
    
        ContratoTrab ct = new ContratoTrab();
        
        ct.setCargo(cargo);
        ct.setSalario(salario);
        ct.setData_inicio(data_inicio);
        ct.setData_fim(data_fim);
        ct.setTipo_contrato(tipo_contrato);
        ct.setId_funcionario(funcionario_id);
        
        contratoDAO.inserir(ct);
        
        
    
    }
    
    
}
