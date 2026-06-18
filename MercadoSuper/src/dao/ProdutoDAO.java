package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Produto;

public class ProdutoDAO {

    public void inserir(Produto produto) throws SQLException {
        String sql = "INSERT INTO produto (nome, preco, quantidade, id_categoria) VALUES (?, ?, ?, ?)";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, produto.getNome());
            stmt.setDouble(2, produto.getPreco());
            stmt.setInt(3, produto.getQuantidade());
            stmt.setInt(4, produto.getIdCategoria());
            stmt.executeUpdate();
        }
    }

    public void atualizar(Produto produto) throws SQLException {
        String sql = "UPDATE produto SET nome = ?, preco = ?, quantidade = ?, id_categoria = ? WHERE id_produto = ?";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, produto.getNome());
            stmt.setDouble(2, produto.getPreco());
            stmt.setInt(3, produto.getQuantidade());
            stmt.setInt(4, produto.getIdCategoria());
            stmt.setInt(5, produto.getIdProduto());
            stmt.executeUpdate();
        }
    }

    public void excluir(int idProduto) throws SQLException {
        String sql = "DELETE FROM produto WHERE id_produto = ?";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idProduto);
            stmt.executeUpdate();
        }
    }

    public List<Produto> listar() throws SQLException {
        List<Produto> lista = new ArrayList<>();
        String sql = "SELECT id_produto, nome, preco, quantidade, id_categoria FROM produto";

        try (Connection conn = Conexao.getConexao();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Produto produto = new Produto();
                produto.setIdProduto(rs.getInt("id_produto"));
                produto.setNome(rs.getString("nome"));
                produto.setPreco(rs.getDouble("preco"));
                produto.setQuantidade(rs.getInt("quantidade"));
                produto.setIdCategoria(rs.getInt("id_categoria"));
                lista.add(produto);
            }
        }

        return lista;
    }

    public Produto buscarPorId(int idProduto) throws SQLException {
        String sql = "SELECT id_produto, nome, preco, quantidade, id_categoria FROM produto WHERE id_produto = ?";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idProduto);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Produto produto = new Produto();
                    produto.setIdProduto(rs.getInt("id_produto"));
                    produto.setNome(rs.getString("nome"));
                    produto.setPreco(rs.getDouble("preco"));
                    produto.setQuantidade(rs.getInt("quantidade"));
                    produto.setIdCategoria(rs.getInt("id_categoria"));
                    return produto;
                }
            }
        }

        return null;
    }
}
