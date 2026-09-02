package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Categoria_Produtos;
import model.Produtos;

public class ProdutosDAO {

    // Método para INSERIR (Create) - Status inserido automaticamente como 1
    public void cadastrar(Produtos produto) {
        String sql = "INSERT INTO produtos (nome, descricao, preco, data_vencimento, categoria_produto_id, status) VALUES (?, ?, ?, ?, ?, 1)";
        
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getDescricao());
            stmt.setDouble(3, produto.getPreco());
            stmt.setString(4, produto.getData_vencimento());
            stmt.setInt(5, produto.getCategoria_produto().getId());
            
            stmt.executeUpdate();
            System.out.println("Produto cadastrado com sucesso!");
            
        } catch (SQLException e) {
            System.err.println("Erro ao cadastrar produto: " + e.getMessage());
        }
    }

    // Método para LISTAR TODOS ATIVOS (Read) - Filtra por status = 1
    public List<Produtos> listarTodos() {
        String sql = "SELECT p.*, c.nome AS nome_categoria, c.descricao AS desc_categoria " +
                     "FROM produtos p " +
                     "INNER JOIN categoria_produtos c ON p.categoria_produto_id = c.id " +
                     "WHERE p.status = 1";
        
        List<Produtos> lista = new ArrayList<>();
        
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                Produtos produto = new Produtos();
                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setPreco(rs.getDouble("preco"));
                produto.setData_vencimento(rs.getString("data_vencimento"));
                produto.setStatus(rs.getInt("status"));
                
                // Monta o objeto da relação categoria_produto_id
                Categoria_Produtos categoria = new Categoria_Produtos();
                categoria.setId(rs.getInt("categoria_produto_id"));
                categoria.setNome(rs.getString("nome_categoria"));
                categoria.setDescricao(rs.getString("desc_categoria"));
                
                produto.setCategoria_produto(categoria);
                
                lista.add(produto);
            }
            
        } catch (SQLException e) {
            System.err.println("Erro ao listar produtos: " + e.getMessage());
        }
        
        return lista;
    }

    // Método para BUSCAR POR ID (Read complementar)
    public Produtos buscarPorId(int id) {
        String sql = "SELECT p.*, c.nome AS nome_categoria, c.descricao AS desc_categoria " +
                     "FROM produtos p " +
                     "INNER JOIN categoria_produtos c ON p.categoria_produto_id = c.id " +
                     "WHERE p.id = ?";
        
        Produtos produto = null;
        
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    produto = new Produtos();
                    produto.setId(rs.getInt("id"));
                    produto.setNome(rs.getString("nome"));
                    produto.setDescricao(rs.getString("descricao"));
                    produto.setPreco(rs.getDouble("preco"));
                    produto.setData_vencimento(rs.getString("data_vencimento"));
                    produto.setStatus(rs.getInt("status"));
                    
                    Categoria_Produtos categoria = new Categoria_Produtos();
                    categoria.setId(rs.getInt("categoria_produto_id"));
                    categoria.setNome(rs.getString("nome_categoria"));
                    categoria.setDescricao(rs.getString("desc_categoria"));
                    
                    produto.setCategoria_produto(categoria);
                }
            }
            
        } catch (SQLException e) {
            System.err.println("Erro ao buscar produto por ID: " + e.getMessage());
        }
        
        return produto;
    }

    // Método para ATUALIZAR (Update)
    public void atualizar(Produtos produto) {
        String sql = "UPDATE produtos SET nome = ?, descricao = ?, preco = ?, data_vencimento = ?, categoria_produto_id = ?, status = ? WHERE id = ?";
        
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getDescricao());
            stmt.setDouble(3, produto.getPreco());
            stmt.setString(4, produto.getData_vencimento());
            stmt.setInt(5, produto.getCategoria_produto().getId());
            stmt.setInt(6, produto.getStatus());
            stmt.setInt(7, produto.getId());
            
            stmt.executeUpdate();
            System.out.println("Produto atualizado com sucesso!");
            
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar produto: " + e.getMessage());
        }
    }

    // Método para DELETAR (Delete lógico) - Apenas desativa tornando o status em 0
    public void deletar(int id) {
        String sql = "UPDATE produtos SET status = 0 WHERE id = ?";
        
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, id);
            
            stmt.executeUpdate();
            System.out.println("Produto desativado com sucesso!");
            
        } catch (SQLException e) {
            System.err.println("Erro ao desativar produto: " + e.getMessage());
        }
    }
}