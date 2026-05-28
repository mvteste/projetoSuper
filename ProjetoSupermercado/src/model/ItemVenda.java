package model;

public class ItemVenda {
   
    private int id;
    private int vendas_id;
    private int quantidade;
    private float valor_unitario;
    private float subtotal;

    public int getId() {
        return id;
    }

    public int getVendas_id() {
        return vendas_id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public float getValor_unitario() {
        return valor_unitario;
    }

    public float getSubtotal() {
        return subtotal;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setVendas_id(int vendas_id) {
        this.vendas_id = vendas_id;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setValor_unitario(float valor_unitario) {
        this.valor_unitario = valor_unitario;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }
   
}
