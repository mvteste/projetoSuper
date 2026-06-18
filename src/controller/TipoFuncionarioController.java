package controller;

import dao.TipoFuncionarioDAO;
import model.TipoFuncionario;
import java.util.List;

public class TipoFuncionarioController {

    private TipoFuncionarioDAO tipoFuncionarioDAO = new TipoFuncionarioDAO();

    // Listar
    public List<TipoFuncionario> obterTiposFuncionario() {
        return tipoFuncionarioDAO.listar();
    }

    // Inserir
    public void salvarTipoFuncionario(String desc) {

        TipoFuncionario tp = new TipoFuncionario();

        tp.setDesc(desc);

        tipoFuncionarioDAO.inserir(tp);
    }

    // Atualizar
    public void atualizarTipoFuncionario(int id, String desc) {

        TipoFuncionario tp = new TipoFuncionario();

        tp.setId(id);
        tp.setDesc(desc);

        tipoFuncionarioDAO.atualizar(tp);
    }

    // Excluir
    public void excluirTipoFuncionario(int id) {
        tipoFuncionarioDAO.deletar(id);
    }

    // Buscar por ID
    public TipoFuncionario buscarTipoFuncionario(int id) {
        return tipoFuncionarioDAO.buscarPorId(id);
    }
}