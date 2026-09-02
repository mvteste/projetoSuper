package controller;

import dao.ContratosDAO;
import java.util.List;
import model.Cargo_Funcionario;
import model.Contratos;
import model.Funcionarios;

public class ContratoController extends ControllerSupport {
    private final ContratosDAO dao;

    public ContratoController() { this(new ContratosDAO()); }
    public ContratoController(ContratosDAO dao) { this.dao = requireEntity(dao, "DAO de contratos"); }

    public List<Contratos> obterContratos() { return dao.listar(); }
    public void salvarContrato(int cargoId, int funcionarioId, double salario, String inicio, String fim) {
        dao.inserir(criar(cargoId, funcionarioId, salario, inicio, fim));
    }
    public void atualizarContrato(int cargoId, int funcionarioId, double salario, String inicio, String fim) {
        dao.editar(criar(cargoId, funcionarioId, salario, inicio, fim));
    }
    public void excluirContrato(int cargoId, int funcionarioId) {
        dao.deletar(criar(cargoId, funcionarioId, 0, "1970-01-01", null));
    }

    private Contratos criar(int cargoId, int funcionarioId, double salario, String inicio, String fim) {
        Cargo_Funcionario cargo = new Cargo_Funcionario();
        cargo.setId(requirePositive(cargoId, "ID do cargo"));
        Funcionarios funcionario = new Funcionarios();
        funcionario.setId(requirePositive(funcionarioId, "ID do funcionário"));
        Contratos contrato = new Contratos();
        contrato.setCargo_funcionario(cargo);
        contrato.setFuncionario(funcionario);
        contrato.setSalario(requireNonNegative(salario, "Salário"));
        contrato.setData_inicio(requireNonBlank(inicio, "Data de início"));
        contrato.setData_fim(fim == null || fim.isBlank() ? null : fim.trim());
        return contrato;
    }
}
