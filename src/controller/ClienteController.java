package controller;
import dao.ClientesDAO;
import java.util.List;
import model.Clientes;

public class ClienteController {
    private ClientesDAO clienteDAO = new ClientesDAO();
    
public List<Clientes>obterClientes() {
    return clienteDAO.listarTodos();
    }

public void salvarClientes(int id_usuario, String nome, String cpf, String telefone, 
        String email, String endereço, String data_cadastro, boolean situacao) {
    
    Clientes c = new Clientes();
    c.setId(id_usuario);
    c.setNome(nome);
    c.setCPF(cpf);
    c.setTelefone(telefone);
    c.setEmail(email);
    c.setEndereço(endereço);
    c.setData_Cadastro(data_cadastro);
    c.setSituaçao(situacao);
    
    clienteDAO.salvar(c);
}
}
