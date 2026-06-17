package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.ContasReceber;

public class ContasReceberDAO {

    public void inserir(ContasReceber contasReceber) throws SQLException {
        String sql = "INSERT INTO contas_receber (id_venda, data_vencimento, valor, situacao) VALUES (?, ?, ?, ?)";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, contasReceber.getIdVenda());
            stmt.setDate(2, contasReceber.getDataVencimento());
            stmt.setBigDecimal(3, contasReceber.getValor());
            stmt.setString(4, contasReceber.getSituacao());
            stmt.executeUpdate();
        }
    }

    public void atualizar(ContasReceber contasReceber) throws SQLException {
        String sql = "UPDATE contas_receber SET id_venda = ?, data_vencimento = ?, valor = ?, situacao = ? WHERE id_conta_receber = ?";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, contasReceber.getIdVenda());
            stmt.setDate(2, contasReceber.getDataVencimento());
            stmt.setBigDecimal(3, contasReceber.getValor());
            stmt.setString(4, contasReceber.getSituacao());
            stmt.setInt(5, contasReceber.getIdContaReceber());
            stmt.executeUpdate();
        }
    }

    public void excluir(int idContaReceber) throws SQLException {
        String sql = "DELETE FROM contas_receber WHERE id_conta_receber = ?";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idContaReceber);
            stmt.executeUpdate();
        }
    }

    public List<ContasReceber> listar() throws SQLException {
        List<ContasReceber> lista = new ArrayList<>();
        String sql = "SELECT id_conta_receber, id_venda, data_vencimento, valor, situacao FROM contas_receber";

        try (Connection conn = Conexao.getConexao();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                ContasReceber contasReceber = new ContasReceber();
                contasReceber.setIdContaReceber(rs.getInt("id_conta_receber"));
                contasReceber.setIdVenda(rs.getInt("id_venda"));
                contasReceber.setDataVencimento(rs.getDate("data_vencimento"));
                contasReceber.setValor(rs.getBigDecimal("valor"));
                contasReceber.setSituacao(rs.getString("situacao"));
                lista.add(contasReceber);
            }
        }

        return lista;
    }

    public ContasReceber buscarPorId(int idContaReceber) throws SQLException {
        String sql = "SELECT id_conta_receber, id_venda, data_vencimento, valor, situacao FROM contas_receber WHERE id_conta_receber = ?";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idContaReceber);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    ContasReceber contasReceber = new ContasReceber();
                    contasReceber.setIdContaReceber(rs.getInt("id_conta_receber"));
                    contasReceber.setIdVenda(rs.getInt("id_venda"));
                    contasReceber.setDataVencimento(rs.getDate("data_vencimento"));
                    contasReceber.setValor(rs.getBigDecimal("valor"));
                    contasReceber.setSituacao(rs.getString("situacao"));
                    return contasReceber;
                }
            }
        }

        return null;
    }
}
