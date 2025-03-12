package com.teste.service;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import java.util.List;

import com.teste.model.Contact;
import com.teste.repository.ContactRepository;

@Stateless
public class ContactService {
    @Inject
    private ContactRepository contactRepository;

    public void salvar(Contact contact) {
        contactRepository.salvar(contact);
    }

    public Contact encontrarPorId(int id) {
        return contactRepository.encontrarPorId(id);
    }

    public List<Contact> encontrarTodos() {
        return contactRepository.encontrarTodos();
    }

    public void deletar(Contact contact) {
        contactRepository.deletar(contact);
    }

    public void atualizar(Contact contact) {
        contactRepository.atualizar(contact);
    }
}