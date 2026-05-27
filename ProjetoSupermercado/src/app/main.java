package app;

import dao.Conexao;
import java.sql.Connection;

public class main {

  
    public static void main(String[] args) {
            try {
                Connection conn = Conexao.conectar();
                
                if(conn != null){
                    System.out.println("Conectado com sucesso");
                }
            } catch (Exception e) {
                System.out.println("Erro" + e.getMessage());
            }
    }
    
}
