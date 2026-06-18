package model;

public class Funcionario {
    private int id;
    private String nome;
    private String cpf;
    private String tipo_funcionario;    
    
    //método construtor
    public Funcionario(){ }
    public Funcionario(int id, String nome, String cpf, String tipo_funcionario ){
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.tipo_funcionario = tipo_funcionario;
    }
    
    //Getters/Setters
    public int getId(){ return id; }
    public void setId(int id){ this.id = id;}
    
    public String getNome(){ return nome;}
    public void setNome(String nome){ this.nome = nome;}

    public String getCpf(){ return cpf;}
    public void setCpf(String cpf){ this.cpf = cpf;}
    
    public String getTipoFuncionario(){ return tipo_funcionario;}
    public void setTipoFuncionario(String tipo_funcionario){ this.tipo_funcionario = tipo_funcionario;}
        
}
