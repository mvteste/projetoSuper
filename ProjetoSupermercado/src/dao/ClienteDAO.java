package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Cliente;

public class ClienteDAO implements GenericDAO<Cliente> {

    @Override
    public void salvar(Cliente cliente) {

        String sql = """
                     INSERT INTO clientes
                     (nome, data_nascimento, cpf, endereco, telefone)
                     VALUES (?, ?, ?, ?, ?)
                     """;

        try (
                Connection conn = Conexao.conectar();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getDataNascimento());
            stmt.setString(3, cliente.getCpf());
            stmt.setString(4, cliente.getEndereco());
            stmt.setString(5, cliente.getTelefone());

            stmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Erro ao salvar cliente: " + e.getMessage());
        }
    }

    @Override
    public void atualizar(Cliente cliente) {

        String sql = """
                     UPDATE clientes
                     SET nome = ?,
                         data_nascimento = ?,
                         cpf = ?,
                         endereco = ?,
                         telefone = ?
                     WHERE id = ?
                     """;

        try (
                Connection conn = Conexao.conectar();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getDataNascimento());
            stmt.setString(3, cliente.getCpf());
            stmt.setString(4, cliente.getEndereco());
            stmt.setString(5, cliente.getTelefone());
            stmt.setInt(6, cliente.getId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Erro ao atualizar cliente: " + e.getMessage());
        }
    }

    @Override
    public void excluir(int id) {

        String sql = "DELETE FROM clientes WHERE id = ?";

        try (
                Connection conn = Conexao.conectar();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            stmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Erro ao excluir cliente: " + e.getMessage());
        }
    }

    @Override
    public Cliente buscarPorId(int id) {

        String sql = "SELECT * FROM clientes WHERE id = ?";

        try (
                Connection conn = Conexao.conectar();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                Cliente cliente = new Cliente();

                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setDataNascimento(rs.getString("data_nascimento"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setEndereco(rs.getString("endereco"));
                cliente.setTelefone(rs.getString("telefone"));

                return cliente;
            }

        } catch (SQLException e) {
            System.err.println("Erro ao buscar cliente: " + e.getMessage());
        }

        return null;
    }

    @Override
    public List<Cliente> listarTodos() {

        List<Cliente> lista = new ArrayList<>();

        String sql = "SELECT * FROM clientes";

        try (
                Connection conn = Conexao.conectar();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {

                Cliente cliente = new Cliente();

                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setDataNascimento(rs.getString("data_nascimento"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setEndereco(rs.getString("endereco"));
                cliente.setTelefone(rs.getString("telefone"));

                lista.add(cliente);
            }

        } catch (SQLException e) {
            System.err.println("Erro ao listar clientes: " + e.getMessage());
        }

        return lista;
    }
}