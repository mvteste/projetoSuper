package model;

public class ContasPagar {
    
    private int id;
    private String nome;
    private float valor;
    private String data_vencimento;
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

    public String getData_vencimento() {
        return data_vencimento;
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

    public void setData_vencimento(String data_vencimento) {
        this.data_vencimento = data_vencimento;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}