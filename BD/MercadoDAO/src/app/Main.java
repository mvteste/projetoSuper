/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package app;

import dao.Conexao;
import dao.FornecedorDAO;
import java.sql.Connection;
import java.util.Scanner;
import model.Fornecedor;

/**
 *
 * @author Emanuel
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
            
    Scanner sc = new Scanner(System.in);
    FornecedorDAO dao = new FornecedorDAO();
            
        int op;
            
        do{
            System.out.println("1 - Teste conexao BD | 2 - Inserir Fornecedor | 3 - Editar Fornecedor | 4 - Listar Fornecedor | 0 - Sair");
            op = sc.nextInt();
            
            if (op == 1) {

        try {
            Connection conn = Conexao.conectar();

            if (conn != null) {
                System.out.println("Conectado com sucesso!");
            }

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            
        
                }
            }
                
            if(op == 2){
                Fornecedor f = new Fornecedor();
                sc.nextLine(); // limpar buffer

                System.out.println("Nome: ");
                f.setNome(sc.nextLine());
                sc.nextLine();

                System.out.println("CNPJ: ");
                f.setCnpj(sc.nextLine());

                System.out.println("Email: ");
               f.setEmail(sc.nextLine()); 
                        
                System.out.println("Endereco: ");
                f.setEndereco(sc.nextLine());

                dao.inserir(f);
            }
           
            if(op == 3){
                Fornecedor f = new Fornecedor();
                sc.nextLine();
                
                System.out.println("ID do Cliente: ");
                f.setId(sc.nextInt());
                sc.nextLine();
                
                System.out.println("Novo nome: ");
                f.setNome(sc.nextLine());
                
                System.out.println("Novo CNPJ: ");
                f.setCnpj(sc.nextLine());
                
                System.out.println("Novo email: ");
                f.setEmail(sc.nextLine());
                
                System.out.println("Novo edereco: ");
                f.setEndereco(sc.nextLine());
                
                dao.editar(f);

            }
            
            if(op == 4){
                dao.listar().forEach(f ->
                    System.out.println(
                        f.getId() + " - " +
                        f.getNome() + " - " +
                        f.getCnpj() + " - " +
                        f.getEmail() + " - " +
                        f.getEndereco()
                            + "\n"
                    )
                );
            }

            else{
                System.out.println("Escolha uma opção");
            }

            }while (op != 0);
          }
        }
    

    

