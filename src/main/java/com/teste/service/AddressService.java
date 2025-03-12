package com.teste.service;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import java.util.List;

import com.teste.model.Address;
import com.teste.repository.AddressRepository;

@Stateless
public class AddressService {
    @Inject
    private AddressRepository addressRepository;

    public void salvar(Address address) {
        addressRepository.salvar(address);
    }

    public Address encontrarPorId(int id) {
        return addressRepository.encontrarPorId(id);
    }

    public List<Address> encontrarTodos() {
        return addressRepository.encontrarTodos();
    }

    public void deletar(Address address) {
        addressRepository.deletar(address);
    }

    public void atualizar(Address address) {
        addressRepository.atualizar(address);
    }
}