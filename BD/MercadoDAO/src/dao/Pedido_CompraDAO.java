package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Pedido_Compra;
import model.Fornecedor;

/**
 *
 * @author Emanuel
 */
public class Pedido_CompraDAO {

    public List<Pedido_Compra> listar() {
        List<Pedido_Compra> lista = new ArrayList<>();
        
        // Query trazendo o pedido e o nome do fornecedor vinculado
        String sql = "SELECT p.*, f.nome AS nome_fornecedor " +
                     "FROM pedido_compra p " +
                     "INNER JOIN fornecedor f ON p.fornecedor_id = f.id";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                // 1. Instancia e popula o Fornecedor do pedido
                Fornecedor fornecedor = new Fornecedor();
                fornecedor.setId(rs.getInt("fornecedor_id"));
                fornecedor.setNome(rs.getString("nome_fornecedor"));

                // 2. Instancia e popula o Pedido de Compra
                Pedido_Compra pedido = new Pedido_Compra();
                pedido.setId(rs.getInt("id"));
                pedido.setQuantidade(rs.getInt("quantidade"));
                pedido.setTotal(rs.getDouble("total"));
                pedido.setFornecedor(fornecedor); // Associa o objeto fornecedor

                lista.add(pedido);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    public void inserir(Pedido_Compra pedido) {
        String sql = "INSERT INTO pedido_compra (quantidade, total, fornecedor_id) VALUES (?, ?, ?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, pedido.getQuantidade());
            stmt.setDouble(2, pedido.getTotal());
            stmt.setInt(3, pedido.getFornecedor().getId());

            stmt.execute();
            System.out.println("Pedido de compra registrado com sucesso!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void editar(Pedido_Compra pedido) {
        String sql = "UPDATE pedido_compra SET quantidade = ?, total = ?, fornecedor_id = ? WHERE id = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, pedido.getQuantidade());
            stmt.setDouble(2, pedido.getTotal());
            stmt.setInt(3, pedido.getFornecedor().getId());
            stmt.setInt(4, pedido.getId());

            stmt.executeUpdate();
            System.out.println("Pedido de compra atualizado com sucesso!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deletar(Pedido_Compra pedido) {
        // Como não há campo status/ativo nesta tabela no DER, fazemos a remoção física
        String sql = "DELETE FROM pedido_compra WHERE id = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, pedido.getId());

            stmt.executeUpdate();
            System.out.println("Pedido de compra removido com sucesso!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}