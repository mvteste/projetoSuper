package dao;

import model.Funcionario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO implements GenericDAO<Funcionario> {


@Override
public List<Funcionario> listar() {

    List<Funcionario> lista = new ArrayList<>();

    try (Connection conn = Conexao.conectar()) {

        String sql = "SELECT * FROM funcionario";

        PreparedStatement stmt = conn.prepareStatement(sql);

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {

            Funcionario f = new Funcionario();

            f.setId(rs.getInt("id"));
            f.setNome(rs.getString("nome"));
            f.setTelefone(rs.getString("telefone"));
            f.setData_nascimento(rs.getString("data_nascimento"));
            f.setId_tipoFuncionario(rs.getInt("tipo_funcionario_id"));

            lista.add(f);
        }

        rs.close();
        stmt.close();

    } catch (Exception e) {
        e.printStackTrace();
    }

    return lista;
}

@Override
public void inserir(Funcionario f) {

    try (Connection conn = Conexao.conectar()) {

        String sql = "INSERT INTO funcionario (nome, telefone, data_nascimento, tipo_funcionario_id) VALUES (?, ?, ?, ?)";

        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setString(1, f.getNome());
        stmt.setString(2, f.getTelefone());
        stmt.setString(3, f.getData_nascimento());
        stmt.setInt(4, f.getId_tipoFuncionario());

        stmt.execute();

        stmt.close();

    } catch (Exception e) {
        e.printStackTrace();
    }
}

@Override
public void atualizar(Funcionario f) {

    try (Connection conn = Conexao.conectar()) {

        String sql = "UPDATE funcionario SET nome=?, telefone=?, data_nascimento=?, tipo_funcionario_id=? WHERE id=?";

        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setString(1, f.getNome());
        stmt.setString(2, f.getTelefone());
        stmt.setString(3, f.getData_nascimento());
        stmt.setInt(4, f.getId_tipoFuncionario());
        stmt.setInt(5, f.getId());

        stmt.execute();

        stmt.close();

    } catch (Exception e) {
        e.printStackTrace();
    }
}

@Override
public void deletar(int id) {

    try (Connection conn = Conexao.conectar()) {

        String sql = "DELETE FROM funcionario WHERE id = ?";

        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setInt(1, id);

        stmt.execute();

        stmt.close();

    } catch (Exception e) {
        e.printStackTrace();
    }
}

@Override
public Funcionario buscarPorId(int id) {

    Funcionario f = null;

    try (Connection conn = Conexao.conectar()) {

        String sql = "SELECT * FROM funcionario WHERE id = ?";

        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setInt(1, id);

        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {

            f = new Funcionario();

            f.setId(rs.getInt("id"));
            f.setNome(rs.getString("nome"));
            f.setTelefone(rs.getString("telefone"));
            f.setData_nascimento(rs.getString("data_nascimento"));
            f.setId_tipoFuncionario(rs.getInt("tipo_funcionario_id"));
        }

        rs.close();
        stmt.close();

    } catch (Exception e) {
        e.printStackTrace();
    }

    return f;
}


}
