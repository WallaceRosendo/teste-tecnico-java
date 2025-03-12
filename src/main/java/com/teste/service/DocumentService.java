package com.teste.service;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import java.util.List;

import com.teste.model.Document;
import com.teste.repository.DocumentRepository;

@Stateless
public class DocumentService {
    @Inject
    private DocumentRepository documentRepository;

    public void salvar(Document document) {
        documentRepository.salvar(document);
    }

    public Document encontrarPorId(int id) {
        return documentRepository.encontrarPorId(id);
    }

    public List<Document> encontrarTodos() {
        return documentRepository.encontrarTodos();
    }

    public void deletar(Document document) {
        documentRepository.deletar(document);
    }

    public void atualizar(Document document) {
        documentRepository.atualizar(document);
    }
}