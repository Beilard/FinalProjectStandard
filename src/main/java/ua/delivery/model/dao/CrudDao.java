package ua.delivery.model.dao;

import java.util.List;

public interface CrudDao<T> {
    void create(T item);
    List<T> findById(Integer id);
    List<T> findAll();
    void update(Integer id, T item);
    boolean delete (Integer id);
}
