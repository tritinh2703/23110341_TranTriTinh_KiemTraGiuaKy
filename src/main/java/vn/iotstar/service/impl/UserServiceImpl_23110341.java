package vn.iotstar.service.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import vn.iotstar.config.JPAConfig_23110341;
import vn.iotstar.dao.UserDao_23110341;
import vn.iotstar.dao.impl.UserDaoImpl_23110341;
import vn.iotstar.entity.Users_23110341;
import vn.iotstar.service.UserService_23110341;

public class UserServiceImpl_23110341 implements UserService_23110341 {
    private final UserDao_23110341 userDao = new UserDaoImpl_23110341();

    @Override
    public Users_23110341 login(String username, String password) {
        Users_23110341 u = userDao.findByUsername(username);
        if (u != null && Boolean.TRUE.equals(u.getActive())
                && u.getPassword() != null && u.getPassword().equals(password)) {
            return u;
        }
        return null;
    }
    @Override
    public void register(Users_23110341 u) {
        EntityManager em = JPAConfig_23110341.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(u);
            tx.commit();
        } finally { em.close(); }
    }

    @Override
    public boolean existsByUsername(String username){
        EntityManager em = JPAConfig_23110341.getEntityManager();
        try {
            return em.find(Users_23110341.class, username) != null;
        } finally { em.close(); }
    }

}
