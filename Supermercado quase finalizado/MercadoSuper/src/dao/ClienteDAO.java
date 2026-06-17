package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Cliente;

public class ClienteDAO {

    public void inserir(Cliente cliente) throws SQLException {
        String sql = "INSERT INTO cliente (nome, cpf, telefone, endereco) VALUES (?, ?, ?, ?)";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setString(3, cliente.getTelefone());
            stmt.setString(4, cliente.getEndereco());
            stmt.executeUpdate();
        }
    }

    public void atualizar(Cliente cliente) throws SQLException {
        String sql = "UPDATE cliente SET nome = ?, cpf = ?, telefone = ?, endereco = ? WHERE id_cliente = ?";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setString(3, cliente.getTelefone());
            stmt.setString(4, cliente.getEndereco());
            stmt.setInt(5, cliente.getIdCliente());
            stmt.executeUpdate();
        }
    }

    public void excluir(int idCliente) throws SQLException {
        String sql = "DELETE FROM cliente WHERE id_cliente = ?";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idCliente);
            stmt.executeUpdate();
        }
    }

  public List<Cliente> listar() throws SQLException {
    List<Cliente> lista = new ArrayList<>();
    String sql = "SELECT id_cliente, nome, cpf, telefone, endereco FROM cliente";
    try (Connection conn = Conexao.getConexao();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(sql)) {
        while (rs.next()) {
            Cliente cliente = new Cliente();
            cliente.setIdCliente(rs.getInt("id_cliente"));
            cliente.setNome(rs.getString("nome"));
            cliente.setCpf(rs.getString("cpf"));
            cliente.setTelefone(rs.getString("telefone"));
            cliente.setEndereco(rs.getString("endereco"));
            lista.add(cliente);
        }
    }
    return lista;
}

public Cliente buscarPorId(int idCliente) throws SQLException {
    String sql = "SELECT id_cliente, nome, cpf, telefone, endereco FROM cliente WHERE id_cliente = ?";
    try (Connection conn = Conexao.getConexao();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, idCliente);
        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setIdCliente(rs.getInt("id_cliente"));
                cliente.setNome(rs.getString("nome"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setEndereco(rs.getString("endereco"));
                return cliente;
            }
        }
    }
    return null;
}
}
