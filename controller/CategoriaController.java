package controller;

import dao.CategoriaDAO;
import model.Categoria;


public class CategoriaController {
    private CategoriaDAO categoriaDAO = new CategoriaDAO();
    
public void SalvarCategoria(String nome){
    Categoria c = new Categoria();
    c.setNome(nome);    
    categoriaDAO.salvar(c);
    
    }

    public void salvarCategoria(String nome) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
