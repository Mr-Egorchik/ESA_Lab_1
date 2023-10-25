package com.example.demo.dao;

import com.example.demo.entity.Character;
import com.example.demo.entity.Character;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;
import java.util.UUID;

@Stateless
public class CharacterDAO {

    @PersistenceContext(name = "lab")
    protected EntityManager em;


    public void create(Character character) {
        em.persist(character);
    }

    public Character read(UUID uuid) {
        return em.createQuery("SELECT c from Character c WHERE :id = (c.id)", Character.class)
                .setParameter("id", uuid)
                .getSingleResult();
    }

    public List<Character> readAll() {
        return em.createQuery("SELECT c from Character c", Character.class).getResultList();
    }

    public void update(Character character) {
        em.merge(character);
    }

    public void delete(Character character) {
        em.remove(character);
    }

    public void deleteById(UUID uuid) {
        Character character = em.find(Character.class, uuid);
        delete(character);
    }
}
