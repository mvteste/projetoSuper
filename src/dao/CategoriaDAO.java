/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connection.Conexao;
import model.Categoria;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author GUSTAVOSCALEIMORAES
 */
public class CategoriaDAO implements GenericDAO<Categoria> {
    
    @Override
    public void salvar(Categoria entidade){
        System.out.println("Salvando");
        
    }
    
    @Override 
    public void atualizar(Categoria entidade){
        System.out.println("Cliente atualizado: " + entidade.getNome());
    
    }
    
    @Override
    public void excluir(int id){
        System.out.println("Cliente excluído" +id);
    
    }
    
    @Override 
    public Categoria buscarPorId(int id){
        System.out.println("Buscando cliente ID: " + id);
        return null;
    
    }
    
    @Override 
    public List<Categoria>listarTodos(){
        System.out.println("Listando Clientes:");
        return null;
    
    
    }
}
