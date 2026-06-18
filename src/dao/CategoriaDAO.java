package dao;

import model.Categoria;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class CategoriaDAO implements GenericDAO<Categoria>{
    
    @Override
    public void salvar(Categoria categoria){
        String sql = "INSERT INTO categoria (nome) VALUES (?)";
        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)){
                stmt.setString(1, categoria.getNome());
                
                stmt.executeUpdate();
                System.out.println("Acessou Salvar");
        }catch (SQLException e) {
            System.err.println("Erro ao salvar Cliente: " + e.getMessage());
        }     
    }
    
    @Override
    public void atualizar(Categoria entidade){
    
    }
            
    @Override        
    public void excluir (int id){
    }
   
    @Override
    public Categoria buscarPorId(int id){
        System.out.println("Buscando CategroriaDliente ID: " + id);
        return null;
    
    }
    
    @Override
    public List<Categoria> listarTodos(){
        String sql = "SELECT id, nome FROM categoria ORDER BY nome";        
        List<Categoria> lista = new ArrayList<>();
           // O try-with-resources garante que os recursos sejam fechados automaticamente
    try (Connection conn = Conexao.conectar();
         PreparedStatement stmt = conn.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {

        while (rs.next()) {
            Categoria cat = new Categoria();
            cat.setId(rs.getInt("id"));
            cat.setNome(rs.getString("nome"));
            
            lista.add(cat);
        }

    } catch (SQLException e) {
        // Log de erro técnico para o desenvolvedor
        System.err.println("Erro ao listar categorias: " + e.getMessage());
        // Opcional: relançar uma exceção personalizada ou retornar lista vazia
    }

    return lista;
}
        
        
        // SQL: SELECT * FROM categoria
        // Exemplo de preenchimento manual para teste:
       /* lista.add(new Categoria(1, "Eletrônicos"));
        lista.add(new Categoria(2, "Eletrodomésticos"));
        return lista;*/
  
             
}
