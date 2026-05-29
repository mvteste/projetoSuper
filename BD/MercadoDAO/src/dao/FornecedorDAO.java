/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import model.Fornecedor;



/**
 *
 * @author Emanuel
 */
public class FornecedorDAO {
    
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
              
              String sql = "UPDATE fornecedor SET nome = ?, cnpj = ?, email = ?, endereco = ?";
              
              PreparedStatement stmt = conn.prepareStatement(sql);
              
              stmt.setString(1, f.getNome());
              stmt.setString(2, f.getCnpj());
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
