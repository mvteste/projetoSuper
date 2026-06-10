package dao;

import model.ContasReceber;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContasReceberDAO {

    public List<ContasReceber> listar() {

        List<ContasReceber> lista = new ArrayList();

        try {

            Connection conn = Conexao.conectar();

            String sql = "SELECT * FROM contas_receber";

            PreparedStatement stmt = conn.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                ContasReceber cr = new ContasReceber();

                lista.add(cr);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }
}