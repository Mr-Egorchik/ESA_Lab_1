package com.example.demo.dao;

import com.example.demo.entity.Weapon;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;
import java.util.UUID;

@Stateless
public class WeaponDAO {

    @PersistenceContext(name = "lab")
    protected EntityManager em;


    public void create(Weapon weapon) {
        em.persist(weapon);
    }

    public Weapon read(UUID uuid) {
        return em.createQuery("SELECT w from Weapon w WHERE :id = (w.id)", Weapon.class)
                .setParameter("id", uuid)
                .getSingleResult();
    }

    public List<Weapon> readAll() {
        return em.createQuery("SELECT w from Weapon w", Weapon.class).getResultList();
    }

    public void update(Weapon weapon) {
        em.merge(weapon);
    }

    public void delete(Weapon weapon) {
        em.remove(weapon);
    }

    public void deleteById(UUID uuid) {
        Weapon weapon = em.find(Weapon.class, uuid);
        delete(weapon);
    }
}
