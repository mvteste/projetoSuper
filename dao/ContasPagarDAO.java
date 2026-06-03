
package dao;


import model.ContasPagar;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;



public class ContasPagarDAO {
    
    public List<ContasPagar> listar(){
        List<ContasPagar> lista = new ArrayList<>();
        
        try {
            Connection conn = Conexao.conectar();
            
            String sql = "SELECT * FROM contas_pagar";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                
                ContasPagar cp = new ContasPagar();
                
                cp.setId(rs.getInt("id"));
                cp.setId_fornecedor(rs.getInt("id_fornecedor"));
                cp.setData(rs.getString("data"));
                cp.setStatus(rs.getString("status"));
                cp.setValor(rs.getFloat("valor"));
                
                lista.add(cp);
               
            
            
            
            }
            
            rs.close();
            stmt.close();
            conn.close();
        
        
        
        }catch(Exception e){
            e.printStackTrace();
        
        }
        
    
    
    return lista;
    }
    
    public void inserir(ContasPagar cp){
        
        try(Connection conn = Conexao.conectar()){
            
            
        String sql = "INSERT INTO contas_pagar (data, status, valor,id_fornecedor) VALUES (?,?,?,?)";

        PreparedStatement stmt = conn.prepareStatement(sql);
        
        stmt.setString(1, cp.getData());
        stmt.setString(2, cp.getStatus());
        stmt.setFloat(3, cp.getValor());
        stmt.setInt(4, cp.getId_fornecedor());
        
        
        stmt.execute();
        
        
        
        
        }catch(Exception e){
            e.printStackTrace();
        }
        
    
    }//Fim do listar
    
    
    public void atualizar(ContasPagar cp){
        
        try(Connection conn = Conexao.conectar()){
            
            String sql = "UPDATE contas_pagar SET data= ?, status=?, valor=?, id_fornecedor=?  WHERE id = ?";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, cp.getData());
            stmt.setString(2, cp.getStatus());
            stmt.setFloat(3, cp.getValor());
            stmt.setInt(4, cp.getId());
            stmt.setInt(5,cp.getId_fornecedor());

            
            stmt.execute();
        
        
        }catch(Exception e){
            e.printStackTrace();
        }
    
    
    
    }//Fim do Atualizar
    
    public void deletar(int id){
        try(Connection conn = Conexao.conectar()){
            
            String sql = "DELETE FROM contas_pagar WHERE id = ?";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setInt(1, id);
            
            stmt.execute();
        
        
        
        }catch(Exception e){
            e.printStackTrace();
        }
    
    }
    
     
}
