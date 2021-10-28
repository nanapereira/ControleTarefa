package model.dao;

import model.entity.Gestor;

import java.util.List;

public interface iDAO<T> {
    void save(T t);
    void update(T t);
    void delete(T t);


    T findById(int id);
    List<T> findAll();
}
