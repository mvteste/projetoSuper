package dao;

import model.Estoque;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EstoqueDAO implements GenericDAO<Estoque> {


@Override
public List<Estoque> listar() {

    List<Estoque> lista = new ArrayList<>();

    try (Connection conn = Conexao.conectar()) {

        String sql = "SELECT * FROM estoque";

        PreparedStatement stmt = conn.prepareStatement(sql);

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {

            Estoque e = new Estoque();

            e.setId(rs.getInt("id"));
            e.setQuantidade(rs.getInt("quantidade"));
            e.setProduto_id(rs.getInt("produto_id"));
            e.setData_validade(rs.getString("data_validade"));
            e.setLote(rs.getString("lote"));

            lista.add(e);
        }

        rs.close();
        stmt.close();

    } catch (Exception ex) {
        ex.printStackTrace();
    }

    return lista;
}

@Override
public void inserir(Estoque e) {

    try (Connection conn = Conexao.conectar()) {

        String sql = "INSERT INTO estoque (quantidade, produto_id, data_validade, lote) VALUES (?, ?, ?, ?)";

        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setInt(1, e.getQuantidade());
        stmt.setInt(2, e.getProduto_id());
        stmt.setString(3, e.getData_validade());
        stmt.setString(4, e.getLote());

        stmt.execute();

        stmt.close();

    } catch (Exception ex) {
        ex.printStackTrace();
    }
}

@Override
public void atualizar(Estoque e) {

    try (Connection conn = Conexao.conectar()) {

        String sql = "UPDATE estoque SET quantidade=?, produto_id=?, data_validade=?, lote=? WHERE id=?";

        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setInt(1, e.getQuantidade());
        stmt.setInt(2, e.getProduto_id());
        stmt.setString(3, e.getData_validade());
        stmt.setString(4, e.getLote());
        stmt.setInt(5, e.getId());

        stmt.execute();

        stmt.close();

    } catch (Exception ex) {
        ex.printStackTrace();
    }
}

@Override
public void deletar(int id) {

    try (Connection conn = Conexao.conectar()) {

        String sql = "DELETE FROM estoque WHERE id = ?";

        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setInt(1, id);

        stmt.execute();

        stmt.close();

    } catch (Exception ex) {
        ex.printStackTrace();
    }
}

@Override
public Estoque buscarPorId(int id) {

    Estoque e = null;

    try (Connection conn = Conexao.conectar()) {

        String sql = "SELECT * FROM estoque WHERE id = ?";

        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setInt(1, id);

        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {

            e = new Estoque();

            e.setId(rs.getInt("id"));
            e.setQuantidade(rs.getInt("quantidade"));
            e.setProduto_id(rs.getInt("produto_id"));
            e.setData_validade(rs.getString("data_validade"));
            e.setLote(rs.getString("lote"));
        }

        rs.close();
        stmt.close();

    } catch (Exception ex) {
        ex.printStackTrace();
    }

    return e;
}


}
