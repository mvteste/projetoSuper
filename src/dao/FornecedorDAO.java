package dao;

import model.Fornecedor;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FornecedorDAO implements GenericDAO<Fornecedor> {


@Override
public List<Fornecedor> listar() {

    List<Fornecedor> lista = new ArrayList<>();

    try (Connection conn = Conexao.conectar()) {

        String sql = "SELECT * FROM fornecedor";

        PreparedStatement stmt = conn.prepareStatement(sql);

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {

            Fornecedor f = new Fornecedor();

            f.setId(rs.getInt("id"));
            f.setNome(rs.getString("nome"));
            f.setCnpj(rs.getString("cnpj"));
            f.setTelefone(rs.getString("telefone"));
            f.setEmail(rs.getString("email"));

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
public void inserir(Fornecedor f) {

    try (Connection conn = Conexao.conectar()) {

        String sql = "INSERT INTO fornecedor (nome, cnpj, telefone, email) VALUES (?, ?, ?, ?)";

        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setString(1, f.getNome());
        stmt.setString(2, f.getCnpj());
        stmt.setString(3, f.getTelefone());
        stmt.setString(4, f.getEmail());

        stmt.execute();

        stmt.close();

    } catch (Exception e) {
        e.printStackTrace();
    }
}

@Override
public void atualizar(Fornecedor f) {

    try (Connection conn = Conexao.conectar()) {

        String sql = "UPDATE fornecedor SET nome=?, cnpj=?, telefone=?, email=? WHERE id=?";

        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setString(1, f.getNome());
        stmt.setString(2, f.getCnpj());
        stmt.setString(3, f.getTelefone());
        stmt.setString(4, f.getEmail());
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

        String sql = "DELETE FROM fornecedor WHERE id = ?";

        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setInt(1, id);

        stmt.execute();

        stmt.close();

    } catch (Exception e) {
        e.printStackTrace();
    }
}

@Override
public Fornecedor buscarPorId(int id) {

    Fornecedor f = null;

    try (Connection conn = Conexao.conectar()) {

        String sql = "SELECT * FROM fornecedor WHERE id = ?";

        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setInt(1, id);

        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {

            f = new Fornecedor();

            f.setId(rs.getInt("id"));
            f.setNome(rs.getString("nome"));
            f.setCnpj(rs.getString("cnpj"));
            f.setTelefone(rs.getString("telefone"));
            f.setEmail(rs.getString("email"));
        }

        rs.close();
        stmt.close();

    } catch (Exception e) {
        e.printStackTrace();
    }

    return f;
}


}
