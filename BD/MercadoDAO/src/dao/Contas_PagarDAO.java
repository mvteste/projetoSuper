package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Caixa;
import model.Contas_Pagar;
import model.Pedido_Compra;

public class Contas_PagarDAO {


    public void inserir(Contas_Pagar conta) {

        String sql = "INSERT INTO contas_pagar (nome, valor, data_vencimento, caixa_id, pedido_compra_id, status) VALUES (?, ?, ?, ?, ?, ?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = Conexao.conectar();
            pstm = conn.prepareStatement(sql);

            pstm.setString(1, conta.getNome());
            pstm.setDouble(2, conta.getValor());
            pstm.setString(3, conta.getData_vencimento());
            pstm.setInt(4, conta.getCaixa().getId());

            if (conta.getPedido_compra() != null) {
                pstm.setInt(5, conta.getPedido_compra().getId());
            } else {
                pstm.setNull(5, java.sql.Types.INTEGER);
            }

            pstm.setInt(6, 1);

            pstm.execute();
            System.out.println("Conta a pagar registrada com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao inserir conta a pagar: " + e.getMessage());
        } finally {
            try {
                if (pstm != null) pstm.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.out.println("Erro ao fechar conexões: " + e.getMessage());
            }
        }
    }


    public void pagarConta(int idConta) {

        String sqlBuscarConta = "SELECT valor, caixa_id, status FROM contas_pagar WHERE id = ?";
        String sqlAtualizarConta = "UPDATE contas_pagar SET status = 2 WHERE id = ?";
        String sqlAtualizarCaixa = "UPDATE caixa SET valor = valor - ? WHERE id = ?";

        Connection conn = null;
        PreparedStatement pstmBusca = null;
        PreparedStatement pstmConta = null;
        PreparedStatement pstmCaixa = null;
        ResultSet rs = null;

        try {
            conn = Conexao.conectar();
            conn.setAutoCommit(false);

            pstmBusca = conn.prepareStatement(sqlBuscarConta);
            pstmBusca.setInt(1, idConta);
            rs = pstmBusca.executeQuery();

            if (rs.next()) {

                int status = rs.getInt("status");

                if (status == 2) {
                    System.out.println("Esta conta já foi paga anteriormente!");
                    conn.rollback();
                    return;
                }

                double valorConta = rs.getDouble("valor");
                int idCaixa = rs.getInt("caixa_id");

                pstmConta = conn.prepareStatement(sqlAtualizarConta);
                pstmConta.setInt(1, idConta);
                pstmConta.execute();

                pstmCaixa = conn.prepareStatement(sqlAtualizarCaixa);
                pstmCaixa.setDouble(1, valorConta);
                pstmCaixa.setInt(2, idCaixa);
                pstmCaixa.execute();

                conn.commit();
                System.out.println("Conta paga com sucesso! Valor debitado do caixa.");

            } else {
                System.out.println("Conta a pagar não encontrada.");
                conn.rollback();
            }

        } catch (SQLException e) {
            try {
                if (conn != null) {
                    conn.rollback();
                    System.out.println("Erro na transação. Operação revertida!");
                }
            } catch (SQLException ex) {
                System.out.println("Erro ao reverter: " + ex.getMessage());
            }
            System.out.println("Erro ao processar pagamento: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmBusca != null) pstmBusca.close();
                if (pstmConta != null) pstmConta.close();
                if (pstmCaixa != null) pstmCaixa.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.out.println("Erro ao fechar conexões: " + e.getMessage());
            }
        }
    }


    public void editar(Contas_Pagar conta) {

        String sql = "UPDATE contas_pagar SET nome = ?, valor = ?, data_vencimento = ?, caixa_id = ?, pedido_compra_id = ? WHERE id = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = Conexao.conectar();
            pstm = conn.prepareStatement(sql);

            pstm.setString(1, conta.getNome());
            pstm.setDouble(2, conta.getValor());
            pstm.setString(3, conta.getData_vencimento());
            pstm.setInt(4, conta.getCaixa().getId());

            if (conta.getPedido_compra() != null) {
                pstm.setInt(5, conta.getPedido_compra().getId());
            } else {
                pstm.setNull(5, java.sql.Types.INTEGER);
            }

            pstm.setInt(6, conta.getId());

            pstm.execute();
            System.out.println("Conta a pagar editada com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao editar conta a pagar: " + e.getMessage());
        } finally {
            try {
                if (pstm != null) pstm.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.out.println("Erro ao fechar conexões: " + e.getMessage());
            }
        }
    }


    public List<Contas_Pagar> listar() {

        String sql = "SELECT cp.*, cx.nome AS nome_caixa FROM contas_pagar cp " +
                     "INNER JOIN caixa cx ON cp.caixa_id = cx.id";

        List<Contas_Pagar> lista = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            conn = Conexao.conectar();
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {

                Contas_Pagar cp = new Contas_Pagar();
                cp.setId(rs.getInt("id"));
                cp.setNome(rs.getString("nome"));
                cp.setValor(rs.getDouble("valor"));
                cp.setData_vencimento(rs.getString("data_vencimento"));
                cp.setStatus(rs.getInt("status"));

                Caixa cx = new Caixa();
                cx.setId(rs.getInt("caixa_id"));
                cx.setNome(rs.getString("nome_caixa"));
                cp.setCaixa(cx);

                int idPedido = rs.getInt("pedido_compra_id");
                if (idPedido > 0) {
                    Pedido_Compra pc = new Pedido_Compra();
                    pc.setId(idPedido);
                    cp.setPedido_compra(pc);
                }

                lista.add(cp);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar contas a pagar: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstm != null) pstm.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.out.println("Erro ao fechar conexões: " + e.getMessage());
            }
        }

        return lista;
    }


    public void deletar(Contas_Pagar conta) {

        String sql = "DELETE FROM contas_pagar WHERE id = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = Conexao.conectar();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, conta.getId());

            pstm.execute();
            System.out.println("Conta a pagar removida com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao deletar conta a pagar: " + e.getMessage());
        } finally {
            try {
                if (pstm != null) pstm.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.out.println("Erro ao fechar conexões: " + e.getMessage());
            }
        }
    }
}