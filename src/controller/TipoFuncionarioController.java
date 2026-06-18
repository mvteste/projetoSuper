package controller;

import dao.TipoFuncionarioDAO;
import model.TipoFuncionario;

public class TipoFuncionarioController {
    private TipoFuncionarioDAO tipoFuncionarioDAO = new TipoFuncionarioDAO();
    
    public void salvarTipoFuncionario(String nome){
    TipoFuncionario tf = new TipoFuncionario();
    tf.setNome(nome);    
    tipoFuncionarioDAO.salvar(tf);
    
    }
}
