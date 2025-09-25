package vn.iotstar.service;

import vn.iotstar.entity.Users_23110341;

public interface UserService_23110341 {
    Users_23110341 login(String username, String password);
    void register(Users_23110341 user);
    boolean existsByUsername(String username);
}
