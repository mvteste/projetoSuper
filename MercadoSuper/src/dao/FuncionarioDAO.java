package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Funcionario;

public class FuncionarioDAO {

    public void inserir(Funcionario funcionario) throws SQLException {
        String sql = "INSERT INTO funcionario (nome, cpf, telefone, id_tipo_funcionario) VALUES (?, ?, ?, ?)";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getCpf());
            stmt.setString(3, funcionario.getTelefone());
            stmt.setInt(4, funcionario.getIdTipoFuncionario());
            stmt.executeUpdate();
        }
    }

    public void atualizar(Funcionario funcionario) throws SQLException {
        String sql = "UPDATE funcionario SET nome = ?, cpf = ?, telefone = ?, id_tipo_funcionario = ? WHERE id_funcionario = ?";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getCpf());
            stmt.setString(3, funcionario.getTelefone());
            stmt.setInt(4, funcionario.getIdTipoFuncionario());
            stmt.setInt(5, funcionario.getIdFuncionario());
            stmt.executeUpdate();
        }
    }

    public void excluir(int idFuncionario) throws SQLException {
        String sql = "DELETE FROM funcionario WHERE id_funcionario = ?";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idFuncionario);
            stmt.executeUpdate();
        }
    }

    public List<Funcionario> listar() throws SQLException {
        List<Funcionario> lista = new ArrayList<>();
        String sql = "SELECT id_funcionario, nome, cpf, telefone, id_tipo_funcionario FROM funcionario";

        try (Connection conn = Conexao.getConexao();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Funcionario funcionario = new Funcionario();
                funcionario.setIdFuncionario(rs.getInt("id_funcionario"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setCpf(rs.getString("cpf"));
                funcionario.setTelefone(rs.getString("telefone"));
                funcionario.setIdTipoFuncionario(rs.getInt("id_tipo_funcionario"));
                lista.add(funcionario);
            }
        }

        return lista;
    }

    public Funcionario buscarPorId(int idFuncionario) throws SQLException {
        String sql = "SELECT id_funcionario, nome, cpf, telefone, id_tipo_funcionario FROM funcionario WHERE id_funcionario = ?";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idFuncionario);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Funcionario funcionario = new Funcionario();
                    funcionario.setIdFuncionario(rs.getInt("id_funcionario"));
                    funcionario.setNome(rs.getString("nome"));
                    funcionario.setCpf(rs.getString("cpf"));
                    funcionario.setTelefone(rs.getString("telefone"));
                    funcionario.setIdTipoFuncionario(rs.getInt("id_tipo_funcionario"));
                    return funcionario;
                }
            }
        }

        return null;
    }
}
