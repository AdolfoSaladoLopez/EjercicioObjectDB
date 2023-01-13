package org.example;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactoryUtil {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("db.odb");

    public static EntityManagerFactory getEmf() {
        return emf;
    }
}
