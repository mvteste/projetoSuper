
package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Venda;

public class VendaDAO {
    public List<Venda> listar(){
        List<Venda> lista = new ArrayList<>();
        
        try{
            
          Connection conn = Conexao.conectar();
          
          String sql = "SELECT * FROM venda";
          
          PreparedStatement stmt = conn.prepareStatement(sql);
          
          ResultSet rs = stmt.executeQuery();
          
          while(rs.next()){
              
         Venda v = new Venda();   
              
         stmt.setInt(1, rs.getInt("id"));
         stmt.setString(2,rs.getString("data_venda"));
         stmt.setFloat(3,rs.getFloat("valor_total"));
         stmt.setInt(4,rs.getInt("id_funcionario"));
         stmt.setString(5,rs.getString("status"));
         
         lista.add(v);
              
          
          }
            
        }catch(Exception e){
            e.printStackTrace();
        
        }
    
        
        
        
    return lista;
    }
    
    
    
    
}
