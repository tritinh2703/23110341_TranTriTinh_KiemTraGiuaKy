package vn.iotstar.dao.impl;

import jakarta.persistence.EntityManager;
import vn.iotstar.config.JPAConfig_23110341;
import vn.iotstar.dao.CategoryDao_23110341;
import vn.iotstar.entity.Category_23110341;
import java.util.List;

public class CategoryDaoImpl_23110341 implements CategoryDao_23110341 {

    @Override
    public List<Category_23110341> findAll() {
        EntityManager em = JPAConfig_23110341.getEntityManager();
        try {
            return em.createQuery("SELECT c FROM Category_23110341 c WHERE c.status = true",
                    Category_23110341.class).getResultList();
        } finally { em.close(); }
    }

    @Override
    public List<Object[]> countVideosPerCategory() {
        EntityManager em = JPAConfig_23110341.getEntityManager();
        try {
            return em.createQuery(
                    "SELECT c, COUNT(v) FROM Category_23110341 c LEFT JOIN c.videos v GROUP BY c",
                    Object[].class).getResultList();
        } finally { em.close(); }
    }
}
