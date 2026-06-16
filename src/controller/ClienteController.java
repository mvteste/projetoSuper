package controller;

import dao.ClienteDAO;
import java.util.List;
import model.Cliente;
import java.sql.Date;

public class ClienteController {

    private ClienteDAO clienteDAO = new ClienteDAO();

    public List<Cliente> obterClientes() {
        return clienteDAO.listarTodos();
    }

    public void salvarCliente(
            String nome,
            String cpf,
            String email,
            Date data_Nascimento,
            String telefone,
            String endereco) {

        Cliente c = new Cliente();

        c.setNome(nome);
        c.setCpf(cpf);
        c.data_Nascimento();
        c.setEmail(email);
        c.setTelefone(telefone);
        c.setEndereco(endereco);

        clienteDAO.salvar(c);
    }
}