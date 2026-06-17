package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Caixa;

/**
 *
 * @author Emanuel
 */
public class CaixaDAO {

    public List<Caixa> listar() {
        List<Caixa> lista = new ArrayList<>();
        String sql = "SELECT * FROM caixa";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Caixa caixa = new Caixa();
                caixa.setId(rs.getInt("id"));
                caixa.setNome(rs.getString("nome"));
                caixa.setValor(rs.getDouble("valor"));

                lista.add(caixa);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    public void inserir(Caixa caixa) {
        String sql = "INSERT INTO caixa (nome, valor) VALUES (?, ?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, caixa.getNome());
            stmt.setDouble(2, caixa.getValor());

            stmt.execute();
            System.out.println("Caixa registrado com sucesso!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void editar(Caixa caixa) {
        String sql = "UPDATE caixa SET nome = ?, valor = ? WHERE id = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, caixa.getNome());
            stmt.setDouble(2, caixa.getValor());
            stmt.setInt(3, caixa.getId());

            stmt.executeUpdate();
            System.out.println("Caixa atualizado com sucesso!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deletar(Caixa caixa) {
        String sql = "DELETE FROM caixa WHERE id = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, caixa.getId());

            stmt.executeUpdate();
            System.out.println("Caixa removido com sucesso!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}