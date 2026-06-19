/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Professor
 */
public class AgendamentoRepositorio {
    private List<Agendamento> agendamentos = new ArrayList<>();
    
    public void adicionar(Agendamento a){
        agendamentos.add(a);
    }
    public List<Agendamento> Listar(){
        return agendamentos;
    }
    public boolean remover(int id){
        return agendamentos.removeIf(a -> a.getId() == id);
    }
    public boolean existeConflito(String data, String horario){
        for (Agendamento a : agendamentos){
            if(a.getData().equals(data) && 
                    a.getHorario().equals(horario)){
            return true;
        }
        }
        return false;
    }

   public List<Agendamento> listar() {
    return agendamentos;
}
}
