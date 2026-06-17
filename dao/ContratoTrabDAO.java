
package dao;

import model.ContratoTrab;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContratoTrabDAO {
    
    
    public List<ContratoTrab> listar(){
        List<ContratoTrab> lista = new ArrayList<>();
        
        try{
            Connection conn = Conexao.conectar();
            
            String sql = "SELECT * FROM ContratoTrab";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                
                ContratoTrab ct = new ContratoTrab();
            
                stmt.setInt(1, rs.getInt("id"));
                stmt.setString(2, rs.getString("cargo"));
                stmt.setFloat(3,rs.getFloat("salario"));
                stmt.setString(4,rs.getString("data_inicio"));
                stmt.setString(5,rs.getString("data_fim"));
                stmt.setString(6, rs.getString("tipo_contrato"));
                stmt.setInt(7, rs.getInt("funcionario_id"));
                
                lista.add(ct);
            
            
            }
            
            rs.close();
            stmt.close();
            conn.close();
        
        
        }catch(Exception e){
            e.printStackTrace();
        
        }
    
    
    
    return lista;
    }
    
    public void inserir (ContratoTrab ct){
        
        try(Connection conn = Conexao.conectar()){
        
            String sql = "INSERT INTO ContratoTrab (cargo,salario,data_inicio,data_fim,tipo_contrato,funcionario_id) VALUES (?,?,?,?,?,?)";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, ct.getCargo());
            stmt.setFloat(2, ct.getSalario());
            stmt.setString(3, ct.getData_inicio());
            stmt.setString(4, ct.getData_fim());
            stmt.setString(5, ct.getTipo_contrato());
            stmt.setInt(6, ct.getId_funcionario());
            
            stmt.execute();
            
            
            
        
        }catch(Exception e){
            e.printStackTrace();
        }
    
    
    }//Fim do inserir
    
    public void atualizar(ContratoTrab ct){
        
        try(Connection conn = Conexao.conectar()){
            
            String sql = "UPDATE ContratoTrab SET cargo = ?, salario = ?, data_inicio = ?, data_fim= ?, tipo_contrato = ?, funcionario_id = ? WHERE id = ?";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, ct.getCargo());
            stmt.setFloat(2, ct.getSalario());
            stmt.setString(3, ct.getData_inicio());
            stmt.setString(4, ct.getData_fim());
            stmt.setString(5, ct.getTipo_contrato());
            stmt.setInt(6, ct.getId_funcionario());
            stmt.setInt(7, ct.getId());
            
            stmt.execute();
        
        
        }catch(Exception e){
            e.printStackTrace();
        }
    
    }//Fim do Atualizar
    
    public void deletar(int id){
    
        try(Connection conn = Conexao.conectar()){
            
            String sql = "DELETE FROM ContratoTrab WHERE id = ?";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setInt(1, id);
            
            stmt.execute();
        
        }catch(Exception e){
            e.printStackTrace();
        }
    
    }//Fim do deletar
    
}
