
package model;


public class ContasReceber {
    
    private int id;
    private int id_item_venda;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_item_venda() {
        return id_item_venda;
    }

    public void setId_item_venda(int id_item_venda) {
        this.id_item_venda = id_item_venda;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getData_vencimento() {
        return data_vencimento;
    }

    public void setData_vencimento(String data_vencimento) {
        this.data_vencimento = data_vencimento;
    }
    private float valor;
    private String data_vencimento;
    
    
}
