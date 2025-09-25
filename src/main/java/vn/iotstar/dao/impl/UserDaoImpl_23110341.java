package vn.iotstar.dao.impl;

import jakarta.persistence.EntityManager;
import vn.iotstar.config.JPAConfig_23110341;
import vn.iotstar.dao.UserDao_23110341;
import vn.iotstar.entity.Users_23110341;

public class UserDaoImpl_23110341 implements UserDao_23110341 {

    @Override
    public Users_23110341 findByUsername(String username) {
        EntityManager em = JPAConfig_23110341.getEntityManager();
        try {
            return em.find(Users_23110341.class, username);
        } finally {
            em.close();
        }
    }
}
