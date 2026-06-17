package model;

import java.math.BigDecimal;
import java.sql.Date;

public class ContratoTrab {

    private int idContrato;
    private int idFuncionario;
    private Date dataAdmissao;
    private BigDecimal salario;
    private String cargo;

    public ContratoTrab() {
    }

    public ContratoTrab(int idContrato, int idFuncionario, Date dataAdmissao, BigDecimal salario, String cargo) {
        this.idContrato = idContrato;
        this.idFuncionario = idFuncionario;
        this.dataAdmissao = dataAdmissao;
        this.salario = salario;
        this.cargo = cargo;
    }

    public int getIdContrato() {
        return idContrato;
    }

    public void setIdContrato(int idContrato) {
        this.idContrato = idContrato;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public Date getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(Date dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}
