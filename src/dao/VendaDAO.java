package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Venda;

public class VendaDAO implements GenericDAO<Venda> {


@Override
public List<Venda> listar() {

    List<Venda> lista = new ArrayList<>();

    try (Connection conn = Conexao.conectar()) {

        String sql = "SELECT * FROM venda";

        PreparedStatement stmt = conn.prepareStatement(sql);

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {

            Venda v = new Venda();

            v.setId(rs.getInt("id"));
            v.setData_venda(rs.getString("data_venda"));
            v.setValorTotal(rs.getFloat("valor_total"));
            v.setId_funcionario(rs.getInt("id_funcionario"));
            v.setStatus(rs.getString("status"));
            v.setId_cliente(rs.getInt("id_cliente"));

            lista.add(v);
        }

        rs.close();
        stmt.close();

    } catch (Exception e) {
        e.printStackTrace();
    }

    return lista;
}

@Override
public void inserir(Venda v) {

    try (Connection conn = Conexao.conectar()) {

        String sql = "INSERT INTO venda (data_venda, valor_total, id_funcionario, status, id_cliente) VALUES (?, ?, ?, ?, ?)";

        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setString(1, v.getData_venda());
        stmt.setFloat(2, v.getValorTotal());
        stmt.setInt(3, v.getId_funcionario());
        stmt.setString(4, v.getStatus());
        stmt.setInt(5, v.getId_cliente());

        stmt.execute();

        stmt.close();

    } catch (Exception e) {
        e.printStackTrace();
    }
}

@Override
public void atualizar(Venda v) {

    try (Connection conn = Conexao.conectar()) {

        String sql = "UPDATE venda SET data_venda=?, valor_total=?, id_funcionario=?, status=?, id_cliente=? WHERE id=?";

        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setString(1, v.getData_venda());
        stmt.setFloat(2, v.getValorTotal());
        stmt.setInt(3, v.getId_funcionario());
        stmt.setString(4, v.getStatus());
        stmt.setInt(5, v.getId_cliente());
        stmt.setInt(6, v.getId());

        stmt.execute();

        stmt.close();

    } catch (Exception e) {
        e.printStackTrace();
    }
}

@Override
public void deletar(int id) {

    try (Connection conn = Conexao.conectar()) {

        String sql = "DELETE FROM venda WHERE id = ?";

        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setInt(1, id);

        stmt.execute();

        stmt.close();

    } catch (Exception e) {
        e.printStackTrace();
    }
}

@Override
public Venda buscarPorId(int id) {

    Venda v = null;

    try (Connection conn = Conexao.conectar()) {

        String sql = "SELECT * FROM venda WHERE id = ?";

        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setInt(1, id);

        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {

            v = new Venda();

            v.setId(rs.getInt("id"));
            v.setData_venda(rs.getString("data_venda"));
            v.setValorTotal(rs.getFloat("valor_total"));
            v.setId_funcionario(rs.getInt("id_funcionario"));
            v.setStatus(rs.getString("status"));
            v.setId_cliente(rs.getInt("id_cliente"));
        }

        rs.close();
        stmt.close();

    } catch (Exception e) {
        e.printStackTrace();
    }

    return v;
}


}
