package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Estoque;

public class EstoqueDAO {

    public void inserir(Estoque estoque) throws SQLException {
        String sql = "INSERT INTO estoque (id_produto, quantidade, data_atualizacao) VALUES (?, ?, ?)";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, estoque.getIdProduto());
            stmt.setInt(2, estoque.getQuantidade());
            stmt.setDate(3, estoque.getDataAtualizacao());
            stmt.executeUpdate();
        }
    }

    public void atualizar(Estoque estoque) throws SQLException {
        String sql = "UPDATE estoque SET id_produto = ?, quantidade = ?, data_atualizacao = ? WHERE id_estoque = ?";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, estoque.getIdProduto());
            stmt.setInt(2, estoque.getQuantidade());
            stmt.setDate(3, estoque.getDataAtualizacao());
            stmt.setInt(4, estoque.getIdEstoque());
            stmt.executeUpdate();
        }
    }

    public void excluir(int idEstoque) throws SQLException {
        String sql = "DELETE FROM estoque WHERE id_estoque = ?";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idEstoque);
            stmt.executeUpdate();
        }
    }

    public List<Estoque> listar() throws SQLException {
        List<Estoque> lista = new ArrayList<>();
        String sql = "SELECT id_estoque, id_produto, quantidade, data_atualizacao FROM estoque";

        try (Connection conn = Conexao.getConexao();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Estoque estoque = new Estoque();
                estoque.setIdEstoque(rs.getInt("id_estoque"));
                estoque.setIdProduto(rs.getInt("id_produto"));
                estoque.setQuantidade(rs.getInt("quantidade"));
                estoque.setDataAtualizacao(rs.getDate("data_atualizacao"));
                lista.add(estoque);
            }
        }

        return lista;
    }

    public Estoque buscarPorId(int idEstoque) throws SQLException {
        String sql = "SELECT id_estoque, id_produto, quantidade, data_atualizacao FROM estoque WHERE id_estoque = ?";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idEstoque);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Estoque estoque = new Estoque();
                    estoque.setIdEstoque(rs.getInt("id_estoque"));
                    estoque.setIdProduto(rs.getInt("id_produto"));
                    estoque.setQuantidade(rs.getInt("quantidade"));
                    estoque.setDataAtualizacao(rs.getDate("data_atualizacao"));
                    return estoque;
                }
            }
        }

        return null;
    }
}
