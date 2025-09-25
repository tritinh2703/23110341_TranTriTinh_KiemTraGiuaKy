package vn.iotstar.service.impl;

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
}
