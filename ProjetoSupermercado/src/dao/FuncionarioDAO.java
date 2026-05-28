package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class FuncionarioDAO {

    public static void main(String[] args) {
        //abre conexão com o banco
        Connection conn = Conexao.conectar();

        try {
            //Comando SQL para buscar todos os alunos
            String sql = "SELECT * FROM funcionarios";

            //prepara o comando SQL
            PreparedStatement stmt = conn.prepareStatement(sql);

            //executa a consulta
            ResultSet rs = stmt.executeQuery();

            //percorre cada registro retornado
            while (rs.next()) {
                //recupera os dados das colunas
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String cpf = rs.getString("cpf");

                //imprime no console.
                System.out.println(id + "-" + nome + "-" + cpf);
            }
            //fecha os recursos
            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}