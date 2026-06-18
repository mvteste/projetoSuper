package model;

public class Fornecedor {

    private int idFornecedor;
    private String nome;
    private String cnpj;
    private String telefone;

    public Fornecedor() {
    }

    public Fornecedor( String nome, String cnpj, String telefone) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.telefone = telefone;
    }
    public Fornecedor(int idFornecedor, String nome, String cnpj, String telefone) {
        this.idFornecedor = idFornecedor;
        this.nome = nome;
        this.cnpj = cnpj;
        this.telefone = telefone;
    }

    public int getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(int idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
