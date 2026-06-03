
package dao;

import model.Fornecedor;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FornecedorDAO {
    
    public List<Fornecedor> listar(){
        List<Fornecedor> lista = new ArrayList<>();
        
        try{
            Connection conn = Conexao.conectar();                    
             String sql = "SELECT * FROM fornecedor";
             
             PreparedStatement stmt = conn.prepareStatement(sql);
             
             ResultSet rs = stmt.executeQuery();
             
             while(rs.next()){
                 
                 Fornecedor f = new Fornecedor();
                 
                 stmt.setInt(1, rs.getInt("id"));
                 stmt.setString(2, rs.getString("nome"));
                 stmt.setString(3, rs.getString("cnpj"));
                 stmt.setString(4,rs.getString("telefone"));
                 stmt.setString(5,rs.getString("email"));
                 
                 lista.add(f);
             
             
             }
             
             rs.close();
             stmt.close();
             conn.close();
        
        }catch(Exception e){
            e.printStackTrace();
        }
       
        
       
        
    
    
    return lista;
    }//Fim do lista
    
    public void inserir(Fornecedor f){
        
        try(Connection conn= Conexao.conectar()){
        
            String sql = "INSERT INTO fornecedor (nome,cnpj,telefone,email) VALUES (?,?,?,?)";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setString(1,f.getNome());
            stmt.setString(2,f.getCnpj());
            stmt.setString(3,f.getTelefone());
            stmt.setString(4,f.getEmail());
            
            stmt.execute();
            
        
        
        }catch(Exception e){
            e.printStackTrace();
        
        }
    
    
    }
    
    public void atualizar(Fornecedor f){
    
        try(Connection conn = Conexao.conectar()){
        
            String sql = "UPDATE fornecedor SET nome=?, cnpj=?, telefone= ?, email=? WHERE id = ?";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setInt(1, f.getId());
            stmt.setString(2,f.getNome());
            stmt.setString(3,f.getCnpj());
            stmt.setString(4,f.getTelefone());
            stmt.setString(5,f.getTelefone());
            
            stmt.execute();
        
        
        }catch(Exception e){
            e.printStackTrace();
        
        }
    
    
    }//Fim do deletar
    
    
    public void deletar(int id){
        try(Connection conn = Conexao.conectar()){
        
            String sql = "DELETE FROM fornecedor WHERE id = ?";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setInt(1, id);
            
        
        }catch(Exception e){
            e.printStackTrace();
        
        }
        
    
    }//Fim do deletar
    
    
}
