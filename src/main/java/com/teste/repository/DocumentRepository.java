package com.teste.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.util.List;

import com.teste.model.Document;

public class DocumentRepository {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void salvar(Document document) {
        em.persist(document);
    }

    @Transactional
    public void atualizar(Document document) {
        em.merge(document);
    }

    @Transactional
    public void deletar(Document document) {
        em.remove(em.contains(document) ? document : em.merge(document));
    }

    public Document encontrarPorId(int id) {
        return em.find(Document.class, id);
    }

    public List<Document> encontrarTodos() {
        return em.createQuery("SELECT d FROM Document d", Document.class).getResultList();
    }
}