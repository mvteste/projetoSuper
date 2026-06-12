/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Emanuel
 */
public class Contratos {
    
    private Cargo_Funcionario cargo_funcionario;
    private Funcionarios funcionario;
    private double salario;
    private String data_inicio;
    private String data_fim;

    public Contratos(Cargo_Funcionario cargo_funcionario, Funcionarios funcionario, double salario, String data_inicio, String data_fim) {
        this.cargo_funcionario = cargo_funcionario;
        this.funcionario = funcionario;
        this.salario = salario;
        this.data_inicio = data_inicio;
        this.data_fim = data_fim;
    }

    public Cargo_Funcionario getCargo_funcionario() {
        return cargo_funcionario;
    }

    public void setCargo_funcionario(Cargo_Funcionario cargo_funcionario) {
        this.cargo_funcionario = cargo_funcionario;
    }

    public Funcionarios getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionarios funcionario) {
        this.funcionario = funcionario;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getData_inicio() {
        return data_inicio;
    }

    public void setData_inicio(String data_inicio) {
        this.data_inicio = data_inicio;
    }

    public String getData_fim() {
        return data_fim;
    }

    public void setData_fim(String data_fim) {
        this.data_fim = data_fim;
    }

}
