package model;

import java.math.BigDecimal;
import java.sql.Date;

public class Caixa {

    private int idCaixa;
    private Date dataMovimento;
    private String tipoMovimentacao;
    private String descricao;
    private BigDecimal valor;

    public Caixa() {
    }

    public Caixa(int idCaixa, Date dataMovimento, String tipoMovimentacao, String descricao, BigDecimal valor) {
        this.idCaixa = idCaixa;
        this.dataMovimento = dataMovimento;
        this.tipoMovimentacao = tipoMovimentacao;
        this.descricao = descricao;
        this.valor = valor;
    }

    public int getIdCaixa() {
        return idCaixa;
    }

    public void setIdCaixa(int idCaixa) {
        this.idCaixa = idCaixa;
    }

    public Date getDataMovimento() {
        return dataMovimento;
    }

    public void setDataMovimento(Date dataMovimento) {
        this.dataMovimento = dataMovimento;
    }

    public String getTipoMovimentacao() {
        return tipoMovimentacao;
    }

    public void setTipoMovimentacao(String tipoMovimentacao) {
        this.tipoMovimentacao = tipoMovimentacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}
