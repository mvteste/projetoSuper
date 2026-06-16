
package dao;

import java.util.List;

public interface GenericDAO<T>{
    
    void inserir(T entidade);
    void atualizar(T entidade);
    void deletar(int id);
    T buscarPorId(int id);
    List<T> listar();
    
    
}
