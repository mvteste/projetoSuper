package dao;

import model.ContratoTrab;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContratoTrabDAO implements GenericDAO<ContratoTrab> {


@Override
public List<ContratoTrab> listar() {

    List<ContratoTrab> lista = new ArrayList<>();

    try (Connection conn = Conexao.conectar()) {

        String sql = "SELECT * FROM ContratoTrab";

        PreparedStatement stmt = conn.prepareStatement(sql);

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {

            ContratoTrab ct = new ContratoTrab();

            ct.setId(rs.getInt("id"));
            ct.setCargo(rs.getString("cargo"));
            ct.setSalario(rs.getFloat("salario"));
            ct.setData_inicio(rs.getString("data_inicio"));
            ct.setData_fim(rs.getString("data_fim"));
            ct.setTipo_contrato(rs.getString("tipo_contrato"));
            ct.setId_funcionario(rs.getInt("funcionario_id"));

            lista.add(ct);
        }

        rs.close();
        stmt.close();

    } catch (Exception e) {
        e.printStackTrace();
    }

    return lista;
}

@Override
public void inserir(ContratoTrab ct) {

    try (Connection conn = Conexao.conectar()) {

        String sql = "INSERT INTO ContratoTrab (cargo, salario, data_inicio, data_fim, tipo_contrato, funcionario_id) VALUES (?, ?, ?, ?, ?, ?)";

        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setString(1, ct.getCargo());
        stmt.setFloat(2, ct.getSalario());
        stmt.setString(3, ct.getData_inicio());
        stmt.setString(4, ct.getData_fim());
        stmt.setString(5, ct.getTipo_contrato());
        stmt.setInt(6, ct.getId_funcionario());

        stmt.execute();

        stmt.close();

    } catch (Exception e) {
        e.printStackTrace();
    }
}

@Override
public void atualizar(ContratoTrab ct) {

    try (Connection conn = Conexao.conectar()) {

        String sql = "UPDATE ContratoTrab SET cargo=?, salario=?, data_inicio=?, data_fim=?, tipo_contrato=?, funcionario_id=? WHERE id=?";

        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setString(1, ct.getCargo());
        stmt.setFloat(2, ct.getSalario());
        stmt.setString(3, ct.getData_inicio());
        stmt.setString(4, ct.getData_fim());
        stmt.setString(5, ct.getTipo_contrato());
        stmt.setInt(6, ct.getId_funcionario());
        stmt.setInt(7, ct.getId());

        stmt.execute();

        stmt.close();

    } catch (Exception e) {
        e.printStackTrace();
    }
}

@Override
public void deletar(int id) {

    try (Connection conn = Conexao.conectar()) {

        String sql = "DELETE FROM ContratoTrab WHERE id = ?";

        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setInt(1, id);

        stmt.execute();

        stmt.close();

    } catch (Exception e) {
        e.printStackTrace();
    }
}

@Override
public ContratoTrab buscarPorId(int id) {

    ContratoTrab ct = null;

    try (Connection conn = Conexao.conectar()) {

        String sql = "SELECT * FROM ContratoTrab WHERE id = ?";

        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setInt(1, id);

        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {

            ct = new ContratoTrab();

            ct.setId(rs.getInt("id"));
            ct.setCargo(rs.getString("cargo"));
            ct.setSalario(rs.getFloat("salario"));
            ct.setData_inicio(rs.getString("data_inicio"));
            ct.setData_fim(rs.getString("data_fim"));
            ct.setTipo_contrato(rs.getString("tipo_contrato"));
            ct.setId_funcionario(rs.getInt("funcionario_id"));
        }

        rs.close();
        stmt.close();

    } catch (Exception e) {
        e.printStackTrace();
    }

    return ct;
}


}
