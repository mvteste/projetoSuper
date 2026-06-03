
package dao;

import model.Estoque;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class EstoqueDAO {
    
    public List<Estoque> listar(){
        List<Estoque> lista = new ArrayList<>();
        
        try{
        
            Connection conn = Conexao.conectar();
            
            String sql = "SELECT * FROM Estoque";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                
                Estoque e = new Estoque();
                
                stmt.setInt(1, rs.getInt("id"));
                stmt.setInt(2, rs.getInt("quantidade"));
                stmt.setInt(3, rs.getInt("produto_id"));
                stmt.setString(4, rs.getString("data_validade"));
                stmt.setString(5, rs.getString("lote"));
                
                lista.add(e);
            
            }
            
            rs.close();
            stmt.close();
            conn.close();
        
        }catch(Exception e){
            e.printStackTrace();
        
        }
        
    
        return lista;
        
    }//Fim da lista
    
    public void inserir(Estoque e){
        
        try(Connection conn = Conexao.conectar()){
            
            String sql = "INSERT INTO estoque (quantidade, produto_id,data_validade,lote) VALUES (?,?,?,?)";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setInt(1, e.getQuantidade());
            stmt.setInt(2,e.getProduto_id());
            stmt.setString(3,e.getData_validade());
            stmt.setString(4,e.getLote());
            
            stmt.execute();   
            
        
        }catch(Exception ex){
            ex.printStackTrace();
        
        }
    
    
    }//Fim do Inserir
    
    public void atualizar(Estoque e){
    
        try(Connection conn = Conexao.conectar()){
        
            String sql = "UPDATE estoque SET quantidade= ?, produto_id = ?, data_validade= ?, lote= ? WHERE id = ?";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setInt(1,e.getQuantidade());
            stmt.setInt(2, e.getProduto_id());
            stmt.setString(3, e.getData_validade());
            stmt.setString(4, e.getLote());
            stmt.setInt(5, e.getId());
            
            stmt.execute();
            
            
        
        }catch(Exception ex){
            ex.printStackTrace();
        
        }
        
        
    
    }//Fim do Atualizar
    
    public void deletar(int id){
        try(Connection conn = Conexao.conectar()){
        
            String sql = "DELETE FROM estoque WHERE id = ?";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setInt(1, id);
        
        }catch(Exception e){
            e.printStackTrace();
        }
    
    
    }
    
    
    
}
