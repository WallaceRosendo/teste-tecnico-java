package com.teste.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.util.List;

import com.teste.model.Person;

public class PersonRepository {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void salvar(Person person) {
        em.persist(person);
    }

    @Transactional
    public void atualizar(Person person) {
        em.merge(person);
    }

    @Transactional
    public void deletar(Person person) {
        em.remove(em.contains(person) ? person : em.merge(person));
    }

    public Person encontrarPorId(int id) {
        return em.find(Person.class, id);
    }

    public List<Person> encontrarTodos() {
        return em.createQuery("SELECT p FROM Person p", Person.class).getResultList();
    }
}