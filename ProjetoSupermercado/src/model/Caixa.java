package model;

import java.util.Date;

public class Caixa {
    private int id;
    private String nome;
    private String tipo_movimento;
    private float valor;
    private Date data_movimento;
    private String observacao;

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getTipo_movimento() {
        return tipo_movimento;
    }

    public float getValor() {
        return valor;
    }

    public Date getData_movimento() {
        return data_movimento;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTipo_movimento(String tipo_movimento) {
        this.tipo_movimento = tipo_movimento;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public void setData_movimento(Date data_movimento) {
        this.data_movimento = data_movimento;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
    
}