package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Caixa;
import model.Contas_Receber;
import model.Vendas;

public class Contas_ReceberDAO {


    public void inserir(Contas_Receber conta) {

        String sql = "INSERT INTO contas_receber (nome, valor, data_recebimento, caixa_id, vendas_id, status) VALUES (?, ?, ?, ?, ?, 1)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, conta.getNome());
            stmt.setDouble(2, conta.getValor());
            stmt.setString(3, conta.getData_recebimento());
            stmt.setInt(4, conta.getCaixa().getId());

            if (conta.getVendas() != null && conta.getVendas().getId() > 0) {
                stmt.setInt(5, conta.getVendas().getId());
            } else {
                stmt.setNull(5, java.sql.Types.INTEGER);
            }

            stmt.executeUpdate();
            System.out.println("Conta a receber registrada com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao inserir conta a receber: " + e.getMessage());
        }
    }

    public void editar(Contas_Receber conta) {

        String sql = "UPDATE contas_receber SET nome = ?, valor = ?, data_recebimento = ?, caixa_id = ?, vendas_id = ? WHERE id = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, conta.getNome());
            stmt.setDouble(2, conta.getValor());
            stmt.setString(3, conta.getData_recebimento());
            stmt.setInt(4, conta.getCaixa().getId());

            if (conta.getVendas() != null && conta.getVendas().getId() > 0) {
                stmt.setInt(5, conta.getVendas().getId());
            } else {
                stmt.setNull(5, java.sql.Types.INTEGER);
            }

            stmt.setInt(6, conta.getId());

            stmt.executeUpdate();
            System.out.println("Conta a receber editada com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao editar conta a receber: " + e.getMessage());
        }
    }

    public List<Contas_Receber> listar() {

        List<Contas_Receber> lista = new ArrayList<>();

        String sql = "SELECT cr.id, cr.nome, cr.valor, cr.data_recebimento, cr.status, " +
                     "cx.id AS id_cx, cx.nome AS nome_cx, " +
                     "v.id AS vendas_id " +
                     "FROM contas_receber cr " +
                     "INNER JOIN caixa cx ON cr.caixa_id = cx.id " +
                     "LEFT JOIN vendas v ON cr.id_vendas = v.id";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {

                Contas_Receber conta = new Contas_Receber();
                conta.setId(rs.getInt("id"));
                conta.setNome(rs.getString("nome"));
                conta.setValor(rs.getDouble("valor"));
                conta.setData_recebimento(rs.getString("data_recebimento"));
                conta.setStatus(rs.getInt("status"));

                Caixa caixa = new Caixa();
                caixa.setId(rs.getInt("id_cx"));
                caixa.setNome(rs.getString("nome_cx"));
                conta.setCaixa(caixa);

                int idVenda = rs.getInt("vendas_id");
                if (!rs.wasNull()) {
                    Vendas venda = new Vendas();
                    venda.setId(idVenda);
                    conta.setVendas(venda);
                }

                lista.add(conta);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar contas a receber: " + e.getMessage());
        }

        return lista;
    }

    public void receberConta(int idConta) {

        String sqlBuscarConta = "SELECT valor, caixa_id, status FROM contas_receber WHERE id = ?";
        String sqlAtualizarCaixa = "UPDATE caixa SET valor = valor + ? WHERE id = ?";
        String sqlAtualizarConta = "UPDATE contas_receber SET status = 2 WHERE id = ?";

        Connection conn = null;

        try {
            conn = Conexao.conectar();
            conn.setAutoCommit(false);

            double valorConta = 0;
            int idCaixa = 0;
            int status = 0;

            try (PreparedStatement stmtBusca = conn.prepareStatement(sqlBuscarConta)) {
                stmtBusca.setInt(1, idConta);
                try (ResultSet rs = stmtBusca.executeQuery()) {
                    if (rs.next()) {
                        valorConta = rs.getDouble("valor");
                        idCaixa = rs.getInt("caixa_id");
                        status = rs.getInt("status");
                    }
                }
            }

            if (status == 2) {
                System.out.println("Esta conta já foi recebida anteriormente!");
                conn.rollback();
                return;
            }

            if (idCaixa > 0) {

                try (PreparedStatement stmtCaixa = conn.prepareStatement(sqlAtualizarCaixa)) {
                    stmtCaixa.setDouble(1, valorConta);
                    stmtCaixa.setInt(2, idCaixa);
                    stmtCaixa.executeUpdate();
                }

                try (PreparedStatement stmtConta = conn.prepareStatement(sqlAtualizarConta)) {
                    stmtConta.setInt(1, idConta);
                    stmtConta.executeUpdate();
                }

                conn.commit();
                System.out.println("Recebimento processado e saldo do caixa atualizado com sucesso!");

            } else {
                System.out.println("Conta não encontrada ou sem caixa vinculado.");
                conn.rollback();
            }

        } catch (SQLException e) {
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    System.out.println("Erro no rollback: " + ex.getMessage());
                }
            }
            System.out.println("Erro ao processar recebimento: " + e.getMessage());
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    System.out.println("Erro ao fechar conexão: " + e.getMessage());
                }
            }
        }
    }
}