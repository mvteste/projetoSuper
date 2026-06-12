package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Funcionarios;
import model.Cargo_Funcionario; // Importante importar a model do Cargo
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Emanuel
 */
public class FuncionariosDAO {
    
    public List<Funcionarios> listar() {
        
        List<Funcionarios> lista = new ArrayList<>();
        
        // Boa prática: Usar try-with-resources também no listar para fechar a conexão automaticamente
        try (Connection conn = Conexao.conectar()) {
            
            // Fazemos um INNER JOIN para buscar os dados do Funcionário E o nome/dados do Cargo dele de uma vez só
            String sql = "SELECT f.*, c.nome AS nome_cargo FROM funcionarios f " +
                         "INNER JOIN cargo_funcionarios c ON f.cargo_funcionarios_id = c.id";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()) {
                // 1. Primeiro, instanciamos e montamos o objeto Cargo correspondente
                Cargo_Funcionario cargo = new Cargo_Funcionario();
                cargo.setId(rs.getInt("cargo_funcionarios_id"));
                cargo.setNome(rs.getString("nome_cargo")); 
                // Se sua classe Cargo_Funcionario tiver outros campos (ex: salario, descricao), popule-os aqui se necessário.

                // 2. Criamos o funcionário usando o construtor completo que você definiu na Model
                Funcionarios f = new Funcionarios(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("cpf"),
                    rs.getString("telefone"),
                    rs.getString("email"),
                    rs.getString("endereco"),
                    rs.getString("data_admissao"),
                    rs.getString("data_nascimento"),
                    rs.getInt("status"),
                    cargo // Passando o objeto cargo preenchido aqui
                );
                
                lista.add(f);
            }
            
            rs.close();
            stmt.close();
            
        } catch(Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
    
    public void inserir(Funcionarios f) {
        
        try(Connection conn = Conexao.conectar()) {
            
            // Incluída a coluna cargo_funcionarios_id no INSERT
            String sql = "INSERT INTO funcionarios (nome, cpf, telefone, email, endereco, data_admissao, data_nascimento, status, cargo_funcionarios_id) VALUES (?, ?, ?, ?, ?, ?, ?, 1, ?)";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, f.getNome());
            stmt.setString(2, f.getCpf());
            stmt.setString(3, f.getTelefone());
            stmt.setString(4, f.getEmail());
            stmt.setString(5, f.getEndereco());
            stmt.setString(6, f.getData_admissao());
            stmt.setString(7, f.getData_nascimento());
            // Pegamos o ID de dentro do objeto Cargo que está associado ao Funcionário
            stmt.setInt(8, f.getCargo_funcionario().getId());
            
            stmt.execute();
            stmt.close();
            
            System.out.println("Funcionário salvo com sucesso!");
            
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public void editar(Funcionarios f) {
        
        try(Connection conn = Conexao.conectar()) {
              
            // Incluída a atualização do cargo_funcionarios_id no UPDATE
            String sql = "UPDATE funcionarios SET nome = ?, cpf = ?, telefone = ?, email = ?, endereco = ?, data_admissao = ?, data_nascimento = ?, cargo_funcionarios_id = ? WHERE id = ?";
              
            PreparedStatement stmt = conn.prepareStatement(sql);
              
            stmt.setString(1, f.getNome());
            stmt.setString(2, f.getCpf());
            stmt.setString(3, f.getTelefone());
            stmt.setString(4, f.getEmail());
            stmt.setString(5, f.getEndereco());
            stmt.setString(6, f.getData_admissao());
            stmt.setString(7, f.getData_nascimento());
            stmt.setInt(8, f.getCargo_funcionario().getId()); // Atualiza o cargo dele caso mude
            stmt.setInt(9, f.getId());
              
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