package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.PedidoCompra;

public class PedidoCompraDAO {

    public void inserir(PedidoCompra pedidoCompra) throws SQLException {
        String sql = "INSERT INTO pedido_compra (id_fornecedor, data_pedido, valor_total) VALUES (?, ?, ?)";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, pedidoCompra.getIdFornecedor());
            stmt.setDate(2, pedidoCompra.getDataPedido());
            stmt.setBigDecimal(3, pedidoCompra.getValorTotal());
            stmt.executeUpdate();
        }
    }

    public void atualizar(PedidoCompra pedidoCompra) throws SQLException {
        String sql = "UPDATE pedido_compra SET id_fornecedor = ?, data_pedido = ?, valor_total = ? WHERE id_pedido_compra = ?";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, pedidoCompra.getIdFornecedor());
            stmt.setDate(2, pedidoCompra.getDataPedido());
            stmt.setBigDecimal(3, pedidoCompra.getValorTotal());
            stmt.setInt(4, pedidoCompra.getIdPedidoCompra());
            stmt.executeUpdate();
        }
    }

    public void excluir(int idPedidoCompra) throws SQLException {
        String sql = "DELETE FROM pedido_compra WHERE id_pedido_compra = ?";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idPedidoCompra);
            stmt.executeUpdate();
        }
    }

    public List<PedidoCompra> listar() throws SQLException {
        List<PedidoCompra> lista = new ArrayList<>();
        String sql = "SELECT id_pedido_compra, id_fornecedor, data_pedido, valor_total FROM pedido_compra";

        try (Connection conn = Conexao.getConexao();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                PedidoCompra pedidoCompra = new PedidoCompra();
                pedidoCompra.setIdPedidoCompra(rs.getInt("id_pedido_compra"));
                pedidoCompra.setIdFornecedor(rs.getInt("id_fornecedor"));
                pedidoCompra.setDataPedido(rs.getDate("data_pedido"));
                pedidoCompra.setValorTotal(rs.getBigDecimal("valor_total"));
                lista.add(pedidoCompra);
            }
        }

        return lista;
    }

    public PedidoCompra buscarPorId(int idPedidoCompra) throws SQLException {
        String sql = "SELECT id_pedido_compra, id_fornecedor, data_pedido, valor_total FROM pedido_compra WHERE id_pedido_compra = ?";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idPedidoCompra);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    PedidoCompra pedidoCompra = new PedidoCompra();
                    pedidoCompra.setIdPedidoCompra(rs.getInt("id_pedido_compra"));
                    pedidoCompra.setIdFornecedor(rs.getInt("id_fornecedor"));
                    pedidoCompra.setDataPedido(rs.getDate("data_pedido"));
                    pedidoCompra.setValorTotal(rs.getBigDecimal("valor_total"));
                    return pedidoCompra;
                }
            }
        }

        return null;
    }
}
