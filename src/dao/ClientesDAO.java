/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connection.Conexao;
import model.Clientes;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// Classe DAO responsável pelo acesso aos dados da entidade Cliente
public class ClientesDAO {
   
     // Método que retorna uma lista de objetos Cliente
    public List<Clientes> listar(){
         // Lista que armazenará os objetos Cliente vindos do banco
        List<Clientes> lista = new ArrayList<>();
       
        try{
            // Obtém a conexão com o banco de dados
            Connection conn = Conexao.conectar();
           
            // Define a instrução SQL (sem parâmetros neste caso)
            String sql = "SELECT * FROM clientes";
           
            // Cria um PreparedStatement a partir da conexão e da query SQL
            PreparedStatement stmt = conn.prepareStatement(sql);
           
            // Executa a consulta e armazena o resultado em um ResultSet
            ResultSet rs = stmt.executeQuery();
           
            // Percorre cada linha retornada pelo banco de dados
            while(rs.next()){
             // Instancia um novo objeto Cliente
             Clientes c = new Clientes();
             
             // Obtém o valor da coluna "id" (inteiro) e seta no objeto
             c.setId(rs.getInt("id"));
           
             // Obtém o valor da coluna "nome" (string) e seta no objeto
             c.setNome(rs.getString("nome"));
             
             // Obtém o valor da coluna "cidade" (string) e seta no objeto
             c.setCidade(rs.getString("cidade"));
             
             // Obtém o valor da coluna "cidade" (string) e seta no objeto
             c.setCep(rs.getString("cep"));
           
            //Adiciona o objeto preenchido na lista
            lista.add(c);
            }
            // Fecha o ResultSet
             rs.close();            
            // Fecha o PreparedStatement
             stmt.close();
            // Fecha a conexão com o banco
             conn.close();
             
        }catch (Exception e){
             // Em caso de erro, imprime detalhes no console
            e.printStackTrace();
        }
        // Retorna a lista de clientes
       return lista;  
    }// fim metodo listar
    
    
    public List<Clientes> buscarPorCidade(String cidade){
        List<Clientes> lista = new ArrayList<>();
        
        try{
            //Abre conexão com o banco
            Connection conn = Conexao.conectar();
            
            //Query SQL com parametro (?)
            //o ? será substituido com segurança pelo valor informado
            String sql = "SELECT * FROM clientes WHERE = ?";
            
            //Cria o preparedStatement com a query parametrizada
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            //Define o valor do parametro na posição 1
            //(PreparedStatement usa indice baseado em 1, não 0)
            stmt.setString(1, cidade);
            
            //Executa a consulta
            ResultSet rs = stmt.executeQuery();
            
            //recorre os resultados
            while (rs.next()){
                //Cria um objeto Alunos
                Clientes a = new Clientes();
                
                //Preenche os dados com os valores retornados
                a.setId(rs.getInt("id"));
                a.setNome(rs.getString("nome"));
                a.setCidade(rs.getString("cidade"));
                
                //Adiciona à lista
                lista.add(a);
            }
            
            rs.close();
            // Fecha o PreparedStatement
            stmt.close();
            // Fecha a conexão com o banco
            conn.close();
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return lista;
    }// fim buscar por cidade
    
    public Clientes buscarPorId(int id){
        //objeto que armazenará o resultado (apenas um registro esperado)
       Clientes c = null;
       
       try{
           // Conexão com o banco
           Connection conn = Conexao.conectar ();
           
           //Query com filtro por ID
           String sql = "SELECT * FROM clientes WHERE id = ?";
           
           //Prepara a instrução
           PreparedStatement stmt = conn.prepareStatement(sql);
           
           //Define o valor do parametro (posição 1)
           stmt.setInt(1, id);
           
           //Executa a consulta
           ResultSet rs = stmt.executeQuery();
           
           //Verifica se encontrou algum registro
           if(rs.next()){
               //Instancia o objeto Alunos
               c = new Clientes();
               
               //Preenche os dados
               c.setId(rs.getInt("id"));
               c.setNome(rs.getString("nome"));
               c.setCidade("cidade");
           }
           
            //Fecha 
            rs.close();
            // Fecha o PreparedStatement
            stmt.close();
            // Fecha a conexão com o banco
            conn.close();
       }catch(Exception e){
           e.printStackTrace();
       }
       //Retorna o cliente encontrado ou null se não existir
       return c;
    }
   
    //Método public que recebe Cliente como parâmetro
    public void inserir (Clientes c){
        
        //abre conexão com banco de dados
          try (Connection conn = Conexao.conectar()){
              
              //Define a instrução SQL para execução
              String sql = "INSERT INTO clientes (nome, cidade, cep) VALUES (?,?,?)";
              
              //Prepara a instrução
              PreparedStatement stmt = conn.prepareStatement(sql);
              
              //Define o valor do parametro na posição 1
              //(PreparedStetement usa indice baseado em ', não 0)
               stmt.setString(1, c.getNome());
               stmt.setString(2, c.getCidade());
               stmt.setString(3, c.getCep());
               
               //Executa a instrução SQL no banco de dados
               
                stmt.execute();
               
          }catch(Exception e){
              e.printStackTrace();
          }
          
          
    }// fecha inserir
    
    
    public void atualizar (Clientes c){
        
    
        //abre conexão com banco de dados
          try (Connection conn = Conexao.conectar()) {

            String sql = "UPDATE clientes SET nome = ?, cidade = ?, cep = ? WHERE id = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);

            
            stmt.setString(1, c.getNome());
            stmt.setString(2, c.getCidade());
            stmt.setString(3, c.getCep());
            stmt.setInt(4, c.getId());
            

            stmt.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }
            //update
      
    }  
              //delete
    public void deletar(Clientes c){
          try (Connection conn = Conexao.conectar()) {

            String sql = "DELETE FROM clientes WHERE id = ?";

            // Prepara a instrução
            PreparedStatement stmt = conn.prepareStatement(sql);

            // Define o valor do parâmetro
            stmt.setInt(1, c.getId());

            // Executa o DELETE
            stmt.executeUpdate();

            System.out.println("Cliente removido com sucesso!");

            } catch (Exception e) {
                e.printStackTrace();
            }
    }
}

