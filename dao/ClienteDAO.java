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
        String sql = "INSERT INTO cliente (nome, cpf, email, telefone, endereco) VALUES (?, ?, ?, ?, ?)";
          try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, cliente.getNome());
                stmt.setString(2, cliente.getCpf());
                stmt.setString(3, cliente.getEmail());
                stmt.setString(4, cliente.getTelefone());
                stmt.setString(5, cliente.getEndereco());               
            
                stmt.executeUpdate();
          } catch (SQLException e) {
            System.err.println("Erro ao salvar Cliente: " + e.getMessage());
        }
    }
    
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
        String sql = "SELECT p.*, c.nome as cat_nome FROM produto p " +
                     "INNER JOIN categoria c ON c.id = p.categoria_id";
        List<Cliente> lista = new ArrayList();
        
         try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
             
                 while (rs.next()) {
                Cliente c = new Cliente();
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setNome(rs.getString("cpf"));
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
