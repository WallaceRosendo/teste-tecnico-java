package com.teste.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.logging.Logger;

public class JPAUtil {
    private static final EntityManagerFactory emf = buildEntityManagerFactory();
    private static final Logger logger = Logger.getLogger(JPAUtil.class.getName());

    private static EntityManagerFactory buildEntityManagerFactory() {
        try {
            return Persistence.createEntityManagerFactory("your-persistence-unit-name");
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "Falha na criação inicial do EntityManagerFactory.", ex);
            throw new ExceptionInInitializerError("Failed to create EntityManagerFactory: " + ex.getMessage(), ex);
        }
    }

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
}