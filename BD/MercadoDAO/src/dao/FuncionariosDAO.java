package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Funcionarios; // Certifique-se de que sua classe Model está no singular ou plural exato
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Emanuel
 */
public class FuncionariosDAO {
    
    public List<Funcionarios> listar() {
        
        List<Funcionarios> lista = new ArrayList<>();
        
        try {
            Connection conn = Conexao.conectar();
            
            String sql = "SELECT * FROM funcionarios";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()) {
                Funcionarios f = new Funcionarios();
                
                f.setId(rs.getInt("id"));
                f.setNome(rs.getString("nome"));
                f.setCpf(rs.getString("cpf"));
                f.setTelefone(rs.getString("telefone"));
                f.setEmail(rs.getString("email"));
                f.setEndereco(rs.getString("endereco"));
                f.setData_admissao(rs.getString("data_admissao")); // Use os getters/setters da sua classe
                f.setData_nascimento(rs.getString("data_nascimento"));
                f.setStatus(rs.getInt("status"));
                
                lista.add(f);
            }
            rs.close();
            stmt.close();
            conn.close();   
            
        } catch(Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
    
    public void inserir(Funcionarios f) {
        
        try(Connection conn = Conexao.conectar()) {
                
            String sql = "INSERT INTO funcionarios (nome, cpf, telefone, email, endereco, data_admissao, data_nascimento, status) VALUES (?, ?, ?, ?, ?, ?, ?, 1)";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, f.getNome());
            stmt.setString(2, f.getCpf());
            stmt.setString(3, f.getTelefone());
            stmt.setString(4, f.getEmail());
            stmt.setString(5, f.getEndereco());
            stmt.setString(6, f.getData_admissao());
            stmt.setString(7, f.getData_nascimento());
            
            stmt.execute();
            stmt.close();
            
            System.out.println("Funcionário salvo com sucesso!");
            
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public void editar(Funcionarios f) {
        
        try(Connection conn = Conexao.conectar()) {
              
            // Adicionado o WHERE id = ? para atualizar apenas o funcionário correto
            String sql = "UPDATE funcionarios SET nome = ?, cpf = ?, telefone = ?, email = ?, endereco = ?, data_admissao = ?, data_nascimento = ? WHERE id = ?";
              
            PreparedStatement stmt = conn.prepareStatement(sql);
              
            stmt.setString(1, f.getNome());
            stmt.setString(2, f.getCpf());
            stmt.setString(3, f.getTelefone());
            stmt.setString(4, f.getEmail());
            stmt.setString(5, f.getEndereco());
            stmt.setString(6, f.getData_admissao());
            stmt.setString(7, f.getData_nascimento());
            stmt.setInt(8, f.getId());
              
            stmt.executeUpdate();
            stmt.close();
              
            System.out.println("Funcionário atualizado com sucesso!");
              
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public void desativar(Funcionarios f) {
        
        try(Connection conn = Conexao.conectar()) {
         
            String sql = "UPDATE funcionarios SET status = 0 WHERE id = ?";
             
            PreparedStatement stmt = conn.prepareStatement(sql);
              
            stmt.setInt(1, f.getId());
              
            stmt.executeUpdate();
            stmt.close();
              
            System.out.println("Funcionário desativado com sucesso!");
            
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}