package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Categoria_Produtos;

public class Categoria_ProdutosDAO {

    // Método para INSERIR (Create)
    public void cadastrar(Categoria_Produtos categoria) {
        String sql = "INSERT INTO categoria_produtos (nome, descricao) VALUES (?, ?)";
        
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, categoria.getNome());
            stmt.setString(2, categoria.getDescricao());
            
            stmt.executeUpdate();
            System.out.println("Categoria cadastrada com sucesso!");
            
        } catch (SQLException e) {
            System.err.println("Erro ao cadastrar categoria: " + e.getMessage());
        }
    }

    // Método para LISTAR TODOS (Read)
    public List<Categoria_Produtos> listarTodos() {
        String sql = "SELECT * FROM categoria_produtos";
        List<Categoria_Produtos> lista = new ArrayList<>();
        
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                Categoria_Produtos categoria = new Categoria_Produtos();
                categoria.setId(rs.getInt("id"));
                categoria.setNome(rs.getString("nome"));
                categoria.setDescricao(rs.getString("descricao"));
                
                lista.add(categoria);
            }
            
        } catch (SQLException e) {
            System.err.println("Erro ao listar categorias: " + e.getMessage());
        }
        
        return lista;
    }

    // Método para BUSCAR POR ID (Read complementar)
    public Categoria_Produtos buscarPorId(int id) {
        String sql = "SELECT * FROM categoria_produtos WHERE id = ?";
        Categoria_Produtos categoria = null;
        
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    categoria = new Categoria_Produtos();
                    categoria.setId(rs.getInt("id"));
                    categoria.setNome(rs.getString("nome"));
                    categoria.setDescricao(rs.getString("descricao"));
                }
            }
            
        } catch (SQLException e) {
            System.err.println("Erro ao buscar categoria por ID: " + e.getMessage());
        }
        
        return categoria;
    }

    // Método para ATUALIZAR (Update)
    public void atualizar(Categoria_Produtos categoria) {
        String sql = "UPDATE categoria_produtos SET nome = ?, descricao = ? WHERE id = ?";
        
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, categoria.getNome());
            stmt.setString(2, categoria.getDescricao());
            stmt.setInt(3, categoria.getId());
            
            stmt.executeUpdate();
            System.out.println("Categoria atualizada com sucesso!");
            
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar categoria: " + e.getMessage());
        }
    }

    // Método para DELETAR (Delete)
    public void deletar(int id) {
        String sql = "DELETE FROM categoria_produtos WHERE id = ?";
        
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, id);
            
            stmt.executeUpdate();
            System.out.println("Categoria deletada com sucesso!");
            
        } catch (SQLException e) {
            System.err.println("Erro ao deletar categoria: " + e.getMessage());
        }
    }
}