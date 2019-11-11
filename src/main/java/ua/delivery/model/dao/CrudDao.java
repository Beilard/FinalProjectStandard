package ua.delivery.model.dao;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface CrudDao<T, ID> {
    void save(T item);
    Optional<T> findById(ID id);
    List<T> findAll(int start, int total);
    void update(T item);
    void deleteById(ID id);
    void deleteAllById(Set<ID> ids);
}
