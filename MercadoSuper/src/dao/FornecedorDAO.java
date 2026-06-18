package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Fornecedor;

public class FornecedorDAO {

    public void inserir(Fornecedor fornecedor) throws SQLException {
        String sql = "INSERT INTO fornecedor (nome, cnpj, telefone) VALUES (?, ?, ?)";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, fornecedor.getNome());
            stmt.setString(2, fornecedor.getCnpj());
            stmt.setString(3, fornecedor.getTelefone());
            stmt.executeUpdate();
        }
    }

    public void atualizar(Fornecedor fornecedor) throws SQLException {
        String sql = "UPDATE fornecedor SET nome = ?, cnpj = ?, telefone = ? WHERE id_fornecedor = ?";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, fornecedor.getNome());
            stmt.setString(2, fornecedor.getCnpj());
            stmt.setString(3, fornecedor.getTelefone());
            stmt.setInt(4, fornecedor.getIdFornecedor());
            stmt.executeUpdate();
        }
    }

    public void excluir(int idFornecedor) throws SQLException {
        String sql = "DELETE FROM fornecedor WHERE id_fornecedor = ?";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idFornecedor);
            stmt.executeUpdate();
        }
    }

    public List<Fornecedor> listar() throws SQLException {
        List<Fornecedor> lista = new ArrayList<>();
        String sql = "SELECT id_fornecedor, nome, cnpj, telefone FROM fornecedor";

        try (Connection conn = Conexao.getConexao();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Fornecedor fornecedor = new Fornecedor();
                fornecedor.setIdFornecedor(rs.getInt("id_fornecedor"));
                fornecedor.setNome(rs.getString("nome"));
                fornecedor.setCnpj(rs.getString("cnpj"));
                fornecedor.setTelefone(rs.getString("telefone"));
                lista.add(fornecedor);
            }
        }

        return lista;
    }

    public Fornecedor buscarPorId(int idFornecedor) throws SQLException {
        String sql = "SELECT id_fornecedor, nome, cnpj, telefone FROM fornecedor WHERE id_fornecedor = ?";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idFornecedor);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Fornecedor fornecedor = new Fornecedor();
                    fornecedor.setIdFornecedor(rs.getInt("id_fornecedor"));
                    fornecedor.setNome(rs.getString("nome"));
                    fornecedor.setCnpj(rs.getString("cnpj"));
                    fornecedor.setTelefone(rs.getString("telefone"));
                    return fornecedor;
                }
            }
        }

        return null;
    }
}
