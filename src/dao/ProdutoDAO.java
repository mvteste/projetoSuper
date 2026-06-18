package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
//import java.util.List;
import model.Categoria;
import model.Produto;
//import util.Conexao;
import java.util.List;

public class ProdutoDAO implements GenericDAO<Produto> {
    
    @Override
    public void salvar(Produto produto){
        String sql = "INSERT INTO produto (nome, preco, categoria_id) VALUES (?, ?, ?)";
          try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, produto.getNome());
                stmt.setDouble(2, produto.getPreco());
                // Pegamos o ID do objeto Categoria que está dentro do Produto
                stmt.setInt(3, produto.getCategoria().getId());
            
                stmt.executeUpdate();
          } catch (SQLException e) {
            System.err.println("Erro ao salvar produto: " + e.getMessage());
        }
    }
    
    @Override
    public void atualizar(Produto entidade){
    
    }
            
    @Override        
    public void excluir (int id){
    }
   
    @Override
    public Produto buscarPorId(int id){
        System.out.println("Buscando Dliente ID: " + id);
        return null;
    
    }
    
    @Override
    public List<Produto> listarTodos(){
         // Exemplo com INNER JOIN para trazer os dados da categoria junto
        String sql = "SELECT p.*, c.nome as cat_nome FROM produto p " +
                     "INNER JOIN categoria c ON c.id = p.categoria_id";
        List<Produto> lista = new ArrayList();
        
         try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
             
                 while (rs.next()) {
                Produto p = new Produto();
                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setPreco(rs.getDouble("preco"));
                
                   // Montamos o objeto Categoria para o Produto
                Categoria c = new Categoria();
                c.setId(rs.getInt("categoria_id"));
                c.setNome(rs.getString("cat_nome"));
                p.setCategoria(c);
                
                lista.add(p);
            } 
        } catch (SQLException e) {
            System.err.println("Erro ao listar produtos: " + e.getMessage());
        }
        return lista;
    }
}   
