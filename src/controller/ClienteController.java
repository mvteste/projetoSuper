

package controller;

import dao.ClienteDAO;
import java.util.List;
import model.Cliente;
       


public class ClienteController {
    
    private ClienteDAO clienteDAO = new ClienteDAO();
    
    public List<Cliente>obterClientes(){
        return clienteDAO.listar();
    }
    
    public void salvarCliente (String nome, String cpf, String email, String telefone, String cep, String cidade){
    
        Cliente c = new Cliente();
        c.setNome(nome);
        c.setCpf(cpf);
        c.setEmail(email);
        c.setTelefone(telefone);
        c.setCep(cep);
        c.setCidade(cidade);
        
        clienteDAO.inserir(c);
    
    
    
    }
    
    public void atualizarCliente(int id, String nome, String cidade, String cep, String telefone, String cpf, String email){
    
        Cliente c = new Cliente();
        c.setId(id);
        c.setNome(nome);
        c.setCidade(cidade);
        c.setCep(cep);
        c.setTelefone(telefone);
        c.setCpf(cpf);
        c.setEmail(email);
        
        clienteDAO.atualizar(c);
    
    }
    
    public void excluirCliente(int id){
        clienteDAO.deletar(id);
    
    }
     
    public Cliente buscarCliente(int id){
        return clienteDAO.buscarPorId(id);
    
    }
    
}//Fim da classe
