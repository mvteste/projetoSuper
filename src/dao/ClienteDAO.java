package dao;

import connection.Conexao;
import model.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO implements GenericDAO<Cliente> {

    public void inserir(Cliente c) {
        String sql = """
            INSERT INTO cliente
            (nome, data_nascimento, cpf, telefone, endereco)
            VALUES (?, ?, ?, ?, ?)
            """;

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, c.getNome());

            if (c.getData_Nascimento() != null) {
                java.sql.Date dataSql = new java.sql.Date(c.getData_Nascimento().getTime());
                stmt.setDate(2, dataSql);
            } else {
                stmt.setNull(2, java.sql.Types.DATE);
            }

            stmt.setString(3, c.getCpf());
            stmt.setString(4, c.getTelefone());
            stmt.setString(5, c.getEndereco());

            stmt.executeUpdate();

        } catch (SQLIntegrityConstraintViolationException e) {
            javax.swing.JOptionPane.showMessageDialog(
                    null,
                    "Erro: Este CPF já está cadastrado no sistema!"
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Cliente> listarTodos() {
        List<Cliente> lista = new ArrayList<>();
        String sql = "SELECT * FROM cliente ORDER BY nome";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                lista.add(mapearCliente(rs));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }

    public List<Cliente> buscarPorNome(String nomePesquisa) {
        List<Cliente> lista = new ArrayList<>();
        String sql = "SELECT * FROM cliente WHERE nome LIKE ? ORDER BY nome";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, "%" + nomePesquisa.trim() + "%");

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    lista.add(mapearCliente(rs));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }

    /**
     * Exclui um cliente e informa se uma linha foi realmente removida.
     *
     * O SQLException é propagado para a camada de tela para que seja possível
     * diferenciar, por exemplo, uma restrição de chave estrangeira de outro
     * problema de banco de dados.
     */
    public boolean excluirCliente(int id) throws SQLException {
        String sql = "DELETE FROM cliente WHERE id = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        }
    }

    /**
     * Mantém compatibilidade com a interface GenericDAO.
     */
    @Override
    public void excluir(int id) {
        try {
            excluirCliente(id);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir cliente de ID " + id, e);
        }
    }

    @Override
    public void salvar(Cliente entidade) {
        inserir(entidade);
    }

    @Override
    public void atualizar(Cliente entidade) {
        String sql = """
            UPDATE cliente
               SET nome = ?,
                   data_nascimento = ?,
                   cpf = ?,
                   telefone = ?,
                   endereco = ?
             WHERE id = ?
            """;

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, entidade.getNome());

            if (entidade.getData_Nascimento() != null) {
                stmt.setDate(2, new java.sql.Date(entidade.getData_Nascimento().getTime()));
            } else {
                stmt.setNull(2, java.sql.Types.DATE);
            }

            stmt.setString(3, entidade.getCpf());
            stmt.setString(4, entidade.getTelefone());
            stmt.setString(5, entidade.getEndereco());
            stmt.setInt(6, entidade.getId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar cliente", e);
        }
    }

    @Override
    public Cliente buscarPorId(int id) {
        String sql = "SELECT * FROM cliente WHERE id = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapearCliente(rs);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar cliente por ID", e);
        }

        return null;
    }

    private Cliente mapearCliente(ResultSet rs) throws SQLException {
        Cliente c = new Cliente();
        c.setId(rs.getInt("id"));
        c.setNome(rs.getString("nome"));
        c.setCpf(rs.getString("cpf"));
        c.setTelefone(rs.getString("telefone"));
        c.setEndereco(rs.getString("endereco"));
        c.setData_Nascimento(rs.getDate("data_nascimento"));
        return c;
    }
}
