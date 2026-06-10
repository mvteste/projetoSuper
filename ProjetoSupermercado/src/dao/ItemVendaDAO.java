package dao;

import model.ItemVenda;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItemVendaDAO {

    public List<ItemVenda> listar() {

        List<ItemVenda> lista = new ArrayList();

        try {

            Connection conn = Conexao.conectar();

            String sql = "SELECT * FROM item_venda";

            PreparedStatement stmt = conn.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                ItemVenda iv = new ItemVenda();

                lista.add(iv);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }
}