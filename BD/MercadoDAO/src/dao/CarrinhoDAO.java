package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Carrinho;
import model.Produtos;
import model.Vendas;

public class CarrinhoDAO {
    public List<Carrinho> listarPorVenda(int vendaId) {
        List<Carrinho> itens = new ArrayList<>();
        String sql = "SELECT c.vendas_id, c.produtos_id, c.quantidade, c.valor, p.nome "
                + "FROM carrinho c INNER JOIN produtos p ON p.id = c.produtos_id WHERE c.vendas_id = ?";
        try (Connection conn = Conexao.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, vendaId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Vendas venda = new Vendas();
                    venda.setId(rs.getInt("vendas_id"));
                    Produtos produto = new Produtos();
                    produto.setId(rs.getInt("produtos_id"));
                    produto.setNome(rs.getString("nome"));
                    itens.add(new Carrinho(venda, produto, rs.getInt("quantidade"), rs.getDouble("valor")));
                }
            }
        } catch (Exception e) {
            throw new IllegalStateException("Não foi possível listar os itens da venda.", e);
        }
        return itens;
    }

    public void inserir(Carrinho item) {
        String sql = "INSERT INTO carrinho (vendas_id, produtos_id, quantidade, valor) VALUES (?, ?, ?, ?)";
        try (Connection conn = Conexao.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, item.getVenda().getId());
            stmt.setInt(2, item.getProduto().getId());
            stmt.setInt(3, item.getQuantidade());
            stmt.setDouble(4, item.getValor());
            stmt.executeUpdate();
        } catch (Exception e) {
            throw new IllegalStateException("Não foi possível adicionar o item à venda.", e);
        }
    }

    public void atualizar(Carrinho item) {
        String sql = "UPDATE carrinho SET quantidade = ?, valor = ? WHERE vendas_id = ? AND produtos_id = ?";
        try (Connection conn = Conexao.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, item.getQuantidade());
            stmt.setDouble(2, item.getValor());
            stmt.setInt(3, item.getVenda().getId());
            stmt.setInt(4, item.getProduto().getId());
            stmt.executeUpdate();
        } catch (Exception e) {
            throw new IllegalStateException("Não foi possível atualizar o item da venda.", e);
        }
    }

    public void deletar(int vendaId, int produtoId) {
        String sql = "DELETE FROM carrinho WHERE vendas_id = ? AND produtos_id = ?";
        try (Connection conn = Conexao.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, vendaId);
            stmt.setInt(2, produtoId);
            stmt.executeUpdate();
        } catch (Exception e) {
            throw new IllegalStateException("Não foi possível remover o item da venda.", e);
        }
    }
}
