package model.dao;

import model.entity.Tarefa;

import javax.persistence.EntityManager;
import java.util.List;

public class TarefaDAO implements iDAO<Tarefa> {

    @Override
    public void save(Tarefa tarefa) {
        this.entityManager(tarefa);
    }

    @Override
    public void update(Tarefa tarefa) {
        this.entityManager(tarefa);
    }

    @Override
    public void delete(Tarefa tarefa) {
        tarefa = entityManager.merge(tarefa);
        this.entity.remove(tarefa);
    }

    @Override
    public Tarefa findById(int id) {
        return entityManager.find(Tarefa.class, id);
    }

    @Override
    public List<Tarefa> findAll() {
        String jpql = "SELECT t from Tarefa t";
        return entityManager.createQuery(jpql, Tarefa.class).getResultList();
    }
}
