package dao;

import model.ContasPagar;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContasPagarDAO {

    public List<ContasPagar> listar() {

        List<ContasPagar> lista = new ArrayList();

        try {

            Connection conn = Conexao.conectar();

            String sql = "SELECT * FROM contas_pagar";

            PreparedStatement stmt = conn.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                ContasPagar cp = new ContasPagar();

                lista.add(cp);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }
}