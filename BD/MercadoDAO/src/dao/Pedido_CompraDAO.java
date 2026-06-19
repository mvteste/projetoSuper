package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Fornecedor;
import model.Pedido_Compra;
import model.Produtos;

/**
 *
 * @author Emanuel
 */
public class Pedido_CompraDAO {

    public List<Pedido_Compra> listar() {
        List<Pedido_Compra> lista = new ArrayList<>();
        String sql = "SELECT * FROM pedido_compra";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Pedido_Compra pedido = new Pedido_Compra();
                pedido.setId(rs.getInt("id"));
                pedido.setQuantidade(rs.getInt("quantidade"));
                pedido.setTotal(rs.getDouble("total"));

                // Instancia e define o ID do fornecedor vinculado
                Fornecedor f = new Fornecedor();
                f.setId(rs.getInt("fornecedor_id"));
                pedido.setFornecedor(f);

                // Instancia e define o ID do produto vinculado
                Produtos prod = new Produtos();
                prod.setId(rs.getInt("produtos_id"));
                pedido.setProdutos(prod);

                lista.add(pedido);
            }

        } catch (Exception e) {
            System.out.println("Erro al listar os pedidos de compra.");
            e.printStackTrace();
        }
        return lista;
    }

public void inserir(Pedido_Compra pedido) {
        String sqlPedido = "INSERT INTO pedido_compra (fornecedor_id, total, quantidade) VALUES (?, ?, ?)";
        String sqlAuxiliar = "INSERT INTO pedido_compra_produtos (pedido_compra_id, produtos_id) VALUES (?, ?)";

        Connection conn = null;
        try {
            conn = Conexao.conectar();
            conn.setAutoCommit(false); // Transação manual ativa

            // 1. Insere o Pedido
            try (PreparedStatement stmtPedido = conn.prepareStatement(sqlPedido, Statement.RETURN_GENERATED_KEYS)) {
                stmtPedido.setInt(1, pedido.getFornecedor().getId());
                stmtPedido.setDouble(2, pedido.getTotal());
                stmtPedido.setInt(3, pedido.getQuantidade());
                stmtPedido.executeUpdate();

                try (ResultSet rs = stmtPedido.getGeneratedKeys()) {
                    if (rs.next()) {
                        int idPedidoGerado = rs.getInt(1);
                        pedido.setId(idPedidoGerado);

                        // 2. Insere na tabela intermediária auxiliar
                        try (PreparedStatement stmtAux = conn.prepareStatement(sqlAuxiliar)) {
                            stmtAux.setInt(1, idPedidoGerado);
                            stmtAux.setInt(2, pedido.getProdutos().getId());
                            stmtAux.executeUpdate();
                        }

                        // =========================================================
                        // 3. ATUALIZAÇÃO AUTOMÁTICA DO ESTOQUE (COMPRA)
                        // =========================================================
                        EstoqueDAO estoqueDAO = new EstoqueDAO();
                        // Passamos a mesma conexão 'conn', o ID do produto e a quantidade comprada
                        estoqueDAO.aumentarEstoque(conn, pedido.getProdutos().getId(), pedido.getQuantidade());
                        // =========================================================
                    }
                }
            }

            conn.commit(); // Salva as duas tabelas e o estoque de uma só vez com total segurança!
            System.out.println("Pedido registrado e estoque atualizado com sucesso!");

        } catch (Exception e) {
            try {
                if (conn != null) conn.rollback(); // Se algo falhar, desfaz o pedido E a alteração do estoque
            } catch (Exception rollbackEx) {
                rollbackEx.printStackTrace();
            }
            System.out.println("Erro ao registrar o pedido de compra e atualizar o estoque.");
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) conn.close();
            } catch (Exception closeEx) {
                closeEx.printStackTrace();
            }
        }
    }

public void editar(Pedido_Compra pedido) {
    String sql = "UPDATE pedido_compra SET fornecedor_id = ?, total = ?, quantidade = ? WHERE id = ?";
    // Se precisar atualizar a tabela intermediária ao mesmo tempo:
    String sqlAux = "UPDATE pedido_compra_produtos SET produtos_id = ? WHERE pedido_compra_id = ?";

    try (Connection conn = Conexao.conectar()) {
        conn.setAutoCommit(false);

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, pedido.getFornecedor().getId());
            stmt.setDouble(2, pedido.getTotal());
            stmt.setInt(3, pedido.getQuantidade());
            stmt.setInt(4, pedido.getId());
            stmt.executeUpdate();
        }

        try (PreparedStatement stmtAux = conn.prepareStatement(sqlAux)) {
            stmtAux.setInt(1, pedido.getProdutos().getId());
            stmtAux.setInt(2, pedido.getId());
            stmtAux.executeUpdate();
        }

        conn.commit();
        System.out.println("Pedido de compra e vínculos atualizados com sucesso!");
    } catch (Exception e) {
        System.out.println("Erro ao atualizar o pedido de compra.");
        e.printStackTrace();
    }
}

    public void deletar(Pedido_Compra pedido) {
        String sqlPedido = "DELETE FROM pedido_compra WHERE id = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmtPedido = conn.prepareStatement(sqlPedido)) {
            
            stmtPedido.setInt(1, pedido.getId());
            stmtPedido.executeUpdate();

            System.out.println("Pedido de compra removido com sucesso!");

        } catch (Exception e) {
            System.out.println("Erro ao remover o pedido de compra.");
            e.printStackTrace();
        }
    }
}