
package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.ItemVenda;


public class ItemVendaDAO {
    
    public List<ItemVenda> listar(){
        List<ItemVenda> lista = new ArrayList<>();
        
        try{
        Connection conn = Conexao.conectar();
        
        String sql = "SELECT * FROM item_venda";
        
        PreparedStatement stmt = conn.prepareStatement(sql);
        
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()){
        
        ItemVenda Iv = new ItemVenda();
        
        stmt.setInt(1, rs.getInt("id"));
        stmt.setInt(2, rs.getInt("id_produto"));
        stmt.setInt(3,rs.getInt("id_venda"));
        stmt.setInt(4,rs.getInt("quantidade"));
        
        lista.add(Iv);
            
        
        }
        
        rs.close();
        stmt.close();
        conn.close();
        
            
        
        }catch(Exception e){
            e.printStackTrace();
                
        }
            
        return lista;

        }//Fim do listar
    
    
    public void inserir(ItemVenda Iv){
    
        try(Connection conn = Conexao.conectar()){
        
        
            String sql = "INSERT INTO item_venda (id_produto,quantidade,id_venda) VALUES (?,?,?)";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setInt(1,Iv.getId_produto());
            stmt.setInt(2,Iv.getQuantidade());
            stmt.setInt(3, Iv.getId_venda());
            
            stmt.execute();
        
        
        }catch(Exception e){
            e.printStackTrace();
        }
    
    
    }//Fim do inserir
        
        public void atualizar(ItemVenda Iv){
        
        try(Connection conn = Conexao.conectar()){
            
            String sql = "UPDATE item_venda SET id_produto=?, quantidade= ?, id_venda = ? WHERE id = ?";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
        
            stmt.setInt(1, Iv.getId());
            stmt.setInt(2,Iv.getId_produto());
            stmt.setInt(3,Iv.getQuantidade());
            stmt.setInt(4,Iv.getId_venda());
            
            stmt.execute();
        
        }catch(Exception e){
            e.printStackTrace();
        
        }
        
        
        }//Fim do Atualizar
    
        public void deletar(int id){
        
            try(Connection conn = Conexao.conectar()){
            
                String sql = "DELETE FROM item_venda WHERE id = ?";
                
                PreparedStatement stmt = conn.prepareStatement(sql);
                
                stmt.setInt(1,id);
                
                stmt.execute();
                
            
            }catch(Exception e){
                e.printStackTrace();
            
            }
        
        
        }
        
        
    
    }
    

