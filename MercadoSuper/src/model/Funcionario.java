package model;

public class Funcionario {

    private int idFuncionario;
    private String nome;
    private String cpf;
    private String telefone;
    private int idTipoFuncionario;

    public Funcionario() {
    }

 public Funcionario(String nome, String cpf, String telefone) {
    this.nome = nome;
    this.cpf = cpf;
    this.telefone = telefone;
 }
     
   public Funcionario(String nome, String cpf, String telefone, int idTipoFuncionario) {
    this.nome = nome;
    this.cpf = cpf;
    this.telefone = telefone;
    this.idTipoFuncionario = idTipoFuncionario;
}

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getIdTipoFuncionario() {
        return idTipoFuncionario;
    }

    public void setIdTipoFuncionario(int idTipoFuncionario) {
        this.idTipoFuncionario = idTipoFuncionario;
    }
}
