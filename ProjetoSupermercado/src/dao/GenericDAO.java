package dao;

import java.util.List;

public interface GenericDAO<T> {

    void salvar(T entidade);

    void atualizar(T entidade);

    void excluir(int id);

    T buscarPorId(int id);

    List<T> listarTodos();
}