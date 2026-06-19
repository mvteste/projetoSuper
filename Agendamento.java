/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Professor
 */
public class Agendamento {
    private static int contadorID = 1;
    
    private int id;
    private Clientes cliente;
    private String data;
    private String horario;
    private String servico;
    private String status;
    
    public Agendamento(Clientes cliente, String data, String horario, String servico){
        this.id = contadorID++;
        this.cliente = cliente;
        this.data = data;
        this.horario = horario;
        this.servico = servico;
        this.status = "Pendente";
    }

    public static int getContadorID() {return contadorID;}
    public int getId() {return id;}
    public Clientes getCliente() {return cliente;}
    public String getData() {return data;}
    public String getHorario() {return horario;}
    public String getServico() {return servico;}
    public String getStatus() {return status;}
    
    
    //seters

    public void setStatus(String status) {this.status = status;}
    
}

