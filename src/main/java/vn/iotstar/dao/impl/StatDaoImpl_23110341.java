package vn.iotstar.dao.impl;

import jakarta.persistence.EntityManager;
import vn.iotstar.config.JPAConfig_23110341;
import vn.iotstar.dao.StatDao_23110341;

public class StatDaoImpl_23110341 implements StatDao_23110341 {
    @Override
    public long likesOf(String videoId) {
        EntityManager em = JPAConfig_23110341.getEntityManager();
        try {
            return em.createQuery(
                    "SELECT COUNT(f) FROM Favorites_23110341 f WHERE f.video.videoId = :vid", Long.class)
                    .setParameter("vid", videoId).getSingleResult();
        } finally { em.close(); }
    }

    @Override
    public long sharesOf(String videoId) {
        EntityManager em = JPAConfig_23110341.getEntityManager();
        try {
            return em.createQuery(
                    "SELECT COUNT(s) FROM Shares_23110341 s WHERE s.video.videoId = :vid", Long.class)
                    .setParameter("vid", videoId).getSingleResult();
        } finally { em.close(); }
    }
}
