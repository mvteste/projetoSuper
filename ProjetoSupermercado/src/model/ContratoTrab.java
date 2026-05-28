package model;


public class ContratoTrab {
    private int id;
    private String descricao;
    private float salario;
    private int funcionarios_id;

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public float getSalario() {
        return salario;
    }

    public int getFuncionarios_id() {
        return funcionarios_id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public void setFuncionarios_id(int funcionarios_id) {
        this.funcionarios_id = funcionarios_id;
    }
  
}
