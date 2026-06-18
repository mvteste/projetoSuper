package dao;

import connection.Conexao;
import model.Cliente;
import java.sql.*;
import java.util.List;

public class ClienteDAO implements GenericDAO<Cliente>{

    public void inserir(Cliente c){
        try(Connection conn = Conexao.conectar()){

        // O SQL deve conter todas as colunas que correspondem ao seu modelo Cliente
        String sql = """
            INSERT INTO cliente
            (nome, data_nascimento, cpf, telefone, endereco)
            VALUES (?, ?, ?, ?, ?)
            """;

        PreparedStatement stmt = conn.prepareStatement(sql);

        // Abaixo, configuramos EXATAMENTE 5 valores:
        stmt.setString(1, c.getNome());
        
        if (c.getData_Nascimento() != null) {
            java.sql.Date dataSql = new java.sql.Date(c.getData_Nascimento().getTime());
            stmt.setDate(2, dataSql);
        } else {
            stmt.setNull(2, java.sql.Types.DATE);
        }

        stmt.setString(3, c.getCpf());
        stmt.setString(4, c.getTelefone());
        stmt.setString(5, c.getEndereco());

        stmt.executeUpdate();

        } catch (java.sql.SQLIntegrityConstraintViolationException e) {
            javax.swing.JOptionPane.showMessageDialog(null, "Erro: Este CPF já está cadastrado no sistema!");
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    
    // Método 1: Lista todos os clientes do banco
    public java.util.List<Cliente> listarTodos() {
        java.util.List<Cliente> lista = new java.util.ArrayList<>();
        String sql = "SELECT * FROM cliente"; 

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Cliente c = new Cliente();
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setCpf(rs.getString("cpf"));
                c.setTelefone(rs.getString("telefone"));
                c.setEndereco(rs.getString("endereco"));
                c.setData_Nascimento(rs.getDate("data_nascimento")); 
                
                lista.add(c);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    // Método 2: Busca clientes por uma parte do nome (Pesquisa)
    public java.util.List<Cliente> buscarPorNome(String nomePesquisa) {
        java.util.List<Cliente> lista = new java.util.ArrayList<>();
        // O comando LIKE do SQL serve para buscar partes de um texto
        String sql = "SELECT * FROM cliente WHERE nome LIKE ?"; 

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
             
            // Os símbolos "%" dizem para o banco buscar o nome em qualquer parte do texto
            stmt.setString(1, "%" + nomePesquisa + "%");
            
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Cliente c = new Cliente();
                    c.setId(rs.getInt("id"));
                    c.setNome(rs.getString("nome"));
                    c.setCpf(rs.getString("cpf"));
                    c.setTelefone(rs.getString("telefone"));
                    c.setEndereco(rs.getString("endereco"));
                    c.setData_Nascimento(rs.getDate("data_nascimento")); 
                    
                    lista.add(c);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
    
    public void excluir(int id) {
        String sql = "DELETE FROM cliente WHERE id = ?";

        try (java.sql.Connection conn = connection.Conexao.conectar();
             java.sql.PreparedStatement stmt = conn.prepareStatement(sql)) {
             
            // Troca a interrogação pelo ID que veio lá da tela
            stmt.setInt(1, id);
            
            // Executa a exclusão no banco
            stmt.executeUpdate();
            System.out.println("Cliente excluído do banco com sucesso!");

        } catch (Exception e) {
            System.out.println("Erro ao excluir cliente: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void salvar(Cliente entidade){
        inserir(entidade);
    }

    @Override
    public void atualizar(Cliente entidade){
        System.out.println("Cliente atualizado: " + entidade.getNome());
    }

    

    @Override
    public Cliente buscarPorId(int id){
        System.out.println("Buscando cliente ID: " + id);
        return null;
    }


}