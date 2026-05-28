package model;

import java.util.Date;

public class ContasReceber {
    
    private int id;
    private String nome;
    private float valor;
    private Date data_recebimento;
    private String status;

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public float getValor() {
        return valor;
    }

    public Date getData_recebimento() {
        return data_recebimento;
    }

    public String getStatus() {
        return status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public void setData_recebimento(Date data_recebimento) {
        this.data_recebimento = data_recebimento;
    }

    public void setStatus(String status) {
        this.status = status;
    }
  
}
