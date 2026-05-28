package model;

import java.util.Date;


public class Produto {
    private int id;
    private String nome;
    private String descricao;
    private float preco;
    private Date data_vencimento;
    private int categoria_id;
    private int fornecedor_id;

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public float getPreco() {
        return preco;
    }

    public Date getData_vencimento() {
        return data_vencimento;
    }

    public int getCategoria_id() {
        return categoria_id;
    }

    public int getFornecedor_id() {
        return fornecedor_id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public void setData_vencimento(Date data_vencimento) {
        this.data_vencimento = data_vencimento;
    }

    public void setCategoria_id(int categoria_id) {
        this.categoria_id = categoria_id;
    }

    public void setFornecedor_id(int fornecedor_id) {
        this.fornecedor_id = fornecedor_id;
    }

}
