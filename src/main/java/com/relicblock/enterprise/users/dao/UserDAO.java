package com.relicblock.enterprise.users.dao;

import com.relicblock.enterprise.users.repositories.User;

import java.util.List;

public interface UserDAO {
    void save(User user);

    User findBySlug(String userSlug);

    List<User> findAll();

    void update(String userSlug, String firstName);

    void delete(String userSlug);

}
