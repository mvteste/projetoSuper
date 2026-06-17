package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.ContasPagar;

public class ContasPagarDAO {

    public void inserir(ContasPagar contasPagar) throws SQLException {
        String sql = "INSERT INTO contas_pagar (id_fornecedor, data_vencimento, valor, situacao) VALUES (?, ?, ?, ?)";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, contasPagar.getIdFornecedor());
            stmt.setDate(2, contasPagar.getDataVencimento());
            stmt.setBigDecimal(3, contasPagar.getValor());
            stmt.setString(4, contasPagar.getSituacao());
            stmt.executeUpdate();
        }
    }

    public void atualizar(ContasPagar contasPagar) throws SQLException {
        String sql = "UPDATE contas_pagar SET id_fornecedor = ?, data_vencimento = ?, valor = ?, situacao = ? WHERE id_conta_pagar = ?";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, contasPagar.getIdFornecedor());
            stmt.setDate(2, contasPagar.getDataVencimento());
            stmt.setBigDecimal(3, contasPagar.getValor());
            stmt.setString(4, contasPagar.getSituacao());
            stmt.setInt(5, contasPagar.getIdContaPagar());
            stmt.executeUpdate();
        }
    }

    public void excluir(int idContaPagar) throws SQLException {
        String sql = "DELETE FROM contas_pagar WHERE id_conta_pagar = ?";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idContaPagar);
            stmt.executeUpdate();
        }
    }

    public List<ContasPagar> listar() throws SQLException {
        List<ContasPagar> lista = new ArrayList<>();
        String sql = "SELECT id_conta_pagar, id_fornecedor, data_vencimento, valor, situacao FROM contas_pagar";

        try (Connection conn = Conexao.getConexao();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                ContasPagar contasPagar = new ContasPagar();
                contasPagar.setIdContaPagar(rs.getInt("id_conta_pagar"));
                contasPagar.setIdFornecedor(rs.getInt("id_fornecedor"));
                contasPagar.setDataVencimento(rs.getDate("data_vencimento"));
                contasPagar.setValor(rs.getBigDecimal("valor"));
                contasPagar.setSituacao(rs.getString("situacao"));
                lista.add(contasPagar);
            }
        }

        return lista;
    }

    public ContasPagar buscarPorId(int idContaPagar) throws SQLException {
        String sql = "SELECT id_conta_pagar, id_fornecedor, data_vencimento, valor, situacao FROM contas_pagar WHERE id_conta_pagar = ?";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idContaPagar);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    ContasPagar contasPagar = new ContasPagar();
                    contasPagar.setIdContaPagar(rs.getInt("id_conta_pagar"));
                    contasPagar.setIdFornecedor(rs.getInt("id_fornecedor"));
                    contasPagar.setDataVencimento(rs.getDate("data_vencimento"));
                    contasPagar.setValor(rs.getBigDecimal("valor"));
                    contasPagar.setSituacao(rs.getString("situacao"));
                    return contasPagar;
                }
            }
        }

        return null;
    }
}
