package model;

import java.util.Date;

public class Cliente {
    private int id;
    private String nome;
    private Date data;
    private String cpf;
    private String endereco;
    private String telefone;

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Date getData() {
        return data;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
}
