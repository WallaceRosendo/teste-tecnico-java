package com.teste.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.util.List;

import com.teste.model.Address;

public class AddressRepository {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void salvar(Address address) {
        em.persist(address);
    }

    @Transactional
    public void atualizar(Address address) {
        em.merge(address);
    }

    @Transactional
    public void deletar(Address address) {
        em.remove(em.contains(address) ? address : em.merge(address));
    }

    public Address encontrarPorId(int id) {
        return em.find(Address.class, id);
    }

    public List<Address> encontrarTodos() {
        return em.createQuery("SELECT a FROM Address a", Address.class).getResultList();
    }
}