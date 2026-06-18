package dao;

import model.Pagamento;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PagamentoDAO implements GenericDAO<Pagamento> {


@Override
public List<Pagamento> listar() {

    List<Pagamento> lista = new ArrayList<>();

    try (Connection conn = Conexao.conectar()) {

        String sql = "SELECT * FROM pagamento";

        PreparedStatement stmt = conn.prepareStatement(sql);

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {

            Pagamento p = new Pagamento();

            p.setId(rs.getInt("id"));
            p.setForma_pagamento(rs.getString("forma_pagamento"));
            p.setId_venda(rs.getInt("id_venda"));
            p.setValor(rs.getFloat("valor"));

            lista.add(p);
        }

        rs.close();
        stmt.close();

    } catch (Exception e) {
        e.printStackTrace();
    }

    return lista;
}

@Override
public void inserir(Pagamento p) {

    try (Connection conn = Conexao.conectar()) {

        String sql = "INSERT INTO pagamento (forma_pagamento, id_venda, valor) VALUES (?, ?, ?)";

        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setString(1, p.getForma_pagamento());
        stmt.setInt(2, p.getId_venda());
        stmt.setFloat(3, p.getValor());

        stmt.execute();

        stmt.close();

    } catch (Exception e) {
        e.printStackTrace();
    }
}

@Override
public void atualizar(Pagamento p) {

    try (Connection conn = Conexao.conectar()) {

        String sql = "UPDATE pagamento SET forma_pagamento=?, id_venda=?, valor=? WHERE id=?";

        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setString(1, p.getForma_pagamento());
        stmt.setInt(2, p.getId_venda());
        stmt.setFloat(3, p.getValor());
        stmt.setInt(4, p.getId());

        stmt.execute();

        stmt.close();

    } catch (Exception e) {
        e.printStackTrace();
    }
}

@Override
public void deletar(int id) {

    try (Connection conn = Conexao.conectar()) {

        String sql = "DELETE FROM pagamento WHERE id = ?";

        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setInt(1, id);

        stmt.execute();

        stmt.close();

    } catch (Exception e) {
        e.printStackTrace();
    }
}

@Override
public Pagamento buscarPorId(int id) {

    Pagamento p = null;

    try (Connection conn = Conexao.conectar()) {

        String sql = "SELECT * FROM pagamento WHERE id = ?";

        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setInt(1, id);

        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {

            p = new Pagamento();

            p.setId(rs.getInt("id"));
            p.setForma_pagamento(rs.getString("forma_pagamento"));
            p.setId_venda(rs.getInt("id_venda"));
            p.setValor(rs.getFloat("valor"));
        }

        rs.close();
        stmt.close();

    } catch (Exception e) {
        e.printStackTrace();
    }

    return p;
}


}
