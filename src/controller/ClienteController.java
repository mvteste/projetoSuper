package controller;
import dao.ClienteDAO;
import java.util.List;
import model.Cliente;
import java.util.Date;

public class ClienteController {    
    private final ClienteDAO clienteDAO;

       public ClienteController() {
        this.clienteDAO = new ClienteDAO();
    }
    
public List<Cliente>listarTodos(){
        return clienteDAO.listarTodos();        
    }

public void salvarCliente(String nome, String cpf, String email, String telefone, String endereco, Date datanasc ){   
    Cliente c = new Cliente();
    c.setNome(nome);
    c.setCpf(cpf);
    c.setEmail(email);
    c.setTelefone(telefone);
    c.setEndereco(endereco);
    c.setDataNascimento(datanasc);
    
      System.out.println("DEBUG CONTROLLER: Data no objeto Cliente: " + c.getDataNascimento());
      
    clienteDAO.salvar(c);
    }

    public void salvarCliente(String nome, String cpf, String email, String telefone, String endereco, String datanasc) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
