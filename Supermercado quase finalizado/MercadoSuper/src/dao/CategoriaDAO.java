package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Categoria;

public class CategoriaDAO {

    public void inserir(Categoria categoria) throws SQLException {
        String sql = "INSERT INTO categoria (nome) VALUES (?)";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, categoria.getNome());
            stmt.executeUpdate();
        }
    }

    public void atualizar(Categoria categoria) throws SQLException {
        String sql = "UPDATE categoria SET nome = ? WHERE id_categoria = ?";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, categoria.getNome());
            stmt.setInt(2, categoria.getIdCategoria());
            stmt.executeUpdate();
        }
    }

    public void excluir(int idCategoria) throws SQLException {
        String sql = "DELETE FROM categoria WHERE id_categoria = ?";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idCategoria);
            stmt.executeUpdate();
        }
    }

    public List<Categoria> listar() throws SQLException {
        List<Categoria> lista = new ArrayList<>();
        String sql = "SELECT id_categoria, nome FROM categoria";

        try (Connection conn = Conexao.getConexao();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Categoria categoria = new Categoria();
                categoria.setIdCategoria(rs.getInt("id_categoria"));
                categoria.setNome(rs.getString("nome"));
                lista.add(categoria);
            }
        }

        return lista;
    }

    public Categoria buscarPorId(int idCategoria) throws SQLException {
        String sql = "SELECT id_categoria, nome FROM categoria WHERE id_categoria = ?";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idCategoria);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Categoria categoria = new Categoria();
                    categoria.setIdCategoria(rs.getInt("id_categoria"));
                    categoria.setNome(rs.getString("nome"));
                    return categoria;
                }
            }
        }

        return null;
    }
}
