package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Cargo_Funcionario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Emanuel
 */
public class Cargo_FuncionarioDAO {

    public List<Cargo_Funcionario> listar() {
        List<Cargo_Funcionario> lista = new ArrayList<>();

        String sql = "SELECT * FROM cargo_funcionarios";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Cargo_Funcionario cargo = new Cargo_Funcionario(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("descricao")
                );
                lista.add(cargo);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    public void inserir(Cargo_Funcionario cargo) {
        String sql = "INSERT INTO cargo_funcionarios (nome, descricao) VALUES (?, ?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cargo.getNome());
            stmt.setString(2, cargo.getDescricao());

            stmt.execute();
            System.out.println("Cargo salvo com sucesso!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void editar(Cargo_Funcionario cargo) {
        String sql = "UPDATE cargo_funcionarios SET nome = ?, descricao = ? WHERE id = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cargo.getNome());
            stmt.setString(2, cargo.getDescricao());
            stmt.setInt(3, cargo.getId());

            stmt.executeUpdate();
            System.out.println("Cargo atualizado com sucesso!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deletar(Cargo_Funcionario cargo) {
        // Se sua tabela cargo_funcionarios não tiver uma coluna 'status', realizamos o DELETE físico:
        String sql = "DELETE FROM cargo_funcionarios WHERE id = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, cargo.getId());

            stmt.executeUpdate();
            System.out.println("Cargo removido com sucesso!");

        } catch (Exception e) {
            System.out.println("Erro ao remover cargo. Verifique se existem funcionários vinculados a ele.");
            e.printStackTrace();
        }
    }
}