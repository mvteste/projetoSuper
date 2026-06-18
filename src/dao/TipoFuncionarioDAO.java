package dao;

import model.TipoFuncionario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Categoria;


public class TipoFuncionarioDAO implements GenericDAO<TipoFuncionario>{
    
    @Override
    public void salvar(TipoFuncionario tipofuncionario){
        String sql = "INSERT INTO tipo_funcionario (descricao) VALUES (?)";
        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, tipofuncionario.getNome());
            stmt.executeUpdate();
            System.out.println("Acessou Salvar Tipo Funcionario");                    
        }catch (SQLException e){
                System.err.println("Erro ao salvar tipo Funcionario " + e.getMessage());                
        }
    }
    
    @Override
    public void atualizar(TipoFuncionario entidade){
    
    }
    
    @Override        
    public void excluir (int id){
    }
    
    @Override
    public TipoFuncionario buscarPorId(int id){
        System.out.println("Buscando Tipo Funcionario ID: " + id);
        return null;
    
    }
    
    @Override
    public List<TipoFuncionario> listarTodos(){
        String sql = "SELECT id, desricao FROM tipo_funcionario ORDER BY id";        
        List<TipoFuncionario> lista = new ArrayList<>();
           // O try-with-resources garante que os recursos sejam fechados automaticamente
    try (Connection conn = Conexao.conectar();
         PreparedStatement stmt = conn.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {

        while (rs.next()) {
            TipoFuncionario tpf = new TipoFuncionario();
            tpf.setId(rs.getInt("id"));
            tpf.setNome(rs.getString("descricao"));
            
            lista.add(tpf);
        }

    } catch (SQLException e) {
        // Log de erro técnico para o desenvolvedor
        System.err.println("Erro ao listar categorias: " + e.getMessage());
        // Opcional: relançar uma exceção personalizada ou retornar lista vazia
    }

    return lista;
    }
    
}
