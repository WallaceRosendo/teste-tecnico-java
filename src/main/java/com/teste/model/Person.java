package com.teste.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome;
    private String email;
    private String telefone;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Address> enderecos;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Document> documentos;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Contact> contatos;

    // Getters e setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public List<Address> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Address> enderecos) {
        this.enderecos = enderecos;
    }

    public List<Document> getDocumentos() {
        return documentos;
    }

    public void setDocumentos(List<Document> documentos) {
        this.documentos = documentos;
    }

    public List<Contact> getContatos() {
        return contatos;
    }

    public void setContatos(List<Contact> contatos) {
        this.contatos = contatos;
    }
}