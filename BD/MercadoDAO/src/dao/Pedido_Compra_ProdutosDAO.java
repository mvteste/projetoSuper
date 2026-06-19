package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Pedido_Compra;
import model.Pedido_Compra_Produtos;
import model.Produtos;

/**
 *
 * @author Emanuel
 */
public class Pedido_Compra_ProdutosDAO {

    // Método para inserir um item na tabela auxiliar
    public void inserir(Pedido_Compra_Produtos item) {
        String sql = "INSERT INTO pedido_compra_produtos (pedido_compra_id, produtos_id) VALUES (?, ?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, item.getPedidoCompra().getId());
            stmt.setInt(2, item.getProdutos().getId());

            stmt.execute();
            System.out.println("Produto vinculado ao pedido com sucesso!");

        } catch (Exception e) {
            System.out.println("Erro ao vincular produto ao pedido de compra.");
            e.printStackTrace();
        }
    }

    // Método para listar todos os produtos de um pedido específico
    public List<Pedido_Compra_Produtos> listarPorPedido(int idPedido) {
        List<Pedido_Compra_Produtos> lista = new ArrayList<>();
        String sql = "SELECT * FROM pedido_compra_produtos WHERE pedido_compra_id = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, idPedido);
            
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Pedido_Compra_Produtos item = new Pedido_Compra_Produtos();
                    
                    // Vincula o Pedido apenas com o ID encontrado
                    Pedido_Compra p = new Pedido_Compra();
                    p.setId(rs.getInt("pedido_compra_id"));
                    item.setPedidoCompra(p);
                    
                    // Vincula o Produto apenas com o ID encontrado
                    Produtos prod = new Produtos();
                    prod.setId(rs.getInt("produtos_id"));
                    item.setProdutos(prod);
                    
                    lista.add(item);
                }
            }

        } catch (Exception e) {
            System.out.println("Erro ao listar os produtos do pedido.");
            e.printStackTrace();
        }
        return lista;
    }

    // Método para remover um produto específico de um pedido
    public void deletarProdutoDoPedido(Pedido_Compra_Produtos item) {
        String sql = "DELETE FROM pedido_compra_produtos WHERE pedido_compra_id = ? AND produtos_id = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, item.getPedidoCompra().getId());
            stmt.setInt(2, item.getProdutos().getId());

            stmt.executeUpdate();
            System.out.println("Produto removido do pedido com sucesso!");

        } catch (Exception e) {
            System.out.println("Erro ao remover produto do pedido.");
            e.printStackTrace();
        }
    }
}