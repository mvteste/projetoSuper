package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author Emanuel
 */
public class EstoqueDAO {

    // Método chamado quando um pedido de COMPRA é realizado (Aumenta o estoque)
    public void aumentarEstoque(Connection conn, int idProduto, int quantidadeSomar) throws Exception {
        String sql = "UPDATE estoque SET quantidade = quantidade + ? WHERE produtos_id = ?";
        
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, quantidadeSomar);
            stmt.setInt(2, idProduto);
            stmt.executeUpdate();
            System.out.println("Estoque do produto ID " + idProduto + " aumentado em " + quantidadeSomar + " unidades.");
        }
    }

    // Método chamado quando uma VENDA é realizada (Diminui o estoque)
    public void diminuirEstoque(Connection conn, int idProduto, int quantidadeSubtrair) throws Exception {
        String sql = "UPDATE estoque SET quantidade = quantidade - ? WHERE produtos_id = ?";
        
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, quantidadeSubtrair);
            stmt.setInt(2, idProduto);
            stmt.executeUpdate();
            System.out.println("Estoque do produto ID " + idProduto + " reduzido em " + quantidadeSubtrair + " unidades.");
        }
    }
    // Método para o "case 1" do menu: Listar o saldo de todos os produtos
    public java.util.List<model.Estoque> listarTudo() {
        java.util.List<model.Estoque> lista = new java.util.ArrayList<>();
        String sql = "SELECT * FROM estoque";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             java.sql.ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                model.Estoque est = new model.Estoque();
                est.setId(rs.getInt("id"));
                est.setQuantidade(rs.getInt("quantidade"));

                model.Produtos prod = new model.Produtos();
                prod.setId(rs.getInt("produtos_id"));
                est.setProdutos(prod);

                lista.add(est);
            }

        } catch (Exception e) {
            System.out.println("Erro ao listar dados do estoque.");
            e.printStackTrace();
        }
        return lista;
    }

    // Método para o "case 2" do menu: Sobrescreve a quantidade atual por uma nova
    public void ajustarQuantidadeManual(int idProduto, int novaQuantidade) {
        String sql = "UPDATE estoque SET quantidade = ? WHERE produtos_id = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, novaQuantidade);
            stmt.setInt(2, idProduto);
            
            int linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("Estoque ajustado manualmente com sucesso!");
            } else {
                System.out.println("Aviso: Produto ID " + idProduto + " não encontrado na tabela estoque.");
            }

        } catch (Exception e) {
            System.out.println("Erro ao ajustar o estoque manualmente.");
            e.printStackTrace();
        }
    }
}