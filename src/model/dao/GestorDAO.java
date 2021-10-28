package model.dao;

import model.entity.Gestor;

import javax.persistence.EntityManager;
import java.util.List;

public class GestorDAO implements iDAO<Gestor> {
    private EntityManager entityManager;


    public GestorDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Gestor gestor) {
        this.entityManager.persist(gestor);
    }

    public void update(Gestor gestor) {
        this.entityManager.merge(gestor);
    }

    public void delete(Gestor gestor) {
        gestor = entityManager.merge(gestor);
        this.entityManager.remove(gestor);
    }

    public Gestor findById(int id) {
        return entityManager.find(Gestor.class, id);
    }

    public List<Gestor> findAll() {
        String jpql = "SELECT g from Gestor g";
        return entityManager.createQuery(jpql, Gestor.class).getResultList();
    }
}
