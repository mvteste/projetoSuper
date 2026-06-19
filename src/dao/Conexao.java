package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private static final String URL = "jdbc:mysql://localhost:3306/projeto_senac_db";
    private static final String USUARIO = "root";
    private static final String SENHA = "";

    public static Connection conectar() {
        try {
            Connection conn = DriverManager.getConnection(URL, USUARIO, SENHA);
            System.out.println("Conexão realizada com sucesso!");
            return conn;

        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados.");
            e.printStackTrace();
            return null;
        }
    }

    public static void fechar(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
                System.out.println("Conexão encerrada.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}