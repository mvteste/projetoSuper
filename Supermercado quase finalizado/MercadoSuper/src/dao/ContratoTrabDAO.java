package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.ContratoTrab;

public class ContratoTrabDAO {

    public void inserir(ContratoTrab contratoTrab) throws SQLException {
        String sql = "INSERT INTO contrato_trab (id_funcionario, data_admissao, salario, cargo) VALUES (?, ?, ?, ?)";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, contratoTrab.getIdFuncionario());
            stmt.setDate(2, contratoTrab.getDataAdmissao());
            stmt.setBigDecimal(3, contratoTrab.getSalario());
            stmt.setString(4, contratoTrab.getCargo());
            stmt.executeUpdate();
        }
    }

    public void atualizar(ContratoTrab contratoTrab) throws SQLException {
        String sql = "UPDATE contrato_trab SET id_funcionario = ?, data_admissao = ?, salario = ?, cargo = ? WHERE id_contrato = ?";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, contratoTrab.getIdFuncionario());
            stmt.setDate(2, contratoTrab.getDataAdmissao());
            stmt.setBigDecimal(3, contratoTrab.getSalario());
            stmt.setString(4, contratoTrab.getCargo());
            stmt.setInt(5, contratoTrab.getIdContrato());
            stmt.executeUpdate();
        }
    }

    public void excluir(int idContrato) throws SQLException {
        String sql = "DELETE FROM contrato_trab WHERE id_contrato = ?";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idContrato);
            stmt.executeUpdate();
        }
    }

    public List<ContratoTrab> listar() throws SQLException {
        List<ContratoTrab> lista = new ArrayList<>();
        String sql = "SELECT id_contrato, id_funcionario, data_admissao, salario, cargo FROM contrato_trab";

        try (Connection conn = Conexao.getConexao();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                ContratoTrab contratoTrab = new ContratoTrab();
                contratoTrab.setIdContrato(rs.getInt("id_contrato"));
                contratoTrab.setIdFuncionario(rs.getInt("id_funcionario"));
                contratoTrab.setDataAdmissao(rs.getDate("data_admissao"));
                contratoTrab.setSalario(rs.getBigDecimal("salario"));
                contratoTrab.setCargo(rs.getString("cargo"));
                lista.add(contratoTrab);
            }
        }

        return lista;
    }

    public ContratoTrab buscarPorId(int idContrato) throws SQLException {
        String sql = "SELECT id_contrato, id_funcionario, data_admissao, salario, cargo FROM contrato_trab WHERE id_contrato = ?";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idContrato);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    ContratoTrab contratoTrab = new ContratoTrab();
                    contratoTrab.setIdContrato(rs.getInt("id_contrato"));
                    contratoTrab.setIdFuncionario(rs.getInt("id_funcionario"));
                    contratoTrab.setDataAdmissao(rs.getDate("data_admissao"));
                    contratoTrab.setSalario(rs.getBigDecimal("salario"));
                    contratoTrab.setCargo(rs.getString("cargo"));
                    return contratoTrab;
                }
            }
        }

        return null;
    }
}
