package model.dao;

import java.util.List;

public interface iDAO<T> {
    void save(T t);
    void update(T t);
    void delete(T t);
    T findById(int id);
    List<T> findAll();
}
