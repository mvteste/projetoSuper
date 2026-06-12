/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import dao.ClientesDAO;
import java.util.List;
import model.Clientes;

public class ClienteController {
    private ClientesDAO clientesDAO = new ClientesDAO();
    
    public List<Clientes>obterClientes(){
        return clientesDAO.listar();
    }
    public void salvarCliente (String nome, String cpf, String telefone, String data_nascimento){
        Clientes c = new Clientes();
        c.setNome(nome);
        c.setData_nascimento(data_nascimento);
        c.setCpf(cpf);
        c.setTelefone(telefone);
        
        clientesDAO.inserir(c);
    }
    
}
