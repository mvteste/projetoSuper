package controller;

import dao.Cargo_FuncionarioDAO;
import java.util.List;
import model.Cargo_Funcionario;

public class CargoFuncionarioController extends ControllerSupport {
    private final Cargo_FuncionarioDAO dao;

    public CargoFuncionarioController() { this(new Cargo_FuncionarioDAO()); }
    public CargoFuncionarioController(Cargo_FuncionarioDAO dao) { this.dao = requireEntity(dao, "DAO de cargos"); }

    public List<Cargo_Funcionario> obterCargos() { return dao.listar(); }
    public void salvarCargo(String nome, String descricao) { dao.inserir(criar(nome, descricao)); }

    public void atualizarCargo(int id, String nome, String descricao) {
        Cargo_Funcionario cargo = criar(nome, descricao);
        cargo.setId(requirePositive(id, "ID do cargo"));
        dao.editar(cargo);
    }

    public void excluirCargo(int id) {
        Cargo_Funcionario cargo = new Cargo_Funcionario();
        cargo.setId(requirePositive(id, "ID do cargo"));
        dao.deletar(cargo);
    }

    private Cargo_Funcionario criar(String nome, String descricao) {
        Cargo_Funcionario cargo = new Cargo_Funcionario();
        cargo.setNome(requireNonBlank(nome, "Nome"));
        cargo.setDescricao(requireNonBlank(descricao, "Descrição"));
        return cargo;
    }
}
