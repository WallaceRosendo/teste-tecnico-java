package com.teste.service;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import java.util.List;

import com.teste.model.Person;
import com.teste.repository.PersonRepository;

@Stateless
public class PersonService {
    @Inject
    private PersonRepository personRepository;

    public void salvarPessoa(Person person) {
        personRepository.salvar(person);
    }

    public void atualizarPessoa(Person person) {
        personRepository.atualizar(person);
    }

    public void deletarPessoa(Person person) {
        personRepository.deletar(person);
    }

    public Person encontrarPessoaPorId(int id) {
        return personRepository.encontrarPorId(id);
    }

    public List<Person> encontrarTodas() {
        return personRepository.encontrarTodos();
    }
}