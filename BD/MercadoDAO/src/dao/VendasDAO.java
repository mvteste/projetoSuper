package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Clientes;
import model.Funcionarios;
import model.Vendas;

public class VendasDAO {
    public List<Vendas> listar() {
        List<Vendas> vendas = new ArrayList<>();
        String sql = "SELECT v.id, v.descricao, v.data, v.clientes_id, c.nome AS cliente_nome, "
                + "v.funcionarios_id, f.nome AS funcionario_nome FROM vendas v "
                + "INNER JOIN clientes c ON c.id = v.clientes_id "
                + "INNER JOIN funcionarios f ON f.id = v.funcionarios_id ORDER BY v.id";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Clientes cliente = new Clientes();
                cliente.setId(rs.getInt("clientes_id"));
                cliente.setNome(rs.getString("cliente_nome"));
                Funcionarios funcionario = new Funcionarios();
                funcionario.setId(rs.getInt("funcionarios_id"));
                funcionario.setNome(rs.getString("funcionario_nome"));
                vendas.add(new Vendas(rs.getInt("id"), rs.getString("descricao"),
                        rs.getString("data"), cliente, funcionario));
            }
        } catch (Exception e) {
            throw new IllegalStateException("Não foi possível listar as vendas.", e);
        }
        return vendas;
    }

    public void inserir(Vendas venda) {
        executarAlteracao("INSERT INTO vendas (descricao, data, clientes_id, funcionarios_id) VALUES (?, ?, ?, ?)", venda, false);
    }

    public void editar(Vendas venda) {
        executarAlteracao("UPDATE vendas SET descricao = ?, data = ?, clientes_id = ?, funcionarios_id = ? WHERE id = ?", venda, true);
    }

    public void deletar(int id) {
        try (Connection conn = Conexao.conectar(); PreparedStatement stmt = conn.prepareStatement("DELETE FROM vendas WHERE id = ?")) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (Exception e) {
            throw new IllegalStateException("Não foi possível excluir a venda.", e);
        }
    }

    private void executarAlteracao(String sql, Vendas venda, boolean incluirId) {
        try (Connection conn = Conexao.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, venda.getDescricao());
            stmt.setString(2, venda.getData());
            stmt.setInt(3, venda.getCliente().getId());
            stmt.setInt(4, venda.getFuncionario().getId());
            if (incluirId) stmt.setInt(5, venda.getId());
            stmt.executeUpdate();
        } catch (Exception e) {
            throw new IllegalStateException("Não foi possível salvar a venda.", e);
        }
    }
}
