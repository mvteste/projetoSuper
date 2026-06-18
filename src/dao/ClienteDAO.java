
package dao;

import model.Cliente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;


public class ClienteDAO implements GenericDAO <Cliente>{
    
    
        
    @Override
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
                c.setCpf(rs.getString("cpf"));
                c.setEmail(rs.getString("email"));
                c.setTelefone(rs.getString("telefone"));
                
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
    
        @Override
    public void inserir(Cliente c){
        try(Connection conn = Conexao.conectar()){
            
            String sql = "INSERT INTO cliente (nome,cidade,cep, cpf, email, telefone) VALUES (?,?,?, ?,?,?)";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, c.getNome());
            stmt.setString(2, c.getCidade());
            stmt.setString(3, c.getCep());
            stmt.setString(4, c.getCpf());
            stmt.setString(5, c.getEmail());
            stmt.setString(6, c.getTelefone());
            
            
            stmt.execute();
                               
        
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }//Fim do Inserir
    
    
        @Override
    public void atualizar(Cliente c){
    
    try(Connection conn = Conexao.conectar()){
          
        String sql = "UPDATE cliente SET nome=?, cidade=?, cep=?, cpf=?, telefone=?, email=? WHERE id = ?";
        
        PreparedStatement stmt = conn.prepareStatement(sql);
        
        stmt.setString(1, c.getNome());
        stmt.setString(2,c.getCidade());
        stmt.setString(3, c.getCep());
        stmt.setString(4,c.getCpf());
        stmt.setString(5, c.getEmail());
        stmt.setString(6,c.getTelefone());
        stmt.setInt(7, c.getId());
        
        stmt.execute();
    
    
    
    }catch(Exception e){
        e.printStackTrace();
    
    }
    
    
    }
    
        @Override
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
    
    @Override
    public Cliente buscarPorId(int id){
        System.out.println("Buscando cliente por id: " + id);
        return null;
    
    }

    

    
   
    
    
    
}
