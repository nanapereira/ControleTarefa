package factory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

    //nome do schema
    private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("controleTarefa");

    public static EntityManager getEntityManager() {
        return FACTORY.createEntityManager();
    }

}