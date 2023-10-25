package com.example.demo.dao;

import com.example.demo.entity.Bonus;
import com.example.demo.mapping.BonusMapping;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;
import java.util.UUID;


@Stateless
public class BonusDAO {

    @PersistenceContext(name = "lab")
    protected EntityManager em;


    public void create(Bonus bonus) {
        em.persist(bonus);
    }

    public Bonus read(UUID uuid) {
        return em.createQuery("SELECT b from Bonus b WHERE :id = (b.id)", Bonus.class)
                .setParameter("id", uuid)
                .getSingleResult();
    }

    public List<Bonus> readAll() {
        return em.createQuery("SELECT b from Bonus b", Bonus.class).getResultList();
    }

    public void update(Bonus bonus) {
        em.merge(bonus);
    }

    public void delete(Bonus bonus) {
        em.remove(bonus);
    }

    public void deleteById(UUID uuid) {
        Bonus bonus = em.find(Bonus.class, uuid);
        delete(bonus);
    }

}
