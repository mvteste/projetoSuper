package model;

import java.util.Date;

public class Funcionario {
    
    private int id;
    private String nome;
    private String cpf;
    private String email;
    private String endereco;
    private Date data_admissao;
    private Date data_nascimento;
    private int cargo_funcionario_id;

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public String getEndereco() {
        return endereco;
    }

    public Date getData_admissao() {
        return data_admissao;
    }

    public Date getData_nascimento() {
        return data_nascimento;
    }

    public int getCargo_funcionario_id() {
        return cargo_funcionario_id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setData_admissao(Date data_admissao) {
        this.data_admissao = data_admissao;
    }

    public void setData_nascimento(Date data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public void setCargo_funcionario_id(int cargo_funcionario_id) {
        this.cargo_funcionario_id = cargo_funcionario_id;
    }
            
    }
