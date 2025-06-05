package pe.edu.cibertec.t1.service.impl;
import pe.edu.cibertec.t1.dao.GenericDAO;
import pe.edu.cibertec.t1.service.GenericService;

import java.util.List;

public class GenericServiceImpl<T, ID> implements GenericService<T, ID> {

    protected GenericDAO<T, ID> dao;

    public GenericServiceImpl(GenericDAO<T, ID> dao) {
        this.dao = dao;
    }


    @Override
    public T conseguirPorID(ID id) {
        return dao.encontrarPorID(id);
    }

    @Override
    public List<T> conseguirTodo() {
        return dao.encontrarTodo();
    }

    @Override
    public void create(T entity) {
        dao.guardar(entity);
    }

    @Override
    public void modificar(T entity) {
        dao.actualizar(entity);
    }

    @Override
    public void remover(ID id) {
        dao.eliminar(id);
    }
}