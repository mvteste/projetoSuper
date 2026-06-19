/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Professor
 */
public class ClienteRepositorio {
    private List<Clientes> clientes = new ArrayList<>();
    
    public boolean cpfExiste(String cpf){
        for(Clientes c : clientes){
            if(c.getCpf().equals(cpf))
                return true; //CPF Encontrado
        }
        return false; //CPF ñ encontrado
    }
    
    public void adicionar(Clientes c){
        clientes.add(c);
    }
    public List<Clientes> listar(){
        return clientes;
    }
}
