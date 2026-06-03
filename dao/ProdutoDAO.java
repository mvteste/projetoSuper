/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import model.Produto;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {
    
    public List<Produto>listar(){
        List<Produto> lista = new ArrayList();
        
        try{
            Connection conn = Conexao.conectar();
            
            String sql = "SELECT * FROM produto";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                
                Produto p = new Produto();
                
                stmt.setInt(1, rs.getInt("id"));
                stmt.setString(2,rs.getString("nome"));
                stmt.setFloat(3,rs.getFloat("preco"));
                stmt.setInt(4,rs.getInt("id_categoria"));
                stmt.setInt(5,rs.getInt("id_fornecedor"));
                stmt.setString(6,rs.getString("marca"));
                stmt.setInt(7,rs.getInt("codigo_barras"));
                stmt.setString(8,rs.getString("descricao"));
                
                lista.add(p);
                
                                         
            }
            
            rs.close();
            stmt.close();
            conn.close();
        
        
        
        }catch(Exception e){
            e.printStackTrace();
        
        }
        
    
    
        return null;
        
    
    
    }//Fim do listar
    
    public void inserir (Produto p){
    
        try(Connection conn = Conexao.conectar()){
        
            String sql = "INSERT INTO produto (nome,preco,id_categoria,id_fornecedor,marca,codigo_barras,descricao)";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, p.getNome());
            stmt.setFloat(2,p.getPreco());
            stmt.setInt(3,p.getId_categoria());
            stmt.setInt(4,p.getId_fornecedor());
            stmt.setString(5,p.getMarca());
            stmt.setInt(6, p.getCodigo_barras());
            stmt.setString(7, p.getDescricao());
            
            stmt.execute();
            
        
        }catch(Exception e){
            e.printStackTrace();
        }
    
    }//Fim do inserir
    
    
    public void atualizar(Produto p){
    
        try(Connection conn = Conexao.conectar()){
            
            String sql = "UPDATE produto SET nome=?, preco=?,id_categoria= ?, id_fornecedor= ?, marca= ?, codigo_barras =?, descricao = ? WHERE id = ?";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setInt(1,p.getId());
            stmt.setString(2, p.getNome());
            stmt.setFloat(3,p.getPreco());
            stmt.setInt(4,p.getId_categoria());
            stmt.setInt(5, p.getId_fornecedor());
            stmt.setString(6, p.getMarca());
            stmt.setInt(7,p.getCodigo_barras());
            stmt.setString(8, p.getDescricao());
            
            stmt.execute();
        
        
        
        
        }catch(Exception e){
            e.printStackTrace();
        
        }
    
        
    
    }//Fim do atualizar
    
    public void deletar(int id){
    
        try(Connection conn = Conexao.conectar()){
        
            String sql = "DELETE FROM produto WHERE id = ?";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setInt(1,id);
        
            stmt.execute();
        
        }catch(Exception e){
            e.printStackTrace();
        
        
        }
    
    
    
    }
    
}
