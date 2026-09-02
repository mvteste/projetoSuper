package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Contratos;
import model.Funcionarios;
import model.Cargo_Funcionario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Emanuel
 */
public class ContratosDAO {

    public List<Contratos> listar() {
        List<Contratos> lista = new ArrayList<>();

        // Buscando os dados do contrato trazendo junto os nomes para exibição simples no menu
        String sql = "SELECT con.*, f.nome AS nome_funcionario, c.nome AS nome_cargo " +
                     "FROM contratos con " +
                     "INNER JOIN funcionarios f ON con.funcionarios_id = f.id " +
                     "INNER JOIN cargo_funcionarios c ON con.cargo_funcionarios_id = c.id";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                // 1. Instancia e popula o Funcionário
                Funcionarios func = new Funcionarios();
                func.setId(rs.getInt("funcionarios_id"));
                func.setNome(rs.getString("nome_funcionario"));

                // 2. Instancia e popula o Cargo
                Cargo_Funcionario cargo = new Cargo_Funcionario();
                cargo.setId(rs.getInt("cargo_funcionarios_id"));
                cargo.setNome(rs.getString("nome_cargo"));

                // 3. Cria o objeto contrato com os dados completos
                Contratos contrato = new Contratos(
                    cargo,
                    func,
                    rs.getDouble("salario"),
                    rs.getString("data_inicio"),
                    rs.getString("data_fim")
                );

                lista.add(contrato);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

public void inserir(Contratos con) {
    String sql = "INSERT INTO contratos (cargo_funcionarios_id, funcionarios_id, salario, data_inicio, data_fim) VALUES (?, ?, ?, ?, ?)";

    try (Connection conn = Conexao.conectar();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setInt(1, con.getCargo_funcionario().getId());
        stmt.setInt(2, con.getFuncionario().getId());
        stmt.setDouble(3, con.getSalario());
        stmt.setString(4, con.getData_inicio());

        // SE A DATA FIM ESTIVER VAZIA OU NULA, GRAVA NULL NO BANCO
        if (con.getData_fim() == null || con.getData_fim().trim().isEmpty()) {
            stmt.setNull(5, java.sql.Types.DATE);
        } else {
            stmt.setString(5, con.getData_fim());
        }

        stmt.execute();
        System.out.println("Contrato registrado com sucesso!");

    } catch (Exception e) {
        e.printStackTrace();
    }
}

public void editar(Contratos con) {
    String sql = "UPDATE contratos SET salario = ?, data_inicio = ?, data_fim = ? WHERE cargo_funcionarios_id = ? AND funcionarios_id = ?";

    try (Connection conn = Conexao.conectar();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setDouble(1, con.getSalario());
        stmt.setString(2, con.getData_inicio());

        // SE A DATA FIM ESTIVER VAZIA OU NULA, GRAVA NULL NO BANCO
        if (con.getData_fim() == null || con.getData_fim().trim().isEmpty()) {
            stmt.setNull(3, java.sql.Types.DATE);
        } else {
            stmt.setString(3, con.getData_fim());
        }

        stmt.setInt(4, con.getCargo_funcionario().getId());
        stmt.setInt(5, con.getFuncionario().getId());

        stmt.executeUpdate();
        System.out.println("Contrato atualizado com sucesso!");

    } catch (Exception e) {
        e.printStackTrace();
    }
}

    public void deletar(Contratos con) {
        // Como não há campo status no seu diagrama para contratos, faremos a remoção física
        String sql = "DELETE FROM contratos WHERE cargo_funcionarios_id = ? AND funcionarios_id = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, con.getCargo_funcionario().getId());
            stmt.setInt(2, con.getFuncionario().getId());

            stmt.executeUpdate();
            System.out.println("Contrato removido com sucesso!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}