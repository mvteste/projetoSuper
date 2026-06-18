package model;

import java.util.Date;


public class Cliente {
    private int id;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private String endereco;
    private Date datanasc;
    
    //método construtor
    public Cliente(){}
    
    public Cliente(int id, String nome, String cpf, Date datanasc){
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.datanasc = datanasc;
    }
    
    public int getId(){ return id; }
    public void setId(int id){ this.id = id;}
    
    public String getNome(){ return nome;}
    public void setNome(String nome){ this.nome = nome;}

    public String getCpf(){ return cpf;}
    public void setCpf(String cpf){ this.cpf = cpf;}
    
    public String getEmail(){ return email;}
    public void setEmail(String email){ this.email = email;}
    
    public String getTelefone(){ return telefone;}
    public void setTelefone(String telefone){ this.telefone = telefone;}
    
    public String getEndereco(){ return endereco;}
    public void setEndereco(String endereco){ this.endereco = endereco;}
    
    public Date getDataNascimento(){ return datanasc;}
    public void setDataNascimento(Date datanasc){ this.datanasc = datanasc;}
    
}
