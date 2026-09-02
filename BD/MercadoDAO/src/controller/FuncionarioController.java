package controller;

import dao.FuncionariosDAO;
import java.util.List;
import model.Cargo_Funcionario;
import model.Funcionarios;

public class FuncionarioController extends ControllerSupport {
    private final FuncionariosDAO dao;

    public FuncionarioController() { this(new FuncionariosDAO()); }
    public FuncionarioController(FuncionariosDAO dao) { this.dao = requireEntity(dao, "DAO de funcionários"); }

    public List<Funcionarios> obterFuncionarios() { return dao.listar(); }

    public void salvarFuncionario(String nome, String cpf, String telefone, String email,
            String endereco, String dataAdmissao, String dataNascimento, int cargoId) {
        dao.inserir(criar(nome, cpf, telefone, email, endereco, dataAdmissao, dataNascimento, cargoId));
    }

    public void atualizarFuncionario(int id, String nome, String cpf, String telefone, String email,
            String endereco, String dataAdmissao, String dataNascimento, int cargoId) {
        Funcionarios funcionario = criar(nome, cpf, telefone, email, endereco, dataAdmissao, dataNascimento, cargoId);
        funcionario.setId(requirePositive(id, "ID do funcionário"));
        dao.editar(funcionario);
    }

    public void desativarFuncionario(int id) {
        Funcionarios funcionario = new Funcionarios();
        funcionario.setId(requirePositive(id, "ID do funcionário"));
        dao.desativar(funcionario);
    }

    private Funcionarios criar(String nome, String cpf, String telefone, String email,
            String endereco, String dataAdmissao, String dataNascimento, int cargoId) {
        Cargo_Funcionario cargo = new Cargo_Funcionario();
        cargo.setId(requirePositive(cargoId, "ID do cargo"));
        Funcionarios funcionario = new Funcionarios();
        funcionario.setNome(requireNonBlank(nome, "Nome"));
        funcionario.setCpf(requireNonBlank(cpf, "CPF"));
        funcionario.setTelefone(requireNonBlank(telefone, "Telefone"));
        funcionario.setEmail(requireNonBlank(email, "E-mail"));
        funcionario.setEndereco(requireNonBlank(endereco, "Endereço"));
        funcionario.setData_admissao(requireNonBlank(dataAdmissao, "Data de admissão"));
        funcionario.setData_nascimento(requireNonBlank(dataNascimento, "Data de nascimento"));
        funcionario.setCargo_funcionario(cargo);
        return funcionario;
    }
}
