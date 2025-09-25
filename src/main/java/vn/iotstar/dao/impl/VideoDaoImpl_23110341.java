package vn.iotstar.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import vn.iotstar.config.JPAConfig_23110341;
import vn.iotstar.dao.VideoDao_23110341;
import vn.iotstar.entity.Videos_23110341;
import java.util.List;

public class VideoDaoImpl_23110341 implements VideoDao_23110341 {

    @Override
    public void create(Videos_23110341 v) {
        EntityManager em = JPAConfig_23110341.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(v);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally { em.close(); }
    }

    @Override
    public void update(Videos_23110341 v) {
        EntityManager em = JPAConfig_23110341.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(v);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally { em.close(); }
    }

    @Override
    public void delete(String videoId) {
        EntityManager em = JPAConfig_23110341.getEntityManager();
        try {
            em.getTransaction().begin();
            Videos_23110341 v = em.find(Videos_23110341.class, videoId);
            if (v != null) em.remove(v);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally { em.close(); }
    }

    @Override
    public Videos_23110341 findById(String id) {
        EntityManager em = JPAConfig_23110341.getEntityManager();
        try { return em.find(Videos_23110341.class, id); }
        finally { em.close(); }
    }

    @Override
    public long countAll() {
        EntityManager em = JPAConfig_23110341.getEntityManager();
        try {
            return em.createQuery("SELECT COUNT(v) FROM Videos_23110341 v", Long.class)
                     .getSingleResult();
        } finally { em.close(); }
    }

    @Override
    public List<Videos_23110341> findPage(int page, int size) {
        EntityManager em = JPAConfig_23110341.getEntityManager();
        try {
            TypedQuery<Videos_23110341> q = em.createQuery(
                    "SELECT v FROM Videos_23110341 v ORDER BY v.title", Videos_23110341.class);
            q.setFirstResult((page - 1) * size);
            q.setMaxResults(size);
            return q.getResultList();
        } finally { em.close(); }
    }
}
