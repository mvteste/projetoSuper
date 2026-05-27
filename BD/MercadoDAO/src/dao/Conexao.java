/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*1
 *
 * @author 
 */
public class Conexao {
    //URL de conexão com o banco
    //jdbc:mysql  -> protocoo JDBC para MySQL
    //localhost -> servidor do banco
    
//escola -> nome do banco
    private static final String URL = "jdbc:mysql://localhost:3306/sistema";
    
 //usuario do banco
    private static final String USER = "root";
 
    //senha do banco
    private static final String PASSWORD = "f3n1x.f3n1x";
    
    //metodo responsavel por criar a conexão
    public static Connection conectar(){
            try{
                //Cria a conexão com o banco de dados
                Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                
                //mensagem informando que conectou
                System.out.println("Conexão realizada com sucesso!");
                         return conn;
            }catch (SQLException e){
                //Caso ocorra erro de conexão
                System.out.println("Erro ao conectar ao banco");
                e.printStackTrace();
                
            }
        return null;
    }
    
}
