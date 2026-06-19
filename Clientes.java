/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Professor
 */
public class Clientes {

    private String nome;
    private String Nascimento;
    private String cpf;

    public Clientes(String nome, String nascimento, String cpf) {
        this.nome = nome;
        this.Nascimento = nascimento;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getNascimento() {
        return Nascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNascimento(String Nascimento) {
        this.Nascimento = Nascimento;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
