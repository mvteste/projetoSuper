package dao;

import connection.Conexao;
import model.Produto;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO implements GenericDAO<Produto> {
    
    @Override
    public void salvar(Produto entidade) {
        // Atenção: Confirme se o nome da coluna da chave estrangeira no seu banco 
        // de dados é "categoria_id" ou "id_categoria" e ajuste no SQL abaixo se necessário.
        String sql = """
            INSERT INTO produto
            (descricao, categoria_id) 
            VALUES (?, ?)
            """;
            
        try (Connection conn = Conexao.conectar()) {
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, entidade.getDescricao());
            
            // Aqui pegamos o ID de dentro do objeto Categoria
            if (entidade.getCategoria() != null) {
                stmt.setInt(2, entidade.getCategoria().getId());
            } else {
                // Caso a categoria não tenha sido selecionada por algum motivo
                stmt.setNull(2, java.sql.Types.INTEGER);
            }
            
            stmt.executeUpdate();
            System.out.println("Produto salvo com sucesso no banco de dados!");
            
        } catch (Exception e) {
            System.out.println("Erro ao salvar produto: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    @Override 
    public void atualizar(Produto entidade){
        System.out.println("Produto atualizado: " + entidade.getDescricao());
    }
    
    @Override
    public void excluir(int id){
        System.out.println("Produto excluído " + id);
    }
    
    @Override 
    public Produto buscarPorId(int id){
        System.out.println("Buscando Produto ID: " + id);
        return null;
    }
    
    @Override 
    public List<Produto> listarTodos(){
        System.out.println("Listando Produtos:");
        return null;
    }
}