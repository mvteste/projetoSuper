package model;

public class TipoFuncionario {

    private int idTipoFuncionario;
    private String descricao;

    public TipoFuncionario() {
    }

    public TipoFuncionario(int idTipoFuncionario, String descricao) {
        this.idTipoFuncionario = idTipoFuncionario;
        this.descricao = descricao;
    }

    public int getIdTipoFuncionario() {
        return idTipoFuncionario;
    }

    public void setIdTipoFuncionario(int idTipoFuncionario) {
        this.idTipoFuncionario = idTipoFuncionario;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
