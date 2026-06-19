package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Estoque;
import model.Produto; // Importamos o Produto pois o Estoque depende dele

public class EstoqueDAO implements GenericDAO<Estoque> {

    @Override
    public void salvar(Estoque entidade) {
        // ATENÇÃO: Se no seu banco a coluna se chamar "id_produto", troque aqui embaixo!
        String sql = "INSERT INTO estoque (produto_id, quantidade) VALUES (?, ?)";
        
        try (Connection conn = connection.Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
             
            // Pegamos o ID do Produto que está dentro do Estoque
            stmt.setInt(1, entidade.getProduto().getId()); 
            stmt.setInt(2, entidade.getQuantidade());
            
            stmt.executeUpdate();
            System.out.println("Estoque salvo com sucesso no banco!");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void atualizar(Estoque entidade) {
        // ATENÇÃO: Se no seu banco a coluna se chamar "id_produto", troque aqui também!
        String sql = "UPDATE estoque SET produto_id=?, quantidade=? WHERE id=?";
        
        try (Connection conn = connection.Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
             
            stmt.setInt(1, entidade.getProduto().getId());
            stmt.setInt(2, entidade.getQuantidade());
            stmt.setInt(3, entidade.getId());
            
            stmt.executeUpdate();
            System.out.println("Estoque atualizado com sucesso!");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void excluir(int id) {
        String sql = "DELETE FROM estoque WHERE id=?";
        
        try (Connection conn = connection.Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
             
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Item excluído do estoque com sucesso!");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Estoque buscarPorId(int id) {
        Estoque e = null;
        String sql = "SELECT * FROM estoque WHERE id=?";
        
        try (Connection conn = connection.Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
             
            stmt.setInt(1, id);
            
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    e = new Estoque();
                    e.setId(rs.getInt("id"));
                    e.setQuantidade(rs.getInt("quantidade"));
                    
                    // Como o banco retorna apenas o ID do produto, criamos um Produto "vazio" 
                    // apenas com o ID para colocar dentro do Estoque
                    Produto p = new Produto();
                    // ATENÇÃO: Se no banco for "id_produto", mude a palavra entre aspas abaixo
                    p.setId(rs.getInt("produto_id")); 
                    e.setProduto(p);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return e;
    }

    @Override
    public List<Estoque> listarTodos() {
        List<Estoque> lista = new ArrayList<>();
        String sql = "SELECT * FROM estoque";
        
        try (Connection conn = connection.Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
             
            while (rs.next()) {
                Estoque e = new Estoque();
                e.setId(rs.getInt("id"));
                e.setQuantidade(rs.getInt("quantidade"));
                
                // Recriamos a associação do Produto
                Produto p = new Produto();
                // ATENÇÃO: Se no banco for "id_produto", mude a palavra entre aspas abaixo
                p.setId(rs.getInt("produto_id"));
                e.setProduto(p);
                
                lista.add(e);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return lista;
    }
}
