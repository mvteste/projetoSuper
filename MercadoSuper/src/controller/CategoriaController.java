package controller;

import dao.CategoriaDAO;
import java.sql.SQLException;
import java.util.List;
import model.Categoria;

public class CategoriaController {

    private final CategoriaDAO categoriaDAO = new CategoriaDAO();

    public void inserir(Categoria categoria) throws SQLException {
        categoriaDAO.inserir(categoria);
    }

    public void atualizar(Categoria categoria) throws SQLException {
        categoriaDAO.atualizar(categoria);
    }

    public void excluir(int idCategoria) throws SQLException {
        categoriaDAO.excluir(idCategoria);
    }

    public List<Categoria> listar() throws SQLException {
        return categoriaDAO.listar();
    }

    public Categoria buscarPorId(int idCategoria) throws SQLException {
        return categoriaDAO.buscarPorId(idCategoria);
    }
}
