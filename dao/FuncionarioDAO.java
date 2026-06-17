
package dao;

import model.Funcionario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class FuncionarioDAO {
    
    public List<Funcionario> listar(){
        List<Funcionario>lista = new ArrayList<>();
        
        try{
            Connection conn = Conexao.conectar();
            
            String sql = "SELECT * FROM funcionario";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
            
                Funcionario f = new Funcionario();
                
                stmt.setInt(1, rs.getInt("id"));
                stmt.setString(2,rs.getString("nome"));
                stmt.setString(3,rs.getString("telefone"));
                stmt.setString(4,rs.getString("data_nascimento"));
                stmt.setInt(5,rs.getInt("tipo_funcionario_id"));
                
                lista.add(f);
                
            
            }
            
            rs.close();
            stmt.close();
            conn.close();
            
            
        
        }catch(Exception e){
            e.printStackTrace();
                   
        }
        
    
    
    return lista;
    
    }//Fim do listar
    
    public void inserir (Funcionario f){
    
        try(Connection conn = Conexao.conectar()){
        
        
            String sql = "INSERT INTO funcionario (nome,telefone,data_nascimento,tipo_funcionario_id VALUES (?,?,?,?)";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, f.getNome());
            stmt.setString(2,f.getTelefone());
            stmt.setString(3,f.getData_nascimento());
            stmt.setInt(4, f.getId_tipoFuncionario());
            
            stmt.execute();
        
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
    
    }//Fim do inserir
    
    
    public void atualizar (Funcionario f){
    
        try(Connection conn = Conexao.conectar()){
        
        String sql = "UPDATE funcionario SET nome=?, telefone= ?, data_nascimento = ?, tipo_funcionario_id=? WHERE id=?";
        
        PreparedStatement stmt = conn.prepareStatement(sql);
        
        stmt.setInt(1, f.getId());
        stmt.setString(2, f.getNome());
        stmt.setString(3, f.getData_nascimento());
        stmt.setInt(5, f.getId_tipoFuncionario());
        
        stmt.execute();
        
        
        }catch(Exception e){
            e.printStackTrace();
        
        }
    
    
    }//Fim do atualizar
    
    public void deletar(int id){
    
        try(Connection conn = Conexao.conectar()){
        
            String sql = "DELETE FROM funcionario WHERE id = ?";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setInt(1,id);
            
            stmt.execute();
        
        
        }catch(Exception e){
            e.printStackTrace();
            
        }
    
    
    }//Fim do deletar
    
}
