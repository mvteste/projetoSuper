package dao;

import model.TipoFuncionario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TipoFuncionarioDAO implements GenericDAO<TipoFuncionario> {


@Override
public List<TipoFuncionario> listar() {

    List<TipoFuncionario> lista = new ArrayList<>();

    try (Connection conn = Conexao.conectar()) {

        String sql = "SELECT * FROM tipo_funcionario";

        PreparedStatement stmt = conn.prepareStatement(sql);

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {

            TipoFuncionario tp = new TipoFuncionario();

            tp.setId(rs.getInt("id"));
            tp.setDesc(rs.getString("desc"));

            lista.add(tp);
        }

        rs.close();
        stmt.close();

    } catch (Exception e) {
        e.printStackTrace();
    }

    return lista;
}

@Override
public void inserir(TipoFuncionario tp) {

    try (Connection conn = Conexao.conectar()) {

        String sql = "INSERT INTO tipo_funcionario (descricao) VALUES (?)";

        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setString(1, tp.getDesc());

        stmt.execute();

        stmt.close();

    } catch (Exception e) {
        e.printStackTrace();
    }
}

@Override
public void atualizar(TipoFuncionario tp) {

    try (Connection conn = Conexao.conectar()) {

        String sql = "UPDATE tipo_funcionario SET descricao = ? WHERE id = ?";

        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setString(1, tp.getDesc());
        stmt.setInt(2, tp.getId());

        stmt.execute();

        stmt.close();

    } catch (Exception e) {
        e.printStackTrace();
    }
}

@Override
public void deletar(int id) {

    try (Connection conn = Conexao.conectar()) {

        String sql = "DELETE FROM tipo_funcionario WHERE id = ?";

        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setInt(1, id);

        stmt.execute();

        stmt.close();

    } catch (Exception e) {
        e.printStackTrace();
    }
}

@Override
public TipoFuncionario buscarPorId(int id) {

    TipoFuncionario tp = null;

    try (Connection conn = Conexao.conectar()) {

        String sql = "SELECT * FROM tipo_funcionario WHERE id = ?";

        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setInt(1, id);

        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {

            tp = new TipoFuncionario();

            tp.setId(rs.getInt("id"));
            tp.setDesc(rs.getString("desc"));
        }

        rs.close();
        stmt.close();

    } catch (Exception e) {
        e.printStackTrace();
    }

    return tp;
}


}
