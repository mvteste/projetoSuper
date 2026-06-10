package dao;

import model.Funcionario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO {

    public List<Funcionario> listar() {

        List<Funcionario> lista = new ArrayList();

        try {

            Connection conn = Conexao.conectar();

            String sql = "SELECT * FROM funcionario";

            PreparedStatement stmt = conn.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Funcionario f = new Funcionario();

                lista.add(f);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }
}