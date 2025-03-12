package com.teste.controller;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.List;

import com.teste.model.Address;
import com.teste.service.AddressService;

@Named
@RequestScoped
public class AddressController {
    @Inject
    private AddressService addressService;

    private Address address = new Address();
    private List<Address> addresses;

    public void salvar() {
        addressService.save(address);
        addresses = null;
        address = new Address();
    }

    public void deletar(Address address) {
        addressService.delete(address);
        addresses = null;
    }

    public List<Address> obterEnderecos() {
        if (addresses == null) {
            addresses = addressService.findAll();
        }
        return addresses;
    }

    public Address obterEndereco() {
        return address;
    }

    public void definirEndereco(Address address) {
        this.address = address;
    }
}