package dao;

import model.Produto;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO implements GenericDAO<Produto> {


@Override
public List<Produto> listar() {

    List<Produto> lista = new ArrayList<>();

    try (Connection conn = Conexao.conectar()) {

        String sql = "SELECT * FROM produto";

        PreparedStatement stmt = conn.prepareStatement(sql);

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {

            Produto p = new Produto();

            p.setId(rs.getInt("id"));
            p.setNome(rs.getString("nome"));
            p.setPreco(rs.getFloat("preco"));
            p.setId_categoria(rs.getInt("id_categoria"));
            p.setId_fornecedor(rs.getInt("id_fornecedor"));
            p.setMarca(rs.getString("marca"));
            p.setCodigo_barras(rs.getInt("codigo_barras"));
            p.setDescricao(rs.getString("descricao"));

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
public void inserir(Produto p) {

    try (Connection conn = Conexao.conectar()) {

        String sql = "INSERT INTO produto (nome, preco, id_categoria, id_fornecedor, marca, codigo_barras, descricao) VALUES (?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setString(1, p.getNome());
        stmt.setFloat(2, p.getPreco());
        stmt.setInt(3, p.getId_categoria());
        stmt.setInt(4, p.getId_fornecedor());
        stmt.setString(5, p.getMarca());
        stmt.setInt(6, p.getCodigo_barras());
        stmt.setString(7, p.getDescricao());

        stmt.execute();

        stmt.close();

    } catch (Exception e) {
        e.printStackTrace();
    }
}

@Override
public void atualizar(Produto p) {

    try (Connection conn = Conexao.conectar()) {

        String sql = "UPDATE produto SET nome=?, preco=?, id_categoria=?, id_fornecedor=?, marca=?, codigo_barras=?, descricao=? WHERE id=?";

        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setString(1, p.getNome());
        stmt.setFloat(2, p.getPreco());
        stmt.setInt(3, p.getId_categoria());
        stmt.setInt(4, p.getId_fornecedor());
        stmt.setString(5, p.getMarca());
        stmt.setInt(6, p.getCodigo_barras());
        stmt.setString(7, p.getDescricao());
        stmt.setInt(8, p.getId());

        stmt.execute();

        stmt.close();

    } catch (Exception e) {
        e.printStackTrace();
    }
}

@Override
public void deletar(int id) {

    try (Connection conn = Conexao.conectar()) {

        String sql = "DELETE FROM produto WHERE id = ?";

        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setInt(1, id);

        stmt.execute();

        stmt.close();

    } catch (Exception e) {
        e.printStackTrace();
    }
}

@Override
public Produto buscarPorId(int id) {

    Produto p = null;

    try (Connection conn = Conexao.conectar()) {

        String sql = "SELECT * FROM produto WHERE id = ?";

        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setInt(1, id);

        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {

            p = new Produto();

            p.setId(rs.getInt("id"));
            p.setNome(rs.getString("nome"));
            p.setPreco(rs.getFloat("preco"));
            p.setId_categoria(rs.getInt("id_categoria"));
            p.setId_fornecedor(rs.getInt("id_fornecedor"));
            p.setMarca(rs.getString("marca"));
            p.setCodigo_barras(rs.getInt("codigo_barras"));
            p.setDescricao(rs.getString("descricao"));
        }

        rs.close();
        stmt.close();

    } catch (Exception e) {
        e.printStackTrace();
    }

    return p;
}


}
