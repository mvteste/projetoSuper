package dao;

import connection.Conexao;
import model.Produto;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Categoria;

public class ProdutoDAO implements GenericDAO<Produto> {
    
    public void salvar(model.Produto entidade) {
        // Trocamos as aspas triplas (""") pelo formato tradicional com o sinal de +
        // para funcionar em qualquer versão do Java!
        String sql = "INSERT INTO produto " +
                     "(nome, descricao, data_vencimento, categoria_id, preco) " +
                     "VALUES (?, ?, ?, ?, ?)";
            
        try (java.sql.Connection conn = connection.Conexao.conectar();
             java.sql.PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            // 1 e 2: Nome e Descrição
            stmt.setString(1, entidade.getNome());
            stmt.setString(2, entidade.getDescricao());
            
            // 3: Data de Vencimento
            if (entidade.getDataVencimento() != null) {
                java.sql.Date dataSql = new java.sql.Date(entidade.getDataVencimento().getTime());
                stmt.setDate(3, dataSql);
            } else {
                stmt.setNull(3, java.sql.Types.DATE);
            }
            
            // 4: Categoria ID
            if (entidade.getCategoria() != null) {
                stmt.setInt(4, entidade.getCategoria().getId());
            } else {
                stmt.setNull(4, java.sql.Types.INTEGER);
            }
            
            // 5: Preço
            stmt.setDouble(5, entidade.getPreco());
            
            // Executa e salva no banco
            stmt.executeUpdate();
            System.out.println("Produto salvo com sucesso!");
            
        } catch (Exception e) {
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
    
    public java.util.List<Produto> buscarPorNome(String nomePesquisa) {
        java.util.List<Produto> lista = new java.util.ArrayList<>();
        String sql = "SELECT p.*, c.nome AS categoria_nome " +
                     "FROM produto p " +
                     "LEFT JOIN categoria c ON p.categoria_id = c.id " +
                     "WHERE p.nome LIKE ?";

        try (java.sql.Connection conn = connection.Conexao.conectar();
             java.sql.PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, "%" + nomePesquisa + "%");

            try (java.sql.ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Produto p = new Produto();
                    p.setId(rs.getInt("id"));
                    p.setNome(rs.getString("nome"));
                    p.setDescricao(rs.getString("descricao"));
                    p.setPreco(rs.getDouble("preco"));
                    p.setDataVencimento(rs.getDate("data_vencimento"));

                    if (rs.getObject("categoria_id") != null) {
                        Categoria cat = new Categoria();
                        cat.setId(rs.getInt("categoria_id"));
                        cat.setNome(rs.getString("categoria_nome"));
                        p.setCategoria(cat);
                    }

                    lista.add(p);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
    
    @Override 
    public java.util.List<model.Produto> listarTodos() {
        // AQUI ESTAVA O ERRO: A lista precisa ser inicializada com o ArrayList!
        java.util.List<model.Produto> lista = new java.util.ArrayList<>();
        
        String sql = "SELECT p.*, c.nome AS categoria_nome " +
                     "FROM produto p " +
                     "LEFT JOIN categoria c ON p.categoria_id = c.id";

        try (java.sql.Connection conn = connection.Conexao.conectar();
             java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
             java.sql.ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                model.Produto p = new model.Produto();
                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setDescricao(rs.getString("descricao"));
                p.setPreco(rs.getDouble("preco"));
                p.setDataVencimento(rs.getDate("data_vencimento"));

                // Se o produto tiver uma categoria, preenche o objeto Categoria
                if (rs.getObject("categoria_id") != null) {
                    model.Categoria cat = new model.Categoria();
                    cat.setId(rs.getInt("categoria_id"));
                    cat.setNome(rs.getString("categoria_nome"));
                    p.setCategoria(cat);
                }

                lista.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // Garante que vai devolver a lista (mesmo que vazia), e nunca um "null"
        return lista;
    }
}