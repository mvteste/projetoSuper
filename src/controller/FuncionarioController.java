
package controller;

import model.Funcionario;
import dao.FuncionarioDAO;
import java.util.List;


public class FuncionarioController {
    
    private FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
    
    public List<Funcionario>obterFuncionario(){
        return funcionarioDAO.listar();
         
        
    }
    
    public void salvarFuncionario(String nome, String data_nascimento,String telefone, int tipo_funcionario_id){
        
        Funcionario f = new Funcionario();
        
        f.setNome(nome);
        f.setData_nascimento(data_nascimento);
        f.setTelefone(telefone);
        f.setId_tipoFuncionario(tipo_funcionario_id);
        
        
        funcionarioDAO.inserir(f);
        
    
    
    }
    
    
    
}
