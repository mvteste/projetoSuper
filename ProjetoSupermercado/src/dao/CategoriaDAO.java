package dao;

import model.Categoria;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class CategoriaDAO {
    
    public List<Categoria> listar(){
        List<Categoria> lista = new ArrayList<>();
        
       try{
       Connection conn = Conexao.conectar();
       
       String sql = "SELECT * FROM categoria";
       
       PreparedStatement stmt = conn.prepareStatement(sql);
       
       ResultSet rs = stmt.executeQuery();
       
       while(rs.next()){
           Categoria c = new Categoria();
           
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

    }//Fim do Listar
    
    public void inserir(Categoria c){
        
        try(Connection conn = Conexao.conectar()){
            
            String sql = "INSERT INTO categoria(nome) VALUES (?)";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, c.getNome());
            
            stmt.execute();
        
        
        
        }catch(Exception e){
            e.printStackTrace();
                  
        }
    }//Fim do Inserir
    
    public void atualizar(Categoria c){
        try(Connection conn = Conexao.conectar()){
            
            String sql = "UPDATE categoria SET nome = ?, WHERE id = ?";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, c.getNome());
            
            stmt.execute();
            
                   
        }catch(Exception e){
            e.printStackTrace();
        }
    
    
    }
    
    public void deletar(int id){
        
        try(Connection conn = Conexao.conectar()){
            
            String sql = "DELETE FROM categoria WHERE id= ? ";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setInt(1, id);
            stmt.execute();
            
            
        }catch(Exception e){
            e.printStackTrace();
        
        }
    }   
}