package dao;

import model.Venda;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VendaDAO {

    public List<Venda> listar() {

        List<Venda> lista = new ArrayList();

        try {

            Connection conn = Conexao.conectar();

            String sql = "SELECT * FROM venda";

            PreparedStatement stmt = conn.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Venda v = new Venda();

                lista.add(v);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }
}