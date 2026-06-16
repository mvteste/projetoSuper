package controller;

import dao.CategoriaDAO;
import model.Categoria;
import java.util.List;

public class CategoriaController {

    private CategoriaDAO categoriaDAO = new CategoriaDAO();

    public List<Categoria> obterCategorias() {
        return categoriaDAO.listar();
    }

    public void salvarCategoria(String nome) {

        Categoria c = new Categoria();
        c.setNome(nome);

        categoriaDAO.inserir(c);
    }

    public void atualizarCategoria(int id, String nome) {

        Categoria c = new Categoria();
        c.setId(id);
        c.setNome(nome);

        categoriaDAO.atualizar(c);
    }

    public void excluirCategoria(int id) {
        categoriaDAO.deletar(id);
    }

    public Categoria buscarCategoria(int id) {
        return categoriaDAO.buscarPorId(id);
    }
}