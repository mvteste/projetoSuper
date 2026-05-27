/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package app;

import dao.Conexao;
import java.sql.Connection;

/**
 *
 * @author Emanuel
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Connection conn = Conexao.conectar();

            if (conn != null) {
                System.out.println("Conectado com sucesso!");
            }

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
    
}
