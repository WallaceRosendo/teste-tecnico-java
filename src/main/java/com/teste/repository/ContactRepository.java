package com.teste.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.util.List;

import com.teste.model.Contact;

public class ContactRepository {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void salvar(Contact contact) {
        em.persist(contact);
    }

    @Transactional
    public void atualizar(Contact contact) {
        em.merge(contact);
    }

    @Transactional
    public void deletar(Contact contact) {
        em.remove(em.contains(contact) ? contact : em.merge(contact));
    }

    public Contact encontrarPorId(int id) {
        return em.find(Contact.class, id);
    }

    public List<Contact> encontrarTodos() {
        return em.createQuery("SELECT c FROM Contact c", Contact.class).getResultList();
    }
}