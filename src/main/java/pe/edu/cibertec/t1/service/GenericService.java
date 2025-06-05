package pe.edu.cibertec.t1.service;

import java.util.List;

public interface GenericService<T, ID> {
    T conseguirPorID(ID id);
    List<T> conseguirTodo();
    void create(T entity);
    void modificar(T entity);
    void remover(ID id);
}