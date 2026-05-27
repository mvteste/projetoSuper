/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

import dao.ClientesDAO;
import model.Clientes;

import java.util.Scanner;

public class Main {
   public static void main(String[] args) {
       
       Scanner sc = new Scanner(System.in);
       ClientesDAO dao = new ClientesDAO();
       int op;
       
       do{
           System.out.println("1-Listar | 2-Inserir | 3-Editar | 4-Deletar | 0-Sair");
           op = sc.nextInt();
           
           if(op == 1){
               dao.listar().forEach(c->System.out.println(c.getId() + " " + c.getNome() + " " + c.getCidade() + " " + c.getCep()));
           }
           if(op == 2){
               Clientes c = new Clientes(); //Cria um novo objeto CLiente
               sc.nextLine(); //Limpa o buffer do Scanner (consome a quebra de linha pendente)
               
               System.out.println("Nome: "); //Solicita ao usuario que informe o nome
               c.setNome(sc.nextLine()); // Lê o nome digitado e define no objeto Cliente
               
               System.out.println("Cidade: "); 
               c.setCidade(sc.nextLine());
               
                System.out.println("Cep: "); 
               c.setCep(sc.nextLine()); 
               
               //Chama o metodos inserir do DAO para salvar o cliente no banco de dados
               dao.inserir(c);
           }
           
           if(op == 3){
               Clientes c = new Clientes(); //Cria um novo objeto CLiente
               sc.nextLine(); //Limpa o buffer do Scanner (consome a quebra de linha pendente)
               
               System.out.println("Id: ");
               c.setId(sc.nextInt());
               
               sc.nextLine();
               
               System.out.println("Nome: "); //Solicita ao usuario que informe o nome
               c.setNome(sc.nextLine()); // Lê o nome digitado e define no objeto Cliente
               
               System.out.println("Cidade: "); 
               c.setCidade(sc.nextLine());
               
                System.out.println("Cep: "); 
               c.setCep(sc.nextLine()); 
               
               //Chama o metodos inserir do DAO para salvar o cliente no banco de dados
               dao.atualizar(c);
           }
           
           if(op == 4){
               Clientes c = new Clientes(); //Cria um novo objeto CLiente
               sc.nextLine(); //Limpa o buffer do Scanner (consome a quebra de linha pendente)
               
               System.out.println("Id: ");
               c.setId(sc.nextInt());
               
               sc.nextLine();
               
               System.out.println("Nome: "); //Solicita ao usuario que informe o nome
               c.setNome(sc.nextLine()); // Lê o nome digitado e define no objeto Cliente
               
               System.out.println("Cidade: "); 
               c.setCidade(sc.nextLine());
               
                System.out.println("Cep: "); 
               c.setCep(sc.nextLine()); 
               
               //Chama o metodos inserir do DAO para salvar o cliente no banco de dados
               dao.deletar(c);
           }
           
            if(op == 9){
            //ClientesDAO dao = new ClientesDAO();

            for (Clientes c : dao.listar()) {
                System.out.println(c.getNome());
            }

             System.out.println("\n=== CLIENTES do RJ ===");

            for(Clientes c : dao.buscarPorCidade("Rio de Janeiro")){
                System.out.println(c.getCidade());
            }

             System.out.println("\n=== BUSCAR POR ID (ex: 3) ===");
            Clientes clientes = dao.buscarPorId(3);

             if(clientes != null){
                 System.out.println("Encontrado: "+ clientes.getNome());
             }else{
                 System.out.println("Cliente não encontrado.");
             }
            }//fecha if op == 9
        }while (op!=0);
       
       
   }//fecha main
}