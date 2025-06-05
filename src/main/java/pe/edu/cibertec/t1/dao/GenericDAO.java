package pe.edu.cibertec.t1.dao;

import java.util.List;

public interface GenericDAO<T, ID> {
	T encontrarPorID(ID id);
    List<T> encontrarTodo();
    void guardar(T entity);
    void actualizar(T entity);
    void eliminar(ID id);
}