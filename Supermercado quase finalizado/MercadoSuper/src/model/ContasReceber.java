package model;

import java.math.BigDecimal;
import java.sql.Date;

public class ContasReceber {

    private int idContaReceber;
    private int idVenda;
    private Date dataVencimento;
    private BigDecimal valor;
    private String situacao;

    public ContasReceber() {
    }

    public ContasReceber(int idContaReceber, int idVenda, Date dataVencimento, BigDecimal valor, String situacao) {
        this.idContaReceber = idContaReceber;
        this.idVenda = idVenda;
        this.dataVencimento = dataVencimento;
        this.valor = valor;
        this.situacao = situacao;
    }

    public int getIdContaReceber() {
        return idContaReceber;
    }

    public void setIdContaReceber(int idContaReceber) {
        this.idContaReceber = idContaReceber;
    }

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
}
