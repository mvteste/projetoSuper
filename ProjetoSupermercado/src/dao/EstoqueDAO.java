package dao;

import model.Estoque;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EstoqueDAO {

    public List<Estoque> listar() {

        List<Estoque> lista = new ArrayList();

        try {

            Connection conn = Conexao.conectar();

            String sql = "SELECT * FROM estoque";

            PreparedStatement stmt = conn.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Estoque e = new Estoque();

                lista.add(e);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return lista;
    }
}