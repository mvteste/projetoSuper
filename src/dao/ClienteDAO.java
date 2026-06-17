package dao;

import connection.Conexao;
import model.Cliente;
import java.sql.*;
import java.util.List;

public class ClienteDAO implements GenericDAO<Cliente>{

    public void inserir(Cliente c){
        try(Connection conn = Conexao.conectar()){

        // O SQL deve conter todas as colunas que correspondem ao seu modelo Cliente
        String sql = """
            INSERT INTO cliente
            (nome, data_nascimento, cpf, telefone, endereco)
            VALUES (?, ?, ?, ?, ?)
            """;

        PreparedStatement stmt = conn.prepareStatement(sql);

        // Abaixo, configuramos EXATAMENTE 5 valores:
        stmt.setString(1, c.getNome());
        
        if (c.getData_Nascimento() != null) {
            java.sql.Date dataSql = new java.sql.Date(c.getData_Nascimento().getTime());
            stmt.setDate(2, dataSql);
        } else {
            stmt.setNull(2, java.sql.Types.DATE);
        }

        stmt.setString(3, c.getCpf());
        stmt.setString(4, c.getTelefone());
        stmt.setString(5, c.getEndereco());

        stmt.executeUpdate();

    } catch (java.sql.SQLIntegrityConstraintViolationException e) {
        javax.swing.JOptionPane.showMessageDialog(null, "Erro: Este CPF já está cadastrado no sistema!");
    } catch(Exception e){
        e.printStackTrace();
    }
}

    @Override
    public void salvar(Cliente entidade){
        inserir(entidade);
    }

    @Override
    public void atualizar(Cliente entidade){
        System.out.println("Cliente atualizado: " + entidade.getNome());
    }

    @Override
    public void excluir(int id){
        System.out.println("Cliente excluído " + id);
    }

    @Override
    public Cliente buscarPorId(int id){
        System.out.println("Buscando cliente ID: " + id);
        return null;
    }

    @Override
    public List<Cliente> listarTodos(){
        System.out.println("Listando Clientes:");
        return null;
    }
}