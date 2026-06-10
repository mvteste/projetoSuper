package controller;

import dao.ClienteDAO;
import java.util.List;
import model.Cliente;


public class ClienteController {    
    private ClienteDAO clienteDAO = new ClienteDAO();
    
public List<Cliente>obterClientes(){
        return clienteDAO.listarTodos();
    }

public void salvarCliente(String nome, String cpf, String email, String telefone, String endereco ){
    
    Cliente c = new Cliente();
    c.setNome(nome);
    c.setCpf(cpf);
    c.setEmail(email);
    c.setTelefone(telefone);
    c.setEndereco(endereco);
    
    clienteDAO.salvar(c);
    
    }
}
