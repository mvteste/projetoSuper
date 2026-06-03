
package dao;

import model.ContasReceber;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContasReceberDAO {
    
    public List<ContasReceber> listar(){
        List<ContasReceber>lista = new ArrayList<>();
        
        try{
            Connection conn = Conexao.conectar();
            
            String sql = "SELECT * FROM contas_receber";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                
                ContasReceber cr = new ContasReceber();
                
                stmt.setInt(1, rs.getInt("id"));
                stmt.setFloat(2, rs.getFloat("valor"));
                stmt.setString(3, rs.getString("data_vencimento"));
                stmt.setInt(4, rs.getInt("item_venda_id"));
                
                lista.add(cr);
                
                
            
            
            }
            
            rs.close();
            stmt.close();
            conn.close();
            
        
        
        
        }catch(Exception e){
            e.printStackTrace();
        }
    
    
    
      return lista;

    }
    
    
    public void inserir (ContasReceber cr){
        
        try(Connection conn = Conexao.conectar()){
            
            String sql = "INSERT INTO contas_receber (valor,data_vencimento,item_venda_id) VALUES (?,?,?)";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setFloat(1, cr.getValor());
            stmt.setString(2, cr.getData_vencimento());
            stmt.setInt(3,cr.getId_item_venda());
            
            stmt.execute();
            
        
        
        }catch(Exception e){
            e.printStackTrace();
        }
    
    
    
    }//Fim do listar
    
    public void atualizar(ContasReceber cr){
        try(Connection conn = Conexao.conectar()){
            
            String sql = "UPDATE contas_receber SET valor = ?, data_vencimento = ?, item_venda_id = ? WHERE id = ?";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setFloat(1,cr.getValor());
            stmt.setString(2, cr.getData_vencimento());
            stmt.setInt(3, cr.getId_item_venda());
            stmt.setInt(4, cr.getId());
            
            stmt.execute();
        
        
        
        }catch(Exception e){
            e.printStackTrace();
        }
    
    
    
    }//Fim do atualizar
    
    
    public void deletar(int id){
    
        try(Connection conn = Conexao.conectar()){
        
            String sql = "DELETE FROM contas_receber WHERE id = ?";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setInt(1, id);
            
            stmt.execute();
            
        
        }catch(Exception e){
            e.printStackTrace();
        
        }
    
    
    }//Fim do deletar
    
    
}
