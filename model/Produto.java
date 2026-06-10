package model;


public class Produto {
    private int id;
    private String nome;
    private String descricao;
    private double preco;
    private Categoria categoria; //Relacionamento
    
    //método construtor
    public Produto(){}
    public Produto(int id, String nome, Double preco){
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }
    
    //Getters/Setters
    public int getId(){ return id; }
    public void setId(int id){ this.id = id;}
    
    public String getNome(){ return nome;}
    public void setNome(String nome){ this.nome = nome;}
    
    public String getDescricao(){ return descricao;}
    public void setDescricao(String descricao){ this.descricao = descricao;}    

    public double getPreco(){ return preco;}
    public void setPreco(Double preco){ this.preco = preco;}       
    
    public Categoria getCategoria(){ return categoria;}
    public void setCategoria(Categoria categoria){ this.categoria = categoria;}   
    
}
