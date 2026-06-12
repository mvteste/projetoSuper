package controller;

import dao.ClienteDAO;
import java.util.List;
import model.Cliente;

public class ClienteController {

    private ClienteDAO clienteDAO = new ClienteDAO();

    public List<Cliente> obterClientes() {
        return clienteDAO.listarTodos();
    }

    public void salvarCliente(
            String nome,
            String dataNascimento,
            String cpf,
            String endereco,
            String telefone) {

        Cliente cliente = new Cliente();

        cliente.setNome(nome);
        cliente.setDataNascimento(dataNascimento);
        cliente.setCpf(cpf);
        cliente.setEndereco(endereco);
        cliente.setTelefone(telefone);

        clienteDAO.salvar(cliente);
    }

    public void atualizarCliente(Cliente cliente) {
        clienteDAO.atualizar(cliente);
    }

    public void excluirCliente(int id) {
        clienteDAO.excluir(id);
    }

    public Cliente buscarCliente(int id) {
        return clienteDAO.buscarPorId(id);
    }
}