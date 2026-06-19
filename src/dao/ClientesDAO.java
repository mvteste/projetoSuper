package dao;

import java.util.ArrayList;
import java.util.List;
import model.Clientes;

public class ClientesDAO implements GenericDAO<Clientes> {

    @Override
    public void salvar(Clientes entidade) {
        System.out.println("Salvando cliente: " + entidade.getNome());
    }

    @Override
    public void atualizar(Clientes entidade) {
        System.out.println("Cliente atualizado: " + entidade.getNome());
    }

    @Override
    public void excluir(int id) {
        System.out.println("Cliente excluído: " + id);
    }

    @Override
    public Clientes BuscarPorId(int id) {
        System.out.println("Buscando cliente ID: " + id);
        return null;
    }

    @Override
    public List<Clientes> listarTodos() {
        System.out.println("Listando clientes...");
        return new ArrayList<>();
    }
}