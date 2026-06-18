package model;

import java.util.Date;

public class Produto {
    private int id;
    private String nome;
    private String descricao;
    private Date dataVencimento;
    private Categoria categoria; 
    private double preco;
    

    // Getters e Setters
    
    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
    

    public int getId() {
        return id;
    }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public Date getDataVencimento() { return dataVencimento; }
    public void setDataVencimento(Date dataVencimento) { this.dataVencimento = dataVencimento; }

    public Categoria getCategoria() { return categoria; }
    public void setCategoria(Categoria categoria) { this.categoria = categoria; }
}