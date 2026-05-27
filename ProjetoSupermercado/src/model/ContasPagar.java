
package model;


public class ContasPagar {
    
    private int id;
    private int id_fornecedor;
    private float valor;
    private String data;
    private String status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_fornecedor() {
        return id_fornecedor;
    }

    public void setId_fornecedor(int id_fornecedor) {
        this.id_fornecedor = id_fornecedor;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
