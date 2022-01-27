package by.overone.restaurant.repository;

import java.util.List;

public interface IRepository<T, K> {
    List<T> findAll();

    T findById(K id);

    void create(T entity);

    void delete(K id);
}
