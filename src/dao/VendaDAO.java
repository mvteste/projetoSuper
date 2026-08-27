package dao;

import connection.Conexao;
import model.Cliente;
import model.Venda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VendaDAO implements GenericDAO<Venda> {

    @Override
    public void salvar(Venda entidade) {
        String sql = "INSERT INTO venda (cliente_id, data_venda, valor_total) VALUES (?, ?, ?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            validarVenda(entidade);
            stmt.setInt(1, entidade.getCliente().getId());

            if (entidade.getDataVenda() != null) {
                stmt.setDate(2, java.sql.Date.valueOf(entidade.getDataVenda()));
            } else {
                stmt.setNull(2, java.sql.Types.DATE);
            }

            stmt.setDouble(3, entidade.getValorTotal());
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar venda", e);
        }
    }

    @Override
    public void atualizar(Venda entidade) {
        String sql = "UPDATE venda SET cliente_id = ?, data_venda = ?, valor_total = ? WHERE id = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            validarVenda(entidade);
            stmt.setInt(1, entidade.getCliente().getId());

            if (entidade.getDataVenda() != null) {
                stmt.setDate(2, java.sql.Date.valueOf(entidade.getDataVenda()));
            } else {
                stmt.setNull(2, java.sql.Types.DATE);
            }

            stmt.setDouble(3, entidade.getValorTotal());
            stmt.setInt(4, entidade.getId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar venda", e);
        }
    }

    @Override
    public void excluir(int id) {
        String sql = "DELETE FROM venda WHERE id = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir venda", e);
        }
    }

    @Override
    public Venda buscarPorId(int id) {
        String sql = """
            SELECT v.id,
                   v.cliente_id,
                   v.data_venda,
                   v.valor_total,
                   c.nome AS cliente_nome
              FROM venda v
              JOIN cliente c ON c.id = v.cliente_id
             WHERE v.id = ?
            """;

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapearVenda(rs);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar venda por ID", e);
        }

        return null;
    }

    @Override
    public List<Venda> listarTodos() {
        String sql = """
            SELECT v.id,
                   v.cliente_id,
                   v.data_venda,
                   v.valor_total,
                   c.nome AS cliente_nome
              FROM venda v
              JOIN cliente c ON c.id = v.cliente_id
             ORDER BY v.data_venda DESC, v.id DESC
            """;

        return executarConsulta(sql, null);
    }

    public List<Venda> buscarPorCliente(String nomeCliente) {
        String sql = """
            SELECT v.id,
                   v.cliente_id,
                   v.data_venda,
                   v.valor_total,
                   c.nome AS cliente_nome
              FROM venda v
              JOIN cliente c ON c.id = v.cliente_id
             WHERE c.nome LIKE ?
             ORDER BY v.data_venda DESC, v.id DESC
            """;

        return executarConsulta(sql, "%" + nomeCliente.trim() + "%");
    }

    private List<Venda> executarConsulta(String sql, String filtro) {
        List<Venda> lista = new ArrayList<>();

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            if (filtro != null) {
                stmt.setString(1, filtro);
            }

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    lista.add(mapearVenda(rs));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao consultar vendas", e);
        }

        return lista;
    }

    private Venda mapearVenda(ResultSet rs) throws SQLException {
        Venda venda = new Venda();
        venda.setId(rs.getInt("id"));
        venda.setValorTotal(rs.getDouble("valor_total"));

        java.sql.Date data = rs.getDate("data_venda");
        if (data != null) {
            venda.setDataVenda(data.toLocalDate());
        }

        Cliente cliente = new Cliente();
        cliente.setId(rs.getInt("cliente_id"));
        cliente.setNome(rs.getString("cliente_nome"));
        venda.setCliente(cliente);

        return venda;
    }

    private void validarVenda(Venda venda) {
        if (venda == null) {
            throw new IllegalArgumentException("A venda não pode ser nula.");
        }

        if (venda.getCliente() == null || venda.getCliente().getId() <= 0) {
            throw new IllegalArgumentException("A venda precisa possuir um cliente válido.");
        }

        if (venda.getValorTotal() < 0) {
            throw new IllegalArgumentException("O valor total da venda não pode ser negativo.");
        }
    }
}
