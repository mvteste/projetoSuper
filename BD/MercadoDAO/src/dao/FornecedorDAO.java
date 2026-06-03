/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Fornecedor;
import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author Emanuel
 */
public class FornecedorDAO {
    
    public List<Fornecedor> listar () {
        
        List<Fornecedor> lista = new ArrayList<>();
        
        try{
            Connection conn = Conexao.conectar();
                
            
            String sql = "SELECT * FROM fornecedor";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()) {
                Fornecedor f = new Fornecedor();
                
                f.setId(rs.getInt("id"));
                f.setNome(rs.getString("nome"));
                f.setCnpj(rs.getString("cnpj"));
                f.setEmail(rs.getString("email"));
                f.setEndereco(rs.getString("endereco"));
                
                lista.add(f);
                }
            rs.close();
            
            stmt.close();
            
            conn.close();   
            
        }catch(Exception e) {
            e.printStackTrace();
        }
        return lista;
        }
    
    public void inserir(Fornecedor f) {
        
        try(Connection conn = Conexao.conectar()) {
                
            String sql = "INSERT INTO   fornecedor (nome, cnpj, email, endereco) VALUES (?, ?, ?, ?)";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, f.getNome());
            stmt.setString(2, f.getCnpj());
            stmt.setString(3,f.getEmail());
            stmt.setString(4,f.getEndereco());
            
            stmt.execute();
            
            System.out.println("Fornecedor salvo com sucesso!");
            
            }catch(Exception e) {
                e.printStackTrace();
                }
        }
    
    public void editar(Fornecedor f){
        
          try(Connection conn = Conexao.conectar()) {
              
              String sql = "UPDATE fornecedor SET nome = ?, email = ?, endereco = ?";
              
              PreparedStatement stmt = conn.prepareStatement(sql);
              
              stmt.setString(1, f.getNome());
              stmt.setString(3, f.getEmail());
              stmt.setString(4, f.getEndereco());
              
              stmt.executeUpdate();
              
              stmt.close();
              
              System.out.println("Fornecedor atualizado com sucesso!");
              
            }catch(Exception e){
                 e.printStackTrace();
                 }
        }

}
