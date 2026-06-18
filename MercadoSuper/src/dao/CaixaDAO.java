package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Caixa;

public class CaixaDAO {

    public void inserir(Caixa caixa) throws SQLException {
        String sql = "INSERT INTO caixa (data_movimento, tipo_movimentacao, descricao, valor) VALUES (?, ?, ?, ?)";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDate(1, caixa.getDataMovimento());
            stmt.setString(2, caixa.getTipoMovimentacao());
            stmt.setString(3, caixa.getDescricao());
            stmt.setBigDecimal(4, caixa.getValor());
            stmt.executeUpdate();
        }
    }

    public void atualizar(Caixa caixa) throws SQLException {
        String sql = "UPDATE caixa SET data_movimento = ?, tipo_movimentacao = ?, descricao = ?, valor = ? WHERE id_caixa = ?";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDate(1, caixa.getDataMovimento());
            stmt.setString(2, caixa.getTipoMovimentacao());
            stmt.setString(3, caixa.getDescricao());
            stmt.setBigDecimal(4, caixa.getValor());
            stmt.setInt(5, caixa.getIdCaixa());
            stmt.executeUpdate();
        }
    }

    public void excluir(int idCaixa) throws SQLException {
        String sql = "DELETE FROM caixa WHERE id_caixa = ?";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idCaixa);
            stmt.executeUpdate();
        }
    }

    public List<Caixa> listar() throws SQLException {
        List<Caixa> lista = new ArrayList<>();
        String sql = "SELECT id_caixa, data_movimento, tipo_movimentacao, descricao, valor FROM caixa";

        try (Connection conn = Conexao.getConexao();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Caixa caixa = new Caixa();
                caixa.setIdCaixa(rs.getInt("id_caixa"));
                caixa.setDataMovimento(rs.getDate("data_movimento"));
                caixa.setTipoMovimentacao(rs.getString("tipo_movimentacao"));
                caixa.setDescricao(rs.getString("descricao"));
                caixa.setValor(rs.getBigDecimal("valor"));
                lista.add(caixa);
            }
        }

        return lista;
    }

    public Caixa buscarPorId(int idCaixa) throws SQLException {
        String sql = "SELECT id_caixa, data_movimento, tipo_movimentacao, descricao, valor FROM caixa WHERE id_caixa = ?";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idCaixa);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Caixa caixa = new Caixa();
                    caixa.setIdCaixa(rs.getInt("id_caixa"));
                    caixa.setDataMovimento(rs.getDate("data_movimento"));
                    caixa.setTipoMovimentacao(rs.getString("tipo_movimentacao"));
                    caixa.setDescricao(rs.getString("descricao"));
                    caixa.setValor(rs.getBigDecimal("valor"));
                    return caixa;
                }
            }
        }

        return null;
    }
}
