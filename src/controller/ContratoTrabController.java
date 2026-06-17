package controller;

import dao.ContratoTrabDAO;
import model.ContratoTrab;
import java.util.List;

public class ContratoTrabController {

    private ContratoTrabDAO contratoDAO = new ContratoTrabDAO();

    // Listar
    public List<ContratoTrab> obterContratos() {
        return contratoDAO.listar();
    }

    // Inserir
    public void salvarContrato(String cargo, float salario,
            String dataInicio, String dataFim,
            String tipoContrato, int funcionarioId) {

        ContratoTrab ct = new ContratoTrab();

        ct.setCargo(cargo);
        ct.setSalario(salario);
        ct.setData_inicio(dataInicio);
        ct.setData_fim(dataFim);
        ct.setTipo_contrato(tipoContrato);
        ct.setId_funcionario(funcionarioId);

        contratoDAO.inserir(ct);
    }

    // Atualizar
    public void atualizarContrato(int id, String cargo,
            float salario, String dataInicio,
            String dataFim, String tipoContrato,
            int funcionarioId) {

        ContratoTrab ct = new ContratoTrab();

        ct.setId(id);
        ct.setCargo(cargo);
        ct.setSalario(salario);
        ct.setData_inicio(dataInicio);
        ct.setData_fim(dataFim);
        ct.setTipo_contrato(tipoContrato);
        ct.setId_funcionario(funcionarioId);

        contratoDAO.atualizar(ct);
    }

    // Excluir
    public void excluirContrato(int id) {
        contratoDAO.deletar(id);
    }

    // Buscar por ID
    public ContratoTrab buscarContrato(int id) {
        return contratoDAO.buscarPorId(id);
    }
}