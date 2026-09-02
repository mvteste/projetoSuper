/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.ClientesDAO;
import java.util.List;
import model.Clientes;

public class ClienteController extends ControllerSupport {
    private final ClientesDAO clientesDAO;

    public ClienteController() {
        this(new ClientesDAO());
    }

    public ClienteController(ClientesDAO clientesDAO) {
        this.clientesDAO = requireEntity(clientesDAO, "DAO de clientes");
    }

    public List<Clientes> obterClientes() {
        return clientesDAO.listar();
    }

    public void salvarCliente(String nome, String cpf, String telefone, String dataNascimento) {
        Clientes cliente = criarCliente(nome, cpf, telefone, dataNascimento);
        clientesDAO.inserir(cliente);
    }

    public void atualizarCliente(int id, String nome, String cpf, String telefone, String dataNascimento) {
        Clientes cliente = criarCliente(nome, cpf, telefone, dataNascimento);
        cliente.setId(requirePositive(id, "ID do cliente"));
        clientesDAO.editar(cliente);
    }

    public void desativarCliente(int id) {
        Clientes cliente = new Clientes();
        cliente.setId(requirePositive(id, "ID do cliente"));
        clientesDAO.desativar(cliente);
    }

    private Clientes criarCliente(String nome, String cpf, String telefone, String dataNascimento) {
        Clientes cliente = new Clientes();
        cliente.setNome(requireNonBlank(nome, "Nome"));
        cliente.setCpf(requireNonBlank(cpf, "CPF"));
        cliente.setTelefone(requireNonBlank(telefone, "Telefone"));
        cliente.setData_nascimento(requireNonBlank(dataNascimento, "Data de nascimento"));
        return cliente;
    }
}
