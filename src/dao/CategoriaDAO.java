
package dao;

import model.Categoria;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class CategoriaDAO implements GenericDAO<Categoria> {
    
    @Override
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
    
    
    return lista;

    }//Fim do Listar
    @Override
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
    
    @Override
    public void atualizar(Categoria c){
        try(Connection conn = Conexao.conectar()){
            
            String sql = "UPDATE categoria SET nome = ? WHERE id = ?";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, c.getNome());
            stmt.setInt(2, c.getId());

            
            stmt.execute();
            
                   
        }catch(Exception e){
            e.printStackTrace();
        }
    
    
    }
    
    @Override
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

    @Override
    public Categoria buscarPorId(int id) {

    Categoria c = null;

    try(Connection conn = Conexao.conectar()) {

        String sql = "SELECT * FROM categoria WHERE id = ?";

        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setInt(1, id);

        ResultSet rs = stmt.executeQuery();

        if(rs.next()) {

            c = new Categoria();

            c.setId(rs.getInt("id"));
            c.setNome(rs.getString("nome"));
        }

        rs.close();
        stmt.close();

    } catch(Exception e) {
        e.printStackTrace();
    }

    return c;
}
    
    
    
}
