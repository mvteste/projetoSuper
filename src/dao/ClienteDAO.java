package dao;

import connection.Conexao;
import model.Cliente;
import java.sql.*;
import java.util.List;

public class ClienteDAO implements GenericDAO<Cliente>{

        public void inserir(Cliente c){

            try(Connection conn = Conexao.conectar()){

                String sql = """
                    INSERT INTO cliente
                    (nome, data_nascimento, cpf)
                    VALUES (?, ?, ?)
                    """;

                PreparedStatement stmt =
                        conn.prepareStatement(sql);

                stmt.setString(1, c.getNome());
                stmt.setDate(2, c.getData_Nascimento());
                stmt.setString(3, c.getCpf());

                stmt.executeUpdate();

                System.out.println("Cliente cadastrado!");

            }catch(Exception e){
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