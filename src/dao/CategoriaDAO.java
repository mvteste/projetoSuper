package dao;

import connection.Conexao;
import model.Categoria;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO {

    public List<Categoria> listarTodos() {
        List<Categoria> lista = new ArrayList<>();
        String sql = "SELECT * FROM categoria"; 

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Categoria c = new Categoria();
                
                // Pegando os dados com os Nomes EXATOS das colunas da sua foto
                c.setId(rs.getInt("id")); 
                c.setNome(rs.getString("nome")); 
                c.setDescricao(rs.getString("descricao")); 
                
                lista.add(c);
            }

        } catch (Exception e) {
            System.out.println("Erro ao listar categorias: " + e.getMessage());
            e.printStackTrace();
        }
        return lista;
    }
}