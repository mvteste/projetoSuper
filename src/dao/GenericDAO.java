package dao;
import java.util.List;

public interface GenericDAO<T> {

    void salvar(T entidade);

    void atualizar(T entidade);

    void excluir(int id);

    T BuscarPorId(int id);

    List<T> listarTodos();
}