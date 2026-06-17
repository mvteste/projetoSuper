package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.TipoFuncionario;

public class TipoFuncionarioDAO {

    public void inserir(TipoFuncionario tipoFuncionario) throws SQLException {
        String sql = "INSERT INTO tipo_funcionario (descricao) VALUES (?)";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, tipoFuncionario.getDescricao());
            stmt.executeUpdate();
        }
    }

    public void atualizar(TipoFuncionario tipoFuncionario) throws SQLException {
        String sql = "UPDATE tipo_funcionario SET descricao = ? WHERE id_tipo_funcionario = ?";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, tipoFuncionario.getDescricao());
            stmt.setInt(2, tipoFuncionario.getIdTipoFuncionario());
            stmt.executeUpdate();
        }
    }

    public void excluir(int idTipoFuncionario) throws SQLException {
        String sql = "DELETE FROM tipo_funcionario WHERE id_tipo_funcionario = ?";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idTipoFuncionario);
            stmt.executeUpdate();
        }
    }

    public List<TipoFuncionario> listar() throws SQLException {
        List<TipoFuncionario> lista = new ArrayList<>();
        String sql = "SELECT id_tipo_funcionario, descricao FROM tipo_funcionario";

        try (Connection conn = Conexao.getConexao();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                TipoFuncionario tipoFuncionario = new TipoFuncionario();
                tipoFuncionario.setIdTipoFuncionario(rs.getInt("id_tipo_funcionario"));
                tipoFuncionario.setDescricao(rs.getString("descricao"));
                lista.add(tipoFuncionario);
            }
        }

        return lista;
    }

    public TipoFuncionario buscarPorId(int idTipoFuncionario) throws SQLException {
        String sql = "SELECT id_tipo_funcionario, descricao FROM tipo_funcionario WHERE id_tipo_funcionario = ?";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idTipoFuncionario);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    TipoFuncionario tipoFuncionario = new TipoFuncionario();
                    tipoFuncionario.setIdTipoFuncionario(rs.getInt("id_tipo_funcionario"));
                    tipoFuncionario.setDescricao(rs.getString("descricao"));
                    return tipoFuncionario;
                }
            }
        }

        return null;
    }
}
