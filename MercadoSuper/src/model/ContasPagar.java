package model;

import java.math.BigDecimal;
import java.sql.Date;

public class ContasPagar {

    private int idContaPagar;
    private int idFornecedor;
    private Date dataVencimento;
    private BigDecimal valor;
    private String situacao;

    public ContasPagar() {
    }

    public ContasPagar(int idContaPagar, int idFornecedor, Date dataVencimento, BigDecimal valor, String situacao) {
        this.idContaPagar = idContaPagar;
        this.idFornecedor = idFornecedor;
        this.dataVencimento = dataVencimento;
        this.valor = valor;
        this.situacao = situacao;
    }

    public int getIdContaPagar() {
        return idContaPagar;
    }

    public void setIdContaPagar(int idContaPagar) {
        this.idContaPagar = idContaPagar;
    }

    public int getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(int idFornecedor) {
        this.idFornecedor = idFornecedor;
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
