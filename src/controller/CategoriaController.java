package controller;

import dao.CategoriaDAO;
import model.Categoria;

public class CategoriaController {
    private CategoriaDAO categoriaDAO = new CategoriaDAO();
    
public void salvarCategoria(String nome){
    Categoria c = new Categoria();
    c.setNome(nome);    
    categoriaDAO.salvar(c);
    
    }

   }
