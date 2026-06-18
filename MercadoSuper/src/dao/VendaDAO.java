package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Venda;

public class VendaDAO {

    public void inserir(Venda venda) throws SQLException {
        String sql = "INSERT INTO venda (id_cliente, data_venda, valor_total) VALUES (?, ?, ?)";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, venda.getIdCliente());
            stmt.setDate(2, venda.getDataVenda());
            stmt.setBigDecimal(3, venda.getValorTotal());
            stmt.executeUpdate();
        }
    }

    public void atualizar(Venda venda) throws SQLException {
        String sql = "UPDATE venda SET id_cliente = ?, data_venda = ?, valor_total = ? WHERE id_venda = ?";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, venda.getIdCliente());
            stmt.setDate(2, venda.getDataVenda());
            stmt.setBigDecimal(3, venda.getValorTotal());
            stmt.setInt(4, venda.getIdVenda());
            stmt.executeUpdate();
        }
    }

    public void excluir(int idVenda) throws SQLException {
        String sql = "DELETE FROM venda WHERE id_venda = ?";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idVenda);
            stmt.executeUpdate();
        }
    }

    public List<Venda> listar() throws SQLException {
        List<Venda> lista = new ArrayList<>();
        String sql = "SELECT id_venda, id_cliente, data_venda, valor_total FROM venda";

        try (Connection conn = Conexao.getConexao();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Venda venda = new Venda();
                venda.setIdVenda(rs.getInt("id_venda"));
                venda.setIdCliente(rs.getInt("id_cliente"));
                venda.setDataVenda(rs.getDate("data_venda"));
                venda.setValorTotal(rs.getBigDecimal("valor_total"));
                lista.add(venda);
            }
        }

        return lista;
    }

    public Venda buscarPorId(int idVenda) throws SQLException {
        String sql = "SELECT id_venda, id_cliente, data_venda, valor_total FROM venda WHERE id_venda = ?";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idVenda);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Venda venda = new Venda();
                    venda.setIdVenda(rs.getInt("id_venda"));
                    venda.setIdCliente(rs.getInt("id_cliente"));
                    venda.setDataVenda(rs.getDate("data_venda"));
                    venda.setValorTotal(rs.getBigDecimal("valor_total"));
                    return venda;
                }
            }
        }

        return null;
    }
}
