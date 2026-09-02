/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Emanuel
 */
public class Funcionarios {
    
    private int id;
    private String nome;
    private String cpf;
    private String telefone;
    private String email;
    private String endereco;
    private String data_admissao;
    private String data_nascimento;
    private int status;
    private Cargo_Funcionario cargo_funcionario;

    public Funcionarios(int id, String nome, String cpf, String telefone, String email, String endereco, String data_admissao, String data_nascimento, int status, Cargo_Funcionario cargo_funcionario) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
        this.data_admissao = data_admissao;
        this.data_nascimento = data_nascimento;
        this.status = status;
        this.cargo_funcionario = cargo_funcionario;
    }

    public Funcionarios() {
        
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getData_admissao() {
        return data_admissao;
    }

    public void setData_admissao(String data_admissao) {
        this.data_admissao = data_admissao;
    }

    public String getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(String data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Cargo_Funcionario getCargo_funcionario() {
        return cargo_funcionario;
    }

    public void setCargo_funcionario(Cargo_Funcionario cargo_funcionario) {
        this.cargo_funcionario = cargo_funcionario;
    }
     
}
