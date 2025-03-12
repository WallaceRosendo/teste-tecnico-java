package com.teste.controller;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.List;

import com.teste.model.Contact;
import com.teste.service.ContactService;

@Named
@RequestScoped
public class ContactController {
    @Inject
    private ContactService contactService;

    private Contact contact = new Contact();
    private List<Contact> contacts;

    public void salvar() {
        contactService.save(contact);
        contacts = null;
        contact = new Contact();
    }

    public void deletar(Contact contact) {
        contactService.delete(contact);
        contacts = null;
    }

    public List<Contact> obterContatos() {
        if (contacts == null) {
            contacts = contactService.findAll();
        }
        return contacts;
    }

    public Contact obterContato() {
        return contact;
    }

    public void definirContato(Contact contact) {
        this.contact = contact;
    }
}