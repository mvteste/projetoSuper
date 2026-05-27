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
                
                
            
            
            }
        
        
        
        }catch(Exception e){
            e.printStackTrace();
        
        }
        
    
    
        return null;
        
    
    
    }
    
}
