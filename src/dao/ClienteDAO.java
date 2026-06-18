package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
//import java.util.List;
import model.Cliente;
//import util.Conexao;
import java.util.List;

public class ClienteDAO implements GenericDAO<Cliente>{
    
      @Override
    public void salvar(Cliente cliente){
        System.out.println("DEBUG DAO: Valor enviado ao banco: " + cliente.getDataNascimento());

        
        String sql = "INSERT INTO cliente (nome, cpf, email, telefone, endereco, datanasc  ) VALUES (?, ?, ?, ?, ?, ?)";
        
        
          try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, cliente.getNome());
                stmt.setString(2, cliente.getCpf());
                stmt.setString(3, cliente.getEmail());
                stmt.setString(4, cliente.getTelefone());                
                stmt.setString(5, cliente.getEndereco());
                if (cliente.getDataNascimento() != null) {
                stmt.setDate(6, new java.sql.Date(cliente.getDataNascimento().getTime()));
            } else {
                stmt.setNull(6, java.sql.Types.DATE);
            }        
            
                stmt.executeUpdate();
          } catch (SQLException e) {
            System.err.println("Erro ao salvar Cliente: " + e.getMessage());
        }
    }// fecha método salvar
    
    @Override
    public void atualizar(Cliente entidade){
    
    }
            
    @Override        
    public void excluir (int id){
    }
   
    @Override
    public Cliente buscarPorId(int id){
        System.out.println("Buscando Cliente ID: " + id);
        return null;
    
    }
    
    
    
    @Override
    public List<Cliente> listarTodos(){
         // Exemplo com INNER JOIN para trazer os dados da categoria junto
        String sql = "SELECT id, nome, cpf, email, telefone, endereco FROM cliente";
        List<Cliente> lista = new ArrayList();
        
         try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
             
                 while (rs.next()) {
                Cliente c = new Cliente();
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setCpf(rs.getString("cpf"));
                c.setEmail(rs.getString("email"));
                c.setTelefone(rs.getString("telefone"));
                c.setEndereco(rs.getString("endereco"));
                     
                lista.add(c);
            } 
        } catch (SQLException e) {
            System.err.println("Erro ao listar produtos: " + e.getMessage());
        }
        return lista;
    }
}
