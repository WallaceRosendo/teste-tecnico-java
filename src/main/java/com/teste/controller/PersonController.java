package com.teste.controller;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.List;

import com.teste.model.Person;
import com.teste.service.PersonService;

@Named
@RequestScoped
public class PersonController {
    @Inject
    private PersonService personService;

    private Person selectedPerson = new Person();
    private String searchName;
    private List<Person> persons;

    public void salvarPessoa() {
        personService.savePerson(selectedPerson);
        selectedPerson = new Person();
        persons = null;
    }

    public void atualizarPessoa() {
        personService.updatePerson(selectedPerson);
        persons = null;
    }

    public void deletarPessoa(Person person) {
        personService.deletePerson(person);
        persons = null;
    }

    public void editarPessoa(Person person) {
        this.selectedPerson = personService.findPersonById(person.getId());
    }

    public void buscarPessoas() {
        persons = personService.findAll().stream()
                .filter(p -> p.getName().contains(searchName))
                .toList();
    }

    public Person encontrarPessoaPorId(int id) {
        return personService.findPersonById(id);
    }

    public List<Person> encontrarTodas() {
        return personService.findAll();
    }

    public Person getPessoaSelecionada() {
        return selectedPerson;
    }

    public void setPessoaSelecionada(Person selectedPerson) {
        this.selectedPerson = selectedPerson;
    }

    public String getNomeBusca() {
        return searchName;
    }

    public void setNomeBusca(String searchName) {
        this.searchName = searchName;
    }

    public List<Person> getPessoas() {
        if (persons == null) {
            persons = personService.findAll();
        }
        return persons;
    }

    public void setPessoas(List<Person> persons) {
        this.persons = persons;
    }
}