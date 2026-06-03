
package model;


public class Funcionario {
    
    private int id;
    private int id_tipoFuncionario;
    private String nome;
    private String telefone;
    private String data_nascimento;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_tipoFuncionario() {
        return id_tipoFuncionario;
    }

    public void setId_tipoFuncionario(int id_tipoFuncionario) {
        this.id_tipoFuncionario = id_tipoFuncionario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(String data_nascimento) {
        this.data_nascimento = data_nascimento;
    }
    
    
}
