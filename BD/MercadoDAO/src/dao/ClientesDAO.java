/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author Emanuel
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Clientes;
import java.util.ArrayList;
import java.util.List;

public class ClientesDAO {

    public List<Clientes> listar() {

        List<Clientes> lista = new ArrayList<>();

        try {
            Connection conn = Conexao.conectar();

            String sql = "SELECT * FROM clientes";

            PreparedStatement stmt = conn.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Clientes c = new Clientes();

                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setData_nascimento(rs.getString("data_nascimento"));
                c.setCpf(rs.getString("cpf"));
                c.setTelefone(rs.getString("telefone"));
                c.setStatus(rs.getInt("status"));

                lista.add(c);
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }

    public void inserir(Clientes c) {

        try (Connection conn = Conexao.conectar()) {

            String sql = "INSERT INTO clientes (nome, data_nascimento, cpf, telefone, status) VALUES (?, ?, ?, ?, 1)";

            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, c.getNome());
            stmt.setString(2, c.getData_nascimento());
            stmt.setString(3, c.getCpf());
            stmt.setString(4, c.getTelefone());

            stmt.execute();

            System.out.println("Cliente salvo com sucesso!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void editar(Clientes c) {

        try (Connection conn = Conexao.conectar()) {

            String sql = "UPDATE clientes SET nome = ?, data_nascimento = ?, cpf = ?, telefone = ? WHERE id = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, c.getNome());
            stmt.setString(2, c.getData_nascimento());
            stmt.setString(3, c.getCpf());
            stmt.setString(4, c.getTelefone());
            stmt.setInt(5, c.getId());

            stmt.executeUpdate();

            stmt.close();

            System.out.println("Cliente atualizado com sucesso!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void desativar(Clientes c) {

        try (Connection conn = Conexao.conectar()) {

            String sql = "UPDATE clientes SET status = 0 WHERE id = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, c.getId());

            stmt.executeUpdate();

            stmt.close();

            System.out.println("Cliente desativado com sucesso!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}