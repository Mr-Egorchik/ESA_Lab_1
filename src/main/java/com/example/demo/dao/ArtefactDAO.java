package com.example.demo.dao;

import com.example.demo.entity.Artefact;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;
import java.util.UUID;

@Stateless
public class ArtefactDAO {

    @PersistenceContext(name = "lab")
    protected EntityManager em;

    public void create(Artefact artefact) {
        em.persist(artefact);
    }

    public Artefact read(UUID uuid) {
        return em.createQuery("SELECT a from Artefact a WHERE :id = (a.id)", Artefact.class)
                .setParameter("id", uuid)
                .getSingleResult();
    }

    public List<Artefact> readAll() {
        return em.createQuery("SELECT a from Artefact a", Artefact.class).getResultList();
    }

    public void update(Artefact artefact) {
        em.merge(artefact);
    }

    public void delete(Artefact artefact) {
        em.remove(artefact);
    }

    public void deleteById(UUID uuid) {
        Artefact artefact = em.find(Artefact.class, uuid);
        delete(artefact);
    }
}
