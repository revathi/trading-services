package net.springboot.ipotrading.service;

import net.springboot.ipotrading.model.User;

public interface UserService {
    void save(User user);

    User findByUserName(String userName);
    User findByEmail(String email);
}
