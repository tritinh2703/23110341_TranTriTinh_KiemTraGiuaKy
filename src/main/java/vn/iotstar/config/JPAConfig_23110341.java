package vn.iotstar.config;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAConfig_23110341 {
    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("dataSource");

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public static void shutdown() {
        if (emf.isOpen()) emf.close();
    }
}
