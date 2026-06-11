package controller;
import dao.ClienteDAO;
import java.util.List;
import model.Cliente;

public class ClienteController {
    private ClienteDAO clienteDAO = new ClienteDAO();
    
    public List<Cliente>obterClientes(){
        return clienteDAO.listar();
    }
    public void salvarCliente (String nome, String cpf, String telefone){
        Cliente c = new Cliente();
        c.setNome(nome);
        c.setCpf(cpf);
        c.setTelefone(telefone);
        
        clienteDAO.salvar(c);
    }
    
}