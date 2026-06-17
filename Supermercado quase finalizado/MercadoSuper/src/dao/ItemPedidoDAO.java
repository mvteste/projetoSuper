package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.ItemPedido;

public class ItemPedidoDAO {

    public void inserir(ItemPedido itemPedido) throws SQLException {
        String sql = "INSERT INTO item_pedido (id_pedido_compra, id_produto, quantidade, preco_unitario) VALUES (?, ?, ?, ?)";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, itemPedido.getIdPedidoCompra());
            stmt.setInt(2, itemPedido.getIdProduto());
            stmt.setInt(3, itemPedido.getQuantidade());
            stmt.setBigDecimal(4, itemPedido.getPrecoUnitario());
            stmt.executeUpdate();
        }
    }

    public void atualizar(ItemPedido itemPedido) throws SQLException {
        String sql = "UPDATE item_pedido SET id_pedido_compra = ?, id_produto = ?, quantidade = ?, preco_unitario = ? WHERE id_item_pedido = ?";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, itemPedido.getIdPedidoCompra());
            stmt.setInt(2, itemPedido.getIdProduto());
            stmt.setInt(3, itemPedido.getQuantidade());
            stmt.setBigDecimal(4, itemPedido.getPrecoUnitario());
            stmt.setInt(5, itemPedido.getIdItemPedido());
            stmt.executeUpdate();
        }
    }

    public void excluir(int idItemPedido) throws SQLException {
        String sql = "DELETE FROM item_pedido WHERE id_item_pedido = ?";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idItemPedido);
            stmt.executeUpdate();
        }
    }

    public List<ItemPedido> listar() throws SQLException {
        List<ItemPedido> lista = new ArrayList<>();
        String sql = "SELECT id_item_pedido, id_pedido_compra, id_produto, quantidade, preco_unitario FROM item_pedido";

        try (Connection conn = Conexao.getConexao();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                ItemPedido itemPedido = new ItemPedido();
                itemPedido.setIdItemPedido(rs.getInt("id_item_pedido"));
                itemPedido.setIdPedidoCompra(rs.getInt("id_pedido_compra"));
                itemPedido.setIdProduto(rs.getInt("id_produto"));
                itemPedido.setQuantidade(rs.getInt("quantidade"));
                itemPedido.setPrecoUnitario(rs.getBigDecimal("preco_unitario"));
                lista.add(itemPedido);
            }
        }

        return lista;
    }

    public ItemPedido buscarPorId(int idItemPedido) throws SQLException {
        String sql = "SELECT id_item_pedido, id_pedido_compra, id_produto, quantidade, preco_unitario FROM item_pedido WHERE id_item_pedido = ?";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idItemPedido);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    ItemPedido itemPedido = new ItemPedido();
                    itemPedido.setIdItemPedido(rs.getInt("id_item_pedido"));
                    itemPedido.setIdPedidoCompra(rs.getInt("id_pedido_compra"));
                    itemPedido.setIdProduto(rs.getInt("id_produto"));
                    itemPedido.setQuantidade(rs.getInt("quantidade"));
                    itemPedido.setPrecoUnitario(rs.getBigDecimal("preco_unitario"));
                    return itemPedido;
                }
            }
        }

        return null;
    }
}
