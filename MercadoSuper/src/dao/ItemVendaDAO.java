package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.ItemVenda;

public class ItemVendaDAO {

    public void inserir(ItemVenda itemVenda) throws SQLException {
        String sql = "INSERT INTO item_venda (id_venda, id_produto, quantidade, preco_unitario) VALUES (?, ?, ?, ?)";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, itemVenda.getIdVenda());
            stmt.setInt(2, itemVenda.getIdProduto());
            stmt.setInt(3, itemVenda.getQuantidade());
            stmt.setBigDecimal(4, itemVenda.getPrecoUnitario());
            stmt.executeUpdate();
        }
    }

    public void atualizar(ItemVenda itemVenda) throws SQLException {
        String sql = "UPDATE item_venda SET id_venda = ?, id_produto = ?, quantidade = ?, preco_unitario = ? WHERE id_item_venda = ?";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, itemVenda.getIdVenda());
            stmt.setInt(2, itemVenda.getIdProduto());
            stmt.setInt(3, itemVenda.getQuantidade());
            stmt.setBigDecimal(4, itemVenda.getPrecoUnitario());
            stmt.setInt(5, itemVenda.getIdItemVenda());
            stmt.executeUpdate();
        }
    }

    public void excluir(int idItemVenda) throws SQLException {
        String sql = "DELETE FROM item_venda WHERE id_item_venda = ?";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idItemVenda);
            stmt.executeUpdate();
        }
    }

    public List<ItemVenda> listar() throws SQLException {
        List<ItemVenda> lista = new ArrayList<>();
        String sql = "SELECT id_item_venda, id_venda, id_produto, quantidade, preco_unitario FROM item_venda";

        try (Connection conn = Conexao.getConexao();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                ItemVenda itemVenda = new ItemVenda();
                itemVenda.setIdItemVenda(rs.getInt("id_item_venda"));
                itemVenda.setIdVenda(rs.getInt("id_venda"));
                itemVenda.setIdProduto(rs.getInt("id_produto"));
                itemVenda.setQuantidade(rs.getInt("quantidade"));
                itemVenda.setPrecoUnitario(rs.getBigDecimal("preco_unitario"));
                lista.add(itemVenda);
            }
        }

        return lista;
    }

    public ItemVenda buscarPorId(int idItemVenda) throws SQLException {
        String sql = "SELECT id_item_venda, id_venda, id_produto, quantidade, preco_unitario FROM item_venda WHERE id_item_venda = ?";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idItemVenda);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    ItemVenda itemVenda = new ItemVenda();
                    itemVenda.setIdItemVenda(rs.getInt("id_item_venda"));
                    itemVenda.setIdVenda(rs.getInt("id_venda"));
                    itemVenda.setIdProduto(rs.getInt("id_produto"));
                    itemVenda.setQuantidade(rs.getInt("quantidade"));
                    itemVenda.setPrecoUnitario(rs.getBigDecimal("preco_unitario"));
                    return itemVenda;
                }
            }
        }

        return null;
    }
}
