package com.teste.controller;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.List;

import com.teste.model.Document;
import com.teste.service.DocumentService;

@Named
@RequestScoped
public class DocumentController {
    @Inject
    private DocumentService documentService;

    private Document document = new Document();
    private List<Document> documents;

    public void salvar() {
        documentService.save(document);
        documents = null;
        document = new Document();
    }

    public void deletar(Document document) {
        documentService.delete(document);
        documents = null;
    }

    public List<Document> obterDocumentos() {
        if (documents == null) {
            documents = documentService.findAll();
        }
        return documents;
    }

    public Document obterDocumento() {
        return document;
    }

    public void definirDocumento(Document document) {
        this.document = document;
    }
}