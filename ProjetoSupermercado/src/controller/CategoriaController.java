package controller;

import dao.CategoriaDAO;
import java.util.List;
import model.Categoria;

public class CategoriaController {

    private CategoriaDAO categoriaDAO = new CategoriaDAO();

    public List<Categoria> obterCategorias() {
        return categoriaDAO.listar();
    }

    public void salvarCategoria(String nome) {

        Categoria c = new Categoria();
        c.setNome(nome);

        categoriaDAO.salvar(c);
    }
}