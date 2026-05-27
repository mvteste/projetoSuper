package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    
    // URL de conexão com o banco
    //jdbc:mysql-> protocolo JDBC para MySQL
    //localhost -> servidor do banco
    //escola -> nome do banco
    private static final String URL = "jdbc:mysql://localhost:3306/sistema";
    
    //usuário do banco
    private static final String USER = "root";
    
    //senha do banco
    private static final String PASSWORD ="123456";
    
    //método responsável por criar a conexão
    public static Connection conectar(){
        try{
        // criar a conexão com o banco de dados
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        
        //Mensagem informado que conectou
        System.out.println("Conexão Realizada com Sucesso!!");
        return conn;
        }catch (SQLException e){
         //caso ocorra erro de conexão
            System.out.println("Erro ao conectar ao banco ");
            e.printStackTrace();
            
            return null;
        }
    }
    
}
