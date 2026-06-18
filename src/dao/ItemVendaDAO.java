package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.ItemVenda;

public class ItemVendaDAO implements GenericDAO<ItemVenda> {


@Override
public List<ItemVenda> listar() {

    List<ItemVenda> lista = new ArrayList<>();

    try (Connection conn = Conexao.conectar()) {

        String sql = "SELECT * FROM item_venda";

        PreparedStatement stmt = conn.prepareStatement(sql);

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {

            ItemVenda iv = new ItemVenda();

            iv.setId(rs.getInt("id"));
            iv.setId_produto(rs.getInt("id_produto"));
            iv.setId_venda(rs.getInt("id_venda"));
            iv.setQuantidade(rs.getInt("quantidade"));

            lista.add(iv);
        }

        rs.close();
        stmt.close();

    } catch (Exception e) {
        e.printStackTrace();
    }

    return lista;
}

@Override
public void inserir(ItemVenda iv) {

    try (Connection conn = Conexao.conectar()) {

        String sql = "INSERT INTO item_venda (id_produto, quantidade, id_venda) VALUES (?, ?, ?)";

        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setInt(1, iv.getId_produto());
        stmt.setInt(2, iv.getQuantidade());
        stmt.setInt(3, iv.getId_venda());

        stmt.execute();

        stmt.close();

    } catch (Exception e) {
        e.printStackTrace();
    }
}

@Override
public void atualizar(ItemVenda iv) {

    try (Connection conn = Conexao.conectar()) {

        String sql = "UPDATE item_venda SET id_produto=?, quantidade=?, id_venda=? WHERE id=?";

        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setInt(1, iv.getId_produto());
        stmt.setInt(2, iv.getQuantidade());
        stmt.setInt(3, iv.getId_venda());
        stmt.setInt(4, iv.getId());

        stmt.execute();

        stmt.close();

    } catch (Exception e) {
        e.printStackTrace();
    }
}

@Override
public void deletar(int id) {

    try (Connection conn = Conexao.conectar()) {

        String sql = "DELETE FROM item_venda WHERE id = ?";

        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setInt(1, id);

        stmt.execute();

        stmt.close();

    } catch (Exception e) {
        e.printStackTrace();
    }
}

@Override
public ItemVenda buscarPorId(int id) {

    ItemVenda iv = null;

    try (Connection conn = Conexao.conectar()) {

        String sql = "SELECT * FROM item_venda WHERE id = ?";

        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setInt(1, id);

        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {

            iv = new ItemVenda();

            iv.setId(rs.getInt("id"));
            iv.setId_produto(rs.getInt("id_produto"));
            iv.setId_venda(rs.getInt("id_venda"));
            iv.setQuantidade(rs.getInt("quantidade"));
        }

        rs.close();
        stmt.close();

    } catch (Exception e) {
        e.printStackTrace();
    }

    return iv;
}


}
