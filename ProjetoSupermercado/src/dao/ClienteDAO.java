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
                c.setNome(rs.getString("nome"));
                
                lista.add(c);
             
            }
            
            rs.close();
            stmt.close();
            conn.close();
        
        
        }catch(Exception e){
            e.printStackTrace();
        }
        
    
    
    return listar();
    }
    
    
    public void inserir(Cliente c){
        try(Connection conn = Conexao.conectar()){
            
            String sql = "INSERT INTO cliente (nome,cidade,cep) VALUES (?)";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, c.getNome());
          
            
            stmt.execute();
                               
        
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
    
    
}
