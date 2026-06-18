
package dao;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    
    //URL de conexão com o banco
     //jdbc: mysql-> protocolo JDBC para MySQL
     // localhost -> servidor do banco 
     private static final String URL= "jdbc:mysql://localhost:3306/supermercado";
     
     private static final String USER ="root";
     
     private static final String PASSWORD= "123456";
     
     
     public static Connection conectar(){
         try{
             
             Connection conn = DriverManager.getConnection(URL, USER , PASSWORD);
             
             System.out.println("Conexão estabelecida com sucesso");
             return conn;
             
         
         
         
         }catch(Exception e){
             System.out.println("Erro ao conectar no banco!");
            e.printStackTrace();
         }
         
         return null;
     
     
     }
    
}
