
package dao;

import model.Cliente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ClienteDAO {
    
    public List<Cliente> listar(){
        List<Cliente> lista = new ArrayList<>();
        
        try{
            Connection conn = Conexao.conectar();
            
            String sql = "SELECT * FROM cliente";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Cliente c = new Cliente();
                
                c.setId(rs.getInt("id"));
                c.setCidade(rs.getString("cidade"));
                c.setNome(rs.getString("nome"));
                c.setCep(rs.getString("cep"));
                
                lista.add(c);
            
            
            
            }
            
            rs.close();
            stmt.close();
            conn.close();
        
        
        }catch(Exception e){
            e.printStackTrace();
        }
        
    
    
    return lista;
    }
    
    
    public void inserir(Cliente c){
        try(Connection conn = Conexao.conectar()){
            
            String sql = "INSERT INTO cliente (nome,cidade,cep) VALUES (?,?,?)";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, c.getNome());
            stmt.setString(2, c.getCidade());
            stmt.setString(3, c.getCep());
            
            stmt.execute();
                               
        
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }//Fim do Inserir
    
    public void atualizar(Cliente c){
    
    try(Connection conn = Conexao.conectar()){
          
        String sql = "UPDATE cliente SET nome=?, cidade=?, cep=? WHERE id = ?";
        
        PreparedStatement stmt = conn.prepareStatement(sql);
        
        stmt.setString(1, c.getNome());
        stmt.setString(2,c.getCidade());
        stmt.setString(3, c.getCep());
        stmt.setInt(4, c.getId());
        
        stmt.execute();
    
    
    
    }catch(Exception e){
        e.printStackTrace();
    
    }
    
    
    }
    
    public void deletar(int id){
    
        try(Connection conn = Conexao.conectar()){
            
            String sql = "DELETE from cliente WHERE id = ?";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setInt(1, id);
            
            stmt.execute();
            
        
        }catch(Exception e){
            e.printStackTrace();
        
        }
    
    }
    
    
    
}
