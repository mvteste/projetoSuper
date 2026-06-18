package dao;

import model.ContasPagar;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContasPagarDAO implements GenericDAO<ContasPagar> {

@Override
public List<ContasPagar> listar() {

    List<ContasPagar> lista = new ArrayList<>();

    try (Connection conn = Conexao.conectar()) {

        String sql = "SELECT * FROM contas_pagar";

        PreparedStatement stmt = conn.prepareStatement(sql);

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {

            ContasPagar cp = new ContasPagar();

            cp.setId(rs.getInt("id"));
            cp.setId_fornecedor(rs.getInt("id_fornecedor"));
            cp.setData(rs.getString("data"));
            cp.setStatus(rs.getString("status"));
            cp.setValor(rs.getFloat("valor"));

            lista.add(cp);
        }

        rs.close();
        stmt.close();

    } catch (Exception e) {
        e.printStackTrace();
    }

    return lista;
}

@Override
public void inserir(ContasPagar cp) {

    try (Connection conn = Conexao.conectar()) {

        String sql = "INSERT INTO contas_pagar (data, status, valor, id_fornecedor) VALUES (?, ?, ?, ?)";

        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setString(1, cp.getData());
        stmt.setString(2, cp.getStatus());
        stmt.setFloat(3, cp.getValor());
        stmt.setInt(4, cp.getId_fornecedor());

        stmt.execute();

        stmt.close();

    } catch (Exception e) {
        e.printStackTrace();
    }
}

@Override
public void atualizar(ContasPagar cp) {

    try (Connection conn = Conexao.conectar()) {

        String sql = "UPDATE contas_pagar SET data=?, status=?, valor=?, id_fornecedor=? WHERE id=?";

        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setString(1, cp.getData());
        stmt.setString(2, cp.getStatus());
        stmt.setFloat(3, cp.getValor());
        stmt.setInt(4, cp.getId_fornecedor());
        stmt.setInt(5, cp.getId());

        stmt.execute();

        stmt.close();

    } catch (Exception e) {
        e.printStackTrace();
    }
}

@Override
public void deletar(int id) {

    try (Connection conn = Conexao.conectar()) {

        String sql = "DELETE FROM contas_pagar WHERE id = ?";

        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setInt(1, id);

        stmt.execute();

        stmt.close();

    } catch (Exception e) {
        e.printStackTrace();
    }
}

@Override
public ContasPagar buscarPorId(int id) {

    ContasPagar cp = null;

    try (Connection conn = Conexao.conectar()) {

        String sql = "SELECT * FROM contas_pagar WHERE id = ?";

        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setInt(1, id);

        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {

            cp = new ContasPagar();

            cp.setId(rs.getInt("id"));
            cp.setId_fornecedor(rs.getInt("id_fornecedor"));
            cp.setData(rs.getString("data"));
            cp.setStatus(rs.getString("status"));
            cp.setValor(rs.getFloat("valor"));
        }

        rs.close();
        stmt.close();

    } catch (Exception e) {
        e.printStackTrace();
    }

    return cp;
}

}
