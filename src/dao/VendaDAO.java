/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connection.Conexao;
import model.Venda;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VendaDAO implements GenericDAO<Venda> {
    
    
    @Override
    public void salvar(Venda entidade){
        System.out.println("Salvando");
        
    }
    
    @Override 
    public void atualizar(Venda entidade){
        System.out.println("Venda atualizada: " + entidade.getId());
    
    }
    
    @Override
    public void excluir(int id){
        System.out.println("Venda excluída" +id);
    
    }
    
    @Override 
    public Venda buscarPorId(int id){
        System.out.println("Buscando Venda ID: " + id);
        return null;
    
    }
    
    @Override 
    public List<Venda>listarTodos(){
        System.out.println("Listando Vendas:");
        return null;
    
    
    }
}
