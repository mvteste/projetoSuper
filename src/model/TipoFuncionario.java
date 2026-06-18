package model;

public class TipoFuncionario {
    private int id;
    private String descricao;
    
    //método construtor
    public TipoFuncionario(){}
    
    public TipoFuncionario(int id, String nome){
        this.id = id;
        this.descricao = nome;
    }
    
     //Getters/Setters
    public int getId(){ return id; }
    public void setId(int id){ this.id = id;}
    
    public String getNome(){ return descricao;}
    public void setNome(String nome){ this.descricao = nome;}
}
