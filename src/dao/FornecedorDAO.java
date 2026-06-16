/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.List;
import model.Cliente;
import model.Fornecedor;

/**
 *
 * @author GUSTAVOSCALEIMORAES
 */
public class FornecedorDAO implements GenericDAO<Fornecedor>{
    
    @Override
    public void salvar(Fornecedor entidade){
        System.out.println("Salvando");
        
    }
    
    @Override 
    public void atualizar(Fornecedor entidade){
        System.out.println("Fornecedor atualizado: " + entidade.getNome());
    
    }
    
    
    public void excluir(int id){
        System.out.println("Fornecedor excluído" + id);
    
    }
    
    @Override 
    public Fornecedor buscarPorId(int id){
        System.out.println("Buscando Fornecedores ID: " + id);
        return null;
    
    }
    
    @Override 
    public List<Fornecedor>listarTodos(){
        System.out.println("Listando Fornecedores:");
        return null;
    
    
    }

 

    
}
