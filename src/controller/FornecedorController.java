
package controller;

import dao.FornecedorDAO;
import model.Fornecedor;
import java.util.List;


public class FornecedorController {
    
    private FornecedorDAO fornecedorDAO = new FornecedorDAO();
    
    public List<Fornecedor>obterFornecedor(){
        return fornecedorDAO.listar();
    
    }
    
    
    public void salvarFornecedor(String nome, String cnpj, String email, String telefone){
    
           Fornecedor f = new Fornecedor();
           
           f.setNome(nome);
           f.setCnpj(cnpj);
           f.setEmail(email);
           f.setTelefone(telefone);
           
           fornecedorDAO.inserir(f);
    
    
    }
    
}
