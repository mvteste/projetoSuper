package model;

import java.sql.Date;

public class Estoque {

    private int idEstoque;
    private int idProduto;
    private int quantidade;
    private Date dataAtualizacao;

    public Estoque() {
    }

    public Estoque(int idEstoque, int idProduto, int quantidade, Date dataAtualizacao) {
        this.idEstoque = idEstoque;
        this.idProduto = idProduto;
        this.quantidade = quantidade;
        this.dataAtualizacao = dataAtualizacao;
    }

    public int getIdEstoque() {
        return idEstoque;
    }

    public void setIdEstoque(int idEstoque) {
        this.idEstoque = idEstoque;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Date getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(Date dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }
}
