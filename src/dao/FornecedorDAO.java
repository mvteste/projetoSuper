package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Fornecedor;

public class FornecedorDAO implements GenericDAO<Fornecedor> {
    
    @Override
    public void salvar(Fornecedor entidade) {
        String sql = "INSERT INTO fornecedor (nome, cnpj, email, endereco) VALUES (?, ?, ?, ?)";
        
        try (Connection conn = connection.Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
             
            stmt.setString(1, entidade.getNome());
            stmt.setString(2, entidade.getCnpj());
            stmt.setString(3, entidade.getEmail());
            stmt.setString(4, entidade.getEndereco());
            
            stmt.executeUpdate();
            System.out.println("Fornecedor salvo com sucesso no banco!");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Override 
    public void atualizar(Fornecedor entidade) {
        String sql = "UPDATE fornecedor SET nome=?, cnpj=?, email=?, endereco=? WHERE id=?";
        
        try (Connection conn = connection.Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
             
            stmt.setString(1, entidade.getNome());
            stmt.setString(2, entidade.getCnpj());
            stmt.setString(3, entidade.getEmail());
            stmt.setString(4, entidade.getEndereco());
            stmt.setInt(5, entidade.getId());
            
            stmt.executeUpdate();
            System.out.println("Fornecedor atualizado com sucesso!");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void excluir(int id) {
        String sql = "DELETE FROM fornecedor WHERE id=?";
        
        try (Connection conn = connection.Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
             
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Fornecedor excluído com sucesso!");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Override 
    public Fornecedor buscarPorId(int id) {
        Fornecedor f = null;
        String sql = "SELECT * FROM fornecedor WHERE id=?";
        
        try (Connection conn = connection.Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
             
            stmt.setInt(1, id);
            
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    f = new Fornecedor();
                    f.setId(rs.getInt("id"));
                    f.setNome(rs.getString("nome"));
                    f.setCnpj(rs.getString("cnpj"));
                    f.setEmail(rs.getString("email"));
                    f.setEndereco(rs.getString("endereco"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }
    
    @Override 
    public List<Fornecedor> listarTodos() {
        // Inicializa a lista para evitar aquele erro de NullPointerException!
        List<Fornecedor> lista = new ArrayList<>();
        String sql = "SELECT * FROM fornecedor";
        
        try (Connection conn = connection.Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
             
            while (rs.next()) {
                Fornecedor f = new Fornecedor();
                f.setId(rs.getInt("id"));
                f.setNome(rs.getString("nome"));
                f.setCnpj(rs.getString("cnpj"));
                f.setEmail(rs.getString("email"));
                f.setEndereco(rs.getString("endereco"));
                
                lista.add(f);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    // --- NOVO MÉTODO PARA O BOTÃO DE PESQUISA DA TELA ---
    public List<Fornecedor> buscarPorNome(String nomeBusca) {
        List<Fornecedor> lista = new ArrayList<>();
        // O comando LIKE do SQL serve para buscar palavras parecidas
        // O % significa que pode ter qualquer texto antes ou depois da palavra buscada
        String sql = "SELECT * FROM fornecedor WHERE nome LIKE ?";
        
        try (Connection conn = connection.Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
             
            // Monta o parâmetro com os sinais de porcentagem
            stmt.setString(1, "%" + nomeBusca + "%");
            
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Fornecedor f = new Fornecedor();
                    f.setId(rs.getInt("id"));
                    f.setNome(rs.getString("nome"));
                    f.setCnpj(rs.getString("cnpj"));
                    f.setEmail(rs.getString("email"));
                    f.setEndereco(rs.getString("endereco"));
                    
                    lista.add(f);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
}