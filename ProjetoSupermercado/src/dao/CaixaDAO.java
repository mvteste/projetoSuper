package dao;

import model.Caixa;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CaixaDAO {

    public List<Caixa> listar() {

        List<Caixa> lista = new ArrayList();

        try {

            Connection conn = Conexao.conectar();

            String sql = "SELECT * FROM caixa";

            PreparedStatement stmt = conn.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Caixa c = new Caixa();

                lista.add(c);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }
}