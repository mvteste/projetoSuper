package model;

public class Categoria {
    private int id;
    private String nome;
    private String descricao;

    public Categoria() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    // --- O TRUQUE DE OURO PARA O JCOMBOBOX ---
    // É isso aqui que faz a tela mostrar "Bebidas", "Limpeza", etc.,
    // em vez de mostrar códigos estranhos do Java!
    @Override
    public String toString() {
        return this.nome; 
    }
}